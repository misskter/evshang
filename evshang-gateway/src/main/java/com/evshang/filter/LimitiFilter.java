package com.evshang.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

@Component
public class LimitiFilter extends ZuulFilter {


    private static final RateLimiter rateLimiter = RateLimiter.create(1000);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.printf("common in this here ");
        if(!rateLimiter.tryAcquire()){
            throw new RuntimeException("当前访问人数较多，清稍后再试");
        }
        return null;
    }
}
