package com.igor.projects.scraping.modules.buson.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class BusonRequest {
    String origem;
    String destino;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate ida;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate volta;
}