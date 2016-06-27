package com.walmart.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author ANUSHA
 */
public class SeatHold {
	
	private Integer levelId = null;	
	private String emailId;
	private static Integer seatHoldId = 1000;
	private Map<String, String> reservedSeats = null;
	private String message="";	
	
	public Map<String, String> getReservedSeats()
	{
		if(null == reservedSeats)
			reservedSeats = new HashMap<String, String>();
		return reservedSeats;
	}
	
	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}	
	
	public int getSeatHoldId() {
		return seatHoldId;
	}
	
	public void setSeatHoldId(Integer seatHoldId) {
		this.seatHoldId = seatHoldId;
	}
	
	public synchronized int getSequenceId() {
		return this.seatHoldId+1;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
