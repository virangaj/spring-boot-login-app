package com.example.demo.Controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User.User;
import com.example.demo.User.UserService;

@RestController
@RequestMapping
@CrossOrigin
public class Controller {
    @Autowired
    private UserService userServices;

    @GetMapping("/get")
    public String returnUser() {
        return "Hello";
    }

    @PostMapping("/addUser")
    public boolean addUser(@RequestBody User userdata) throws NoSuchAlgorithmException {
        return userServices.registerUser(userdata);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) throws NoSuchAlgorithmException {
        return userServices.loginUser(user);
    }

    @GetMapping("/all")
    public List<User> all() {
        return userServices.getAll();
    }
}