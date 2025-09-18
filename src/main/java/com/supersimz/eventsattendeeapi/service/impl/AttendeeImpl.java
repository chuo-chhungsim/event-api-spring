package com.supersimz.eventsattendeeapi.service.impl;

import com.supersimz.eventsattendeeapi.exception.UserAlreadyExistsException;
import com.supersimz.eventsattendeeapi.exception.UserNotFoundException;
import com.supersimz.eventsattendeeapi.model.entity.Attendee;
import com.supersimz.eventsattendeeapi.model.request.AttendeeRequest;
import com.supersimz.eventsattendeeapi.repository.AttendeeRepository;
import com.supersimz.eventsattendeeapi.service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendeeImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;
    @Override
    public List<Attendee> getAllAttendees(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Attendee> attendeePage = attendeeRepository.findAll(pageable);
        return attendeePage.getContent();
    }

    @Override
    public Attendee createAttendee(AttendeeRequest request) {

        if (attendeeRepository.existsByEmail(request.getEmail())){
            throw new UserAlreadyExistsException(request.getEmail());
        }

        Attendee attendee = new Attendee();
        attendee.setAttendeeName(request.getAttendeeName());
        attendee.setEmail(request.getEmail());

        return attendeeRepository.save(attendee);
    }
}
