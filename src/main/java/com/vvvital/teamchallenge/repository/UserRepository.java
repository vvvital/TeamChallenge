package com.vvvital.teamchallenge.repository;

import com.vvvital.teamchallenge.entity.User;

import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    User getUser(Integer id);

    User create(User user);

    void update(User user,Integer id);

    void delete(Integer id);
}
