package com.evshang.permission.impl;

import com.evshang.entity.User;
import com.evshang.feign.UserFeign;
import com.evshang.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {


    @Autowired
    UserFeign userFeign;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    private HashMap<String,Set<String>> urlMap = new HashMap<>();



    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            //System.out.println(username);
            User user = userFeign.queryUserByUserName(username);
            //获取用户的对应的链接 此处可以使用redis缓存用户的链接,
            Set<String> urls = new HashSet<String>();

            for (String url : urls) {
                if (antPathMatcher.match(url, request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}

