package com.evshang.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class User  {

    private Urole urole;

    private String id;

    private String username;

    private String password;

    private String uroleId;

    private String address;




}
