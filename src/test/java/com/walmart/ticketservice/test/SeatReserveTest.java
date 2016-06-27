package com.walmart.ticketservice.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.walmart.service.TicketService;
import com.walmart.service.impl.TicketServiceImpl;

/**
 * The class <code>SeatReserveTest</code> test the 
 * <i>reserveSeats()</i> API
 * @author ANUSHA
 */
public class SeatReserveTest {

	private TicketService ticketService = new TicketServiceImpl();
	
	/*Without Hold we can't reserve the seats.
	This api returns NoSeats found with the provided details*/
	@Test
	   public void testReserveSeats() {
	      int seatHoldId=1000;
	      String eMailId="test@walmart.com";
	      String confirmation=ticketService.reserveSeats(seatHoldId,eMailId);
	      assertEquals("NOSEATS", confirmation);
	   }
}
