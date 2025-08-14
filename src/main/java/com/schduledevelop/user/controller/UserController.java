package com.schduledevelop.user.controller;


import com.schduledevelop.user.dto.UserRespDto;
import com.schduledevelop.user.dto.UserReqDto;
import com.schduledevelop.user.dto.PostUserRespDto;
import com.schduledevelop.user.service.UserService;
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
            @RequestBody UserReqDto userReqDto) {
        return ResponseEntity.ok(userService.upDate(id, userReqDto));

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id, @RequestBody String password) {
        userService.delete(id, password);
    }


}
