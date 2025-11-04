package com.project.HotelBooking.controller;

import com.project.HotelBooking.dto.AmenityDto;
import com.project.HotelBooking.entity.Amenity;
import com.project.HotelBooking.services.AmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amenities")
@RequiredArgsConstructor
public class AmenityController {

    private final AmenityService service;

    @PostMapping
    public ResponseEntity<Amenity> create(@RequestParam Long roomId, @RequestBody AmenityDto amenity) {
        return ResponseEntity.ok(service.createAmenity(roomId, amenity));
    }

    @GetMapping
    public ResponseEntity<List<Amenity>> getAll() {
        return ResponseEntity.ok(service.getAllAmenities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Amenity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAmenityById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Amenity> update(@PathVariable Long id, @RequestBody AmenityDto amenity) {
        return ResponseEntity.ok(service.updateAmenity(id, amenity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteAmenity(id);
        return ResponseEntity.noContent().build();
    }
}
