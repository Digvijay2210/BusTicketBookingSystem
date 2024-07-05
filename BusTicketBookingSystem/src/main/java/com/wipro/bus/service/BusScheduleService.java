package com.wipro.bus.service;

import com.wipro.bus.dto.BusScheduleDTO;
import com.wipro.bus.entities.BusSchedule;

import java.util.List;

public interface BusScheduleService {

    BusSchedule createBusSchedule(BusScheduleDTO busScheduleDTO);

    BusSchedule updateBusSchedule(Long scheduleId, BusScheduleDTO busScheduleDTO);

    void deleteBusSchedule(Long scheduleId);

    BusSchedule getBusScheduleById(Long scheduleId);

    List<BusSchedule> getAllBusSchedules();
}
