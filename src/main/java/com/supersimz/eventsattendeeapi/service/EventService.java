package com.supersimz.eventsattendeeapi.service;

import com.supersimz.eventsattendeeapi.model.dto.response.PayloadResponse;
import com.supersimz.eventsattendeeapi.model.entity.Event;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import com.supersimz.eventsattendeeapi.model.dto.request.EventRequest;


import java.util.UUID;

public interface EventService {
    PayloadResponse<Event> getAllEvents(Integer page, Integer size, String sortBy, Sort.Direction direction);

    Event getEventById(UUID eventId);

    Event createEvent(@Valid EventRequest request);

    Event updateEvent(@Valid UUID eventId, EventRequest request);

    void deleteEvent(UUID eventId);
}
