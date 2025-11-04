package com.project.HotelBooking.exceptions;

public class UnavailableDateException extends RuntimeException{

    public UnavailableDateException(String message) {
        super(message);
    }
}
