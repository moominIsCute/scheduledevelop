package com.schduledevelop.schedule.service;


import com.schduledevelop.schedule.dto.*;
import com.schduledevelop.schedule.entity.Schedule;
import com.schduledevelop.user.entity.User;
import com.schduledevelop.schedule.repository.ScdRepository;
import com.schduledevelop.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScdService {
    private final ScdRepository scdRepository;
    private final UserRepository userRepository;

    public PostScdRespDto save(PostScdReqDto reqDto, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다.")
        );
        Schedule schedule = new Schedule(
                reqDto.getTitle(),
                reqDto.getContents(),
                reqDto.getName(),
                reqDto.getPassword(),
                user
        );
        Schedule save = scdRepository.save(schedule);
        PostScdRespDto respDto = new PostScdRespDto(
                save.getTitle(),
                save.getContents(),
                save.getName(),
                save.getCreateAt(),
                save.getModifiedAt());
        return respDto;
    }

    public GetScdRespDto findSchedule(Long Id) {
        //스케쥴 변수 필요한건 알았음 그리고 파인드파이아이도 알고 있었으나 orElse는 자동완성 이용
        Schedule schedule = scdRepository.findById(Id).orElseThrow(
                () -> new IllegalArgumentException("Schedule not found")
        );
        GetScdRespDto respDto = new GetScdRespDto(
                schedule.getId(), schedule.getTitle(),
                schedule.getContents(),
                schedule.getName(),
                schedule.getCreateAt(),
                schedule.getModifiedAt());

        return respDto;
    }

    @Transactional(readOnly = true)
    public List<GetScdRespDto> findSchedules(String name) {
        List<Schedule> schedules;
        if (name == null || name.isEmpty()) {
            schedules = scdRepository.findAll();
        } else {
            schedules = scdRepository.findByName(name);
        }

        List<GetScdRespDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            GetScdRespDto scheduleGetOneResponse = new GetScdRespDto(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContents(),
                    schedule.getName(),
                    schedule.getCreateAt(),
                    schedule.getModifiedAt()
            );
            dtos.add(scheduleGetOneResponse);
        }
        return dtos;
    }


    @Transactional
    public PatchScdRespDto updateScd(Long Id, PatchScdReqDto reqDto) {
        Schedule schedule = scdRepository.findById(Id).orElseThrow(
                () -> new IllegalArgumentException("Schedule not found")
        );
        if (reqDto.getPassword().equals(schedule.getPassword())) {
            schedule.updateScd(reqDto.getTitle(), reqDto.getContents());
            PatchScdRespDto respDto = new PatchScdRespDto(
                    schedule.getTitle(),
                    schedule.getContents(),
                    schedule.getName()
            );
            return respDto;
        } else {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
    }

    public void deleteScd(Long Id, String password) {
        Schedule schedule = scdRepository.findById(Id).orElseThrow(
                () -> new IllegalArgumentException("Schedule not found")
        );
        if (password.equals(schedule.getPassword())) {
            scdRepository.deleteById(Id);
        }
    }

}
