package com.project.HotelBooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.HotelBooking.entity.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "room_cleaning")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomCleaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cleaningId;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private LocalDateTime cleaningTime;

    private LocalTime scheduledTime;

    private String notes;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private LocalDateTime updatedAt;
}
