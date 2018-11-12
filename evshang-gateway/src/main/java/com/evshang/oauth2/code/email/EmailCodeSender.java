package com.evshang.oauth2.code.email;

public interface EmailCodeSender {

	void send(String email, String code);
}
