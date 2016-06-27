package com.walmart.ticketservice.test;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
import org.junit.Test;
import com.walmart.service.TicketService;
import com.walmart.service.impl.TicketServiceImpl;

/**
 * The class <code>SeatAvailableTest</code> test the 
 * <i>numSeatsAvailable()</i> API
 * @author ANUSHA
 */
public class SeatAvailableTest {
	
	private static final int VENUE_LEVEL1 =1250; 
	private static final int VENUE_LEVEL2 =2000; 
	private static final int VENUE_LEVEL3 =1500; 
	private static final int VENUE_LEVEL4 =1500; 
	
	TicketService ticketService = new TicketServiceImpl();
	
	@Test
	public void testNumSeatsAvailable_Level1() {
		Optional<Integer> venueLevel = Optional.of(new Integer(0));
		int numOfSeats = ticketService.numSeatsAvailable(venueLevel);
		assertEquals(VENUE_LEVEL1, numOfSeats);
	}

	@Test
	public void testNumSeatsAvailable_Level2() {
		Optional<Integer> venueLevel = Optional.of(new Integer(1));
		int numOfSeats = ticketService.numSeatsAvailable(venueLevel);
		assertEquals(VENUE_LEVEL2, numOfSeats);
	}

	@Test
	public void testNumSeatsAvailable_Level3() {
		Optional<Integer> venueLevel = Optional.of(new Integer(2));
		int numOfSeats = ticketService.numSeatsAvailable(venueLevel);
		assertEquals(VENUE_LEVEL3, numOfSeats);
	}

	@Test
	public void testNumSeatsAvailable_Level4() {
		Optional<Integer> venueLevel = Optional.of(new Integer(3));
		int numOfSeats = ticketService.numSeatsAvailable(venueLevel);
		assertEquals(VENUE_LEVEL4, numOfSeats);
	}
}
