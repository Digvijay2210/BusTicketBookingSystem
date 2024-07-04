package com.wipro.bus.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bus.entities.Booking;
import com.wipro.bus.entities.User;
import com.wipro.bus.repository.BookingRepository;
import com.wipro.bus.repository.UserRepository;

import jakarta.transaction.Transactional;

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
        return bookingRepository.findByUserId(userId);
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

    @Transactional
	@Override
	public boolean deleteUserByName(String name) {
		// TODO Auto-generated method stub
		 Optional<User> userOptional = userRepository.deleteByName(name);
	        if (userOptional.isPresent()) {
	            userRepository.deleteByName(name);
	            return true;
	        }
	        return false;
	}

}
