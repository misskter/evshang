package com.evshang.oauth2.entity;

import com.evshang.entity.Urole;
import lombok.Data;


@Data
public class User  {


        private Integer uroleId;

        private String username;

        private String password;

        private Urole urole;

}
