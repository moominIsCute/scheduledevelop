package com.schduledevelop.service;


import com.schduledevelop.dto.PostScdReqDto;
import com.schduledevelop.dto.PostScdRespDto;
import com.schduledevelop.entity.Schedule;
import com.schduledevelop.repository.ScdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ScdService {
    private final ScdRepository scdRepository;

    public PostScdRespDto postScdRespDto(PostScdReqDto reqDto) {
        Schedule schedule = new Schedule(
                reqDto.getTitle(),
                reqDto.getContents(),
                reqDto.getName(),
                reqDto.getPassword()
        );
        scdRepository.save(schedule);
        PostScdRespDto respDto = new PostScdRespDto(
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getName(),
                schedule.getCreateAt(),
                schedule.getModifiedAt());
        return respDto ;
    }
}
