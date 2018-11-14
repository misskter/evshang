package com.evshang.oauth2.permission.impl;

import com.evshang.oauth2.permission.PermissionService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Order(Integer.MAX_VALUE)
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object authorities= authentication.getAuthorities();
        boolean hasPermission = false;
        Set<String> urls = new HashSet<>();
        Collection<GrantedAuthority> urolsNames = (Collection<GrantedAuthority>) authorities;
        for (GrantedAuthority grantedAuthority:urolsNames) {
           String uroleName = grantedAuthority.getAuthority();
            urls = redisTemplate.opsForSet().members(uroleName);
           if(CollectionUtils.isEmpty(urls)){
               //调用用户服务提供的角色和资源的接口
               String url1 = "/user";
               String url2 = "/list";
               Set<String> set = new HashSet<>();
               set.add(url1);
               set.add(url2);
               String [] u = set.toArray(new String[set.size()]);
               redisTemplate.opsForSet().add(uroleName,u);
               urls.addAll(set);
           }
        }
        for (String url : urls) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                hasPermission = true;
                break;
            }
        }
        return hasPermission;
    }





}

