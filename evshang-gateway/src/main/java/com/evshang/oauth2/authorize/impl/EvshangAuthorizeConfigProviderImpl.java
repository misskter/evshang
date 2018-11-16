package com.evshang.oauth2.authorize.impl;


import com.evshang.oauth2.authorize.AuthorizeConfigProvider;
import com.evshang.oauth2.properties.ExcludeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Order(Integer.MIN_VALUE)
public class EvshangAuthorizeConfigProviderImpl implements AuthorizeConfigProvider {

	@Autowired
	ExcludeProperties excludeProperties;
	@Override
	public void config(
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {
		List<String> list = excludeProperties.getExcludeUrls();
		String [] urls = list.toArray(new String[list.size()]);
		authorizeRequests.antMatchers(urls).permitAll();
	}





}
