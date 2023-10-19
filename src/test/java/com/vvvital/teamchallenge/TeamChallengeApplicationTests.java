package com.vvvital.teamchallenge;

import com.vvvital.teamchallenge.entity.User;
import com.vvvital.teamchallenge.repository.jdbc.JdbcUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class TeamChallengeApplicationTests {

    private final JdbcUserRepository jdbcUserRepository;

    @Autowired
    TeamChallengeApplicationTests(JdbcUserRepository jdbcUserRepository) {
        this.jdbcUserRepository = jdbcUserRepository;
    }

    @Test
    void contextLoads() {
    }


    @Test
    void jdbcTest(){
        List<User>expectedUsers= Arrays.asList(
//                new User("email1@mail.ua", "name1", "surname1", "phoneNumber1","123456"),
//                new User("email2@mail.ua", "name2", "surname2", "phoneNumber2","234567"),
//                new User("email3@mail.ua", "name3", "surname3", "phoneNumber3","345678"),
//                new User("email4@mail.ua", "name4", "surname4", "phoneNumber4","456789"),
//                new User("email5@mail.ua", "name5", "surname5", "phoneNumber5","567890")
        );
        List<User> users = jdbcUserRepository.getAll();
        for (User u:users
             ) {
            System.out.println(u.toString());
        }

    }

}
