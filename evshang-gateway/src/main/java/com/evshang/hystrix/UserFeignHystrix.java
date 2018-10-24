package com.evshang.hystrix;

import com.evshang.entity.User;
import com.evshang.feign.UserFeign;
import org.springframework.stereotype.Component;

@Component
public class UserFeignHystrix implements UserFeign {

    @Override
    public User queryUserByUserName(String username) {
       User user = new User();
        user.setUsername(username);
        return user;
    }
}
