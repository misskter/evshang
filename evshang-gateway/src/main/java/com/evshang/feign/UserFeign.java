package com.evshang.feign;


import com.evshang.entity.User;
import com.evshang.hystrix.UserFeignHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "evshang-user-service",fallback = UserFeignHystrix.class)
public interface UserFeign {

    @GetMapping("/userDetails/{username}")
    User queryUserByUserName(@RequestParam(value = "name") String username);

}
