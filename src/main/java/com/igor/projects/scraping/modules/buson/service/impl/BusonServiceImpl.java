package com.igor.projects.scraping.modules.buson.service.impl;

import com.igor.projects.scraping.modules.buson.dto.request.BusonRequest;
import com.igor.projects.scraping.modules.buson.dto.response.BusonResponse;
import com.igor.projects.scraping.modules.buson.service.BusonService;
import java.util.List;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class BusonServiceImpl implements BusonService {

    private static final int VALOR_INICIAL_CONTAGEM = 1;

    @Override
    public List<BusonResponse> buscarPassagens(BusonRequest request) throws IOException {

        Document documento = null;

        if (request.getVolta() == null) {
            documento = Jsoup.connect("https://www.buson.com.br/passagem-de-onibus/" + request.getOrigem() + "/" + request.getDestino() + "?ida=" + request.getIda())
                    .userAgent("Mozilla")
                    .get();
        } else {
            documento = Jsoup.connect("https://www.buson.com.br/passagem-de-onibus/" + request.getOrigem() + "/" + request.getDestino() + "?volta=" + request.getVolta() + "&ida=" + request.getIda())
                    .userAgent("Mozilla")
                    .get();
        }

        var contadorPassagens = VALOR_INICIAL_CONTAGEM;
        final ArrayList<BusonResponse> passagens = new ArrayList<BusonResponse>();

        while (true) {
            final Elements row = documento.select("#margin-top-search-result-id > section > div > div > ul > li:nth-child(" + contadorPassagens + ") > div > a");

            if (row.isEmpty()) {
                break;
            }

            final String tipo = row.select("div.search-ticket__trip-info > div.sr_types.desktop-only > p").text();
            final String empresa = row.select("div.search-ticket__trip-info > div.search-ticket__name-company > p").text();
            final String horarioEmbarque = row.select("div.search-ticket__route > div > div:nth-child(1) > span.route-info__hour.route-info__hour--start").text();
            final String horarioChegada = row.select("div.search-ticket__route > div > div:nth-child(1) > span.route-info__hour.route-info__hour--end").text();
            final String duracao = row.select("div.search-ticket__route > div > div:nth-child(1) > div.route-info__time > p").text();
            final String origem = row.select("div.search-ticket__route > div > div:nth-child(2) > div.route-info__city-name.route-info__city-name--start > p:nth-child(1)").text();
            final String destino = row.select("div.search-ticket__route > div > div:nth-child(2) > div.route-info__city-name.route-info__city-name--end > p:nth-child(1)").text();
            final String lugarOrigem = row.select("div.search-ticket__route > div > div:nth-child(2) > div.route-info__city-name.route-info__city-name--start > p:nth-child(2)").text();
            final String lugarChegada = row.select("div.search-ticket__route > div > div:nth-child(2) > div.route-info__city-name.route-info__city-name--end > p:nth-child(2)").text();
            final String qtdPoltronasLivres = row.select("div.search-ticket__trip-info > div.logo-and-easyboarding > p").text();
            final String preco = row.select("div.search-ticket__price > div > div.search-ticket__price__composition > p.search-ticket__price__text").text();

            final BusonResponse passagem = BusonResponse.builder()
                    .qdtPoltronasDisponiveis(qtdPoltronasLivres)
                    .lugarOrigem(lugarOrigem)
                    .empresa(empresa)
                    .horarioChegada(horarioChegada)
                    .horarioEmbarque(horarioEmbarque)
                    .duracao(duracao)
                    .preco(preco)
                    .tempoParaEncerrarVendas(null)
                    .lugarDestino(lugarChegada)
                    .lugarOrigem(lugarOrigem)
                    .origem(origem)
                    .destino(destino)
                    .tipo(tipo)
                    .build();

            passagens.add(passagem);
            contadorPassagens++;

        }

        return passagens;
    }

}
