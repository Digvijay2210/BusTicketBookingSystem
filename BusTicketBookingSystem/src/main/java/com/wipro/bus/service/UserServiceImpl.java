package com.wipro.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bus.entities.User;
import com.wipro.bus.entities.Booking;
import com.wipro.bus.repository.UserRepository;
import com.wipro.bus.repository.BookingRepository;

import java.util.List;

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
        // Find user by email
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Invalid email or password");
    }

    @Override
    public User updateProfile(User user) {
        // Implement update profile logic, e.g., update user details in the database
        return userRepository.save(user);
    }

    @Override
    public List<Booking> viewBookingHistory(Long userId) {
        // Implement logic to fetch booking history for a user
        return bookingRepository.findByUser_UserId(userId);
    }

    @Override
    public boolean cancelBooking(Long bookingId) {
        // Implement logic to cancel a booking, e.g., delete booking from database
        // Return true if booking was successfully cancelled, false otherwise
        if (bookingRepository.existsById(bookingId)) {
            bookingRepository.deleteById(bookingId);
            return true;
        }
        return false;
    }

	@Override
	public User findUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
