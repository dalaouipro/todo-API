package com.todo.todo.controller;

import com.todo.todo.entity.User;
import com.todo.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    
    @GetMapping("/listUsers")
    public List<User> listUsers() {
        return userService.findAll();
    }
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }
    @PostMapping("/deleteUser")
    public User deleteUser(@RequestBody long id) {
        User user = userService.findById(id).get();
        userService.delete(user);
        return user;
    }
}
