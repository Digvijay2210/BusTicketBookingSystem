package com.wipro.bus.service;

import com.wipro.bus.entities.Administrator;
import com.wipro.bus.entities.BusOperator;

public interface AdministratorService {
	Administrator registerAdministrator(Administrator administrator);

	Administrator loginAdministrator(String email, String password);

	BusOperator addBusOperator(BusOperator busOperator);

	boolean deleteBusOperator(String email);

	boolean deleteUser(String email);

}
