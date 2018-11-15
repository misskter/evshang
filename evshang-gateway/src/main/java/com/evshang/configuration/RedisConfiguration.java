/*
package com.evshang.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Data
@Configuration
@PropertySource("classpath:redis.properties")
public class RedisConfiguration<K, V> extends CachingConfigurerSupport {

    @Value("${spring.redis.hostName}")
    private String hostName;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private Integer timeout;
    @Value("${spring.redis.maxIdle}")
    private Integer maxIdle;
    @Value("${spring.redis.maxTotal}")
    private Integer maxTotal;
    @Value("${spring.redis.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${spring.redis.blockWhenExhausted}")
    private Boolean blockWhenExhausted;
    @Value("${spring.redis.evictionPolicyClassName}")
    private String evictionPolicyClassName;
    @Value("${spring.redis.jmxEnabled}")
    private Boolean jmxEnabled;
    @Value("${spring.redis.jmxNamePrefix}")
    private String jmxNamePrefix;
    @Value("${spring.redis.maxActive}")
    private Integer maxActive;
    @Value("${spring.redis.numTestsPerEvictionRun}")
    private Integer numTestsPerEvictionRun;
    @Value("${spring.redis.minIdle}")
    private Integer minIdle;
    @Value("${spring.redis.maxWait}")
    private Integer maxWait;
    @Value("${spring.redis.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${spring.redis.testOnReturn}")
    private Boolean testOnReturn;
    @Value("${spring.redis.lifo}")
    private Boolean lifo;

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(maxWait);
        poolConfig.setTestOnBorrow(testOnBorrow);
        poolConfig.setTestOnReturn(testOnReturn);
        poolConfig.setTestWhileIdle(testWhileIdle);
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setLifo(lifo);
        poolConfig.setEvictionPolicyClassName(evictionPolicyClassName);
        poolConfig.setJmxEnabled(jmxEnabled);
        poolConfig.setJmxNamePrefix(jmxNamePrefix);
        poolConfig.setMaxWaitMillis(maxWait);
        poolConfig.setBlockWhenExhausted(blockWhenExhausted);
        poolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        return poolConfig;
    }
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig());
        jedisConnectionFactory.setHostName(hostName);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setPassword(password);
        jedisConnectionFactory.setTimeout(timeout);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<K, V> redisTemplate(JedisConnectionFactory factory)
    {
        RedisTemplate<K, V> template = new RedisTemplate<K, V>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate<K,V> redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        return rcm;
    }



}
*/
