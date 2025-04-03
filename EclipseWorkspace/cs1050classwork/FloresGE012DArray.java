// FloresGE012DArray //
// Programming example to explore 2D arrays of Cars.//
// By: Brian Flores //
// Computer Science 2 //


public class FloresGE012DArray {

	
	public static void main(String[] args) {
			
		// Here we are creating an array "carArray" with 2 rows, and 3 columns. //
		
		String[][] cars = new String[2][3];
		
		
		// Array declaration. Assigning String values into each element of arrays on a 2x3 matrix //
		
		cars[0][0] = "Ford";
		cars[0][1] = "Dodge";
		cars[0][2] = "Toyota";
		cars[1][0] = "Hyundai";
		cars[1][1] = "Chevrolet";
		cars[1][2] = "Subaru";
		
	 
	 // Iteration of 2D Array following example of CorpSales.J //
	// Nested for loop to display the Array of cars/ //
	
		 
	for (int i = 0; i < cars.length; i++) {
		
		for (int j = 0; j < cars[i].length; j++) {
			
			System.out.println(cars[i][j]+" ");
		}
	}
	
		 
	 }
	 
	 
	 // Car class example provided from Guided Exploration 02. //
	 
	class Car {
		private String make;
		
		public Car() {
			
			this.make = "unkown";
		}	
		
		public Car(String make) {
			this.make = make;
			
		}
		public void printMake() {
			System.out.print(this.make +" ");
	
		}		
	}
	 // Car
		

}

		
		
		
		
	
	
				