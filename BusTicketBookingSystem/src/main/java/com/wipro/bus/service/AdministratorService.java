package com.wipro.bus.service;

import java.util.List;

import com.wipro.bus.dto.AdministratorDTO;
import com.wipro.bus.dto.BusOperatorDTO;

public interface AdministratorService {
    AdministratorDTO createAdministrator(AdministratorDTO administratorDTO);
    AdministratorDTO updateAdministrator(Long adminId, AdministratorDTO administratorDTO);
    void deleteAdministrator(Long adminId);
    AdministratorDTO getAdministratorById(Long adminId);
    List<AdministratorDTO> getAllAdministrators();
    
    BusOperatorDTO addBusOperator(BusOperatorDTO busOperatorDTO);
    void deleteBusOperator(Long operatorId);
}