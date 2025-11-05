package com.project.HotelBooking.entity.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmployeeRole {

    АДМИНИСТРАТОР("Администратор"),
    ГОРНИЧНАЯ("Горничная"),
    МЕНЕДЖЕР("Менеджер"),
    ПОРТЬЕ("Портье");

    private final String dbValue;

    public static EmployeeRole fromDbValue(String value) {
        for (EmployeeRole type : values()) {
            if (type.dbValue.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown employee role value: " + value);
    }
}
