package com.project.HotelBooking.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class RoomCleaningDto {

    private Long roomId;

    private Long employeeId;

    private LocalDateTime cleaningTime;

    private LocalTime scheduledTime;

    private String notes;
}
