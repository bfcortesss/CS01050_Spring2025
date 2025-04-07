// CarVendindMachineProject //
// By: Brian Flores //
// CS2050 Computer Science 2 //
// Project Iteration 1 // 


import java.util.*;



public class CarVendingMachineProject {

	
	public class Main {
		
	
	    public static void main(String[] args) {
	       
	    	
	    	Scanner scanner = new Scanner(System.in);
	        VendingMachine vendingMachine = null;
	        

	        System.out.print("Enter the number of floors for the car vending machine: ");
	        int floors = scanner.nextInt();
	        System.out.print("Enter the number of spaces for the car vending machine: ");
	        int spaces = scanner.nextInt();
	       

	        while (true) {
	            System.out.println("\n=== Car Vending Machine Menu ===");
	            
	            System.out.println("1. Load Car Data");
	            
	            System.out.println("2. Display Vending Machine");
	            
	            System.out.println("3. Retrieve a Car");
	            
	            System.out.println("4. Print Sorted Inventory (Price)");
	            
	            System.out.println("5. Print Sorted Inventory (Year)");
	            
	            System.out.println("6. Exit");
	            
	            System.out.print("Enter your choice: ");
	            
	            int choice = scanner.nextInt();
	            scanner.nextLine();
	
	        }
	    }
   // Car Class // 
	
    class Car {
    	
    	// Attributes // 
    	// Private modifier indicating encapsulation //
    	
        private int year; 
        private double price;
        private String make;
        private String model;

        
        // Car Constructors and Methods // 
        
        public Car(int year, double price, String make, String model) {
            this.year = year;
            this.price = price;
            this.make = make;
            this.model = model;
        }

        // My getter methods for Year, Price, Make, and Model of the car //
        
        public int getYear() {
            return year;
        }

        public double getPrice() {
            return price;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        @Override
        public String toString() {
            return make + " " + model + " " + year + " - $" + price;
        }
    }

    
  // Vending Machine Class // 
    
    class VendingMachine {
        
    	
    	private Car[][] tower;

        public VendingMachine(int floors, int spaces) {
           
        	tower = new Car[floors][spaces]; // Initializing 2D Array of floors (Rows) and spaces (Columns) // 
        }

        
        
        
        // Method for adding car //
        
        public boolean addCar(int floor, int space, Car car) {
            if (floor < 0 || floor >= tower.length || space < 0 || space >= tower[0].length) {
                System.out.println("Error: Invalid position at Floor: " + (floor + 1) + " Space: " + (space + 1));
                System.out.println("Cannot place Car " + car);
                return false;
            }

            if (tower[floor][space] != null) {
                System.out.println("Error: Slot at Floor: " + (floor + 1) + " Space: " + (space + 1) + " is already occupied.");
                System.out.println("Car " + car + " cannot be placed.");
                return false;
            }

            tower[floor][space] = car;
            return true;
        }

        // Method for retrieving a car //
        
        public Car retrieveCar(int floor, int space) {
            if (floor < 0 || floor >= tower.length || space < 0 || space >= tower[0].length) {
                System.out.println("Invalid location.");
                return null;
            }

            Car car = tower[floor][space];
            
            if (car == null) {
               
            	System.out.println("No car located at Floor " + (floor + 1) + " Location " + (space + 1));
            } else {
                System.out.println("Car retrieved from Floor " + (floor + 1) + " Location " + (space + 1) + ": " + car);
                tower[floor][space] = null;
            }
            return car;
        }

        
        // Display with a nested loop to iterate through each array of vehicles // 
        
        public void displayMachine() {
           
        	for (int i = 0; i < tower.length; i++) {
            
        		System.out.println("Floor " + (i + 1) + ":");
               
        		for (int j = 0; j < tower[0].length; j++) {
                 
        			if (tower[i][j] == null) {
                        System.out.println(" \tSpace " + (j + 1) + " [Empty] ");

		
        			}	
	
        	}

        	}
        	
        } 
       
    } 
    
	    } 
	    } 
	
        	
    
    
	    
	   
	
	
	
	