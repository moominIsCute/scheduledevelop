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
                userReqDto.getMail());
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
        Optional<User> user = userRepository.findById(id);
        UserRespDto userRespDto = new UserRespDto(user.get().getUsername(), user.get().getMail());
        return userRespDto;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
