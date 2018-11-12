package com.evshang.oauth2.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeRepository {

	
	public void saveCode(ServletWebRequest request, ValidateCode code, ValidateCodeType type);
	
	public ValidateCode getCode(ServletWebRequest request, ValidateCodeType type);
	
	public void removeCode(ServletWebRequest request, ValidateCodeType type);
}
