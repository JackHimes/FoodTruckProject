package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		boolean keepGoing = true;
		Scanner scanner = new Scanner(System.in);
		int menuSelection;
		int externalWhileCounter = 0;

		FoodTruck[] foodTruckGroup = new FoodTruck[5];

		FoodTruckApp b = new FoodTruckApp();

		while (keepGoing) {
			b.printMenuTruckInput();
			menuSelection = scanner.nextInt();
			scanner.nextLine();
			if (externalWhileCounter > 4) {
				System.out.println("You've reached max number of trucks!");
				keepGoing = false;
				continue;
			}
			if (menuSelection == 1) {
				String name = "";
				String foodType = "";
				double rating = 0.0;

				foodTruckGroup[externalWhileCounter] = new FoodTruck(name, foodType, rating);

				System.out.print("Please enter the food trucks name(or type quit to continue): ");
				name = scanner.nextLine();

				if (name.equals("quit")) {
					keepGoing = false;
					for (int i = externalWhileCounter; i < foodTruckGroup.length; i++) {
						foodTruckGroup[i] = new FoodTruck();
					}
					continue;
				}
				foodTruckGroup[externalWhileCounter].setName(name);

				System.out.print("Please enter the food type: ");
				foodType = scanner.nextLine();
				foodTruckGroup[externalWhileCounter].setFoodType(foodType);
				System.out.print("Please enter the rating(1-5 Stars): ");
				rating = scanner.nextDouble();
				scanner.nextLine();
				foodTruckGroup[externalWhileCounter].setNumericRating(rating);

			} else if (menuSelection == 2) {
				keepGoing = false;
				for (int i = externalWhileCounter; i < foodTruckGroup.length; i++) {
					foodTruckGroup[i] = new FoodTruck();
				}

				continue;
			}

			externalWhileCounter++;
		}

		keepGoing = true;
		while (keepGoing) {
			String truckInfo = "";
			b.printMenuDisplayData();
			menuSelection = scanner.nextInt();
			scanner.nextLine();
			switch (menuSelection) {
			case 1:
				for (int i = 0; i < foodTruckGroup.length; i++) {
					truckInfo = foodTruckGroup[i].toString();
					if (truckInfo.contains("default")) {
						System.out.print("");
					} else {
						System.out.println(truckInfo);
					}
				}
				break;
			case 2:
				double average = b.calcAvg(foodTruckGroup);
				double averageRounded = Math.round(average * 100D) / 100D;
				System.out.println("The average rating of the food trucks is: " + averageRounded);
				break;
			case 3:
				FoodTruck highestRatedFoodTuck = b.findHighestRating(foodTruckGroup);
				System.out.println("The highest rated food truck: ");
				System.out.println(highestRatedFoodTuck.toString());
				break;
			case 4:
				System.exit(0);

			default:
				System.out.println("Please enter a valid option: ");
			}

		}
		scanner.close();

	}

	public void printMenuTruckInput() {
		System.out.println("_________________________");
		System.out.println("|                       |");
		System.out.println("|                       |");
		System.out.println("| 1.Enter a new Food    |");
		System.out.println("|  Truck (up to 5)      |");
		System.out.println("| 2.Continue            |");
		System.out.println("|                       |");
		System.out.println("|_______________________|");
		System.out.print("Input here: ");
	}

	public void printMenuDisplayData() {
		System.out.println("_________________________");
		System.out.println("|                       |");
		System.out.println("|                       |");
		System.out.println("| 1.List all exsisting  |");
		System.out.println("|   food trucks         |");
		System.out.println("| 2.Average rating of   |");
		System.out.println("|   food trucks         |");
		System.out.println("| 3.Highest rated food  |");
		System.out.println("|   truck               |");
		System.out.println("| 4.Quit                |");
		System.out.println("|                       |");
		System.out.println("|_______________________|");
		System.out.print("Input here: ");

	}

	public double calcAvg(FoodTruck[] arrayOfFoodTrucks) {
		double avg = 0.0;
		int numOfRatings = 0;
		for (int i = 0; i < arrayOfFoodTrucks.length; i++) {
			if (arrayOfFoodTrucks[i].getNumericRating() == 0.0) {
				continue;
			} else {
				avg += arrayOfFoodTrucks[i].getNumericRating();
				numOfRatings++;

			}
		}
		avg = (avg / numOfRatings);

		return avg;
	}

	public FoodTruck findHighestRating(FoodTruck[] arrayOfFoodTrucks) {
		FoodTruck tempFoodTruck = new FoodTruck();
		double previousRating = 0.0;

		for (int i = 0; i < arrayOfFoodTrucks.length; i++) {
			if (arrayOfFoodTrucks[i].getNumericRating() > previousRating) {
				tempFoodTruck = arrayOfFoodTrucks[i];
				previousRating = arrayOfFoodTrucks[i].getNumericRating();
			}

		}

		return tempFoodTruck;
	}

}
