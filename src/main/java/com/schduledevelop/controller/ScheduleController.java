package com.schduledevelop.controller;


import com.schduledevelop.dto.*;
import com.schduledevelop.service.ScdService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScdService scdService;

    @PostMapping("/schedule")
    public ResponseEntity<PostScdRespDto> saveSchedule(
            @RequestBody PostScdReqDto reqDto
    ) {
        return ResponseEntity.ok(scdService.save(reqDto));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<GetScdRespDto>> getSchedules(
            @RequestParam(required = false) String name
    ) {
        return ResponseEntity.ok(scdService.findSchedules(name));
    }

    @GetMapping("/schedule/{Id}")
    //@PathVariable("Id") 이거 생각 안나서 인터넷 검색함
    public ResponseEntity<GetScdRespDto> getSchedules(@PathVariable("Id") Long Id) {
        return ResponseEntity.ok(scdService.findSchedule(Id));
    }

    @PutMapping("/schedule/{Id}")
    public ResponseEntity<PatchScdRespDto> updateSchedule(
            @PathVariable("Id") Long id,
            @RequestBody PatchScdReqDto patchScdReqDto) {
        return ResponseEntity.ok(scdService.updateScd(id, patchScdReqDto));
    }
}
