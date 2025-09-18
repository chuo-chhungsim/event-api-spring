package com.supersimz.eventsattendeeapi.controller;

import com.supersimz.eventsattendeeapi.model.entity.Attendee;
import com.supersimz.eventsattendeeapi.model.request.AttendeeRequest;
import com.supersimz.eventsattendeeapi.model.response.ApiResponse;
import com.supersimz.eventsattendeeapi.service.AttendeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/attendees")
public class AttendeeController {
    private final AttendeeService attendeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Attendee>>> getAttendees(@RequestParam(defaultValue = "1") Integer page,
                                                                    @RequestParam(defaultValue = "10") Integer size) {
        List<Attendee> attendees = attendeeService.getAllAttendees(page, size);
        ApiResponse<List<Attendee>> response = ApiResponse.<List<Attendee>>builder()
                .message("")
                .payload(attendees)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Attendee>> createAttendee(@RequestBody @Valid AttendeeRequest request) {
        Attendee newAttendee = attendeeService.createAttendee(request);
        ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
                .message("Attendee added successfully")
                .payload(newAttendee)
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}