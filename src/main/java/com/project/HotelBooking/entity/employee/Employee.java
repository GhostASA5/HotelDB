package com.project.HotelBooking.entity.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.HotelBooking.entity.RoomCleaning;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
    private Long employeeId;

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "employee_role")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
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
