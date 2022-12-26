package com.igor.projects.scraping.modules.buson.dto.request;

import java.time.LocalDate;

import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
@Builder
public class BusonRequest {

    String origem;
    String destino;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate ida;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate volta;

}
