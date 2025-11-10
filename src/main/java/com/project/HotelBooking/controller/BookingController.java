package com.project.HotelBooking.controller;

import com.project.HotelBooking.dto.BookingDto;
import com.project.HotelBooking.entity.Booking;
import com.project.HotelBooking.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService service;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDto bookingDto) {
        return ResponseEntity.ok(service.createBooking(bookingDto));
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(service.getAllBookings());
    }

    @GetMapping("/monthly-revenue")
    public ResponseEntity<List<Map<String, String>>> getMonthlyRevenue() {
        return ResponseEntity.ok(service.getMonthlyRevenue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBookingById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody BookingDto bookingDto) {
        return ResponseEntity.ok(service.updateBooking(id, bookingDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        service.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
