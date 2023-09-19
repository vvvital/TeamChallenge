package com.vvvital.teamchallenge;

import com.vvvital.teamchallenge.entity.Categories;
import com.vvvital.teamchallenge.entity.Location;
import com.vvvital.teamchallenge.entity.Psychologist;
import com.vvvital.teamchallenge.entity.PsychologistToSend;
import com.vvvital.teamchallenge.repository.jdbc.PsychologistRepository;
import com.vvvital.teamchallenge.servise.PsychologistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static com.vvvital.teamchallenge.entity.Location.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PsychologistJdbcTest {

    private final PsychologistRepository repository;
    private final PsychologistService service;

    @Autowired
    public PsychologistJdbcTest(PsychologistRepository repository, PsychologistService service) {
        this.repository = repository;
        this.service = service;
    }

        @Test
    public void create() {
        Categories[] categories={Categories.PSYCHOTHERAPIST,Categories.ORGANIZATIONAL_PSYCHOLOGIST,Categories.CHILD_PSYCHOLOGIST};
        Psychologist psychologist = new Psychologist(
                "Vitaliy", "Kovalenko", "vvvital@i.ua", "123456", "0968469185",
                100,KYIV,true,true,5,"Опис психолога",
                "https://drive.google.com/file/d/1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6/view?usp=sharing",categories);
        repository.create(psychologist);
    }
    @Test
    public void get() {
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
    public void getAll() {
        Set<Categories> categoriesSet = new HashSet<>();
        categoriesSet.add(Categories.CLINICAL_PSYCHOLOGIST);
        categoriesSet.add(Categories.CHILD_PSYCHOLOGIST);
        categoriesSet.add(Categories.PSYCHOLOGIST_SEXOLOGIST);
        categoriesSet.add(Categories.GROUP_THERAPY);
        categoriesSet.add(Categories.SCHOOL_PSYCHOLOGIST);
        categoriesSet.forEach(System.out::println);
        Integer priceMin = 0;
        Integer priceMax = 120;
        Integer experienceMin = 0;
        Integer experienceMax = 6;
        Integer ratingMin = 0;
        Integer ratingMax = 5;
        String order = "price";
        List<PsychologistToSend> psychologists = service.getAll(categoriesSet, KYIV, priceMin, priceMax,
                experienceMin, experienceMax, ratingMin, ratingMax, order);
        psychologists.forEach(System.out::println);
    }

}
