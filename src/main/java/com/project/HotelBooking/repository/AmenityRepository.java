package com.project.HotelBooking.repository;

import com.project.HotelBooking.entity.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {
}
