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

    @GetMapping("/users/{userId}/schedules")
    public ResponseEntity<GetScdRespDto> getSchedule(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(scdService.findSchedule(userId));
    }

    @PutMapping("/users/{userId}/schedules")
    public ResponseEntity<PatchScdRespDto> updateSchedule(
            @PathVariable("userId") Long userId,
            @RequestBody PatchScdReqDto patchScdReqDto) {
        return ResponseEntity.ok(scdService.updateScd(userId, patchScdReqDto));
    }

    @DeleteMapping("/schedules/{Id}")
    public void deleteSchedules(
            @PathVariable("userId") Long userId,
            @RequestBody String password
            ) {
        scdService.deleteScd(userId, password);

    }


}
