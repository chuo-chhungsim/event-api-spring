package com.supersimz.eventsattendeeapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tblAttendee")
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID attendeeId;
    private String attendeeName;
    @Column(unique = true)
    private String email;
}