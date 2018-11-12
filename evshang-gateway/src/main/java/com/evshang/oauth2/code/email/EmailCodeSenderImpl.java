package com.evshang.oauth2.code.email;

import org.springframework.stereotype.Component;


@Component
public class EmailCodeSenderImpl implements EmailCodeSender{


	
	@Override
	public void send(String email, String code) {
		// TODO Auto-generated method stub
		System.out.println(email + "" +code);
		/*emailSend.sendSimpleMail(email, "验证码", code);*/
	}

}
