package com.wipro.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.bus.entities.Administrator;
import com.wipro.bus.entities.BusOperator;
import com.wipro.bus.entities.BusSchedule;
import com.wipro.bus.entities.User;
import com.wipro.bus.service.AdministratorService;
import com.wipro.bus.service.BusOperatorService;
import com.wipro.bus.service.UserService;

import java.util.List;

import javax.validation.Valid;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/administrator")
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;

	@Autowired
	private UserService userService;

	@Autowired
	private BusOperatorService busOperatorService;

	@PostMapping("/registerAdmin")
	public ResponseEntity<Administrator> registerAdministrator(@Valid @RequestBody Administrator administrator) {
		try {
			Administrator registeredAdministrator = administratorService.registerAdministrator(administrator);
			return ResponseEntity.ok(registeredAdministrator);
		} catch (RuntimeException e) {

			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping("/loginAdmin")
	public ResponseEntity<Administrator> loginAdministrator(@RequestBody String email, @RequestBody String password) {
		try {
			Administrator administrator = administratorService.loginAdministrator(email, password);
			return ResponseEntity.ok(administrator);
		} catch (RuntimeException e) {

			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping("/addBusOperators")
	public ResponseEntity<BusOperator> addBusOperator(@Valid @RequestBody BusOperator busOperator) {
		try {
			BusOperator addedBusOperator = administratorService.addBusOperator(busOperator);
			return ResponseEntity.ok(addedBusOperator);
		} catch (RuntimeException e) {

			return ResponseEntity.badRequest().body(null);
		}
	}

	@DeleteMapping("/deleteBusOperator")
	public ResponseEntity<Void> deleteBusOperator(@RequestBody String email) {
		try {
			boolean isDeleted = busOperatorService.deleteBusOperator(email);
			if (isDeleted) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (RuntimeException e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteUsers")
	public ResponseEntity<Void> deleteUser(@RequestBody String email) {
		try {
			boolean isDeleted = userService.deleteUserByEmail(email);
			if (isDeleted) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (RuntimeException e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/allUser")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> User = userService.getAllUser();
		return ResponseEntity.ok(User);
	}
}
