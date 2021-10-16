package com.skilldistillery.foodtruck;

public class FoodTruck {
	private int uniqueID = 1000;
	private String name = "default";
	private String foodType = "default";
	private double numericRating = 0.0;
	private static int counter = 1000;

	public FoodTruck(String name, String foodType, double rating) {
		setUniqueID(++counter);
		this.name = name;
		this.foodType = foodType;
		this.numericRating = rating;
	}

	public FoodTruck() {
		setUniqueID(++counter);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getNumericRating() {
		return numericRating;
	}

	public void setNumericRating(double numericRating) {
		this.numericRating = numericRating;
	}

	public String toString() {
		String output = "Name of Food Truck: " + name + "\nType of Food: " + foodType + "\nUser Rating: "
				+ numericRating + "\nuniqueID(printed for grading purposes)= " + uniqueID + "\n";
		return output;

	}

}
