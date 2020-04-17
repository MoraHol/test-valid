package com.test.valid.service;

import com.test.valid.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();

    User addUser(User user);

    void removeUser(Long id);

    User updateuser(User user);

    User getById(Long id);

}
