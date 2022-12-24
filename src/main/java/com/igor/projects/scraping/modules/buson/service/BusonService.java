package com.igor.projects.scraping.modules.buson.service;

import com.igor.projects.scraping.modules.buson.dto.request.BusonRequest;
import com.igor.projects.scraping.modules.buson.dto.response.BusonResponse;

import java.io.IOException;
import java.util.List;

public interface BusonService {

    List<BusonResponse> buscarPassagens(BusonRequest request) throws IOException;
}
