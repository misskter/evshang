package com.evshang.service;

import com.evshang.entity.User;
import com.evshang.feign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    UserServiceFeign userServiceFeign;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userServiceFeign.findByUsername(s);
        if(user != null){
            return new org.springframework.security.core.userdetails.User(s, UUID.randomUUID().toString(),null);
        }
        return null;
    }
}
