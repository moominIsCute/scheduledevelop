package com.schduledevelop.schedule.repository;

import com.schduledevelop.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScdRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByName(String name);
}
