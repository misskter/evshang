package com.evshang.oauth2;




import com.evshang.oauth2.authentication.email.EmailCodeAuthenticationSecurityConfig;
import com.evshang.oauth2.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.evshang.oauth2.authorize.AuthorizeConfigManager;
import com.evshang.oauth2.code.ValidateCodeSecurityConfig;
import com.evshang.oauth2.constant.SecurityConstants;
import com.evshang.oauth2.handler.EvshangAuthenticationFailureHandler;
import com.evshang.oauth2.handler.EvshangAuthenticationSuccessHandler;
import com.evshang.oauth2.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;


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
    private OAuth2WebSecurityExpressionHandler expressionHandler;

    @Autowired
    private OAuth2AccessDeniedHandler evshangOAuth2AccessDeniedHandler;

	@Autowired
	private EvshangAuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
	private EvshangAuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private AuthorizeConfigManager evshangAuthorizeConfigManager;

	@Bean
	public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
		OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
		expressionHandler.setApplicationContext(applicationContext);
		return expressionHandler;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.expressionHandler(expressionHandler);
		resources.accessDeniedHandler(evshangOAuth2AccessDeniedHandler);
	}

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

        evshangAuthorizeConfigManager.config(http.authorizeRequests());
        http.authorizeRequests().anyRequest().access("@permissionService.hasPermission(request,authentication)");
		
	}
		

}
