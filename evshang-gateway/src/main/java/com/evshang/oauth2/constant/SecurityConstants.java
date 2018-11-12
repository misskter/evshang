/**
 * 
 */
package com.evshang.oauth2.constant;

/**
 * @author
 *
 */
public interface SecurityConstants {
	
	/**
	 * 默认的处理验证码的url前缀
	 */
	public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
	/**
	 * 默认的处理验证码的url前缀
	 */
	public static final String DEFAULT_VALIDATE_CODE_URL = DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*";
	/**
	 * 忽略文章的验证地址
	 */

	/**
	 * 默认的用户名密码登录请求处理url
	 */
	public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/loginCheck/form";
	/**
	 * 默认的手机验证码登录请求处理url
	 */
	public static final String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/loginCheck/mobile";
	/**
	 * 默认的邮箱登录请求处理url
	 */
	public static final String DEFAULT_LOGIN_PROCESSING_URL_EMAIL="/loginCheck/email";
	/**
	 *默认的邮箱注册处理Url处理邮箱验证码 
	 */
	public static final String DEFAULT_REGISTER_PROCESSING_URL_MOBILE="/registerCheck/mobile";
	/**
	 *默认的邮箱注册处理Url处理邮箱验证码 
	 */
	public static final String DEFAULT_REGISTER_PROCESSING_URL_EMAIL="/registerCheck/email";
	/**
	 * 默认的注册处理地址和图片验证码
	 */
	public static final String DEFAULT_REGISTER_PROCESSING_URL_FORM = "/registerCheck/form";

	/**
	 * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
	/**
	 * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
	/**
	 * 发送邮件验证码的地址
	 */
	public static final String DEFAULT_PARAMETER_NAME_CODE_EMAIL="emailCode";
	
	
	
	
	/**
	 * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
	/**
	 * 发送邮件验证码 或 验证邮件验证码时，传递邮件地址的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_EMAIL = "email";

/*	*//**
	 * session失效默认的跳转地址
	 *//*
	public static final String DEFAULT_SESSION_INVALID_URL = "/session/invalid";*/

	
	
	
	
}
