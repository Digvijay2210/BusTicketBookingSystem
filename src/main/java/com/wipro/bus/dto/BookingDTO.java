package com.wipro.bus.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BookingDTO {

    @NotNull(message = "Booking ID cannot be null")
    private Long bookingId;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Route ID cannot be null")
    private Long routeId;

    @NotBlank(message = "Seat numbers cannot be blank")
    private String seatNumbers;

    @NotBlank(message = "Booking date cannot be blank")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Booking date must be in the format YYYY-MM-DD")
    private String bookingDate;

    @Min(value = 0, message = "Total fare must be positive")
    private double totalFare;

    @NotBlank(message = "Status cannot be blank")
    private String status;

    // Default constructor
    public BookingDTO() {
    }

    // Parameterized constructor
    public BookingDTO(Long bookingId, Long userId, Long routeId, String seatNumbers, String bookingDate, double totalFare, String status) {
        this.bookingId = bookingId;
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
