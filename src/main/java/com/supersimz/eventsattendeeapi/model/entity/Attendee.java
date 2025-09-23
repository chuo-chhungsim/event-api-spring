package com.supersimz.eventsattendeeapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_attendee")
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID attendeeId;
    private String attendeeName;
    @Column(unique = true)
    private String email;

    @ManyToMany(mappedBy = "attendees")
    @JsonIgnore
    private List<Event> events;
}