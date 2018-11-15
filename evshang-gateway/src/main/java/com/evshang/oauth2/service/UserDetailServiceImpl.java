package com.evshang.oauth2.service;

import com.evshang.entity.User;
import com.evshang.feign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserServiceFeign userServiceFeign;

    @Autowired
    PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userServiceFeign.queryUserByUserName(username);
        if (user != null) {
            //int uroleId=user.getUroleId();
            //new org.springframework.security.core.userdetails.User(username, password,AuthorityUtils.commaSeparatedStringToAuthorityList(user.getUrole().getUroleName()));
            //String password = passwordEncoder.encode(user.getPassword());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return new UserDetailsImpl(user);
        } else {
            throw new UsernameNotFoundException("auth  failure");
        }
    }
}
