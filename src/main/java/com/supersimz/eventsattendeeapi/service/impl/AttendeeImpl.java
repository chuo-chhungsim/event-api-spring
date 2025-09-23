package com.supersimz.eventsattendeeapi.service.impl;

import com.supersimz.eventsattendeeapi.exception.UserAlreadyExistsException;
import com.supersimz.eventsattendeeapi.exception.UserNotFoundException;
import com.supersimz.eventsattendeeapi.model.entity.Attendee;
import com.supersimz.eventsattendeeapi.model.dto.request.AttendeeRequest;
import com.supersimz.eventsattendeeapi.model.dto.response.PaginationResponse;
import com.supersimz.eventsattendeeapi.model.dto.response.PayloadResponse;
import com.supersimz.eventsattendeeapi.repository.AttendeeRepository;
import com.supersimz.eventsattendeeapi.service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttendeeImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;
    @Override
    public PayloadResponse<Attendee> getAllAttendees(Integer page, Integer size, String sortBy, Sort.Direction direction) {
        Page<Attendee> attendeePage = attendeeRepository.findAll(
                PageRequest.of(page - 1, size, Sort.by(direction, sortBy))
        );
        return PayloadResponse.<Attendee>builder()
                .items(attendeePage.getContent())
                .pagination(PaginationResponse.fromPage(attendeePage, page, size))
                .build();
    }
    @Override
    public Attendee createAttendee(AttendeeRequest request) {

        if (attendeeRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException(request.getEmail());
        }

        Attendee attendee = new Attendee();
        attendee.setAttendeeName(request.getAttendeeName());
        attendee.setEmail(request.getEmail());

        return attendeeRepository.save(attendee);
    }

    @Override
    public Attendee getAttendeeById(UUID id) {
        return attendeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Attendee updateAttendee(UUID attendeeId, AttendeeRequest request) {
        Attendee attendee = getAttendeeById(attendeeId);
        if (attendee == null) {
            throw new UserNotFoundException(attendeeId);
        }
        attendee.setAttendeeName(request.getAttendeeName());
        attendee.setEmail(request.getEmail());
        return attendeeRepository.save(attendee);
    }

    @Override
    public void deleteAttendee(UUID attendeeId) {
        attendeeRepository.deleteById(attendeeId);
    }

}
