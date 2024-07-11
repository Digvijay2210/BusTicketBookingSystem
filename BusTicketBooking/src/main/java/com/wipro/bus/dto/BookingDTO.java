
package com.wipro.bus.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BookingDTO {

	@NotNull(message = "User ID cannot be null")
	private Long userId;

	@NotNull(message = "Schedule ID cannot be null")
	private Long scheduleId;

	@NotBlank(message = "Seat numbers cannot be blank")
	@Pattern(regexp = "^(\\d+,)*\\d+$", message = "Seat numbers must be comma-separated integers") // Adjust pattern if
																									// needed
	private String seatNumbers;

	@NotBlank(message = "Booking date cannot be blank")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Booking date must be in the format YYYY-MM-DD")
	private String bookingDate; // Consider using LocalDate if feasible

	private String totalFare;
	private String status;

	// Default constructor
	public BookingDTO() {
	}

	public BookingDTO(Long userId, Long scheduleId, String seatNumbers, String bookingDate, String totalFare,
			String status) {
		this.userId = userId;
		this.scheduleId = scheduleId;
		this.seatNumbers = seatNumbers;
		this.bookingDate = bookingDate;
		this.totalFare = totalFare;
		this.status = status;

	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(String seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public String getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(String totalFare) {
		this.totalFare = totalFare;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

}