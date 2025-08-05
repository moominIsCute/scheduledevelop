package com.schduledevelop.repository;

import com.schduledevelop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScdRepository extends JpaRepository<Schedule, Long> {
}
