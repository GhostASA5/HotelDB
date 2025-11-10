package com.project.HotelBooking.repository;

import com.project.HotelBooking.entity.roomType.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

    @Query(value = "SELECT * FROM hotel.room_type_statistics", nativeQuery = true)
    List<Map<String, String>> getRoomTypeStats();
}
