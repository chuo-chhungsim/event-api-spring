package com.supersimz.eventsattendeeapi.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeRequest {
    @NotNull
    @NotBlank(message = "Attendee name cannot be blank")
    @Size(min = 3, max = 100, message = "Attendee name must be between 3 and 100 characters")
    private String attendeeName;

    @NotNull
    @Email(message = "Email should be valid")
    private String email;
}