package com.yuvayatraa.backend.repository;

import com.yuvayatraa.backend.entity.Booking;
import com.yuvayatraa.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
    Optional<Booking> findByBookingId(String bookingId);
    List<Booking> findByUserOrderByBookedAtDesc(User user);
}