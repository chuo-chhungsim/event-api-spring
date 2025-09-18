package com.supersimz.eventsattendeeapi.service;

import com.supersimz.eventsattendeeapi.model.entity.Attendee;
import com.supersimz.eventsattendeeapi.model.request.AttendeeRequest;

import java.util.List;

public interface AttendeeService {

    List<Attendee> getAllAttendees(Integer page, Integer size);

    Attendee createAttendee(AttendeeRequest request);
}
