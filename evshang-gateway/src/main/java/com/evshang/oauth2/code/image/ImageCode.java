/**
 * 
 */
package com.evshang.oauth2.code.image;


import com.evshang.oauth2.code.ValidateCode;

import java.awt.image.BufferedImage;


/**
 * @author mk
 *
 */
public class ImageCode extends ValidateCode {
	
	private BufferedImage image; 
	
	public ImageCode(BufferedImage image, String code, int expireIn){
		super(code, expireIn);
		this.image = image;
	}
	
/*	public ImageCode(BufferedImage image, String code, int expireTime){
		super(code, expireTime);
		this.image = image;
	}*/
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
