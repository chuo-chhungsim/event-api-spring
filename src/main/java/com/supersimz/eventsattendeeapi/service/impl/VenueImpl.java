package com.supersimz.eventsattendeeapi.service.impl;

import com.supersimz.eventsattendeeapi.exception.BadRequestException;
import com.supersimz.eventsattendeeapi.model.dto.request.VenueRequest;
import com.supersimz.eventsattendeeapi.model.dto.response.PaginationResponse;
import com.supersimz.eventsattendeeapi.model.dto.response.PayloadResponse;
import com.supersimz.eventsattendeeapi.model.entity.Venue;
import com.supersimz.eventsattendeeapi.repository.VenueRepository;
import com.supersimz.eventsattendeeapi.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VenueImpl implements VenueService {
    private final VenueRepository venueRepository;

    @Override
    public PayloadResponse<Venue> getAllVenues(Integer page, Integer size, String sortBy, Sort.Direction direction) {
        Page<Venue> venuePage = venueRepository.findAll(
                PageRequest.of(page - 1, size, Sort.by(direction, sortBy))
        );
        return PayloadResponse.<Venue>builder()
                .items(venuePage.getContent())
                .pagination(PaginationResponse.fromPage(venuePage, page, size))
                .build();
    }

    @Override
    public Venue getVenueById(UUID id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Venue id" + id + "not found"));
    }

    @Override
    public Venue createVenue(VenueRequest venueRequest) {
        Venue venue = new Venue();

        venue.setVenueName(venueRequest.getVenueName());
        venue.setLocation(venueRequest.getLocation());
        return venueRepository.save(venue);
    }

    @Override
    public Venue updateVenue(UUID id, VenueRequest venueRequest) {
        Venue venue = getVenueById(id);
        venue.setVenueName((venueRequest.getVenueName()));
        venue.setLocation(venueRequest.getLocation());
        return venueRepository.save(venue);
    }

    @Override
    public void deleteVenue(UUID id) {
        venueRepository.deleteById(id);
    }
}
