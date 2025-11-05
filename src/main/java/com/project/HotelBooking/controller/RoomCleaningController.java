package com.project.HotelBooking.controller;

import com.project.HotelBooking.dto.RoomCleaningDto;
import com.project.HotelBooking.entity.RoomCleaning;
import com.project.HotelBooking.services.RoomCleaningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-cleanings")
@RequiredArgsConstructor
public class RoomCleaningController {

    private final RoomCleaningService service;

    @PostMapping
    public ResponseEntity<RoomCleaning> createRoomCleaning(@RequestBody RoomCleaningDto roomCleaningDto) {
        return ResponseEntity.ok(service.createRoomCleaning(roomCleaningDto));
    }

    @GetMapping
    public ResponseEntity<List<RoomCleaning>> getAllRoomCleanings() {
        return ResponseEntity.ok(service.getAllRoomCleanings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomCleaning> getRoomCleaningById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRoomCleaningById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomCleaning> updateRoomCleaning(@PathVariable Long id, @RequestBody RoomCleaningDto roomCleaningDto) {
        return ResponseEntity.ok(service.updateRoomCleaning(id, roomCleaningDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomCleaning(@PathVariable Long id) {
        service.deleteRoomCleaning(id);
        return ResponseEntity.noContent().build();
    }
}
