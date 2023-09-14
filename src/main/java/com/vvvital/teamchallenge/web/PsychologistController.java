package com.vvvital.teamchallenge.web;

import com.vvvital.teamchallenge.ServletInitializer;
import com.vvvital.teamchallenge.TeamChallengeApplication;
import com.vvvital.teamchallenge.entity.Categories;
import com.vvvital.teamchallenge.entity.Psychologist;
import com.vvvital.teamchallenge.servise.PsychologistService;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PsychologistController {
    Logger logger = LoggerFactory.getLogger(PsychologistController.class);
    private final PsychologistService psychologistService;

    @Autowired
    public PsychologistController(PsychologistService psychologistService) {
        this.psychologistService = psychologistService;
        logger.info("/////////////Controller start/////////////////");
    }

    @PostMapping("/psychologist/create")
    public Psychologist create(
            @RequestParam String name,
            @RequestParam String surNane,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String phone,
            @RequestParam(required = false, defaultValue = "0") String price,
            @RequestParam(required = false, defaultValue = "Ukraine") String location,
            @RequestParam(required = false, defaultValue = "false") String online,
            @RequestParam(required = false, defaultValue = "false") String offline,
            @RequestParam(required = false, defaultValue = "0") String experience,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(required = false, defaultValue = "") String photoLink
    ) {
        logger.info("******************/psychologist/create******************");
        Psychologist psychologist = new Psychologist(name, surNane, email, password, phone,
                strToInt(price), location, strToBool(online), strToBool(offline), strToInt(experience), description, photoLink, Categories.ORGANIZATIONAL_PSYCHOLOGIST);
        System.out.println(psychologist.toString());
        return psychologistService.create(psychologist);
    }

    @PostMapping("/psychologist/login")
    public Psychologist login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        return psychologistService.login(email, password);
    }

    @PostMapping("/psychologist/update")
    public Psychologist update() {
        return null;
    }

    @GetMapping("/psychologist/getAll")
    public List<Psychologist> getAll(
            @RequestParam(required = false) String[] categories,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String appointment,
            @RequestParam(required = false) String experience,
            @RequestParam(required = false) String price,
            @RequestParam(required = false) String rating
    ) {
        logger.info("**************PsychologistController/getAll********************");
        Set<Categories>categoriesSet=Categories.arrToSet(categories);
        return psychologistService.getAll(categoriesSet);

    }

    @GetMapping("/psychologist/get")
    public Psychologist get(@RequestParam String id) {
        return psychologistService.get(strToInt(id));
    }

    @GetMapping("/psychologist/delete")
    public void delete(@RequestParam String id) {
        psychologistService.delete(strToInt(id));
    }

    public static Integer strToInt(String str) {
        int integer;
        try {
            integer = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
        return integer;
    }

    public static Boolean strToBool(String str) {
        return str.toLowerCase().trim().equals("true");
    }
}
