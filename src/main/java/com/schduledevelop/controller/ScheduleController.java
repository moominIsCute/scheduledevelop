package com.schduledevelop.controller;


import com.schduledevelop.dto.scddto.*;
import com.schduledevelop.service.ScdService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScdService scdService;

    @PostMapping("/users/{userId}/schedules")
    public ResponseEntity<PostScdRespDto> saveSchedule(
            @RequestBody PostScdReqDto reqDto,
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(scdService.save(reqDto, userId));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<GetScdRespDto>> getSchedules(
            @RequestParam(required = false) String name
    ) {
        return ResponseEntity.ok(scdService.findSchedules(name));
    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetScdRespDto> getSchedule(@PathVariable Long scheduleId) {
        return ResponseEntity.ok(scdService.findSchedule(scheduleId));
    }

    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<PatchScdRespDto> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody PatchScdReqDto patchScdReqDto) {
        return ResponseEntity.ok(scdService.updateScd(scheduleId, patchScdReqDto));
    }

    @DeleteMapping("/schedules/{id}")
    public void deleteSchedules(
            @PathVariable("id") Long id,
            @RequestBody String password
            ) {
        scdService.deleteScd(id, password);

    }


}
