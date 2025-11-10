package com.project.HotelBooking.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.HotelBooking.dto.BookingDto;
import com.project.HotelBooking.entity.Booking;
import com.project.HotelBooking.entity.Guest;
import com.project.HotelBooking.entity.Room;
import com.project.HotelBooking.repository.BookingRepository;
import com.project.HotelBooking.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository repository;
    private final GuestService guestService;
    private final RoomService roomService;
    private final ObjectMapper objectMapper;

    public Booking createBooking(BookingDto bookingDto) {
        Booking booking = objectMapper.convertValue(bookingDto, Booking.class);
        Guest guest = guestService.getGuestById(bookingDto.getGuestId());
        Room room = roomService.getRoomById(bookingDto.getRoomId());
        booking.setGuest(guest);
        booking.setRoom(room);
        return repository.save(booking);
    }

    public List<Map<String, String>> getMonthlyRevenue() {
        return repository.getMonthlyRevenue();
    }

    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    public Booking getBookingById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking updateBooking(Long id, BookingDto bookingDto) {
        Booking existingBooking = getBookingById(id);
        Booking newBooking = objectMapper.convertValue(bookingDto, Booking.class);
        BeanUtils.copyNonNullProperties(newBooking, existingBooking);
        return repository.save(existingBooking);
    }

    public void deleteBooking(Long id) {
        repository.deleteById(id);
    }
}

