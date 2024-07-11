package com.wipro.bus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bus.dto.BusOperatorDTO;
import com.wipro.bus.entities.Booking;
import com.wipro.bus.entities.BusOperator;
import com.wipro.bus.entities.BusSchedule;
import com.wipro.bus.exception.UserNotFoundException;
import com.wipro.bus.repository.BookingRepository;
import com.wipro.bus.service.BusOperatorService;
import com.wipro.bus.service.BusScheduleService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/busOperator")
public class BusOperatorController {

	@Autowired
	private BusOperatorService busOperatorService;

	@Autowired
	private BusScheduleService busScheduleService;
	
	@Autowired
	private BookingRepository bookingRepository;

	@PostMapping("/loginBusOperator")
	public ResponseEntity<BusOperator> loginBusOperator(@RequestBody String email, @RequestBody String password) {
		try {
			BusOperator busOperator = busOperatorService.loginBusOperator(email, password);
			return ResponseEntity.ok(busOperator);
		} catch (RuntimeException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@PostMapping("/createBusSchedule")
	public ResponseEntity<BusSchedule> createBusSchedule(@Valid @RequestBody BusSchedule busSchedule) {
		try {
			BusSchedule createdBusSchedule = busScheduleService.createBusSchedule(busSchedule);
			return ResponseEntity.ok(createdBusSchedule);
		} catch (RuntimeException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@GetMapping("/viewBookingHistory/{userId}")
	public ResponseEntity<List<Booking>> viewBookingHistory(@PathVariable Long userId) throws UserNotFoundException {

		List<Booking> bookings = bookingRepository.findByUser_UserId(userId);
		if (bookings.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
		return ResponseEntity.ok(bookings);
	}

	private BusOperator convertDTOToEntity(BusOperatorDTO busOperatorDTO) {
		BusOperator busOperator = new BusOperator();
		busOperator.setOperatorId(busOperatorDTO.getOperatorId());
		busOperator.setName(busOperatorDTO.getName());
		busOperator.setEmail(busOperatorDTO.getEmail());
		busOperator.setPassword(busOperatorDTO.getPassword());
		busOperator.setPhoneNumber(busOperatorDTO.getPhoneNumber());
		return busOperator;
	}
}
