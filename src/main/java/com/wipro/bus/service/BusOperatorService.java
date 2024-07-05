package com.wipro.bus.service;

import java.util.List;

import com.wipro.bus.dto.BusOperatorDTO;

public interface BusOperatorService {
    BusOperatorDTO createBusOperator(BusOperatorDTO busOperatorDTO);
    BusOperatorDTO updateBusOperator(Long operatorId, BusOperatorDTO busOperatorDTO);
    void deleteBusOperator(Long operatorId);
    BusOperatorDTO getBusOperatorById(Long operatorId);
    List<BusOperatorDTO> getAllBusOperators();
}