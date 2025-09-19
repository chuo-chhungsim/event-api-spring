package com.supersimz.eventsattendeeapi.service;

import com.supersimz.eventsattendeeapi.model.entity.Attendee;
import com.supersimz.eventsattendeeapi.model.request.AttendeeRequest;
import com.supersimz.eventsattendeeapi.model.response.PayloadResponse;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface AttendeeService {

    PayloadResponse<Attendee> getAllAttendees(Integer page, Integer size, String sortBy, Sort.Direction direction);

    Attendee createAttendee(AttendeeRequest request);

    Attendee getAttendeeById(UUID id);

    Attendee updateAttendee(UUID attendeeId, AttendeeRequest request);

    void deleteAttendee(UUID attendeeId);

}
