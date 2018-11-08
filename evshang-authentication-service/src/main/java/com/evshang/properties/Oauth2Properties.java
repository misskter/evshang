package com.evshang.properties;

import lombok.Data;

@Data
public class Oauth2Properties {

	private Oauth2ClientProperties[] clients = {};
	
	private String jwtSigingKey="evshang";

	/*public String getJwtSigingKey() {
		return jwtSigingKey;
	}

	public void setJwtSigingKey(String jwtSigingKey) {
		this.jwtSigingKey = jwtSigingKey;
	}

	public Oauth2ClientProperties[] getClients() {
		return clients;
	}

	public void setClients(Oauth2ClientProperties[] clients) {
		this.clients = clients;
	}*/

}
