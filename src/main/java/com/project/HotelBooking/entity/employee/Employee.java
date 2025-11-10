package com.project.HotelBooking.entity.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.HotelBooking.entity.RoomCleaning;
import com.project.HotelBooking.entity.roomType.RoomTypeNameConverter;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    @Convert(converter = EmployeeRoleConverter.class)
    private EmployeeRole role;

    private LocalDate hireDate;

    private BigDecimal salary;

    private Boolean isActive = true;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<RoomCleaning> cleanings;
}
