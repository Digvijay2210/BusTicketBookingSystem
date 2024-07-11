package com.wipro.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bus.dto.BookingDTO;
import com.wipro.bus.entities.Booking;
import com.wipro.bus.exception.BookingException;
import com.wipro.bus.exception.BookingNotFoundException;
import com.wipro.bus.exception.UserNotFoundException;
import com.wipro.bus.repository.BookingRepository;
import com.wipro.bus.service.BookingService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private BookingRepository bookingRepository;

	@PostMapping("/createBooking")
	public ResponseEntity<Booking> createBooking( @RequestBody BookingDTO bookingDTO) throws BookingException {
		Booking booking = bookingService.createBooking(bookingDTO);
		return ResponseEntity.ok(booking);
	}

	@DeleteMapping("/delete/{bookingId}")
	public ResponseEntity<Void> cancelBooking(@PathVariable Long bookingId) throws BookingNotFoundException {
		try {
			bookingService.cancelBooking(bookingId);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/bookingById/{bookingId}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) throws BookingNotFoundException {
		Booking booking = bookingService.getBookingById(bookingId);
		return ResponseEntity.ok(booking);
	}

	@GetMapping("/viewHistory/{userId}")
	public ResponseEntity<List<Booking>> viewBookingHistory(@PathVariable Long userId) throws UserNotFoundException {

		List<Booking> bookings = bookingRepository.findByUser_UserId(userId);
		if (bookings.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
		return ResponseEntity.ok(bookings);
	}

}
