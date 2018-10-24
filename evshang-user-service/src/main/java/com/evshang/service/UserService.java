package com.evshang.service;

import com.evshang.entity.User;

public interface UserService {


    /**
     * 根据用户名查找用户信息
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}
