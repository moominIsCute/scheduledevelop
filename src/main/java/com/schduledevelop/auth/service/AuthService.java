package com.schduledevelop.auth.service;


import com.schduledevelop.auth.dto.AuthLoginRequest;
import com.schduledevelop.auth.dto.AuthRequest;
import com.schduledevelop.auth.dto.AuthResponse;
import com.schduledevelop.user.entity.User;
import com.schduledevelop.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    @Transactional
    public void signup(AuthRequest request) {
        User user = new User(request.getName(), request.getMail(), request.getPassword());
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public AuthResponse login(AuthLoginRequest request, HttpServletRequest request1
    ) {
        HttpSession session = request1.getSession();
        User user = userRepository.findByMail(request.getMail()).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다.")
        );
        session.setAttribute("LOGIN_USER", user.getId());
        return new AuthResponse(user.getUsername(), user.getMail());
    }
}
