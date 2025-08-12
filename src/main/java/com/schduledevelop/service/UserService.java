package com.schduledevelop.service;

import com.schduledevelop.dto.userdto.UserRespDto;
import com.schduledevelop.dto.userdto.UserReqDto;
import com.schduledevelop.dto.userdto.PostUserRespDto;
import com.schduledevelop.entity.User;
import com.schduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public PostUserRespDto save(UserReqDto userReqDto) {
        User user = new User(
                userReqDto.getUsername(),
                userReqDto.getMail(),
                userReqDto.getPassword()
        );

        userRepository.save(user);
        PostUserRespDto postUserRespDto = new PostUserRespDto(
                user.getUsername(),
                user.getMail());
        return postUserRespDto;
    }

    public List<UserRespDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserRespDto> userRespDtos = new ArrayList<>();
        for (User user : users) {
            userRespDtos.add(new UserRespDto(
                    user.getUsername(),
                    user.getMail())
            );
        }
        return userRespDtos;
    }

    public UserRespDto findById(Long id) {

        Optional<User> user = userRepository.findById(id);
        UserRespDto userRespDto = new UserRespDto(user.get().getUsername(), user.get().getMail());
        return userRespDto;

    }

    public UserRespDto upDate(Long id, UserReqDto userReqDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User not found"));
        if (user.getPassword().equals(userReqDto.getPassword())) {
            user.update(
                    userReqDto.getUsername(),
                    userReqDto.getMail(),
                    userReqDto.getPassword()
            );
            UserRespDto userRespDto = new UserRespDto(user.getUsername(), user.getMail());

            userRepository.save(user);
            return userRespDto;
        } else {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
    }

    public void delete(Long id, String password) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User not found")
        );
        if (user.getPassword().equals(password)) {
            userRepository.deleteById(id);
        }
    }
}
