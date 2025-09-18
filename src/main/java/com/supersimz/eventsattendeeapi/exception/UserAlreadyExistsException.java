package com.supersimz.eventsattendeeapi.exception;

public class UserAlreadyExistsException extends RuntimeException {
    private final String email;

    public UserAlreadyExistsException(String email) {
        super("An attendee with email " + email + " already exists");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
