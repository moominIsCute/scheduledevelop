package com.schduledevelop.auth.controller;


import com.schduledevelop.auth.dto.AuthLoginRequest;
import com.schduledevelop.auth.dto.AuthRequest;
import com.schduledevelop.auth.dto.AuthResponse;
import com.schduledevelop.auth.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public String signup(
            @RequestBody AuthRequest request
    ) {
        authService.signup(request);
        return "회원가입에 성공했습니다.";
    }

    @PostMapping("/login")
    public String login(
            @RequestBody AuthLoginRequest authLoginRequest,
            HttpServletRequest request
    ) {
        authService.login(authLoginRequest,request);
        return "로그인에 성공했습니다.";
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}