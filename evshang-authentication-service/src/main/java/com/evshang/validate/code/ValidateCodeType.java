/**
 * 
 */
package com.evshang.validate.code;


import com.evshang.constant.SecurityConstants;

/**
 * @author
 *
 */
public enum ValidateCodeType {
	
	/**
	 * 短信验证码
	 */
	SMS {
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
		}
	},
	/**
	 * 图片验证码
	 */
	IMAGE {
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
		}
	},
	EMAIL{
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_EMAIL;
		}
	};
	
	
	
	/**
	 * 校验时从请求中获取的参数的名字
	 * @return
	 */
	public abstract String getParamNameOnValidate();

}
