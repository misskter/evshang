package com.example.configuration;

import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApplication.class, args);
    }
}
