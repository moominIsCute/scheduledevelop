package com.schduledevelop.repository;

import com.schduledevelop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScdRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByName(String name);
}
