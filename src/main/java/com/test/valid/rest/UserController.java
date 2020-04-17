package com.test.valid.rest;

import com.test.valid.entity.User;
import com.test.valid.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String getIndex() {
        return "hello world";
    }

    @GetMapping("/users")
    public List<User> getallusers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("/users")
    public User createuser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.updateuser(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HashMap<String, String>> deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        HashMap<String, String> response = new HashMap<String, String>();
        response.put("status", "ok");
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
