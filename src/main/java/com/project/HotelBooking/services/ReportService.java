package com.project.HotelBooking.services;

import com.project.HotelBooking.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final GuestRepository repository;

    public List<Map<String, String>> getReport(String tableName, String columns, String filter) {
        return repository.generateReport(tableName, columns, filter);
    }
}
