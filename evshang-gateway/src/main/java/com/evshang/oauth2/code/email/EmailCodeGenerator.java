package com.evshang.oauth2.code.email;


import com.evshang.oauth2.code.ValidateCode;
import com.evshang.oauth2.code.ValidateCodeGenerator;
import com.evshang.oauth2.properties.SecurityProperties;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;


@Component("emailValidateCodeGenerator")
public class EmailCodeGenerator implements ValidateCodeGenerator {

	@Autowired
	private SecurityProperties securityProperties;
	
	@Override
	public ValidateCode generate(ServletWebRequest request) {
		// TODO Auto-generated method stub
		String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getEmail().getLength());
		return new ValidateCode(code, securityProperties.getCode().getEmail().getExpireIn());
	}

	
	
	
	
}
