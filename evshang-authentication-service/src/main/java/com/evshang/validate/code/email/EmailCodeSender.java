package com.evshang.validate.code.email;

public interface EmailCodeSender {

	void send(String email, String code);
}
