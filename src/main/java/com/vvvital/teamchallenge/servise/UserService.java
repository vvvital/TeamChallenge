package com.vvvital.teamchallenge.servise;

import com.vvvital.teamchallenge.entity.User;
import com.vvvital.teamchallenge.repository.jdbc.JdbcUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    private final JdbcUserRepository jdbcUserRepository;

    @Autowired
    public UserService(JdbcUserRepository jdbcUserRepository) {
        this.jdbcUserRepository = jdbcUserRepository;
    }

    public User login(String login, String password){
        User user = jdbcUserRepository.login(login);
        if (user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
    public List<User> getUsers(){
        logger.info("/************UserService/get Users****************/");
        return jdbcUserRepository.getUsers();
    }

    public User getUser(Integer id){
        logger.info("/************UserService/get User Id****************/");
        return jdbcUserRepository.getUser(id);
    }

    public void create (User user){
        logger.info("/************UserService/create User****************/");
        jdbcUserRepository.create(user);
    }

    public void update (User user,Integer id){
        logger.info("/************UserService/update User id****************/");
        jdbcUserRepository.update(user,id);
    }

    public  void delete (Integer id){
        logger.info("/************UserService/delete User id****************/");
        jdbcUserRepository.delete(id);
    }

}
