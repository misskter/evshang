/**
 * 
 */
package com.evshang.properties;

import lombok.Data;

/**
 * @author zhailiang
 *
 */
@Data
public class SocialProperties {
	
	private String filterProcessesUrl = "/auth";

	private QQProperties qq = new QQProperties();
	
	private WeixinProperties weixin = new WeixinProperties();


	
}
