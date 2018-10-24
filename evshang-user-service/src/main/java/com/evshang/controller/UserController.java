package com.evshang.controller;

import com.evshang.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@RestController
public class UserController {


    @GetMapping("/userDetails/{userId}")
    public User userDetails(@PathVariable("userId") String id){
        User user = new User();
        user.setId(new Random().nextInt());
        user.setAddress(UUID.randomUUID().toString());
        return user;
    }

}
