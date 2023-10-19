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
    private EmailService emailService;

    @Autowired
    public UserService(JdbcUserRepository jdbcUserRepository) {
        this.jdbcUserRepository = jdbcUserRepository;
    }

    public User create(User user) {
        logger.info("/************UserService/create User****************/");
        return jdbcUserRepository.create(user);
    }

    public void update(User user) {
        logger.info("/************UserService/update User id****************/");
        jdbcUserRepository.update(user);
    }

    public List<User> getAll() {
        logger.info("/************UserService/get Users****************/");
        return jdbcUserRepository.getAll();
    }

    public User get(Integer id) {
        logger.info("/************UserService/get User Id****************/");
        return jdbcUserRepository.get(id);
    }

    public void delete(Integer id) {
        logger.info("/************UserService/delete User id****************/");
        jdbcUserRepository.delete(id);
    }

}
