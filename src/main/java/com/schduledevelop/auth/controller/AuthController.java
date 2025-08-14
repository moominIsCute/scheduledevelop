package com.schduledevelop.auth.controller;


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
            @RequestBody AuthRequest authRequest,
            HttpServletRequest request
    ) {
        // Cookie Session을 발급
        AuthResponse result = authService.login(authRequest);

        HttpSession session = request.getSession();
        session.setAttribute("LOGIN_USER", result.getName());
        return "로그인에 성공했습니다.";
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        // 로그인하지 않으면 HttpSession이 null로 반환된다.
        HttpSession session = request.getSession(false);
        // 세션이 존재하면 -> 로그인이 된 경우
        if (session != null) {
            session.invalidate(); // 해당 세션(데이터)을 삭제한다.
        }
    }
}