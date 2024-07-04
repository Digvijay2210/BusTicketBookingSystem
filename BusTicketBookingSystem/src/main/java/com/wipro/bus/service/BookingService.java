package com.wipro.bus.service;

import java.util.List;
import com.wipro.bus.entities.Booking;
import com.wipro.bus.entities.User;

public interface BookingService {
    List<Booking> getBookingsByUser(User user);
}