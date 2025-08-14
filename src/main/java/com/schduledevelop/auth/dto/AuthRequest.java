package com.schduledevelop.auth.dto;

import lombok.Getter;

@Getter
public class AuthRequest {

    private final String name;
    private final String mail;
    private final String password;

    public AuthRequest(String name, String mail,String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }
}
