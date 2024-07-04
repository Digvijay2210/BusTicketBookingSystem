package com.wipro.bus.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.bus.entities.Booking;
import com.wipro.bus.entities.User;
import com.wipro.bus.service.BookingService;
import com.wipro.bus.service.UserService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    
    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUserId(@PathVariable Long userId) {
        User user = userService.findUserById(userId); // Assuming you have a method to fetch User by ID
        return bookingService.getBookingsByUser(user);
    }
}
