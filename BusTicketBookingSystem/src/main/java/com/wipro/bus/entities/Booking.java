package com.wipro.bus.entities;

import jakarta.persistence.*;

@Entity
public class Booking {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Long userId;
    private Long routeId;
    private String seatNumbers;
    private String bookingDate;
    private double totalFare;
    private String status;
    // Default constructor

    public Booking() {

    }
    // Parameterized constructor

    public Booking(Long userId, Long routeId, String seatNumbers, String bookingDate, double totalFare, String status) {
        this.userId = userId;
        this.routeId = routeId;
        this.seatNumbers = seatNumbers;
        this.bookingDate = bookingDate;
        this.totalFare = totalFare;
        this.status = status;

    }
    // Getters and setters
    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
    public String getSeatNumbers() {
        return seatNumbers;
    }
    public void setSeatNumbers(String seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}