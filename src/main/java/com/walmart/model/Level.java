package com.walmart.model;

import java.util.List;


/**
 * The class <code>Level</code> represents the level information
 * 
 * @author ANUSHA
 * 
 */

public class Level {
	
	/**
	 * level ID
	 */
	private int levelId;
	
	/**
	 *level Name
	 */
	private String levelName;
	
	/**
	 * price
	 */
	private double price;
	
	/**
	 * Number of rows of the level
	 */
	//level can have any number of rows
	private List<Row> rows;
	
	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
}
