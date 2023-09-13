package com.vvvital.teamchallenge;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vvvital.teamchallenge.entity.Psychologist;
import com.vvvital.teamchallenge.repository.jdbc.PsychologistRepository;
import com.vvvital.teamchallenge.servise.PsychologistService;
import com.vvvital.teamchallenge.web.PsychologistController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PsychologistController.class)
public class PsychologistControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PsychologistService service;
    @MockBean
    PsychologistRepository repository;


    @Test
    public void create() throws Exception {
        Psychologist psychologist = new Psychologist(
                "Vitaliy", "Kovalenko", "vvvital@i.ua", "123456", "0968469185");
        mockMvc.perform(post("/psychologist/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(psychologist)));

    }

    @Test
    public void get() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/psychologist/get")
                        .param("id", "100000"))
                .andExpect(status().isOk());

    }

    public static String toJson(Object psychologist) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(psychologist);

    }

}
