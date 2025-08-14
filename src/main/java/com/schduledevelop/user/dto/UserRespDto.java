package com.schduledevelop.user.dto;

import lombok.Getter;

@Getter
public class UserRespDto {
    private String username;
    private String mail;

    public UserRespDto(String username, String mail) {
        this.username = username;
        this.mail = mail;
    }
}
