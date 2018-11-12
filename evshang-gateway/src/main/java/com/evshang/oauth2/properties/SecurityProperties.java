/**
 * 
 */
package com.evshang.oauth2.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author
 *
 */
@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "evshang.security")
public class SecurityProperties {

	private ValidateCodeProperties code = new ValidateCodeProperties();
	
	private SocialProperties social = new SocialProperties();

	private Oauth2Properties oauth2=new Oauth2Properties();
	



}

