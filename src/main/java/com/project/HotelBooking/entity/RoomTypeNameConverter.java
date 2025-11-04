package com.project.HotelBooking.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoomTypeNameConverter implements AttributeConverter<RoomTypeName, String> {

    @Override
    public String convertToDatabaseColumn(RoomTypeName attribute) {
        return attribute != null ? attribute.getDbValue() : null;
    }

    @Override
    public RoomTypeName convertToEntityAttribute(String dbData) {
        return dbData != null ? RoomTypeName.fromDbValue(dbData) : null;
    }
}
