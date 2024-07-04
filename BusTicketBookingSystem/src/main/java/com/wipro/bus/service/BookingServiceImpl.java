package com.wipro.bus.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.bus.entities.Booking;
import com.wipro.bus.entities.User;
import com.wipro.bus.repository.BookingRepository;
import com.wipro.bus.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getBookingsByUser(Long user) {
        return bookingRepository.findByUser_Id(user);
    }

	@Override
	public List<Booking> getBookingsByUser(User user) {
		// TODO Auto-generated method stub
		return bookingRepository.findByUser_Id(null);
	}
}