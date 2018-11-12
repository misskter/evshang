package com.evshang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("/userDetails/{userId}")
    public String userDetails(@PathVariable("userId") String id){

        return "laowang is man ";
    }

}
