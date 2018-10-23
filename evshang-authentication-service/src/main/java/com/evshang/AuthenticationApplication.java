package com.evshang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthenticationApplication {

    public static void main(String[] args) {
        //Commodity service
        SpringApplication.run(AuthenticationApplication.class, args);
    }
}
