package com.project.HotelBooking.repository;

import com.project.HotelBooking.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    @Query(value = "SELECT hotel.guest_total_spent(:guestId)", nativeQuery = true)
    BigDecimal getTotalSpent(@Param("guestId") Long guestId);

    @Query(value = "SELECT * FROM hotel.generate_report(:tableName, :columns, :filter) AS t",
            nativeQuery = true)
    List<Map<String, String>> generateReport(
            @Param("tableName") String tableName,
            @Param("columns") String columns,
            @Param("filter") String filter
    );
}
