package com.evshang;

import com.evshang.entity.User;
import com.evshang.feign.UserFeign;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private UserFeign userFeign;

    @GetMapping("/test/{username}")
    public User test(@PathVariable("username") String username){

        return userFeign.queryUserByUserName(username);
    }

}
