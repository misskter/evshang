/**
 * 
 */
package com.evshang.oauth2.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author zhailiang
 *
 */
@Data
public class QQProperties extends SocialProperties {
	
	private String providerId = "qq";


	
}
