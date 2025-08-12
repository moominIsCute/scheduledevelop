package com.schduledevelop.controller;


import com.schduledevelop.dto.userdto.UserRespDto;
import com.schduledevelop.dto.userdto.UserReqDto;
import com.schduledevelop.dto.userdto.PostUserRespDto;
import com.schduledevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    ResponseEntity<PostUserRespDto> saveUser(@Validated @RequestBody UserReqDto userReqDto) {
        return ResponseEntity.ok(userService.save(userReqDto));
    }

    @GetMapping("/users")
    ResponseEntity<List<UserRespDto>> findAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/users/{id}")
    ResponseEntity<UserRespDto> findByIdUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PatchMapping("/users/{id}")
    ResponseEntity<UserRespDto> updateUser(
            @PathVariable Long id,
            UserReqDto userReqDto) {
        return ResponseEntity.ok(userService.upDate(id,userReqDto));

    }


}
