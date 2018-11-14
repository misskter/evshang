package com.evshang.oauth2.service;

import com.evshang.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserDetailsImpl implements UserDetails {

    private User user;

    private PasswordEncoder passwordEncoder;


    public UserDetailsImpl(){}

    public UserDetailsImpl(PasswordEncoder passwordEncoder,User user){
        this.passwordEncoder = passwordEncoder;
        this.user = user;
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority(user.getUrole().getUroleName()));
        return simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword()!=null? passwordEncoder.encode(user.getPassword()):user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
