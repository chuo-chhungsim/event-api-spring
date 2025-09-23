package com.supersimz.eventsattendeeapi.repository;

import com.supersimz.eventsattendeeapi.model.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VenueRepository extends JpaRepository<Venue, UUID> {
    boolean existsByVenueName(String venueName);
}
