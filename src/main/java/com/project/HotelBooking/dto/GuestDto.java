package com.project.HotelBooking.dto;

import lombok.Data;

@Data
public class GuestDto {

    private String firstName;

    private String lastName;

    private String middleName;

    private String passportNumber;

    private String email;

    private String phone;
}
