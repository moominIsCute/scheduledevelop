package com.schduledevelop.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetScdRespDto {
    private final String title;
    private final String contents;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public GetScdRespDto(Long id, String title, String contents, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.contents = contents;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
