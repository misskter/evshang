/**
 * 
 */
package com.evshang.properties;

/**
 * @author zhailiang
 *
 */
public class ValidateCodeProperties {
	
	private ImageCodeProperties image = new ImageCodeProperties();
	
	private SmsCodeProperties sms = new SmsCodeProperties();

	private EmailCodeProperties email = new EmailCodeProperties();
	
	public EmailCodeProperties getEmail() {
		return email;
	}

	public void setEmail(EmailCodeProperties email) {
		this.email = email;
	}

	public ImageCodeProperties getImage() {
		return image; 
	}

	public void setImage(ImageCodeProperties image) {
		this.image = image;
	}

	public SmsCodeProperties getSms() {
		return sms;
	}

	public void setSms(SmsCodeProperties sms) {
		this.sms = sms;
	}
	
}
