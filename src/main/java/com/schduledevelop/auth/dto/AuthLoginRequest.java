package com.schduledevelop.auth.dto;

import lombok.Getter;

@Getter
public class AuthLoginRequest {
    private final String mail;
    private final String password;

    public AuthLoginRequest(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }
}
