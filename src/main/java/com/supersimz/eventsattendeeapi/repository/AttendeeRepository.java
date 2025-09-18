package com.supersimz.eventsattendeeapi.repository;

import com.supersimz.eventsattendeeapi.model.entity.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee,Long> {
    boolean existsByEmail(String email);
}
