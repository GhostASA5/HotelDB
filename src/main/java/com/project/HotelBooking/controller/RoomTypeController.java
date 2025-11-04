package com.project.HotelBooking.controller;

import com.project.HotelBooking.dto.RoomTypeDto;
import com.project.HotelBooking.entity.roomType.RoomType;
import com.project.HotelBooking.services.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-types")
@RequiredArgsConstructor
public class RoomTypeController {

    private final RoomTypeService service;

    @PostMapping
    public ResponseEntity<RoomType> create(@RequestBody RoomTypeDto roomType) {
        return ResponseEntity.ok(service.createRoomType(roomType));
    }

    @GetMapping
    public ResponseEntity<List<RoomType>> getAll() {
        return ResponseEntity.ok(service.getAllRoomType());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomType> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRoomTypeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomType> update(@PathVariable Long id, @RequestBody RoomTypeDto roomType) {
        return ResponseEntity.ok(service.updateRoomType(id, roomType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteRoomType(id);
        return ResponseEntity.noContent().build();
    }
}
