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
public class ImageCodeProperties extends SmsCodeProperties {
	
	public ImageCodeProperties() {
		setLength(4);
	}
	 
	private int width = 67;
	private int height = 23;
	

}
