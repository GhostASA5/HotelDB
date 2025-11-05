package com.project.HotelBooking.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.HotelBooking.dto.RoomCleaningDto;
import com.project.HotelBooking.entity.Room;
import com.project.HotelBooking.entity.RoomCleaning;
import com.project.HotelBooking.entity.employee.Employee;
import com.project.HotelBooking.repository.RoomCleaningRepository;
import com.project.HotelBooking.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomCleaningService {

    private final RoomCleaningRepository repository;
    private final RoomService roomService;
    private final EmployeeService employeeService;
    private final ObjectMapper objectMapper;

    public RoomCleaning createRoomCleaning(RoomCleaningDto roomCleaningDto) {
        RoomCleaning cleaning = objectMapper.convertValue(roomCleaningDto, RoomCleaning.class);
        Room room = roomService.getRoomById(roomCleaningDto.getRoomId());
        Employee employee = employeeService.getEmployeeById(roomCleaningDto.getEmployeeId());
        cleaning.setRoom(room);
        cleaning.setEmployee(employee);
        return repository.save(cleaning);
    }

    public List<RoomCleaning> getAllRoomCleanings() {
        return repository.findAll();
    }

    public RoomCleaning getRoomCleaningById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room cleaning record not found"));
    }

    public RoomCleaning updateRoomCleaning(Long id, RoomCleaningDto roomCleaningDto) {
        RoomCleaning existing = getRoomCleaningById(id);
        RoomCleaning newData = objectMapper.convertValue(roomCleaningDto, RoomCleaning.class);
        BeanUtils.copyNonNullProperties(newData, existing);
        return repository.save(existing);
    }

    public void deleteRoomCleaning(Long id) {
        repository.deleteById(id);
    }
}
