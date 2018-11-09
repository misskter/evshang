package com.evshang;



import com.evshang.authentication.email.EmailCodeAuthenticationSecurityConfig;
import com.evshang.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.evshang.constant.SecurityConstants;
import com.evshang.handler.EvshangAuthenticationFailureHandler;
import com.evshang.handler.EvshangAuthenticationSuccessHandler;
import com.evshang.properties.SecurityProperties;
import com.evshang.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;



@Configuration
@EnableResourceServer
public class AuthorizationResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;
	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
	@Autowired
	private EmailCodeAuthenticationSecurityConfig emailCodeAuthenticationSecurityConfig;



	@Autowired
	private EvshangAuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
	private EvshangAuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
		formLogin()
		.loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
		.successHandler(authenticationSuccessHandler)
		.failureHandler(authenticationFailureHandler);
		http
		.apply(validateCodeSecurityConfig)
		.and()
		.apply(smsCodeAuthenticationSecurityConfig)
		.and()
		.apply(emailCodeAuthenticationSecurityConfig)
		.and()
		.csrf().disable();

		http.authorizeRequests().anyRequest().permitAll();
		
	}
		

}
