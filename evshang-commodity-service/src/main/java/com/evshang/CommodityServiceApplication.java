package com.evshang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class CommodityServiceApplication {

	@Autowired
	private String name;


	public static void main(String[] args) {



		SpringApplication.run(CommodityServiceApplication.class, args);
	}



}
