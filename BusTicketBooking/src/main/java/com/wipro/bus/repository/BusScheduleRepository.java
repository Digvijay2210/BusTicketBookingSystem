package com.wipro.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bus.entities.BusSchedule;

@Repository
public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long> {
	List<BusSchedule> findByOriginAndDestination(String origin, String destination);

	BusSchedule findByScheduleId(Long scheduleId);

}
