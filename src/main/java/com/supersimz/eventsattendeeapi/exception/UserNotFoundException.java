package com.supersimz.eventsattendeeapi.exception;

import lombok.Data;

public class UserNotFoundException extends RuntimeException {
    private final Long id;

    public UserNotFoundException(Long id) {
        super("Entity with id " + id + " not found");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
