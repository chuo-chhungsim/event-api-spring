package com.supersimz.eventsattendeeapi.controller;

import com.supersimz.eventsattendeeapi.model.dto.request.EventRequest;
import com.supersimz.eventsattendeeapi.model.dto.response.ApiResponse;
import com.supersimz.eventsattendeeapi.model.dto.response.PayloadResponse;
import com.supersimz.eventsattendeeapi.model.entity.Event;
import com.supersimz.eventsattendeeapi.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/events")
@RequiredArgsConstructor
@Tag(name = "Events")
public class EventController {
    private final EventService eventService;

    @Operation(summary = "Get all events")
    @GetMapping
    public ResponseEntity<ApiResponse<PayloadResponse<Event>>> getAllEvents(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "eventName") String sortBy,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction
    ) {
        PayloadResponse<Event> payload = eventService.getAllEvents(page, size, sortBy, direction);
        ApiResponse<PayloadResponse<Event>> response = ApiResponse.<PayloadResponse<Event>>builder()
                .message("Get all events successfully")
                .status(HttpStatus.OK)
                .payload(payload)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get event by id")
    @GetMapping("/{event-id}")
    public ResponseEntity<ApiResponse<Event>> getEventById(@PathVariable("event-id") UUID eventId) {
        Event event = eventService.getEventById(eventId);
        ApiResponse<Event> response = ApiResponse.<Event>builder()
                .message("Get event by id successfully")
                .status(HttpStatus.OK)
                .payload(event)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create event")
    @PostMapping
    public ResponseEntity<ApiResponse<Event>> createEvent(@RequestBody @Valid EventRequest request) {
        Event createdEvent = eventService.createEvent(request);
        ApiResponse<Event> response = ApiResponse.<Event>builder()
                .message("Create event successfully")
                .status(HttpStatus.CREATED)
                .payload(createdEvent)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update event")
    @PutMapping("/{event-id}")
    public ResponseEntity<ApiResponse<Event>> updateEvent(
            @Valid @PathVariable("event-id") UUID eventId,
            @RequestBody EventRequest request
    ) {
        Event updatedEvent = eventService.updateEvent(eventId, request);
        ApiResponse<Event> response = ApiResponse.<Event>builder()
                .message("Update event successfully")
                .status(HttpStatus.OK)
                .payload(updatedEvent)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete event")
    @DeleteMapping("/{event-id}")
    public ResponseEntity<ApiResponse<Void>> deleteEvent(@PathVariable("event-id") UUID eventId) {
        eventService.deleteEvent(eventId);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .message("Delete event successfully")
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(response);
    }


}
