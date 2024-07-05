
package com.wipro.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wipro.bus.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUser_UserId(Long userId);

    // Check for any booking that conflicts with the requested seats for the given route
    @Query("SELECT b FROM Booking b WHERE b.routeId = :routeId AND " +
           "EXISTS (SELECT seat FROM Booking b2 JOIN b2.seatNumbers seat " +
           "WHERE b2.id = b.id AND seat IN :seatNumbers)")
    List<Booking> findConflictingBookings(@Param("routeId") Long routeId, @Param("seatNumbers") List<String> seatNumbers);

	List<Booking> findBookingsByRouteIdAndSeatNumbers(Long routeId, String seatNumbers);
}
