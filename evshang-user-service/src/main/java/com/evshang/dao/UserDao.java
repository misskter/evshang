package com.evshang.dao;

import com.evshang.entity.User;

public interface UserDao {


    User findUserByUsername(String username);



}
