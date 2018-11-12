package com.evshang.oauth2.permission;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;


public interface PermissionService {


    /*
     * 验证是否有权限访问一个链接
     * @param request
     * @param authentication
     * @return
     */

    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
