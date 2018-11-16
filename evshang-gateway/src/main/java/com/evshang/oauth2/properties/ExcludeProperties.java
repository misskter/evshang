package com.evshang.oauth2.properties;


import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "exclude")
public class ExcludeProperties {

    private List<String> excludeUrls = Lists.newArrayList();
}
