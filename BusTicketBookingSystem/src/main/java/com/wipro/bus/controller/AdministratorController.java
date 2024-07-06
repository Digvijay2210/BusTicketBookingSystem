
package com.wipro.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bus.dto.AdministratorDTO;
import com.wipro.bus.dto.BusOperatorDTO;
import com.wipro.bus.service.AdministratorService;

@RestController
@RequestMapping("/api/administrators")
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;

	@PostMapping("/create")
	public ResponseEntity<AdministratorDTO> createAdministrator(
			@Validated @RequestBody AdministratorDTO administratorDTO) {
		AdministratorDTO createdAdministrator = administratorService.createAdministrator(administratorDTO);
		return ResponseEntity.ok(createdAdministrator);
	}

	@PutMapping("/update/{adminId}")
	public ResponseEntity<AdministratorDTO> updateAdministrator(@PathVariable Long adminId,
			@Validated @RequestBody AdministratorDTO administratorDTO) {
		AdministratorDTO updatedAdministrator = administratorService.updateAdministrator(adminId, administratorDTO);
		return ResponseEntity.ok(updatedAdministrator);
	}

	@DeleteMapping("/delete/{adminId}")
	public ResponseEntity<Void> deleteAdministrator(@PathVariable Long adminId) {
		administratorService.deleteAdministrator(adminId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/get/{adminId}")
	public ResponseEntity<AdministratorDTO> getAdministratorById(@PathVariable Long adminId) {
		AdministratorDTO administratorDTO = administratorService.getAdministratorById(adminId);
		return ResponseEntity.ok(administratorDTO);
	}

	@GetMapping("/all")
	public ResponseEntity<List<AdministratorDTO>> getAllAdministrators() {
		List<AdministratorDTO> administrators = administratorService.getAllAdministrators();
		return ResponseEntity.ok(administrators);
	}

	@PostMapping("/addBusOperators")
	public ResponseEntity<BusOperatorDTO> addBusOperator(@Validated @RequestBody BusOperatorDTO busOperatorDTO) {
		BusOperatorDTO createdBusOperator = administratorService.addBusOperator(busOperatorDTO);
		return ResponseEntity.ok(createdBusOperator);
	}

	@DeleteMapping("/deleteBusOperators/{operatorId}")
	public ResponseEntity<Void> deleteBusOperator(@PathVariable Long operatorId) {
		administratorService.deleteBusOperator(operatorId);
		return ResponseEntity.noContent().build();
	}

}
