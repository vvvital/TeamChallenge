package com.vvvital.teamchallenge.web;

import com.vvvital.teamchallenge.entity.User;
import com.vvvital.teamchallenge.servise.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        logger.info("/***********Controller Constructor has been called*************/");
    }

    @PostMapping("/createUser")
    public User create(@RequestParam String email,
                       @RequestParam String name,
                       @RequestParam String surName,
                       @RequestParam String phone,
                       @RequestParam String password
    ) {
        logger.info("*******Controller/createUser*******");
        User user = new User(email, name, surName, phone, password);
        return userService.create(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email,
                      @RequestParam String password) {
        System.out.println("Email = " + email + " Password = " + password);
        return userService.login(email, password);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        logger.info("*******Controller/getUsers*******");
        return userService.getUsers();
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam String id) {
        logger.info("*******Controller/getUser id= {}*******", id);
        return userService.getUser(Integer.parseInt(id));
    }

    @PostMapping("/updateUser")
    public void update(User user, String id) {
        logger.info("*******Controller/updateUser*******");
        userService.update(user, Integer.parseInt(id));
    }

    @DeleteMapping("deleteUser")
    public void delete(@RequestParam String id) {
        logger.info("*******Controller/deleteUser*******");
        userService.delete(Integer.parseInt(id));
    }

    @GetMapping("confirm/{code}")
    public void confirmEmail(@PathVariable String code){

    }

}
