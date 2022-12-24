package com.igor.projects.scraping.modules.buson.dto.request;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class BusonRequest {

    String origem;
    String destino;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate ida;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate volta;

}
