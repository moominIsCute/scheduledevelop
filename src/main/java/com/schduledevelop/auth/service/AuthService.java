package com.schduledevelop.auth.service;


import com.schduledevelop.auth.dto.AuthRequest;
import com.schduledevelop.auth.dto.AuthResponse;
import com.schduledevelop.user.entity.User;
import com.schduledevelop.user.repository.UserRepository;
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
    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByUsername(request.getName()).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다.")
        );
        return new AuthResponse(user.getUsername(), user.getMail());
    }
}
