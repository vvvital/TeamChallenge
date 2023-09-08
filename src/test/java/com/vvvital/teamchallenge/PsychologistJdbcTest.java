package com.vvvital.teamchallenge;

import com.vvvital.teamchallenge.entity.Psychologist;
import com.vvvital.teamchallenge.repository.jdbc.PsychologistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PsychologistJdbcTest {

    private final PsychologistRepository repository;

    @Autowired
    public PsychologistJdbcTest(PsychologistRepository repository) {
        this.repository = repository;
    }

    @Test
    public void create() {
        Psychologist psychologist = new Psychologist(
                "Vitaliy", "Kovalenko", "vvvital@i.ua", "123456", "0968469185");
        repository.create(psychologist);
    }
    @Test
    public void get(){
        Psychologist psychologistExpected = new Psychologist(
                "Vitaliy", "Kovalenko", "vvvital@i.ua", "123456", "0968469185");
        psychologistExpected.setId(100000);
        Psychologist psychologistCurrent = repository.get(100000);
        System.out.println(psychologistCurrent);
        assertThat(psychologistCurrent).usingRecursiveComparison().ignoringActualNullFields().isEqualTo(psychologistExpected);
    }

}
