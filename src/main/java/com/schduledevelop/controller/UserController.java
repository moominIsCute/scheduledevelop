package com.schduledevelop.controller;


import com.schduledevelop.dto.userdto.GetUserRespDto;
import com.schduledevelop.dto.userdto.PostUserReqDto;
import com.schduledevelop.dto.userdto.PostUserRespDto;
import com.schduledevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    ResponseEntity<PostUserRespDto> postUserReqDto(@Validated @RequestBody PostUserReqDto  postUserReqDto) {
        return ResponseEntity.ok(userService.save(postUserReqDto));
    }

    @GetMapping("/user")
    ResponseEntity<List<GetUserRespDto>> getUserReqDto() {
        return ResponseEntity.ok(userService.findAll());
    }


}
