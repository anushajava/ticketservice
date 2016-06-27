package com.walmart.menu;

import java.util.Scanner;
import com.walmart.util.TicketServiceUtil;

/**
 * The class <code>Menu</code> display the
 * available menu options to the user
 * 
 * @author ANUSHA
 */
public class Menu {
	
	Scanner input = new Scanner(System.in);
	int userInput=0;
	private static String VENUE_LEVEL="\n1 - Orchestra\n2 - Main\n3 - Balcony 1\n4 - Balacony 2";
	
	/**
	 * @return the user selected option from Main Menu
	 */
	public int mainMenu(){
		
		do{
			
			System.out.println("\n\t  MAIN  MENU ");
			System.out.println("==========================================");
			System.out.println("1- Total seats \n2- Available seats\n3- Hold\n4- Reserve\n5- Exit");
			while (!input.hasNextInt()) 
			{        
				input.next(); 
			    System.out.print("Enter valid input:"); 
			}
			userInput=input.nextInt();
		}while(userInput<1 || userInput>5);
		return userInput;
	}
	
	/**
	 * @return level entered by the user
	 */
	public int levelMenu(){
		do{
			
			System.out.println("\n\tVENUE  LEVELS  ");
			System.out.println("==========================================");
			System.out.println(" select the Level to view the available seats"+VENUE_LEVEL);
			while (!input.hasNextInt()) 
			{        
				input.next(); 
			    System.out.print("Enter valid input: "); 
			}
			userInput=input.nextInt();
		}while(userInput<1 || userInput>4);
		return userInput;
	}
	
	/**
	 * Display the options to Find and Hold the seats
	 * @return  FindAndHoldSeatMenu
	 */
	public FindAndHoldSeatMenu findAndHoldSeatMenu(){
		
			System.out.println("\n\tFIND & HOLD AVAILABLE SEATS  ");
			System.out.println("==========================================");
		
			int maxLevel = 0;
			int minLevel = this.holdMinLevel();
			maxLevel = this.holdMaxLevel(minLevel);
		
			FindAndHoldSeatMenu findAndHoldSeatMenu = new FindAndHoldSeatMenu();			
			findAndHoldSeatMenu.setNumSeats(numSeats());
			findAndHoldSeatMenu.setMinLevel(TicketServiceUtil.convertToOptional(minLevel));
			findAndHoldSeatMenu.setMaxLevel(TicketServiceUtil.convertToOptional(maxLevel));
			findAndHoldSeatMenu.setCustomerEmail(customerEmail());
			
		return findAndHoldSeatMenu;
	}
	
	public int numSeats(){
		int numSeats=0;
		do{
			System.out.println("Maximum number of allowed seats per person is 10");
			System.out.println("Enter number of seats to Hold:");
			while (!input.hasNextInt()) 
			{        
				input.next(); 
			    System.out.print("Enter Valid Number: "); 
			}
			numSeats=input.nextInt();
			}while(numSeats<1 || numSeats>10);
		return numSeats;
	}
	
	public String customerEmail(){
		String customerEmail;
		do{
			System.out.println("Enter Valid email address");
			customerEmail=input.next();
		}while(!TicketServiceUtil.emailIdValidation(customerEmail));
		return customerEmail;
	}
	
	/**
	 * @return minimum level to hold
	 */
	public int holdMinLevel(){
		
		int minLevel=0;		
		do{
			System.out.println("select Minimum Level"+VENUE_LEVEL);
			while (!input.hasNextInt()) 
			{        
				input.next(); 
			    System.out.print("Enter valid input:");
			}
			minLevel=input.nextInt();
		}while(minLevel<0 || minLevel>4);
		return minLevel;
	}
	
	/**
	 * @param minLevel
	 * @return max level to hold
	 */
	public int holdMaxLevel(int minLevel){
		int maxLevel=0;
		do{
			System.out.println("Select Maximum Level "+VENUE_LEVEL);
			while (!input.hasNextInt()) 
			{        
				input.next(); 
			    System.out.print("Enter valid input: "); 	
			    }
			maxLevel=input.nextInt();
		}while((maxLevel<0 || maxLevel>4) || (maxLevel<minLevel));
		return maxLevel;
	}
	
	/**
	 * Display the options to Reserve the Seat
	 * @return ReserveSeatMenu
	 */
	public ReserveSeatMenu reserveSeatMenu() {
		
		System.out.println("\n\tRESERVE MENU ");
		System.out.println("==========================");
		int seatHoldId=0;
		String customerEmail;
		
		System.out.println("Enter valid SeatHoldId");
		while (!input.hasNextInt()) 
		{        
			input.next(); 
		    System.out.print("Enter valid input "); 
		}
		seatHoldId=input.nextInt();
		
		do{
			System.out.println("Enter valid email address");
			customerEmail=input.next();
		}while(!TicketServiceUtil.emailIdValidation(customerEmail));
		
		ReserveSeatMenu reserveSeatMenu= new ReserveSeatMenu();
		reserveSeatMenu.setSeatHoldId(seatHoldId);
		reserveSeatMenu.setCustomerEmail(customerEmail);
		
		return reserveSeatMenu;
	}
}
