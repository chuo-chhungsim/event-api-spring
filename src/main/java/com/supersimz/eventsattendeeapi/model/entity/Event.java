package com.supersimz.eventsattendeeapi.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "tbl_event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "event_id")
    private UUID eventId;
    @Column(name = "event_name")
    private String eventName;
    @Column(name = "event_date")
    private Date eventDate;

    @ManyToOne()
    @JoinColumn(name = "venue_id")
    @JsonBackReference
    private Venue venue;

    @ManyToMany
    @JoinTable(
            name = "tbl_event_attendee",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "attendee_id")
    )
    private List<Attendee> attendees;
}
