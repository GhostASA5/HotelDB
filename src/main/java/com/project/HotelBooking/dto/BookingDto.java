package com.project.HotelBooking.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class BookingDto {

    private Long guestId;

    private Long roomId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private int adultsCount;

    private int childrenCount;

    private BigDecimal totalPrice;

    private String specialRequests;
}
