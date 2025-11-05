package com.project.HotelBooking.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.HotelBooking.dto.GuestDto;
import com.project.HotelBooking.entity.Guest;
import com.project.HotelBooking.repository.GuestRepository;
import com.project.HotelBooking.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepository repository;
    private final ObjectMapper objectMapper;

    public Guest createGuest(GuestDto guestDto) {
        Guest guest = objectMapper.convertValue(guestDto, Guest.class);
        return repository.save(guest);
    }

    public List<Guest> getAllGuests() {
        return repository.findAll();
    }

    public Guest getGuestById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Guest not found"));
    }

    public Guest updateGuest(Long id, GuestDto guest) {
        Guest guestToUpdate = getGuestById(id);
        Guest newGuest = objectMapper.convertValue(guest, Guest.class);
        BeanUtils.copyNonNullProperties(newGuest, guestToUpdate);
        return repository.save(newGuest);
    }

    public void deleteGuest(Long id) {
        repository.deleteById(id);
    }
}
