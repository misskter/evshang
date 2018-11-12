package com.evshang.oauth2.authorize.impl;

import com.evshang.oauth2.authorize.AuthorizeConfigManager;
import com.evshang.oauth2.authorize.AuthorizeConfigProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
@Order(Integer.MIN_VALUE)
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
