package com.project.HotelBooking.controller;

import com.project.HotelBooking.dto.RoomDto;
import com.project.HotelBooking.entity.Room;
import com.project.HotelBooking.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService service;

    @PostMapping
    public ResponseEntity<Room> create(@RequestParam Long roomTypeId, @RequestBody RoomDto room) {
        return ResponseEntity.ok(service.createRoom(roomTypeId, room));
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAll() {
        return ResponseEntity.ok(service.getAllRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRoomById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> update(@PathVariable Long id, @RequestParam Long roomTypeId, @RequestBody RoomDto room) {
        return ResponseEntity.ok(service.updateRoom(id, roomTypeId, room));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
