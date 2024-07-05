package com.wipro.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.wipro.bus.entities.BusSchedule;

public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long> {
    
}
