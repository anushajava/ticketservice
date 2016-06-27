package com.walmart.model;

import java.util.List;

/**
 * The class <code>Row</code> represents the row information
 * 
 * @author ANUSHA
 */
public class Row {
	
	// a row can have any number of seats
	private List<Seat> seats;
	private int rowId;

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
}
