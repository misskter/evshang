package com.evshang.validate.code.email;

import com.evshang.properties.SecurityProperties;
import com.evshang.validate.code.ValidateCode;
import com.evshang.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang3.RandomStringUtils;
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
