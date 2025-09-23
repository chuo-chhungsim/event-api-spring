package com.supersimz.eventsattendeeapi.controller;

import com.supersimz.eventsattendeeapi.model.dto.request.AttendeeRequest;
import com.supersimz.eventsattendeeapi.model.dto.response.ApiResponse;
import com.supersimz.eventsattendeeapi.model.dto.response.DeleteResponse;
import com.supersimz.eventsattendeeapi.model.dto.response.PayloadResponse;
import com.supersimz.eventsattendeeapi.model.entity.Attendee;
import com.supersimz.eventsattendeeapi.service.AttendeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("api/v1/attendees")
@Tag(name = "Attendee")
public class AttendeeController {
    private final AttendeeService attendeeService;

    @Operation(summary = "Get all attendees")
    @GetMapping
    public ResponseEntity<ApiResponse<PayloadResponse<Attendee>>> getAllAttendees(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "attendeeName") String sortBy,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction
    ) {
        PayloadResponse<Attendee> payload = attendeeService.getAllAttendees(page, size, sortBy, direction);
        ApiResponse<PayloadResponse<Attendee>> response = ApiResponse.<PayloadResponse<Attendee>>builder()
                .message("Get all attendees successfully")
                .status(HttpStatus.OK)
                .payload(payload)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a new attendee")
    @PostMapping
    public ResponseEntity<ApiResponse<Attendee>> createAttendee(@RequestBody @Valid AttendeeRequest request) {
        Attendee newAttendee = attendeeService.createAttendee(request);
        ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
                .message("Attendee added successfully")
                .payload(newAttendee)
                .status(HttpStatus.CREATED)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Get attendee by id")
    @GetMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<Attendee>> getAttendeeById(@PathVariable("attendee-id") UUID id) {
        Attendee attendee = attendeeService.getAttendeeById(id);
        ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
                .message("Get attendee successfully")
                .payload(attendee)
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update attendee by id")
    @PutMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<Attendee>> updateAttendee(
            @Valid
            @PathVariable("attendee-id") UUID attendeeId,
            @RequestBody AttendeeRequest request) {
        Attendee updatedAttendee = attendeeService.updateAttendee(attendeeId, request);
        ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
                .message("Attendee updated successfully")
                .payload(updatedAttendee)
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete attendee by id")
    @DeleteMapping("/{attendee-id}")
    public ResponseEntity<DeleteResponse<Void>> deleteAttendee(@PathVariable("attendee-id") UUID attendeeId) {
        attendeeService.deleteAttendee(attendeeId);
        DeleteResponse<Void> response = DeleteResponse.<Void>builder()
                .message("Attendee deleted successfully")
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(response);
    }
}