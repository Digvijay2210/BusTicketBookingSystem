package com.wipro.bus.service;

import java.util.List;

import com.wipro.bus.dto.AdministratorDTO;

public interface AdministratorService {
    AdministratorDTO createAdministrator(AdministratorDTO administratorDTO);
    AdministratorDTO updateAdministrator(Long adminId, AdministratorDTO administratorDTO);
    void deleteAdministrator(Long adminId);
    AdministratorDTO getAdministratorById(Long adminId);
    List<AdministratorDTO> getAllAdministrators();
}
