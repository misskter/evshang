package com.evshang.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_ERROR_FILTER_ORDER;


@Component
public class EvshangZuulFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(EvshangZuulFilter.class);


    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_ERROR_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.printf("common in here" + EvshangZuulFilter.class.getSimpleName());

        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       // LOG.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        return null;
    }
}
