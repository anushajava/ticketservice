package com.walmart.menu;

import java.util.Optional;

/**
 * The class <code>FindAndHoldSeatMenu</code> takes the 
 * options entered by the user to hold the best available seat
 * @author ANUSHA
 */
public class FindAndHoldSeatMenu {

	private int numSeats;
	private Optional<Integer> minLevel; 
	private Optional<Integer> maxLevel; 
	private String customerEmail;
	
	public int getNumSeats() {
		return numSeats;
	}
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}
	public Optional<Integer> getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(Optional<Integer> minLevel) {
		this.minLevel = minLevel;
	}
	public Optional<Integer> getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(Optional<Integer> maxLevel) {
		this.maxLevel = maxLevel;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
}
