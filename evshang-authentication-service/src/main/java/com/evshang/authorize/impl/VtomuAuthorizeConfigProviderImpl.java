package com.evshang.authorize.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.evshang.authorize.AuthorizeConfigProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;


@Component
public class VtomuAuthorizeConfigProviderImpl implements AuthorizeConfigProvider {

	

	
	@Override
	public void config(
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {
		// TODO Auto-generated method stub
		authorizeRequests.antMatchers("/login").permitAll();
	}



}
