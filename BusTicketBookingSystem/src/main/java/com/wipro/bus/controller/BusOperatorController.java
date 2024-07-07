package com.wipro.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.bus.dto.BusOperatorDTO;
import com.wipro.bus.entities.BusOperator;
import com.wipro.bus.entities.BusSchedule;
import com.wipro.bus.service.BusOperatorService;
import com.wipro.bus.service.BusScheduleService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/busOperator")
public class BusOperatorController {

    @Autowired
    private BusOperatorService busOperatorService;

    @Autowired
    private BusScheduleService busScheduleService;

    // Endpoint for Bus Operator login
    @PostMapping("/login")
    public ResponseEntity<BusOperator> loginBusOperator(
            @RequestParam String email,
            @RequestParam String password) {
        try {
            BusOperator busOperator = busOperatorService.loginBusOperator(email, password);
            return ResponseEntity.ok(busOperator);
        } catch (RuntimeException e) {
            // Log the error (optional)
            // log.error("Error logging in bus operator: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Endpoint to add a Bus Operator
//    @PostMapping("/register")
//    public ResponseEntity<BusOperator> registerBusOperator(
//            @Valid @RequestBody BusOperatorDTO busOperatorDTO) {
//        try {
//            // Convert DTO to entity
//            BusOperator busOperator = convertDTOToEntity(busOperatorDTO);
//
//            BusOperator registeredBusOperator = busOperatorService.registerBusOperator(busOperator);
//            return ResponseEntity.ok(registeredBusOperator);
//        } catch (RuntimeException e) {
//            // Log the error (optional)
//            // log.error("Error registering bus operator: ", e);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//    }

    // Endpoint to create a new Bus Schedule
    @PostMapping("/createSchedule")
    public ResponseEntity<BusSchedule> createBusSchedule(
            @Valid @RequestBody BusSchedule busSchedule) {
        try {
            BusSchedule createdBusSchedule = busScheduleService.createBusSchedule(busSchedule);
            return ResponseEntity.ok(createdBusSchedule);
        } catch (RuntimeException e) {
            // Log the error (optional)
            // log.error("Error creating bus schedule: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Helper method to convert BusOperatorDTO to BusOperator entity
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


//package com.wipro.bus.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.wipro.bus.entities.BusOperator;
//import com.wipro.bus.entities.BusSchedule;
//import com.wipro.bus.service.BusOperatorService;
//import com.wipro.bus.service.BusScheduleService;
//
//@RestController
//@RequestMapping("/api/busOperator")
//public class BusOperatorController {
//
//    @Autowired
//    private BusOperatorService busOperatorService;
//
//    @Autowired
//    private BusScheduleService busScheduleService;
//
//    @PostMapping("/login")
//    public ResponseEntity<BusOperator> loginBusOperator(@RequestParam String email, @RequestParam String password) {
//        try {
//            BusOperator busOperator = busOperatorService.loginBusOperator(email, password);
//            return ResponseEntity.ok(busOperator);
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//    
// // Create a new bus schedule
//    @PostMapping("/createSchedule")
//    public ResponseEntity<BusSchedule> createBusSchedule(@RequestBody BusSchedule busSchedule) {
//        try {
//            BusSchedule createdBusSchedule = busScheduleService.createBusSchedule(busSchedule);
//            return ResponseEntity.ok(createdBusSchedule);
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//
//    
//}
