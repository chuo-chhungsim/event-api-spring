package com.supersimz.eventsattendeeapi.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "tbl_venue")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "venue_id")
    private UUID venueId;
    @Column(name = "venue_name")
    private String venueName;
    private String location;

    @OneToMany(mappedBy = "venue",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<Event> events;

}
