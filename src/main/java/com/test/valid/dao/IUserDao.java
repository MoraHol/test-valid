package com.test.valid.dao;

import com.test.valid.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserDao extends JpaRepository<User, Long> {

}
