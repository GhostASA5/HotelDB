package com.project.HotelBooking.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.HotelBooking.dto.RoomDto;
import com.project.HotelBooking.entity.Room;
import com.project.HotelBooking.entity.roomType.RoomType;
import com.project.HotelBooking.repository.RoomRepository;
import com.project.HotelBooking.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository repository;
    private final RoomTypeService roomTypeService;
    private final ObjectMapper objectMapper;

    public Room createRoom(Long roomTypeId, RoomDto room) {
        Room newRoom = objectMapper.convertValue(room, Room.class);
        RoomType roomType = roomTypeService.getRoomTypeById(roomTypeId);
        newRoom.setType(roomType);
        return repository.save(newRoom);
    }

    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    public Room getRoomById(Long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Room not found"));
    }

    public Room updateRoom(Long id, Long roomTypeId, RoomDto room) {
        Room roomToUpdate = getRoomById(id);
        RoomType roomType = roomTypeService.getRoomTypeById(roomTypeId);

        Room newRoom = objectMapper.convertValue(room, Room.class);
        BeanUtils.copyNonNullProperties(newRoom, roomToUpdate);
        roomToUpdate.setType(roomType);
        return repository.save(roomToUpdate);
    }

    public void deleteRoom(Long id) {
        repository.deleteById(id);
    }
}
