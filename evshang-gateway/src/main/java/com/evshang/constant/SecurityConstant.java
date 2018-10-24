package com.evshang.constant;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@Configuration
@ConfigurationProperties(prefix = "security")
@Component
public class SecurityConstant {

    /**
     * 需要排除的url,后续从配置中心获取
     */
    private List<String> excludeUrls = Lists.newArrayList();
}
