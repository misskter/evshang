package com.evshang.authorize.impl;



import com.evshang.authorize.AuthorizeConfigProvider;
import com.evshang.constant.SecurityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EvshangAuthorizeConfigProviderImpl implements AuthorizeConfigProvider {

	@Autowired
	private SecurityConstant securityConstant;

	@Override
	public void config(
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {
		List<String> list = securityConstant.getExcludeUrls();
		String [] urls = list.toArray(new String[list.size()]);
		authorizeRequests.antMatchers(urls).permitAll();
	}





}
