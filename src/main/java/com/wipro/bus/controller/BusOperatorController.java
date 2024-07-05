package com.wipro.bus.controller;

import com.wipro.bus.dto.BusOperatorDTO;
import com.wipro.bus.service.BusOperatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/busOperators")
public class BusOperatorController {

    @Autowired
    private BusOperatorService busOperatorService;

    @PostMapping("/create")
    public ResponseEntity<BusOperatorDTO> createBusOperator(@Validated @RequestBody BusOperatorDTO busOperatorDTO) {
        BusOperatorDTO createdBusOperator = busOperatorService.createBusOperator(busOperatorDTO);
        return ResponseEntity.ok(createdBusOperator);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BusOperatorDTO> updateBusOperator(@PathVariable Long id, @Validated @RequestBody BusOperatorDTO busOperatorDTO) {
        BusOperatorDTO updatedBusOperator = busOperatorService.updateBusOperator(id, busOperatorDTO);
        return ResponseEntity.ok(updatedBusOperator);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBusOperator(@PathVariable Long id) {
        busOperatorService.deleteBusOperator(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BusOperatorDTO> getBusOperatorById(@PathVariable Long id) {
        BusOperatorDTO busOperatorDTO = busOperatorService.getBusOperatorById(id);
        return ResponseEntity.ok(busOperatorDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusOperatorDTO>> getAllBusOperators() {
        List<BusOperatorDTO> busOperators = busOperatorService.getAllBusOperators();
        return ResponseEntity.ok(busOperators);
    }
}
