package com.project.HotelBooking.repository;

import com.project.HotelBooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT * FROM hotel.monthly_revenue", nativeQuery = true)
    List<Map<String, String>> getMonthlyRevenue();

    @Procedure(procedureName = "add_booking")
    void addBooking(
            @Param("p_guest_id") Long guestId,
            @Param("p_room_id") Long roomId,
            @Param("p_check_in") LocalDate checkIn,
            @Param("p_check_out") LocalDate checkOut,
            @Param("p_adults") Integer adults,
            @Param("p_children") Integer children,
            @Param("p_total_price") BigDecimal totalPrice,
            @Param("p_special_requests") String specialRequests
    );

}
