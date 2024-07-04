
package com.wipro.bus.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bus.entities.Booking;
import com.wipro.bus.entities.User;
import com.wipro.bus.repository.BookingRepository;
import com.wipro.bus.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;
	
	@Override
	public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User already exists with this email");
        }
        return userRepository.save(user);
	}

	@Override
	public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Invalid email or password");
	}

	@Override
	public User updateProfile(User user) {
        return userRepository.save(user);
	}

	@Override
	public List<Booking> viewBookingHistory(Long userId) {
        return bookingRepository.findByUser_Id(userId);
	}

	@Override
	public boolean cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking != null) {
            bookingRepository.delete(booking);
            return true;
        }
        return false;
	}

	@Override
	public User findUserById(Long userId) {
	    return userRepository.findById(userId).orElse(null); // Fetch user by ID, return null if not found
	}


}
