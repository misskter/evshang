package com.evshang.dao;

import com.evshang.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao{
    @Override
    public User findUserByUsername(String username) {
        return null;
    }
}
