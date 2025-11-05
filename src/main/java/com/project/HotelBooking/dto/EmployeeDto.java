package com.project.HotelBooking.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EmployeeDto {

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    private String phone;

    private String role;

    private LocalDate hireDate;

    private BigDecimal salary;

    private Boolean isActive;
}
