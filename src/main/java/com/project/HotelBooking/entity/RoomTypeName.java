package com.project.HotelBooking.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoomTypeName {

    STANDARD("Стандарт"),
    FAMILY("Семейный"),
    LUXURY("Люкс");

    private final String dbValue;

    public static RoomTypeName fromDbValue(String value) {
        for (RoomTypeName type : values()) {
            if (type.dbValue.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown room type value: " + value);
    }
}
