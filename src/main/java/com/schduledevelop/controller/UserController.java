package com.schduledevelop.controller;


import com.schduledevelop.dto.userdto.GetUserRespDto;
import com.schduledevelop.dto.userdto.PostUserReqDto;
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
    ResponseEntity<PostUserRespDto> saveUser(@Validated @RequestBody PostUserReqDto  postUserReqDto) {
        return ResponseEntity.ok(userService.save(postUserReqDto));
    }

    @GetMapping("/user")
    ResponseEntity<List<GetUserRespDto>> findAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/user/{id}")
    ResponseEntity<GetUserRespDto> findByIdUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }


}
