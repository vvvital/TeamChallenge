package com.vvvital.teamchallenge;

import com.vvvital.teamchallenge.entity.User;
import com.vvvital.teamchallenge.web.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    UserController userController;

    @Test
    public void getAll() {
        List<User> userList = userController.getAll();
        userList.forEach(System.out::println);
        assert (!userController.getAll().isEmpty());
    }

    @Test
    public void create(){
        userController.getAll().forEach(System.out::println);
        userController.create("new2@mail.ua","NewName","NewSurname","0500000000"
                ,"password","USER");
        userController.getAll().forEach(System.out::println);
    }

    @Test
    public void update(){
        userController.update("6","update@mail.ua","updateName","updateSurname"
                ,"1111111111111","updatePassword");
        userController.getAll().forEach(System.out::println);
    }

    @Test
    public void getId(){
        System.out.println(userController.getUser("1"));
    }

    @Test
    public void delete(){
        userController.getAll().forEach(System.out::println);
        userController.delete("6");
        userController.getAll().forEach(System.out::println);
    }

}
