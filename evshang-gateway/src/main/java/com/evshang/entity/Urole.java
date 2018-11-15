package com.evshang.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Urole implements Serializable {

    private static final long serialVersionUID = 6751401787590988066L;

    private Integer id;

    private String uroleName;

    private Integer uroleCode;

}
