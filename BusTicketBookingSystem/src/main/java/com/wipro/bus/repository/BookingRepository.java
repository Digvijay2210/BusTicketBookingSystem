package com.wipro.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.bus.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser_UserId(Long userId);

}
