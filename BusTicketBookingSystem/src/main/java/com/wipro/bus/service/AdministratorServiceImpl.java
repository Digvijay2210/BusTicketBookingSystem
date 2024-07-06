
package com.wipro.bus.service;

import com.wipro.bus.dto.AdministratorDTO;
import com.wipro.bus.dto.BusOperatorDTO;
import com.wipro.bus.entities.Administrator;
import com.wipro.bus.entities.BusOperator;
import com.wipro.bus.exception.AdministratorNotFoundException;
import com.wipro.bus.repository.AdministratorRepository;
import com.wipro.bus.repository.BusOperatorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private BusOperatorRepository busOperatorRepository;

    @Override
    public AdministratorDTO createAdministrator(AdministratorDTO administratorDTO) {
        Administrator administrator = convertToEntity(administratorDTO);
        Administrator savedAdministrator = administratorRepository.save(administrator);
        return convertToDTO(savedAdministrator);
    }

    @Override
    public AdministratorDTO updateAdministrator(Long adminId, AdministratorDTO administratorDTO) {
        Optional<Administrator> optionalAdministrator = administratorRepository.findById(adminId);
        if (optionalAdministrator.isPresent()) {
            Administrator administrator = optionalAdministrator.get();
            administrator.setName(administratorDTO.getName());
            administrator.setEmail(administratorDTO.getEmail());
            administrator.setPassword(administratorDTO.getPassword());
            Administrator updatedAdministrator = administratorRepository.save(administrator);
            return convertToDTO(updatedAdministrator);
        }
        throw new AdministratorNotFoundException("Administrator not found with id " + adminId);
    }

    @Override
    public void deleteAdministrator(Long adminId) {
        if (!administratorRepository.existsById(adminId)) {
            throw new AdministratorNotFoundException("Administrator not found with id " + adminId);
        }
        administratorRepository.deleteById(adminId);
    }

    @Override
    public AdministratorDTO getAdministratorById(Long adminId) {
        Optional<Administrator> optionalAdministrator = administratorRepository.findById(adminId);
        return optionalAdministrator.map(this::convertToDTO)
                .orElseThrow(() -> new AdministratorNotFoundException("Administrator not found with id " + adminId));
    }

    @Override
    public List<AdministratorDTO> getAllAdministrators() {
        List<Administrator> administrators = administratorRepository.findAll();
        return administrators.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public BusOperatorDTO addBusOperator(BusOperatorDTO busOperatorDTO) {
        BusOperator busOperator = new BusOperator(
                busOperatorDTO.getName(),
                busOperatorDTO.getEmail(),
                busOperatorDTO.getPassword(),
                busOperatorDTO.getPhoneNumber()
        );
        BusOperator savedBusOperator = busOperatorRepository.save(busOperator);
        return new BusOperatorDTO(
                savedBusOperator.getOperatorId(),
                savedBusOperator.getName(),
                savedBusOperator.getEmail(),
                savedBusOperator.getPassword(),
                savedBusOperator.getPhoneNumber()
        );
    }

    public void deleteBusOperator(Long operatorId) {
        if (!busOperatorRepository.existsById(operatorId)) {
            throw new AdministratorNotFoundException("Bus operator not found with id " + operatorId);
        }
        busOperatorRepository.deleteById(operatorId);
    }

    private Administrator convertToEntity(AdministratorDTO administratorDTO) {
        return new Administrator(administratorDTO.getName(), administratorDTO.getEmail(), administratorDTO.getPassword());
    }

    private AdministratorDTO convertToDTO(Administrator administrator) {
        return new AdministratorDTO(administrator.getAdminId(), administrator.getName(), administrator.getEmail(), administrator.getPassword());
    }
}
