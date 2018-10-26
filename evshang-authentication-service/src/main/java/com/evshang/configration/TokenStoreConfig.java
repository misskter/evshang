package com.evshang.configration;

import com.evshang.jwt.EvshangJwtTokenEnhancer;
import com.evshang.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;




/*配置token的生成
 * 
 * 
 */
@Configuration
public class TokenStoreConfig {
	
	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	
	@Bean
	@ConditionalOnProperty(prefix="evshang.security.oauth2",name="storyType",havingValue="redis")
	public TokenStore redisTokenStore() {
		return new RedisTokenStore(redisConnectionFactory);
	}

	@Configuration
	@ConditionalOnProperty(prefix="evshang.security.oauth2",name="storyType",havingValue="jwt",matchIfMissing=true)
	public static class JwtTokenConfig {
		
		@Autowired
		private SecurityProperties securityProperties;
		
		@Bean
		public TokenStore jwtTokenStore() {
			return new JwtTokenStore(jwtAccessTokenConverter());
		}
		
		@Bean
		public JwtAccessTokenConverter jwtAccessTokenConverter() {
			JwtAccessTokenConverter jwtAccessTokenConverter=new JwtAccessTokenConverter();
			jwtAccessTokenConverter.setSigningKey(securityProperties.getOauth2().jwtSigingKey);
			return jwtAccessTokenConverter;
		}
/*
		@Bean
		@ConditionalOnMissingBean(name="jwtTokenEnhancer")
		public TokenEnhancer jwtTokenEnhancer() {
			return new EvshangJwtTokenEnhancer();
		}*/

		
	}



	
	
}
