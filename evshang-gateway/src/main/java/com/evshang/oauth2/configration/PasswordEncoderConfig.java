package com.evshang.oauth2.configration;

import com.evshang.oauth2.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;


/**
 * PasswordEncoderConfig
 * 
 * @author vladimir.stankovic
 *
 *         Dec 27, 2016
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class PasswordEncoderConfig implements Serializable {

	private static final long serialVersionUID = -4757222135626058608L;

	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
