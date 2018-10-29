package com.evshang.configuration;




import com.evshang.authorize.AuthorizeConfigManager;
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
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * 需要这样的配置解决no bean resolver registered for custom bean 500错误
     */
    @Autowired
    private OAuth2WebSecurityExpressionHandler expressionHandler;

    @Autowired
    private OAuth2AccessDeniedHandler evshangOAuth2AccessDeniedHandler;

    @Autowired
    private AuthorizeConfigManager evshangAuthorizeConfigManager;




    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;
    //@Autowired
    //private ValidateCodeSecurityConfig validateCodeSecurityConfig;





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
        http.csrf().disable();
        evshangAuthorizeConfigManager.config(http.authorizeRequests());
        http.authorizeRequests().anyRequest().access("@permissionService.hasPermission(request,authentication)");
    }




}
