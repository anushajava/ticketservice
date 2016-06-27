package com.walmart.menu;

/**
 * The class <code>ReserveSeatMenu</code> takes the options
 * entered by the user to Reserve the seat
 * 
 * @author ANUSHA
 */
public class ReserveSeatMenu {
	
	private int seatHoldId;
	private String customerEmail;
	
	public int getSeatHoldId() {
		return seatHoldId;
	}
	public void setSeatHoldId(int seatHoldId) {
		this.seatHoldId = seatHoldId;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}	
}
