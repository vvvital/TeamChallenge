package com.vvvital.teamchallenge;

import com.vvvital.teamchallenge.entity.Psychologist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(PsychologistControllerTest.class)
public class PsychologistControllerTest{

    @Autowired
    MockMvc mockMvc;

    @Test
    public String getAll() throws Exception {
        mockMvc.perform(get(getAll()));
        return null;
    }

}
