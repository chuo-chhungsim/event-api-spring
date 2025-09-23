package com.supersimz.eventsattendeeapi.controller;

import com.supersimz.eventsattendeeapi.model.dto.request.VenueRequest;
import com.supersimz.eventsattendeeapi.model.dto.response.ApiResponse;
import com.supersimz.eventsattendeeapi.model.dto.response.PayloadResponse;
import com.supersimz.eventsattendeeapi.model.entity.Venue;
import com.supersimz.eventsattendeeapi.service.VenueService;
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
@RequestMapping("api/v1/venues")
@RequiredArgsConstructor
@Tag(name = "Venue")
public class VenueController {
    private final VenueService venueService;

    @Operation(summary = "Get all venues")
    @GetMapping

    public ResponseEntity<ApiResponse<PayloadResponse<Venue>>> getAllVenues(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "venueName") String sortBy,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction
    ) {
        PayloadResponse<Venue> payload = venueService.getAllVenues(page, size, sortBy, direction);
        ApiResponse<PayloadResponse<Venue>> response = ApiResponse.<PayloadResponse<Venue>>builder()
                .message("Get all venues successfully")
                .status(HttpStatus.OK)
                .payload(payload)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get venue by id")
    @GetMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<Venue>> getVenueById(@PathVariable("venue-id") UUID id) {
        Venue venue = venueService.getVenueById(id);
        ApiResponse<Venue> response = ApiResponse.<Venue>builder()
                .message("Get venue by id successfully")
                .status(HttpStatus.OK)
                .payload(venue)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a new venue")
    @PostMapping
    public ResponseEntity<ApiResponse<Venue>> createVenue(@RequestBody @Valid VenueRequest venueRequest) {
        Venue createdVenue = venueService.createVenue(venueRequest);
        ApiResponse<Venue> response = ApiResponse.<Venue>builder()
                .message("Create venue successfully")
                .status(HttpStatus.CREATED)
                .payload(createdVenue)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update venue by id")
    @PutMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<Venue>> updateVenue(
            @Valid
            @PathVariable("venue-id") UUID id,
            @RequestBody VenueRequest venueRequest
    ) {
        Venue updatedVenue = venueService.updateVenue(id, venueRequest);
        ApiResponse<Venue> response = ApiResponse.<Venue>builder()
                .message("Update venue successfully")
                .status(HttpStatus.OK)
                .payload(updatedVenue)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete venue by id")
    @DeleteMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<Void>> deleteVenue(@PathVariable("venue-id") UUID id) {
        venueService.deleteVenue(id);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .message("Delete venue successfully")
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(response);
    }

}
