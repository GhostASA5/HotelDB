package com.project.HotelBooking.repository;

import com.project.HotelBooking.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
