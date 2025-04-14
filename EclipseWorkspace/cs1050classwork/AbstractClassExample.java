/**
 * 
 */

/**
 * 
 */
public class AbstractClassExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		// Vehicle vehicle = new Vehicle(); // This cannot be done. Cannot instantiate an instance of an abstract class //
		
		
		Car car = new Car();
		
		car.go();

	}

}



abstract class Vehicle {
	
	

	abstract void go(); // Method to go. Abstract method //
	
	
}


public class Car extends Vehicle {
	
	@Override
	void go() {
		
		System.out.println("The Driver is Driving the car");
	}
	
	
	
}


interface Auto {
	
	void go();
	void stop();
	
}