package com.wipro.bus.entities;

import jakarta.persistence.*;

@Entity
public class BusRoute {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;
    private String busName;
    private String busNumber;
    private String busType;
    private int numOfSeats;
    private String origin;
    private String destination;
    private String timings;
    private double fare;
    private String amenities;

    // Default constructor
    public BusRoute() {
    }

    // Parameterized constructor
    public BusRoute(String busName, String busNumber, String busType, int numOfSeats, String origin, String destination, String timings, double fare, String amenities) {
        this.busName = busName;
        this.busNumber = busNumber;
        this.busType = busType;
        this.numOfSeats = numOfSeats;
        this.origin = origin;
        this.destination = destination;
        this.timings = timings;
        this.fare = fare;
        this.amenities = amenities;
    }

    // Getters and setters
    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
}
