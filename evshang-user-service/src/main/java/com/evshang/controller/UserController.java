package com.evshang.controller;


import com.evshang.entity.User;
import com.evshang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userDetails/{username}")
    public User userDetails(@PathVariable("username") String username){
        User user = userService.findUserByUsername(username);

        //User user = new User();
        //user.setUsername(UUID.randomUUID().toString());
       // user.setId(new Random().nextInt());
        return user;
    }





}
