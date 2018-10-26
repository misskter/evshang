/**
 * 
 */
package com.evshang.authentication.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @author zhailiang
 *
 */
@Component
public class EmailCodeAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
	
	@Autowired
	private AuthenticationSuccessHandler emailAuthenticationSuccessHandler;
	
	@Autowired
	private AuthenticationFailureHandler emailAuthenticationFailureHandler;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		EmailCodeAuthenticationFilter emailCodeAuthenticationFilter = new EmailCodeAuthenticationFilter();
		emailCodeAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
		emailCodeAuthenticationFilter.setAuthenticationSuccessHandler(emailAuthenticationSuccessHandler);
		emailCodeAuthenticationFilter.setAuthenticationFailureHandler(emailAuthenticationFailureHandler);
		
		EmailCodeAuthenticationProvider emailCodeAuthenticationProvider = new EmailCodeAuthenticationProvider();
		emailCodeAuthenticationProvider.setUserDetailsService(userDetailsService);
		
		http.authenticationProvider(emailCodeAuthenticationProvider)
			.addFilterAfter(emailCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
	}

}
