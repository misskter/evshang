package com.evshang.dao;

import com.evshang.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends BaseDao<User>{


    User findUserByUsername(String username);



}
