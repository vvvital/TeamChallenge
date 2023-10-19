package com.vvvital.teamchallenge.web;

import com.vvvital.teamchallenge.entity.Categories;
import com.vvvital.teamchallenge.entity.Role;
import com.vvvital.teamchallenge.entity.User;
import com.vvvital.teamchallenge.servise.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    private final UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        logger.info("/***********Controller Constructor has been called*************/");
    }

    @PostMapping("/create")
    public User create(@RequestParam(required = true) String email,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = true) String surName,
                       @RequestParam(required = false) String phone,
                       @RequestParam(required = true) String password,
                       @RequestParam(required = false) String roleIn
    ) {
        logger.info("*******Controller/createUser*******{},{},{},{},{},{}", email, name, surName, phone, password, roleIn);
        Role role = roleIn!=null? Role.stringToRole(roleIn):Role.USER;
        List<Categories> categories= Arrays.asList(Categories.CLINICAL_PSYCHOLOGIST,Categories.CHILD_PSYCHOLOGIST,Categories.FAMILY_PSYCHOLOGIST);
        User user = new User(email, name, surName, phone, password, role);
        return userService.create(user);
    }

    @PostMapping("/update")
    public User update(
            @RequestParam(required = true) String id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surName,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String password
    ){
        User user=new User(strToInt(id),email,name,surName,phone,password);
        userService.update(user);
        return null;
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        logger.info("*******Controller/getUsers*******");
        return userService.getAll();
    }

    @GetMapping("/get")
    public User getUser(@RequestParam String id) {
        logger.info("*******Controller/getUser id= {}*******", id);
        return userService.get(strToInt(id));
    }

    @GetMapping("/delete")
    public void delete(@RequestParam String id) {
        logger.info("*******Controller/deleteUser*******");
        userService.delete(Integer.parseInt(id));
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

}
