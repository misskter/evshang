package com.evshang.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nickname;
    private String username;
    private String password;
    private String headPortrait;
    //盐值，登录验证
    private String salt;
    private String signature;
    private Integer version;
    private String address;
    private String email;
    private Date birthday;
    private String phone;
    private Integer sex;
    private Date createTime;
    private Date updateTime;
    //表明注册是哪个平台
    private String channel;
    private Integer uroleId;
    //private Urole urole;

    //private List<Article> articles=new ArrayList<Article>();


}
