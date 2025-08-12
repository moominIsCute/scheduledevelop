package com.schduledevelop.dto.userdto;

import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
public class UserReqDto {

    @NotNull
    private final String username;
    private final String mail;

    public UserReqDto(String username, String mail) {
        this.username = username;
        this.mail = mail;
    }
}
