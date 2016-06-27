package com.walmart.model;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The class <code>seat</code> represents Seat information
 * 
 * @author ANUSHA
 */
public class Seat {
	private static final int SEATHOLD_EXPIRE_TIME = 60;
	private Timer timer;		
	private Integer seatNum;	
	private String isHold = "N";
	private String isReserved = "N";

	public Integer getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}
	public String getIsHold() {
		return isHold;
	}
	public void setIsHold(String isHold) {
		this.isHold = isHold;
	}
	public String getIsReserved() {
		return isReserved;
	}
	public void setIsReserved(String isReserved) {
		this.isReserved = isReserved;
	}
	
	@Override
	public String toString() {
		return " SeatNumber [" + seatNum + "], IsHold [" + isHold + "], IsReserved [" + isReserved + "] ";
	}
	/**
	 * This method set the seatHold status to "Y" and 
	 * start the timer to hold
	 */
	public void putOnHold() {
		this.isHold = "Y";
		timer = new Timer();
		timer.schedule(new SeatHoldTask(), SEATHOLD_EXPIRE_TIME * 1000);
	}

	class SeatHoldTask extends TimerTask {
		public void run() {
			timer.cancel();
			isHold = "N";
		}
	}
}
