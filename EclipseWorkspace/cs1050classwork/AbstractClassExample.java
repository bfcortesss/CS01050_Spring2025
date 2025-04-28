/**
 * /**
 * Abstract Code example 
 * 
 * 
 */

import java.util.ArrayList;

public class AbstractClassExample {

	/**
	 * 
	 */
	public static void main(String[] args) {
		
		
		
		// Vehicle vehicle = new Vehicle(); // This cannot be done. Cannot instantiate an instance of an abstract class //
		
		
		Car car = new Car();
		
		car.go();
		
		
		
		// Array initialization // 
		
		int[] numbers = new int[5];
		numbers[0] = 10;

		// ArrayList initialization//

ArrayList<Integer> list = new ArrayList<>();
		list.add(10);


	}

}



abstract class Vehicle {
	
	

	abstract void go(); // Method to go. Abstract method //
	
	
}

 


interface Auto {
	
	void go();
	void stop();
	
}

class Car implements Auto {
	@Override
	public void go() {
		System.out.println("Car is going.");
		}
	
	@Override
	public void stop() {
		System.out.println("Car is stopped.");
	}
	
	
	
	
}