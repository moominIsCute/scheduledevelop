package com.schduledevelop.service;


import com.schduledevelop.dto.*;
import com.schduledevelop.entity.Schedule;
import com.schduledevelop.repository.ScdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScdService {
    private final ScdRepository scdRepository;

    public PostScdRespDto save(PostScdReqDto reqDto) {
        Schedule schedule = new Schedule(
                reqDto.getTitle(),
                reqDto.getContents(),
                reqDto.getName(),
                reqDto.getPassword()
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
        List<Schedule> schedules = scdRepository.findAll();
        List<GetScdRespDto> dtos = new ArrayList<>();

        if (name == null) {
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
        for (Schedule schedule : schedules) {
            if (name.equals(schedule.getName())) {
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

}
