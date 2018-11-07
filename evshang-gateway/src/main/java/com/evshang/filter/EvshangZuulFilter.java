package com.evshang.filter;

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
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse servletResponse = context.getResponse();
        String header = request.getHeader("access-token");
        if(StringUtils.isNotBlank(header)){

        }
        servletResponse.addHeader("X-Foo", UUID.randomUUID().toString());
        return null;
    }
}
