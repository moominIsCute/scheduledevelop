package com.schduledevelop.dto.userdto;

import lombok.Getter;

@Getter
public class GetUserRespDto {
    private String username;
    private String mail;

    public GetUserRespDto(String username, String mail) {
        this.username = username;
        this.mail = mail;
    }
}
