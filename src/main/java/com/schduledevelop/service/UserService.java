package com.schduledevelop.service;

import com.schduledevelop.dto.userdto.GetUserRespDto;
import com.schduledevelop.dto.userdto.PostUserReqDto;
import com.schduledevelop.dto.userdto.PostUserRespDto;
import com.schduledevelop.entity.User;
import com.schduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public PostUserRespDto save(PostUserReqDto postUserReqDto) {
        User user = new User(
                postUserReqDto.getUsername(),
                postUserReqDto.getMail());
        userRepository.save(user);
        PostUserRespDto postUserRespDto = new PostUserRespDto(
                user.getUsername(),
                user.getMail());
        return postUserRespDto;
    }

    public List<GetUserRespDto> findAll() {
        List<User> users = userRepository.findAll();
        List<GetUserRespDto> getUserRespDtos = new ArrayList<>();
        for (User user : users) {
            getUserRespDtos.add(new GetUserRespDto(
                    user.getUsername(),
                    user.getMail())
            );
        }
        return getUserRespDtos;
    }


}
