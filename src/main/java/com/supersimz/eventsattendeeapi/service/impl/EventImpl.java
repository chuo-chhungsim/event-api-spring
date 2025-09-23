package com.supersimz.eventsattendeeapi.service.impl;

import com.supersimz.eventsattendeeapi.exception.UserNotFoundException;
import com.supersimz.eventsattendeeapi.model.dto.request.EventRequest;
import com.supersimz.eventsattendeeapi.model.dto.response.PaginationResponse;
import com.supersimz.eventsattendeeapi.model.dto.response.PayloadResponse;
import com.supersimz.eventsattendeeapi.model.entity.Attendee;
import com.supersimz.eventsattendeeapi.model.entity.Event;
import com.supersimz.eventsattendeeapi.repository.AttendeeRepository;
import com.supersimz.eventsattendeeapi.repository.EventRepository;
import com.supersimz.eventsattendeeapi.repository.VenueRepository;
import com.supersimz.eventsattendeeapi.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventImpl implements EventService {
    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    private final AttendeeRepository attendeeRepository;

    @Override
    public PayloadResponse<Event> getAllEvents(Integer page, Integer size, String sortBy, Sort.Direction direction) {
        Page<Event> eventPage = eventRepository.findAll(
                PageRequest.of(page - 1, size, Sort.by(direction, sortBy))
        );
        return PayloadResponse.<Event>builder()
                .items(eventPage.getContent())
                .pagination(PaginationResponse.fromPage(eventPage, page, size))
                .build();
    }

    @Override
    public Event getEventById(UUID eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new UserNotFoundException(eventId));
    }

    @Override
    public Event createEvent(EventRequest request) {
        Event event = new Event();
        event.setEventName(request.getEventName());
        event.setEventDate(request.getEventDate());
        event.setVenue(venueRepository.findById(request.getVenueId())
                .orElseThrow(() -> new UserNotFoundException(request.getVenueId())));
        List<Attendee> attendees = attendeeRepository.findAllById(request.getAttendeesId());
        event.setAttendees(attendees);
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(UUID eventId, EventRequest request) {
        Event event = getEventById(eventId);
        event.setEventName(request.getEventName());
        event.setEventDate(request.getEventDate());
        event.setVenue(venueRepository.findById(request.getVenueId())
                .orElseThrow(() -> new UserNotFoundException(request.getVenueId())));
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(UUID eventId) {
        eventRepository.deleteById(eventId);
    }
}
