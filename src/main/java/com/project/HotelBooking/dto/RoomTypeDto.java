package com.project.HotelBooking.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomTypeDto {

    private String typeName;

    private BigDecimal price;

    private Integer maxGuests;

    private String description;
}
