package com.wipro.bus.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bus.dto.BusSearchDTO;
import com.wipro.bus.entities.BusSchedule;
import com.wipro.bus.entities.User;
import com.wipro.bus.exception.BusSearchException;
import com.wipro.bus.exception.MissingBusSearchArgumentException;
import com.wipro.bus.exception.UserNotFoundException;
import com.wipro.bus.service.BusScheduleService;
import com.wipro.bus.service.UserService;

import jakarta.validation.Valid;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BusScheduleService busScheduleService;

//	@PostMapping("/register")
//	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
//		try {
//			User registeredUser = userService.registerUser(user);
//			return ResponseEntity.ok(registeredUser);
//		} catch (RuntimeException e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//		}
//	}
//
//	@PostMapping("/login")
//	public ResponseEntity<User> loginUser(@RequestParam("email") String email,
//			@RequestParam("password") String password) {
//		try {
//			User user = userService.loginUser(email, password);
//			return ResponseEntity.ok(user);
//		} catch (RuntimeException e) {
//			return ResponseEntity.badRequest().body(null);
//		}
//	}

	@PutMapping("/update")
	public ResponseEntity<User> updateProfile(@Valid @RequestBody User user) throws UserNotFoundException {
		try {
			User updatedUser = userService.updateProfile(user);
			return ResponseEntity.ok(updatedUser);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteUserByEmail(@RequestBody String email) {
		boolean isDeleted = userService.deleteUserByEmail(email);
		if (isDeleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/busSearch")
	public ResponseEntity<List<BusSchedule>> searchBuses(@RequestBody String origin, @RequestBody String destination)
			throws MissingBusSearchArgumentException, BusSearchException {

		if (origin == null || origin.isEmpty()) {
			throw new MissingBusSearchArgumentException("Origin cannot be empty");
		}
		if (destination == null || destination.isEmpty()) {
			throw new MissingBusSearchArgumentException("Destination cannot be empty");
		}

		try {
			BusSearchDTO busSearchDTO = new BusSearchDTO(origin, destination);
			List<BusSchedule> busSchedules = busScheduleService.searchBuses(busSearchDTO);
			return ResponseEntity.ok(busSchedules);
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList()); // Example
																											// handling
		}
	}

	@GetMapping("/allbusschedule")
	public ResponseEntity<List<BusSchedule>> getAllBusSchedules() {
		List<BusSchedule> busSchedules = busScheduleService.getAllBusSchedules();
		return ResponseEntity.ok(busSchedules);
	}
}
