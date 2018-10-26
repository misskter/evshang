/**
 * 
 */
package com.evshang.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zhailiang
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
	
	

	public Oauth2Properties getOauth2() {
		return oauth2;
	}

	public void setOauth2(Oauth2Properties oauth2) {
		this.oauth2 = oauth2;
	}



	public ValidateCodeProperties getCode() {
		return code;
	}

	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}

	public SocialProperties getSocial() {
		return social;
	}

	public void setSocial(SocialProperties social) {
		this.social = social;
	}
}

