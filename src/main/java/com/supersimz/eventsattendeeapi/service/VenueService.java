package com.supersimz.eventsattendeeapi.service;

import com.supersimz.eventsattendeeapi.model.entity.Venue;
import com.supersimz.eventsattendeeapi.model.dto.request.VenueRequest;
import com.supersimz.eventsattendeeapi.model.dto.response.PayloadResponse;
import org.springframework.data.domain.Sort;

import java.util.UUID;

public interface VenueService {
    PayloadResponse<Venue> getAllVenues(Integer page, Integer size, String sortBy, Sort.Direction direction);

    Venue getVenueById(UUID id);

    Venue createVenue(VenueRequest venueRequest);

    Venue updateVenue(UUID id, VenueRequest venueRequest);

    void deleteVenue(UUID id);
}
