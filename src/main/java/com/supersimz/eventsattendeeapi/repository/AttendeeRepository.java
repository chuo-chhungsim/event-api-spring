package com.supersimz.eventsattendeeapi.repository;

import com.supersimz.eventsattendeeapi.model.entity.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttendeeRepository extends JpaRepository<Attendee,UUID> {
    boolean existsByEmail(String email);

}
