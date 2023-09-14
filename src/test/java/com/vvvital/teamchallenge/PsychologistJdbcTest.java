package com.vvvital.teamchallenge;

import com.vvvital.teamchallenge.entity.Categories;
import com.vvvital.teamchallenge.entity.Psychologist;
import com.vvvital.teamchallenge.repository.jdbc.PsychologistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        Categories[] categories={Categories.PSYCHOTHERAPIST,Categories.ORGANIZATIONAL_PSYCHOLOGIST,Categories.CHILD_PSYCHOLOGIST};
        Psychologist psychologist = new Psychologist(
                "Vitaliy", "Kovalenko", "vvvital@i.ua", "123456", "0968469185",
                100,"KYIV",true,true,5,"Опис психолога",
                "https://drive.google.com/file/d/1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6/view?usp=sharing",categories);
        repository.create(psychologist);
    }
    @Test
    public void get(){
//        Categories[]categories={Categories.PSYCHOLOGIST_CLOSE,Categories.PSYCHOLOGIST_SEXOLOGIST,Categories.SCHOOL_PSYCHOLOGIST};
//        Psychologist psychologistExpected = new Psychologist(
//                "Vitaliy", "Kovalenko", "vvvital@i.ua", "123456", "0968469185",
//                100,"KYIV",true,true,5,"Опис психолога",
//                "https://drive.google.com/file/d/1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6/view?usp=sharing",categories);
//        psychologistExpected.setId(100007);
        Psychologist psychologistCurrent = repository.get(100004);
        System.out.println(psychologistCurrent);
//        assertThat(psychologistCurrent).usingRecursiveComparison().ignoringActualNullFields().isEqualTo(psychologistExpected);

    }

    @Test
    public void getAll(){
        List<Psychologist>psychologists=repository.getAll();
        psychologists.forEach(System.out::println);
    }

}
