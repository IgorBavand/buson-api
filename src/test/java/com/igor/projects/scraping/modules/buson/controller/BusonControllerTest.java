package com.igor.projects.scraping.modules.buson.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class BusonControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void buscarPassagens_deveRetornarOk_quandoParametrosCorretos() throws Exception {

        mvc.perform(get("/buson")
                        .param("origem", "joao-pessoa-pb")
                        .param("destino", "fortaleza-ce")
                        .param("ida", String.valueOf(LocalDate.now()))
                        .param("volta", String.valueOf(LocalDate.now().plusDays(1)))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
