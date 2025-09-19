package com.supersimz.eventsattendeeapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteResponse<T>{
    private String message;
    private HttpStatus status;
    @Builder.Default
    private Instant requestedTime = Instant.now();
}
