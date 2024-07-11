package com.wipro.bus.service;


import com.wipro.bus.entities.BusOperator;


public interface BusOperatorService {
	
    BusOperator loginBusOperator(String email, String password);

    void logoutBusOperator(Long busOperatorId);
    
    boolean deleteBusOperator(String email);
    
}
