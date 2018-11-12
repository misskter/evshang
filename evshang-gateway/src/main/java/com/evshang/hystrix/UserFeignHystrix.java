package com.evshang.hystrix;

import com.evshang.entity.User;
import com.evshang.feign.UserServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class UserFeignHystrix implements UserServiceFeign {

    @Override
    public User queryUserByUserName(String username) throws RuntimeException{
        throw new RuntimeException("service not connection");
    }
}
