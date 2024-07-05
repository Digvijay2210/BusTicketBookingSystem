package com.wipro.bus.service;

import com.wipro.bus.dto.BusScheduleDTO;
import com.wipro.bus.entities.BusSchedule;
import com.wipro.bus.repository.BusScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {

    @Autowired
    private BusScheduleRepository busScheduleRepository;

    @Override
    public BusSchedule createBusSchedule(BusScheduleDTO busScheduleDTO) {
        BusSchedule busSchedule = new BusSchedule();
        
        // Ensure scheduleId is set if not null
        if (busScheduleDTO.getScheduleId() != null) {
            busSchedule.setScheduleId(busScheduleDTO.getScheduleId());
        }
        
        busSchedule.setBusName(busScheduleDTO.getBusName());
        busSchedule.setBusNumber(busScheduleDTO.getBusNumber());
        busSchedule.setBusType(busScheduleDTO.getBusType());
        busSchedule.setNumOfSeats(busScheduleDTO.getNumOfSeats());
        busSchedule.setOrigin(busScheduleDTO.getOrigin());
        busSchedule.setDestination(busScheduleDTO.getDestination());
        busSchedule.setTimings(busScheduleDTO.getTimings());
        busSchedule.setFare(busScheduleDTO.getFare());

        return busScheduleRepository.save(busSchedule);
    }


    @Override
    public BusSchedule updateBusSchedule(Long scheduleId, BusScheduleDTO busScheduleDTO) {
        Optional<BusSchedule> busScheduleOptional = busScheduleRepository.findById(scheduleId);
        if (busScheduleOptional.isPresent()) {
            BusSchedule busSchedule = busScheduleOptional.get();
            busSchedule.setBusName(busScheduleDTO.getBusName());
            busSchedule.setBusNumber(busScheduleDTO.getBusNumber());
            busSchedule.setBusType(busScheduleDTO.getBusType());
            busSchedule.setNumOfSeats(busScheduleDTO.getNumOfSeats());
            busSchedule.setOrigin(busScheduleDTO.getOrigin());
            busSchedule.setDestination(busScheduleDTO.getDestination());
            busSchedule.setTimings(busScheduleDTO.getTimings());
            busSchedule.setFare(busScheduleDTO.getFare());
            return busScheduleRepository.save(busSchedule);
        } else {
            throw new RuntimeException("Bus Schedule not found");
        }
    }

    @Override
    public void deleteBusSchedule(Long scheduleId) {
        if (busScheduleRepository.existsById(scheduleId)) {
            busScheduleRepository.deleteById(scheduleId);
        } else {
            throw new RuntimeException("Bus Schedule not found");
        }
    }

    @Override
    public BusSchedule getBusScheduleById(Long scheduleId) {
        return busScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Bus Schedule not found"));
    }

    @Override
    public List<BusSchedule> getAllBusSchedules() {
        return busScheduleRepository.findAll();
    }
}
