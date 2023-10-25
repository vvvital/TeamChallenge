package com.vvvital.teamchallenge;

import com.vvvital.teamchallenge.entity.PsychologistToSend;
import com.vvvital.teamchallenge.web.PsychologistController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ControllerTest {

    @Autowired
    PsychologistController controller;

    private List<PsychologistToSend> expectedList;

    @Test
    public void getAllWithoutParam() {
        expectedList = controller.getAll(null, null, null, null, null, null
                , null, null, null);
        expectedList.forEach(System.out::println);
    }

    @Test
    public void getAllWithLocation() {
        expectedList = controller.getAll(null, "KYIV", null, null, null, null
                , null, null, null);
        expectedList.forEach(System.out::println);
    }

    @Test
    public void mainGetAll() {
        List<PsychologistToSend> psychologistToSendList = getAllParam(null, null
                , "100", "120", "5", "6", "4", "5", null);
        psychologistToSendList.forEach(System.out::println);

    }

    public List<PsychologistToSend> getAllParam(String[] categories, String location, String priceMin, String priceMax,
                                                String experienceMin, String experienceMax, String ratingMin, String ratingMax, String order) {
        return controller.getAll(categories, location, priceMin, priceMax, experienceMin, experienceMax, ratingMin, ratingMax, order);
    }

    @Test
    public void create() {
        getAllWithoutParam();
        controller.create("newName", "newSurname", "new@mail.ua", "newPass"
                , "111111111111111", "200", "LVIV", "true", "true", "10", "description", "");
        getAllWithoutParam();
    }

    @Test
    public void update(){
        getAllWithoutParam();
        controller.update("8","updName","updSurname","upd@mail.ua","11111","4444444444444"
        ,"111","LVIV","true","true","10","description","");
        getAllWithoutParam();
    }

    @Test
    public void delete(){
        getAllWithoutParam();
        controller.delete("8");
        getAllWithoutParam();
    }

}