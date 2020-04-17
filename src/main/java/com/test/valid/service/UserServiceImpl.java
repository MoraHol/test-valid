package com.test.valid.service;

import com.test.valid.dao.IUserDao;
import com.test.valid.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> getAll() {
        return this.userDao.findAll();
    }

    @Override
    public User addUser(User user) {
        user.setProcessed(false);
        return this.userDao.save(user);
    }

    @Override
    public void removeUser(Long id) {
        this.userDao.deleteById(id);
    }

    @Override
    public User updateuser(User user) {
        return this.userDao.save(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.findById(id).get();
    }
}
