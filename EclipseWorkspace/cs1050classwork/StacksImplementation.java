/**
 * 
 */
import java.util.Stack;
/**
 * 
 */
public class StacksImplementation {

	/**
	 * Stacks = LIFO data structure. Last in, first out. 
	 * 		   Stores objects into a "vertical tower" think about stacking plates. 
	 *		   push() to add to the top
	 *		   pop() to remove from the top 
	 */
	
	public static void main(String[] args) {
		
		// Initialization: Stack<DataType> stackName = new Stack<>();
		
		Stack<String> stackExample = new Stack<String>();
		
		// System.out.println(stackExample.empty()); Check if stack is empty 
		
		// Push() elements to the top of the Stack 
		stackExample.push("Squirrels");
		stackExample.push("Birds");
		stackExample.push("Cats");
		stackExample.push("Dogs");
		
		//Remove elements from the stack 
		stackExample.pop(); // Removes Dogs from the stack 
		stackExample.pop(); // Removes Cats from the stack 
		
		// Print stack 
		System.out.print(stackExample);
		
		// Look at the element at that is at the top of the stack.
		System.out.print(stackExample.peek());
		

	}

}
