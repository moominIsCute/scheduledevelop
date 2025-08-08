package com.schduledevelop.controller;


import com.schduledevelop.dto.PostUserReqDto;
import com.schduledevelop.dto.PostUserRespDto;
import com.schduledevelop.entity.User;
import com.schduledevelop.service.UserService;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    ResponseEntity<PostUserRespDto> postUserReqDto(@Validated @RequestBody PostUserReqDto  postUserReqDto) {
        return ResponseEntity.ok(userService.save(postUserReqDto));
    }


}
