package com.schduledevelop.dto;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class PatchScdReqDto {

    private final String title;
    private final String contents;
    private final String password;



    public PatchScdReqDto(String title, String contents, String password) {
        this.title = title;
        this.contents = contents;
        this.password = password;
    }
}

