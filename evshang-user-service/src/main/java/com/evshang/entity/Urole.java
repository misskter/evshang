package com.evshang.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Urole {

    @Id
    @GeneratedValue
    private Integer id;

    private String uroleName;

    private Integer uroleCode;

}
