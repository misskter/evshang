package com.evshang.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 拒绝访问资源返回403错误
 */
@Component
public class EvshangOAuth2AccessDeniedHandler extends OAuth2AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
        response.getOutputStream().print("aasfaa");
    }
}
