/**
 * 
 */
package com.evshang.oauth2.properties;

import lombok.Data;

/**
 * @author
 *
 */
@Data
public class ValidateCodeProperties {
	
	private ImageCodeProperties image = new ImageCodeProperties();
	
	private SmsCodeProperties sms = new SmsCodeProperties();

	private EmailCodeProperties email = new EmailCodeProperties();
	

}
