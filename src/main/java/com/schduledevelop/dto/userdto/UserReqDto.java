package com.schduledevelop.dto.userdto;

import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
public class UserReqDto {

    @NotNull
    private final String username;
    private final String mail;
    private final String password;

    public UserReqDto(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }
}
