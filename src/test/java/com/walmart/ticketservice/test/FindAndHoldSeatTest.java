package com.walmart.ticketservice.test;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
import org.junit.Test;
import com.walmart.model.SeatHold;
import com.walmart.service.TicketService;
import com.walmart.service.impl.TicketServiceImpl;

/**
 * The class <code>FindAndHoldSeatTest</code> test the
 *  <i>findAndHoldSeats</i> API
 * @author ANUSHA
 */
public class FindAndHoldSeatTest {

	private TicketService ticketService = new TicketServiceImpl();
	private String customerEmailId="test@walmart.com";
	private static final String SEATHOLD_SUCCESS="SUCCESS";
	private static final String NO_SEAT="NOSEATS";
	
	@Test
	   public void testMinAndMaxLevels_Equal_and_NumOfSeatGreaterThanProvidedLevel() {
		Optional<Integer> minLevel=Optional.of(new Integer(1));
	      Optional<Integer> maxLevel=Optional.of(new Integer(1));
	      int numSeats=3000;
	      SeatHold seatHold=ticketService.findAndHoldSeats(numSeats, minLevel, maxLevel, customerEmailId);
	      assertEquals(NO_SEAT, seatHold.getMessage());
	   }
	
	@Test
	   public void testMinAndMaxLevels_Equal_and_NumOfSeatLessThanProvidedLevel() {
	      Optional<Integer> minLevel=Optional.of(new Integer(1));
	      Optional<Integer> maxLevel=Optional.of(new Integer(1));
	      int numSeats=1;
	      SeatHold seatHold=ticketService.findAndHoldSeats(numSeats, minLevel, maxLevel, customerEmailId);
	      assertEquals(SEATHOLD_SUCCESS, seatHold.getMessage());
	   }
	
	@Test
	   public void testMinAndMaxLevels_NOTEqual_and_NumOfSeatLessThan10() {
	      Optional<Integer> minLevel=Optional.of(new Integer(2));
	      Optional<Integer> maxLevel=Optional.of(new Integer(3));
	      int numSeats=9;     
	      SeatHold seatHold=ticketService.findAndHoldSeats(numSeats, minLevel, maxLevel, customerEmailId);
	      assertEquals(SEATHOLD_SUCCESS, seatHold.getMessage());
	   }
	
	@Test
	   public void testMinAndMaxLevels_NOTEqual_and_NumOfSeatGreaterThan10() {
	      Optional<Integer> minLevel=Optional.of(new Integer(2));
	      Optional<Integer> maxLevel=Optional.of(new Integer(3));
	      int numSeats=5000;	     
	      SeatHold seatHold=ticketService.findAndHoldSeats(numSeats, minLevel, maxLevel, customerEmailId);
	      assertEquals(NO_SEAT, seatHold.getMessage());
	   }	
}
