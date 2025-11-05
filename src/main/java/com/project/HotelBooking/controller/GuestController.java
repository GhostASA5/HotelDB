package com.project.HotelBooking.controller;

import com.project.HotelBooking.dto.GuestDto;
import com.project.HotelBooking.entity.Guest;
import com.project.HotelBooking.services.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService service;

    @PostMapping
    public ResponseEntity<Guest> create(@RequestBody GuestDto g){
        return ResponseEntity.ok(service.createGuest(g));
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAll(){
        return ResponseEntity.ok(service.getAllGuests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getGuestById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> update(@PathVariable Long id,@RequestBody GuestDto g){
        return ResponseEntity.ok(service.updateGuest(id,g));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}
