package com.project.HotelBooking.repository;

import com.project.HotelBooking.entity.roomType.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

}
