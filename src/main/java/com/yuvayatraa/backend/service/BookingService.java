package com.yuvayatraa.backend.service;

import com.yuvayatraa.backend.dto.ApiResponse;
import com.yuvayatraa.backend.dto.BookingRequest;
import com.yuvayatraa.backend.entity.Booking;
import com.yuvayatraa.backend.entity.Route;
import com.yuvayatraa.backend.entity.User;
import com.yuvayatraa.backend.repository.BookingRepository;
import com.yuvayatraa.backend.repository.RouteRepository;
import com.yuvayatraa.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RouteRepository routeRepository;

    public ApiResponse createBooking(BookingRequest request, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Route route = routeRepository.findById(request.getRouteId())
                .orElseThrow(() -> new RuntimeException("Route not found!"));

        String bookingId = "YV" + UUID.randomUUID()
                .toString().substring(0, 6).toUpperCase();

        Booking booking = Booking.builder()
                .bookingId(bookingId)
                .user(user)
                .route(route)
                .seats(request.getSeats())
                .totalAmount(request.getTotalAmount())
                .status(Booking.Status.UPCOMING)
                .build();

        bookingRepository.save(booking);
        return new ApiResponse(true, "Booking successful!", booking);
    }

    public List<Booking> getUserBookings(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        return bookingRepository.findByUserOrderByBookedAtDesc(user);
    }

    public ApiResponse cancelBooking(String bookingId) {
        Booking booking = bookingRepository.findByBookingId(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found!"));
        booking.setStatus(Booking.Status.CANCELLED);
        bookingRepository.save(booking);
        return new ApiResponse(true, "Booking cancelled successfully!", null);
    }
}