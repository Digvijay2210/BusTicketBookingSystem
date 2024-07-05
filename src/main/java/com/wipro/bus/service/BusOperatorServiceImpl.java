package com.wipro.bus.service;

import com.wipro.bus.dto.BusOperatorDTO;
import com.wipro.bus.entities.BusOperator;
import com.wipro.bus.exception.BusOperatorNotFoundException;
import com.wipro.bus.repository.BusOperatorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusOperatorServiceImpl implements BusOperatorService {

    @Autowired
    private BusOperatorRepository busOperatorRepository;

    @Override
    public BusOperatorDTO createBusOperator(BusOperatorDTO busOperatorDTO) {
        BusOperator busOperator = convertToEntity(busOperatorDTO);
        BusOperator savedBusOperator = busOperatorRepository.save(busOperator);
        return convertToDTO(savedBusOperator);
    }

    @Override
    public BusOperatorDTO updateBusOperator(Long operatorId, BusOperatorDTO busOperatorDTO) {
        Optional<BusOperator> optionalBusOperator = busOperatorRepository.findById(operatorId);
        if (optionalBusOperator.isPresent()) {
            BusOperator busOperator = optionalBusOperator.get();
            busOperator.setName(busOperatorDTO.getName());
            busOperator.setEmail(busOperatorDTO.getEmail());
            busOperator.setPassword(busOperatorDTO.getPassword());
            busOperator.setPhoneNumber(busOperatorDTO.getPhoneNumber());
            BusOperator updatedBusOperator = busOperatorRepository.save(busOperator);
            return convertToDTO(updatedBusOperator);
        }
        throw new BusOperatorNotFoundException("Bus operator not found with id " + operatorId);
    }

    @Override
    public void deleteBusOperator(Long operatorId) {
        if (!busOperatorRepository.existsById(operatorId)) {
            throw new BusOperatorNotFoundException("Bus operator not found with id " + operatorId);
        }
        busOperatorRepository.deleteById(operatorId);
    }

    @Override
    public BusOperatorDTO getBusOperatorById(Long operatorId) {
        Optional<BusOperator> optionalBusOperator = busOperatorRepository.findById(operatorId);
        return optionalBusOperator.map(this::convertToDTO)
                .orElseThrow(() -> new BusOperatorNotFoundException("Bus operator not found with id " + operatorId));
    }

    @Override
    public List<BusOperatorDTO> getAllBusOperators() {
        List<BusOperator> busOperators = busOperatorRepository.findAll();
        return busOperators.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private BusOperator convertToEntity(BusOperatorDTO busOperatorDTO) {
        return new BusOperator(busOperatorDTO.getName(), busOperatorDTO.getEmail(), busOperatorDTO.getPassword(), busOperatorDTO.getPhoneNumber());
    }

    private BusOperatorDTO convertToDTO(BusOperator busOperator) {
        return new BusOperatorDTO(busOperator.getOperatorId(), busOperator.getName(), busOperator.getEmail(), busOperator.getPassword(), busOperator.getPhoneNumber());
    }
}
