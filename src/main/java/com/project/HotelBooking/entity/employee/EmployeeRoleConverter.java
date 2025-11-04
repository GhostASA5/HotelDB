package com.project.HotelBooking.entity.employee;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EmployeeRoleConverter implements AttributeConverter<EmployeeRole, String> {

    @Override
    public String convertToDatabaseColumn(EmployeeRole attribute) {
        return attribute != null ? attribute.getDbValue() : null;
    }

    @Override
    public EmployeeRole convertToEntityAttribute(String dbData) {
        return dbData != null ? EmployeeRole.fromDbValue(dbData) : null;
    }
}
