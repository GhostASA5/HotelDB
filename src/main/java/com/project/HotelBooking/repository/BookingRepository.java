package com.project.HotelBooking.repository;

import com.project.HotelBooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT * FROM hotel.monthly_revenue", nativeQuery = true)
    List<Map<String, String>> getMonthlyRevenue();
}
