package com.evshang.feign;


import com.evshang.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "evshang-user-service")
public interface UserServiceFeign {

    @GetMapping("/userDetails/{username}")
    User findByUsername(@PathVariable("username") String username);



}
