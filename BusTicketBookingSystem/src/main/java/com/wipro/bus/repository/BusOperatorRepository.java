package com.wipro.bus.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.bus.entities.BusOperator;

public interface BusOperatorRepository extends JpaRepository<BusOperator, Long> {
  
}
