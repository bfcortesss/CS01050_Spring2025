/**
 * 
 */

import java.util.ArrayList;

/**
 * Example program of ArrayList implementation
 * By: Brian Flores
 * 
 */


public class ArrayListExample {
	
	/**
	 * ArrayList = A re-sizable array. Grows and shrinks dynamically.
	 *			   Elements can be added and removed after compiling. 
	 *			   Stores reference data types. 
	 */
	
	public static void main(String[] args) {
		
		
		//ArrayList<ReferenceDataType> ArrayName = new ArrayList<ReferenceDataType>();
		// Initializing example above. 
		
		ArrayList<String> food = new ArrayList<String>();
		
		// Add values into the ArrayList 
		
		food.add("Pizza");
		food.add("Hamburger");
		food.add("Hotdog");
		
		//Useful method: The set method. 
		// food.set(index, element);
		 food.set(0, "Sushi"); // When the program executes this line "Hamburger" is replaced by "Sushi."
		// food.remove(2); // When the program executes this line hamburger is removed from the index 2.
		// food.clear(); // Clears ArrayList when executed. 
		
		// Display the elements of ArrayList food with a for loop. 
		
		for (int i = 0; i < food.size(); i++) {
			System.out.println(food.get(i));
			
		}

	}

}
