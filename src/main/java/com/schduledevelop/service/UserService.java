package com.schduledevelop.service;

import com.schduledevelop.dto.PostUserReqDto;
import com.schduledevelop.dto.PostUserRespDto;
import com.schduledevelop.entity.User;
import com.schduledevelop.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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




}
