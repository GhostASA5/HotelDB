package com.project.HotelBooking.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.HotelBooking.dto.RoomTypeDto;
import com.project.HotelBooking.entity.roomType.RoomType;
import com.project.HotelBooking.entity.roomType.RoomTypeName;
import com.project.HotelBooking.repository.RoomTypeRepository;
import com.project.HotelBooking.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomTypeService {

    private final RoomTypeRepository repository;
    private final ObjectMapper objectMapper;

    public RoomType createRoomType(RoomTypeDto roomTypeDto) {
        RoomType roomType = objectMapper.convertValue(roomTypeDto, RoomType.class);
        return repository.save(roomType);
    }

    public List<RoomType> getAllRoomType() {
        return repository.findAll();
    }

    public RoomType getRoomTypeById(Long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Room type not found"));
    }

    public RoomType updateRoomType(Long id, RoomTypeDto updated) {
        RoomType roomType = getRoomTypeById(id);
        RoomType updatedRoomType = objectMapper.convertValue(updated, RoomType.class);
        BeanUtils.copyNonNullProperties(updatedRoomType, roomType);
        return repository.save(roomType);
    }

    public void deleteRoomType(Long id) {
        repository.deleteById(id);
    }
}
