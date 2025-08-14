package com.schduledevelop.user.dto;

import lombok.Getter;

@Getter
public class PostUserRespDto {

    private final String username;
    private final String mail;

    public PostUserRespDto(String username, String mail) {
        this.username = username;
        this.mail = mail;
    }
}
