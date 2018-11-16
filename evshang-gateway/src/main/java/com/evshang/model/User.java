package com.evshang.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -8671402532853504476L;

    private Urole urole;

    private String id;

    private String username;

    private String password;









}
