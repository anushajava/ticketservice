package com.walmart.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.walmart.app.VenueInitialize;
import com.walmart.dao.TicketDAO;
import com.walmart.model.Level;
import com.walmart.model.Row;
import com.walmart.model.Seat;
import com.walmart.model.SeatHold;
import com.walmart.model.Venue;
import com.walmart.util.TicketServiceUtil;

/**
 * @author ANUSHA
 */
public class TicketDAOImpl implements TicketDAO{

	VenueInitialize venueInitialize = new VenueInitialize();
	
	//initialize the venu object with given requirements
	Venue venue = venueInitialize.initializeVenu();
	
	// SeatHoldMap will store seatHoldId as Key and SeatHold object as value.
	public static Map<Integer, SeatHold> seatHoldMap = new HashMap<Integer, SeatHold>();
	List<Level> allVL = venue.getVenueLevels();
	
	/**
	 * @param venueLevel
	 * @return number of available seats
	 */
	public int numSeatsAvailable(Optional<Integer> venueLevel) {
		
		int totalNumOfSeats = 0;
		int userSelectedLevel = 0;
		if (venueLevel.isPresent()) {
			userSelectedLevel = venueLevel.get();
		}
		Level vl = allVL.get(userSelectedLevel);
		for (Row row : vl.getRows()) {
			for (Seat seat : row.getSeats()) {
				if (seat.getIsHold().equals("N")&& seat.getIsReserved().equals("N")) {
					totalNumOfSeats++;
				}
			}
		}
		return totalNumOfSeats;
	}

	/**
	 * This method find the available seats and hold them for a particular time
	 * @param numberOfSeats
	 * @param minLevel
	 * @param maxLevel
	 * @param customerEmail
	 * @return SeatHold Object
	 */
	public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel,Optional<Integer> maxLevel, String customerEmail) {
		
		Level vl = null;
		int levelMin=0;
		int levelMax=0;
		int totalSeatsHold = 0;// variable to hold total number of reserved seats
		String strReserverdSeats = null;
		SeatHold seatHold = new SeatHold();
		Map<String, String> reservedSeats = seatHold.getReservedSeats();
		
		if(minLevel.isPresent()){
			levelMin=minLevel.get();
			levelMin = levelMin - 1;
		}
		if(maxLevel.isPresent()){
			levelMax=maxLevel.get();
			levelMax = levelMax - 1;
		}
		
		do{
			//number of available seats in the provided level > no.of seats requested
		if(numSeatsAvailable(TicketServiceUtil.convertToOptional(levelMin)) > numSeats){
			 vl = allVL.get(levelMin);
			for(Row row: vl.getRows()){
				for(Seat seat : row.getSeats()){								
					if(seat.getIsHold().equalsIgnoreCase("N") && seat.getIsReserved().equalsIgnoreCase("N")){
						seat.putOnHold();// put the seat on Hold for 60 seconds
						totalSeatsHold++;
						if(strReserverdSeats == null)
							strReserverdSeats = String.valueOf(seat.getSeatNum());
						else
							strReserverdSeats = strReserverdSeats + "," + seat.getSeatNum();	
					}
					if(totalSeatsHold==numSeats){// if total reserved seat equals to no.of seats requested by user
						reservedSeats.put(String.valueOf(row.getRowId()), strReserverdSeats);
						seatHold.setLevelId(vl.getLevelId());
						seatHold.setSeatHoldId(seatHold.getSequenceId()); //setting seathold Id
						seatHold.setEmailId(customerEmail); 
						seatHold.setMessage("SUCCESS");
						seatHoldMap.put(seatHold.getSeatHoldId(), seatHold);
						return seatHold;
					}
				}						
					if (totalSeatsHold < numSeats) {
						strReserverdSeats = null;
					} else if (totalSeatsHold == numSeats) {
						break;
					}													
				}
			} else {
				levelMin++;
			}
		} while (levelMin <= levelMax);
		if(totalSeatsHold==numSeats){
			seatHold.setLevelId(vl.getLevelId());
			seatHold.setSeatHoldId(seatHold.getSequenceId());
			seatHold.setEmailId(customerEmail);
			seatHoldMap.put(seatHold.getSeatHoldId(), seatHold);
				}else{
					seatHold.setMessage("NOSEATS"); // No seats found to hold
				}
		return seatHold;
	}
	
	/**
	 * @param seatHoldId
	 * @param customerEmail
	 * @return true if seat is on Hold
	 */
	public static boolean verifySeatHold(int seatHoldId, String customerEmail){
		if(seatHoldMap.containsKey(new Integer(seatHoldId))){
			SeatHold seatHold = seatHoldMap.get(seatHoldId);
			if(seatHold.getEmailId().matches(customerEmail)){
				return true;
			}
		}else{
			return false;
		}		
		return false;
	}
	
	/**
	 * @param seatHoldId
	 * @param customerEmail
	 * @return confirmation code
	 */
	public String reserveSeats(int seatHoldId, String customerEmail) {
		
		if (verifySeatHold(seatHoldId, customerEmail)) {
			int numOfSeatsReserved = 0;
			SeatHold seatHold = seatHoldMap.get(seatHoldId);
				Level vl = allVL.get(seatHold.getLevelId()-1);
				for (Row row : vl.getRows()) {
					for (Seat seat : row.getSeats()) {
						if (seat.getIsHold().equals("Y")&& seat.getIsReserved().equals("N")) {
							seat.setIsReserved("Y");
							numOfSeatsReserved++;
						}
					}
					//Remove the SeatHoldId from the SeatHoldMap after the seat is reserved
					seatHoldMap.remove(seatHoldId);
					if (numOfSeatsReserved > 0) {
						//return the seat reservation confirmation code
						return String.valueOf(seatHold.getSequenceId());
					} else {
						return "NOSEATS"; 
					}
				}
		}
		return "NOSEATS";
	}
}