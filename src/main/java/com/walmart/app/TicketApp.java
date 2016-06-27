package com.walmart.app;

import com.walmart.menu.FindAndHoldSeatMenu;
import com.walmart.menu.Menu;
import com.walmart.menu.ReserveSeatMenu;
import com.walmart.model.SeatHold;
import com.walmart.service.TicketService;
import com.walmart.service.impl.TicketServiceImpl;
import com.walmart.util.TicketServiceUtil;

/**
 * The class <code>TicketApp</code> contains main method.
 * The execution of the app begins from this class.
 * 
 * @author ANUSHA
 */
public class TicketApp {

	public static void main(String[] args) {
		
		TicketService ticketService= new TicketServiceImpl();
		
		Menu menu = new Menu();
		int userSelectedOption = 0;
		do {
			userSelectedOption= menu.mainMenu();
			switch (userSelectedOption) {
			case 1:
				VenueInitialize venueInitialize = new VenueInitialize();
				venueInitialize.totalNumSeats();
				break;
				
			case 2:
				int userSelectedLevel = menu.levelMenu();
				int numAvailableSeats = ticketService.numSeatsAvailable(TicketServiceUtil.convertToOptional(userSelectedLevel-1));
				System.out.println("Available Seats:::"+numAvailableSeats);
				break;
				
			case 3:
				FindAndHoldSeatMenu findAndHoldSeatMenu = menu.findAndHoldSeatMenu();
				SeatHold seatHold = ticketService.findAndHoldSeats(findAndHoldSeatMenu.getNumSeats(),
											   findAndHoldSeatMenu.getMinLevel(), 
											   findAndHoldSeatMenu.getMaxLevel(), 
											   findAndHoldSeatMenu.getCustomerEmail());
				if(!seatHold.getMessage().equals("NOSEATS")){
					System.out.println("\nHold successfully Done");
					System.out.println("SeatHold Id ::: " + seatHold.getSeatHoldId());
					System.out.println("SeatHold expires in 1 minute");
					}else{
						System.out.println("No Available seats found of your choice");
					}
				break;
				
			case 4:
				ReserveSeatMenu reserveSeatMenu =  menu.reserveSeatMenu();
				String confirmationCode = ticketService.reserveSeats(reserveSeatMenu.getSeatHoldId(), reserveSeatMenu.getCustomerEmail());
				if(confirmationCode.equals("NOSEATS")){
					System.out.println("No Seats found with the details provided");
				}else{
				System.out.println("Reservation Successfully Done");
				System.out.println("ConfirmationCode ::: " + confirmationCode);
				}
				break;
				
			case 5:
				System.out.println("\nExited the APP");
				System.exit(0);
				break;

			default:
				break;
			}
			
		} while (userSelectedOption != 6);		
	}
}
