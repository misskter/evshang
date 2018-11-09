package com.evshang.service;

import com.evshang.entity.User;
import com.evshang.feign.UserServiceFeign;
import javafx.beans.property.SimpleListProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



@Component
public class UserService implements UserDetailsService {

    @Autowired
    UserServiceFeign userServiceFeign;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userServiceFeign.findByUsername(username);
        if (user != null) {
            //int uroleId=user.getUroleId();
            String password = passwordEncoder.encode(user.getPassword());
            return new org.springframework.security.core.userdetails.User(username, password,
                    AuthorityUtils.createAuthorityList(user.getUrole().getUroleName()));
        } else {
            throw new UsernameNotFoundException("auth  failure");
        }
    }
}
