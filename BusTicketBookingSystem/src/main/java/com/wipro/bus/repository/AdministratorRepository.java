package com.wipro.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.bus.entities.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    // Custom query methods (if any) can be added here
	
}
