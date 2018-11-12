package com.evshang.oauth2.permission.impl;

import com.evshang.oauth2.permission.PermissionService;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Set;

@Order(1000)
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {


    //@Autowired
    //UserFeign userFeign;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    private HashMap<String,Set<String>> urlMap = new HashMap<>();



    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();

        Object authorities= authentication.getAuthorities();
        //Object au
        Object details = authentication.getDetails();

        Object credentials= authentication.getCredentials();


        boolean hasPermission = true;

       /* if (authentication instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            //System.out.println(username);
            //User user = userFeign.queryUserByUserName(username);
            //获取用户的对应的链接 此处可以使用redis缓存用户的链接,
            Set<String> urls = new HashSet<String>();

            for (String url : urls) {
                if (antPathMatcher.match(url, request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
        }*/
      /* String requestUrl = request.getRequestURI();
        //log.info("requestUrl:{}",requestUrl);
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();


        if (principal != null){
            if (CollectionUtils.isEmpty(grantedAuthorityList)){
                return hasPermission;
            }

            return true;
           *//* for (SimpleGrantedAuthority authority:grantedAuthorityList
                    ) {
                if (antPathMatcher.match(authority.getAuthority(),requestUrl)){
                    hasPermission = true;
                    break;
                }
            }*//*
        }*/





        return hasPermission;
    }
}

