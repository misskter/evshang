package com.evshang.oauth2.properties;

import lombok.Data;

@Data
public class EmailCodeProperties {

	private int length = 6;
	private int expireIn = 60;

	private String url;

}
