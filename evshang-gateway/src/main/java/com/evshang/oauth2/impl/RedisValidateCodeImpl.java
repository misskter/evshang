package com.evshang.oauth2.impl;


import com.evshang.oauth2.code.ValidateCode;
import com.evshang.oauth2.code.ValidateCodeException;
import com.evshang.oauth2.code.ValidateCodeRepository;
import com.evshang.oauth2.code.ValidateCodeType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.concurrent.TimeUnit;


@Component
public class RedisValidateCodeImpl implements ValidateCodeRepository {

	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;
	
	
	@Override
	public void saveCode(ServletWebRequest request, ValidateCode code, ValidateCodeType type) {
		// TODO Auto-generated method stub
		redisTemplate.opsForValue().set(bulidKey(request,type), code, 10, TimeUnit.MINUTES);
	}



	private Object bulidKey(ServletWebRequest request, ValidateCodeType type) {
		String deviceId=request.getHeader("deviceId");
		if(StringUtils.isBlank(deviceId)) {
			throw new ValidateCodeException("没有deviceId");
			
		}
		return "code"+type.toString().toLowerCase()+deviceId;
	}



	@Override
	public ValidateCode getCode(ServletWebRequest request, ValidateCodeType type) {
		Object key=redisTemplate.opsForValue().get(bulidKey(request,type));
		if(key==null) {
			return null;
		}
		return (ValidateCode) key;
	}

	@Override
	public void removeCode(ServletWebRequest request, ValidateCodeType type) {
		// TODO Auto-generated method stub
		redisTemplate.delete(bulidKey(request, type));
	}

}
