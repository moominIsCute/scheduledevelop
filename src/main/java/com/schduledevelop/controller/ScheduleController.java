package com.schduledevelop.controller;


import com.schduledevelop.dto.PostScdReqDto;
import com.schduledevelop.dto.PostScdRespDto;
import com.schduledevelop.service.ScdService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScdService scdService;

    @PostMapping("/schedule")
    public ResponseEntity<PostScdRespDto> respDto(
            @RequestBody PostScdReqDto reqDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scdService.postScdRespDto(reqDto));
    }
}
