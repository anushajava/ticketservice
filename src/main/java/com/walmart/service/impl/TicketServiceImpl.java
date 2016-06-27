package com.walmart.service.impl;

import java.util.Optional;
import com.walmart.dao.TicketDAO;
import com.walmart.dao.impl.TicketDAOImpl;
import com.walmart.model.SeatHold;
import com.walmart.service.TicketService;

/**
 * @author ANUSHA
 */
public class TicketServiceImpl implements TicketService{

	private TicketDAO  ticketDAO = new TicketDAOImpl();
	
	public int numSeatsAvailable(Optional<Integer> venueLevel) {
		
		return ticketDAO.numSeatsAvailable(venueLevel);
	}

	public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel, Optional<Integer> maxLevel, String customerEmail) {
		
		return ticketDAO.findAndHoldSeats(numSeats, minLevel, maxLevel, customerEmail);
	}
	
	public String reserveSeats(int seatHoldId, String customerEmail) {
		
		return ticketDAO.reserveSeats(seatHoldId, customerEmail);
	}
}
