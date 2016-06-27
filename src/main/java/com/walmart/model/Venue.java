package com.walmart.model;

import java.util.List;

/**
 * The class <code>Venue</code> represents Venue information
 * 
 * @author ANUSHA
 */
public class Venue {
	
	//venue can have any number of levels
	private static List<Level> VenueLevels ;
		
	/**
	 * @return	VenueLevels
	 */
	public List<Level> getVenueLevels() {
		return VenueLevels;
	}

	/**
	 * @param venueLevels
	 */
	public void setVenueLevels(List<Level> venueLevels) {
		VenueLevels = venueLevels;
	}	
}
