package RestaurantJDBCPro;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class Restaurants extends AbstRestaurant {

	/**
	 *have getter and setter methods 
	 *to implements all private members
	 *extends abstract class 
	 * 
	 * **/


	private static final Scanner scan=new Scanner(System.in);

	private String restaurantName;
	private int avgCost;
	private int rating;
	private String ownerName;
	private int restaurantId;
	
	

	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public int getAvgCost() {
		return avgCost;
	}


	public void setAvgCost(int avgCost) {
		this.avgCost = avgCost;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}




	public static Scanner getScan() {
		return scan;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	/*
	 * Getter method*/
	public int getRestaurantId() {
		return restaurantId;
		
	}
}
