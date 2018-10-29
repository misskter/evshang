package com.evshang.authorize.impl;



import com.evshang.authorize.AuthorizeConfigProvider;

import com.evshang.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Component
@Order(Integer.MAX_VALUE)
public class EvshangAuthorizeConfigProviderImpl implements AuthorizeConfigProvider {

	@Autowired
	private SecurityProperties securityProperties;

	@Override
	public void config(
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {
		List<String> list = securityProperties.getExcludeUrls();
		String [] urls = list.toArray(new String[list.size()]);
		authorizeRequests.antMatchers(urls).permitAll();
	}





}
