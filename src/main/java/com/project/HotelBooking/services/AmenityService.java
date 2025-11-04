package com.project.HotelBooking.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.HotelBooking.dto.AmenityDto;
import com.project.HotelBooking.entity.Amenity;
import com.project.HotelBooking.entity.Room;
import com.project.HotelBooking.entity.RoomAmenity;
import com.project.HotelBooking.repository.AmenityRepository;
import com.project.HotelBooking.repository.RoomAmenityRepository;
import com.project.HotelBooking.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AmenityService {

    private final AmenityRepository repository;
    private final RoomAmenityRepository roomAmenityRepository;
    private final RoomService roomService;
    private final ObjectMapper objectMapper;

    public Amenity createAmenity(Long roomId, AmenityDto amenity) {
        Amenity newAmenity = objectMapper.convertValue(amenity, Amenity.class);
        Room room = roomService.getRoomById(roomId);
        newAmenity.getRooms().add(room);
        repository.save(newAmenity);
        RoomAmenity roomAmenity = new RoomAmenity(room, newAmenity);
        roomAmenityRepository.save(roomAmenity);
        return newAmenity;
    }

    public List<Amenity> getAllAmenities() {
        return repository.findAll();
    }

    public Amenity getAmenityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Amenity not found"));
    }

    public Amenity updateAmenity(Long id, AmenityDto updated) {
        Amenity amenity = getAmenityById(id);
        Amenity newAmenity = objectMapper.convertValue(updated, Amenity.class);
        BeanUtils.copyNonNullProperties(newAmenity, amenity);
        return repository.save(amenity);
    }

    public void deleteAmenity(Long id) {
        repository.deleteById(id);
    }
}
