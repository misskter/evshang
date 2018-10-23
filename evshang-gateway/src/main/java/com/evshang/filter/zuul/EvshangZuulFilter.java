package com.evshang.filter.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

@Component
public class EvshangZuulFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SIMPLE_HOST_ROUTING_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse servletResponse = context.getResponse();
        String header = request.getHeader("token");
        if(StringUtils.isNotBlank(header)){

        }
        servletResponse.addHeader("X-Foo", UUID.randomUUID().toString());
        return null;
    }
}
