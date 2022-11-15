package com.igor.projects.scraping.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusonResponse {

    private String qdtPoltronasDisponiveis;
    private String tipo;
    private String empresa;
    private String horarioEmbarque;
    private String duracao;
    private String horarioChegada;
    private String origem;
    private String lugarOrigem;
    private String destino;
    private String lugarDestino;
    private String preco;
    private String tempoParaEncerrarVendas;

}