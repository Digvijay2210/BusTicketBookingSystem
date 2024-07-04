package com.wipro.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.bus.entities.Booking;
import com.wipro.bus.entities.User;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser_Id(Long userId);
}