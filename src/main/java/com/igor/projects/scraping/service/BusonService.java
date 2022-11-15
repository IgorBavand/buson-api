package com.igor.projects.scraping.service;

import com.igor.projects.scraping.dto.request.BusonRequest;
import com.igor.projects.scraping.dto.response.BusonResponse;

import java.io.IOException;
import java.util.List;

public interface BusonService {

    List<BusonResponse> buscarPassagens(BusonRequest request) throws IOException;
}
