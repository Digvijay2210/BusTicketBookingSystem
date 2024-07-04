package com.wipro.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.bus.entities.BusRoute;

public interface BusRouteRepository extends JpaRepository<BusRoute, Long> {
    
}
