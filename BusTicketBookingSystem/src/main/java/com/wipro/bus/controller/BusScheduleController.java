package com.wipro.bus.controller;

import com.wipro.bus.dto.BusScheduleDTO;
import com.wipro.bus.entities.BusSchedule;
import com.wipro.bus.service.BusScheduleService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus-schedules")
public class BusScheduleController {

    @Autowired
    private BusScheduleService busScheduleService;

    @PostMapping("/create")
    public ResponseEntity<BusSchedule> createBusSchedule(@Valid @RequestBody BusScheduleDTO busScheduleDTO) {
        BusSchedule busSchedule = busScheduleService.createBusSchedule(busScheduleDTO);
        return ResponseEntity.ok(busSchedule);
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<BusSchedule> updateBusSchedule(
            @PathVariable Long scheduleId,
            @RequestBody BusScheduleDTO busScheduleDTO) {
        BusSchedule updatedBusSchedule = busScheduleService.updateBusSchedule(scheduleId, busScheduleDTO);
        return ResponseEntity.ok(updatedBusSchedule);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteBusSchedule(@PathVariable Long scheduleId) {
        busScheduleService.deleteBusSchedule(scheduleId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<BusSchedule> getBusScheduleById(@PathVariable Long scheduleId) {
        BusSchedule busSchedule = busScheduleService.getBusScheduleById(scheduleId);
        return ResponseEntity.ok(busSchedule);
    }

    @GetMapping
    public ResponseEntity<List<BusSchedule>> getAllBusSchedules() {
        List<BusSchedule> busSchedules = busScheduleService.getAllBusSchedules();
        return ResponseEntity.ok(busSchedules);
    }
}
