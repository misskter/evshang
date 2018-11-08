/**
 * 
 */
package com.evshang.validate.code;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author zhailiang
 *
 */
public class ValidateCode implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	
	private int expireTime;
	


	public ValidateCode() {}
	
	public ValidateCode(String code,int expireTime) {
		this.code=code;
		this.expireTime=expireTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}
	@JsonIgnore
	public boolean isExpried() {
		return LocalDateTime.now().isAfter(LocalDateTime.now().plusSeconds(expireTime));
	}
	
/*	public ValidateCode(String code, int expireIn){
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}
	
	public ValidateCode(String code, LocalDateTime expireTime){
		this.code = code;
		this.expireTime = expireTime;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}*/
	
}
