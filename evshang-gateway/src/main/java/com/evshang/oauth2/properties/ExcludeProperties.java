package com.evshang.oauth2.properties;


import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Data
@ConfigurationProperties(prefix = "exclude")
public class ExcludeProperties {

    private List<String> excludeUrls = Lists.newArrayList();
}
