package com.walmart.app;

import java.util.ArrayList;
import java.util.List;

import com.walmart.model.Level;
import com.walmart.model.Row;
import com.walmart.model.Seat;
import com.walmart.model.Venue;

/**
 * The class <code>VenueInitialize</code> initialize the 
 * venue object with the given business requirement
 * 
 * @author ANUSHA
 */
public class VenueInitialize {
	
	public static int LEVEL1_ID=1;
	public static int LEVEL2_ID=2;
	public static int LEVEL3_ID=3;
	public static int LEVEL4_ID=4;
	public static String LEVEL1_NAME="Orchestra";
	public static String LEVEL2_NAME="Main";
	public static String LEVEL3_NAME="Balcony 1";
	public static String LEVEL4_NAME="Balcony 2";
	public static double LEVEL1_PRICE=100.00;
	public static double LEVEL2_PRICE=75.00;
	public static double LEVEL3_PRICE=50.00;
	public static double LEVEL4_PRICE=40.00;
	public static int LEVEL1_ROWS=25;
	public static int LEVEL2_ROWS=20;
	public static int LEVEL3_ROWS=15;
	public static int LEVEL4_ROWS=15;
	public static int LEVEL1_ROW_SEATS=50;
	public static int LEVEL2_ROW_SEATS=100;
	public static int LEVEL3_ROW_SEATS=100;
	public static int LEVEL4_ROW_SEATS=100;
	
	
	//Total number of Seats in the Venue
	public void totalNumSeats(){
		int totalNumSeats =((LEVEL1_ROWS*LEVEL1_ROW_SEATS)+
							(LEVEL2_ROWS*LEVEL2_ROW_SEATS)+
							(LEVEL3_ROWS*LEVEL3_ROW_SEATS)+
							(LEVEL4_ROWS*LEVEL4_ROW_SEATS));
		System.out.println("\n"+LEVEL1_NAME+"=" +(LEVEL1_ROWS*LEVEL1_ROW_SEATS));
		System.out.println(LEVEL2_NAME+"\t="+(LEVEL2_ROWS*LEVEL2_ROW_SEATS));
		System.out.println(LEVEL3_NAME+"="+(LEVEL3_ROWS*LEVEL3_ROW_SEATS));
		System.out.println(LEVEL4_NAME+"="+(LEVEL4_ROWS*LEVEL4_ROW_SEATS));
		System.out.println("Total seats"+"="+totalNumSeats);
	}
	
	//initialize the venu object
	public Venue initializeVenu(){
		
		Venue venue = new Venue();
		
		Level level1 =  new Level();
		level1.setLevelId(LEVEL1_ID);
		level1.setLevelName(LEVEL1_NAME);
		level1.setPrice(LEVEL1_PRICE);
		level1.setRows(getRowsForLevel1());
		
		
		Level level2 =  new Level();
		level2.setLevelId(LEVEL2_ID);
		level2.setLevelName(LEVEL2_NAME);
		level2.setPrice(LEVEL2_PRICE);
		level2.setRows(getRowsForLevel2());
		
		
		Level level3 =  new Level();
		level3.setLevelId(LEVEL3_ID);
		level3.setLevelName(LEVEL3_NAME);
		level3.setPrice(LEVEL3_PRICE);
		level3.setRows(getRowsForLevel3());
		
		
		Level level4 =  new Level();
		level4.setLevelId(LEVEL4_ID);
		level4.setLevelName(LEVEL4_NAME);
		level4.setPrice(LEVEL4_PRICE);
		level4.setRows(getRowsForLevel4());
		
		
		List<Level> venueLevels = new ArrayList<Level>();
		venueLevels.add(level1);
		venueLevels.add(level2);
		venueLevels.add(level3);
		venueLevels.add(level4);
		venue.setVenueLevels(venueLevels);
		return venue;
	}

	/**
	 * @return rowsInLevel1
	 */
	public List<Row> getRowsForLevel1(){
		List<Row> rowsInLevel= new ArrayList<Row>();
		for (int rowNo = 1; rowNo <= LEVEL1_ROWS; rowNo++) {
			Row row = new Row();
			row.setRowId(rowNo);
			getSeatsPerRow(row, LEVEL1_ROW_SEATS);
			rowsInLevel.add(row);
		}
		return rowsInLevel;
	}
	
	/**
	 * @return rowsInLevel2
	 */
	public List<Row> getRowsForLevel2(){
		List<Row> rowsInLevel= new ArrayList<Row>();
		for (int rowNo = 1; rowNo <= LEVEL2_ROWS; rowNo++) {
			Row row = new Row();
			row.setRowId(rowNo);
			getSeatsPerRow(row, LEVEL2_ROW_SEATS);
			rowsInLevel.add(row);
		}
		return rowsInLevel;
	}
	
	/**
	 * @return rowsInLevel3
	 */
	public List<Row> getRowsForLevel3(){
		List<Row> rowsInLevel= new ArrayList<Row>();
		for (int rowNo = 1; rowNo <= LEVEL3_ROWS; rowNo++) {
			Row row = new Row();
			row.setRowId(rowNo);
			getSeatsPerRow(row, LEVEL3_ROW_SEATS);
			rowsInLevel.add(row);
		}
		return rowsInLevel;
	}
	
	/**
	 * @return rowsInLevel4
	 */
	public List<Row> getRowsForLevel4(){
		List<Row> rowsInLevel= new ArrayList<Row>();
		for (int rowNo = 1; rowNo <= LEVEL4_ROWS; rowNo++) {
			Row row = new Row();
			row.setRowId(rowNo);
			getSeatsPerRow(row, LEVEL4_ROW_SEATS);
			rowsInLevel.add(row);
		}
		return rowsInLevel;
	}
	
	
	/**
	 * @param row
	 * @param numSeats
	 */
	// initialize the seats per each row
	public void getSeatsPerRow(Row row, int numSeats) {
		ArrayList<Seat> seatsInRow = new ArrayList<Seat>();
		for (int seatNo = 1; seatNo <= numSeats; seatNo++) {
			Seat seat = new Seat();
			seat.setSeatNum(seatNo);
			seatsInRow.add(seat);
		}
		row.setSeats(seatsInRow);
	}
}
