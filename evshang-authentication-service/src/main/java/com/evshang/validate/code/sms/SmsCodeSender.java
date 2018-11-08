/**
 * 
 */
package com.evshang.validate.code.sms;

/**
 * @author zhailiang
 *
 */
public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
