package com.igor.projects.scraping.helper;

import com.igor.projects.scraping.modules.buson.dto.request.BusonRequest;

import java.time.LocalDate;

public class TestHelper {
    public static BusonRequest umaRequestBuson() {
            return  BusonRequest.builder()
                .origem("joao-pessoa-pb")
                .destino("fortaleza-ce")
                .ida(LocalDate.now())
                .volta(LocalDate.now().plusDays(0))
                .build();
    }
}
