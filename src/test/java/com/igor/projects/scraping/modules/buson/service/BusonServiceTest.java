package com.igor.projects.scraping.modules.buson.service;

import com.igor.projects.scraping.helper.TestHelper;
import com.igor.projects.scraping.modules.buson.dto.request.BusonRequest;
import com.igor.projects.scraping.modules.buson.service.BusonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BusonServiceTest {

    @Autowired
    private BusonService service;

    @Test
    public void buscarPassagens_deveRetornarLista_quandoRequestCorreta() throws IOException {

        var requestService = service.buscarPassagens(TestHelper.umaRequestBuson());
        assertTrue(requestService.size() > 0);

    }

   //TODO : IMPLEMENTAR EXCEPTIONS
}
