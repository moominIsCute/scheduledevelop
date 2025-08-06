package com.schduledevelop.dto;

import java.time.LocalDateTime;

public class PatchScdRespDto {

    private final String title;
    private final String contents;
    private final String name;


    public PatchScdRespDto(String title, String contents, String name) {
        this.title = title;
        this.contents = contents;
        this.name = name;

    }
}
