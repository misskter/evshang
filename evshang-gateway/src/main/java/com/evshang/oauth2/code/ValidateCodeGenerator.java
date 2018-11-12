/**
 * 
 */
package com.evshang.oauth2.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author
 *
 */
public interface ValidateCodeGenerator {

	ValidateCode generate(ServletWebRequest request);
	
}
