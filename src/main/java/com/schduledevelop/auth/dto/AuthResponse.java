package com.schduledevelop.auth.dto;

import com.schduledevelop.user.entity.User;
import lombok.Getter;

@Getter
public class AuthResponse {

    private final String name;
    private final String mail;

    public AuthResponse(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }
}
