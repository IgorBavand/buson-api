package com.igor.projects.scraping.modules.buson.controller;

import java.io.IOException;
import java.util.List;
import com.igor.projects.scraping.modules.buson.dto.request.BusonRequest;
import com.igor.projects.scraping.modules.buson.dto.response.BusonResponse;
import com.igor.projects.scraping.modules.buson.service.BusonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("buson")
public class BusonController {

    @Autowired
    private BusonService service;

    @GetMapping
    public List<BusonResponse> buscarPassagens(BusonRequest request) throws IOException {
        return service.buscarPassagens(request);
    }
}
