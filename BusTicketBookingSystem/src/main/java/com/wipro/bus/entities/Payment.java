package com.wipro.bus.entities;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    // Remove the redundant bookingId field
    // private Long bookingId; 
    
    private String paymentMethod;
    private double paymentAmount;
    private String paymentStatus;
    private Date paymentDate;
    
    // Use the relationship directly
    @OneToOne
    @JoinColumn(name = "booking_id") // This maps to the booking_id column in the Payment table
    private Booking booking;

    // Default constructor
    public Payment() {
    }

    // Parameterized constructor
    public Payment(Booking booking, String paymentMethod, double paymentAmount, String paymentStatus, Date paymentDate) {
        this.booking = booking;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    // Getters and setters
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    // Remove bookingId getters and setters
    // public Long getBookingId() {
    //     return bookingId;
    // }

    // public void setBookingId(Long bookingId) {
    //     this.bookingId = bookingId;
    // }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
