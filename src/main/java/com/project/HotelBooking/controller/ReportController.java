package com.project.HotelBooking.controller;

import com.project.HotelBooking.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService service;

    @GetMapping
    public ResponseEntity<List<Map<String, String>>> getReport(@RequestParam String tableName,
                                            @RequestParam String columns,
                                            @RequestParam String filter){
        return ResponseEntity.ok(service.getReport(tableName, columns, filter));
    }
}
