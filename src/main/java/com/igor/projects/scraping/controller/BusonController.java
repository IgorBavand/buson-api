package com.igor.projects.scraping.controller;

import com.igor.projects.scraping.dto.request.BusonRequest;
import com.igor.projects.scraping.dto.response.BusonResponse;
import com.igor.projects.scraping.service.BusonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

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
