package com.evshang.entity;

import lombok.Data;


@Data
public class User  {


        private Integer uroleId;

        private String username;

        private String password;

        private Urole urole;

}
