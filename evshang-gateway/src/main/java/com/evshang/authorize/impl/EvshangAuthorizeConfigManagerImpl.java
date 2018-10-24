package com.evshang.authorize.impl;

import java.util.Set;

import com.evshang.authorize.AuthorizeConfigManager;
import com.evshang.authorize.AuthorizeConfigProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;


@Component
public class EvshangAuthorizeConfigManagerImpl implements AuthorizeConfigManager {

	@Autowired
	private Set<AuthorizeConfigProvider> authorizeConfigProviders;
	
	
	@Override
	public void config(
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {
		// TODO Auto-generated method stub
		for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
			authorizeConfigProvider.config(authorizeRequests);
		}
		authorizeRequests.anyRequest().authenticated();
	}

	
	
	
	
}
