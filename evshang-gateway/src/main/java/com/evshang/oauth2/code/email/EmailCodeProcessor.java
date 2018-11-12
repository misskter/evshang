package com.evshang.oauth2.code.email;

import com.evshang.oauth2.code.ValidateCode;
import com.evshang.oauth2.code.impl.AbstractValidateCodeProcessor;
import com.evshang.oauth2.constant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;


@Component("emailValidateCodeProcessor")
public class EmailCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

	@Autowired
	private EmailCodeSender emailCodeSender;
	
	@Override
	protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
		// TODO Auto-generated method stub
		String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_EMAIL;
		String email = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
		emailCodeSender.send(email, validateCode.getCode());
	}

}
