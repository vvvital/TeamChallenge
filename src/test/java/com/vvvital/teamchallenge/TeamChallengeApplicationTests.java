package com.vvvital.teamchallenge;

import com.vvvital.teamchallenge.entity.Categories;
import com.vvvital.teamchallenge.entity.Psychologist;
import com.vvvital.teamchallenge.entity.User;
import com.vvvital.teamchallenge.repository.jdbc.JdbcUserRepository;
import com.vvvital.teamchallenge.repository.jdbc.PsychologistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class TeamChallengeApplicationTests {

    private final JdbcUserRepository jdbcUserRepository;

    private final PsychologistRepository psychologistRepository;

    @Autowired
    TeamChallengeApplicationTests(JdbcUserRepository jdbcUserRepository, PsychologistRepository psychologistRepository) {
        this.jdbcUserRepository = jdbcUserRepository;
        this.psychologistRepository = psychologistRepository;
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
        users.forEach(System.out::println);

    }

    @Test
    public void psychologistGetAll(){
        List<Psychologist> psychologistList=psychologistRepository.getAll();
        psychologistList.forEach(System.out::println);
    }

//    @Test
//    public void getPsychIdByCategories(){
//        Set<Categories>categoriesSet=new HashSet<>();
//        categoriesSet.add(Categories.PSYCHOTHERAPIST);
//        Set<Integer> idSet = psychologistRepository.getPsychIdByCategories(categoriesSet);
//        idSet.forEach(System.out::println);
//    }

}
