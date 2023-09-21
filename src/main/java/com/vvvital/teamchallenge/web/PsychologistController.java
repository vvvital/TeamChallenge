package com.vvvital.teamchallenge.web;

import com.vvvital.teamchallenge.entity.Categories;
import com.vvvital.teamchallenge.entity.Location;
import com.vvvital.teamchallenge.entity.Psychologist;
import com.vvvital.teamchallenge.entity.PsychologistToSend;
import com.vvvital.teamchallenge.servise.PsychologistService;
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
            @RequestParam(required = false) String location,
            @RequestParam(required = false, defaultValue = "false") String online,
            @RequestParam(required = false, defaultValue = "false") String offline,
            @RequestParam(required = false, defaultValue = "0") String experience,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(required = false, defaultValue = "") String photoLink
    ) {
        logger.info("******************/psychologist/create******************");
        Psychologist psychologist = new Psychologist(name, surNane, email, password, phone,
                strToInt(price), Location.valueOf(location), strToBool(online), strToBool(offline), strToInt(experience), description, photoLink, Categories.ORGANIZATIONAL_PSYCHOLOGIST);
        System.out.println(psychologist);
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
    public Psychologist update(
            @RequestParam String name,
            @RequestParam String surNane,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String phone,
            @RequestParam(required = false, defaultValue = "0") String price,
            @RequestParam(required = false) String location,
            @RequestParam(required = false, defaultValue = "false") String online,
            @RequestParam(required = false, defaultValue = "false") String offline,
            @RequestParam(required = false, defaultValue = "0") String experience,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(required = false, defaultValue = "") String photoLink
    ) {
        Psychologist psychologist = new Psychologist(name, surNane, email, password, phone,
                strToInt(price), Location.valueOf(location), strToBool(online), strToBool(offline), strToInt(experience), description, photoLink, Categories.ORGANIZATIONAL_PSYCHOLOGIST);
        System.out.println(psychologist);
        return psychologistService.update(psychologist);
    }

    @GetMapping("/psychologist/getAll")
    public List<PsychologistToSend> getAll(
            @RequestParam(required = false) String[] categories,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String priceMin,
            @RequestParam(required = false) String priceMax,
            @RequestParam(required = false) String experienceMin,
            @RequestParam(required = false) String experienceMax,
            @RequestParam(required = false) String ratingMin,
            @RequestParam(required = false) String ratingMax,
            @RequestParam(required = false) String order

    ) {
        logger.info("**************PsychologistController/getAll********************");
        Location location1 = null;
        Set<Categories> categoriesSet = new HashSet<>();
        if (categories != null) {
            categoriesSet = Arrays.stream(categories).map(Categories::valueOf).collect(Collectors.toSet());
        } else if (location != null) {
            location1 = Location.valueOf(location);
            logger.info("**************location = {}",location);
        }
        return psychologistService.getAll(categoriesSet, location1,strToInt(priceMin),strToInt(priceMax),
                strToInt(experienceMin),strToInt(experienceMax),strToInt(ratingMin),strToInt(ratingMax),order);
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
