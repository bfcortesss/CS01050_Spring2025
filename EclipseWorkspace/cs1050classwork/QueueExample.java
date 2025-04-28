/**
 * 
 */
import java.util.Queue;
import java.util.LinkedList;

/**
 * 
 */
public class QueueExample {

	/**
	 * Queue = FIFO (First in, First Out) data structure. First come first serve.
	 * 		   A collection designed to hold elements prior to processing.
	 * 		   Linear Data Structure.
	 * 		   Elements are removed from the head and, added to the tail. 
	 * 
	 * 		   Add = enqueue, offer() to the tail
	 * 		   Remove = dequeue, poll() from the head
	 * 
	 */
	public static void main(String[] args) {
	
		Queue<String> groceryLine = new LinkedList<String>();
		
		//Add individuals to the Queue (Grocery Line). 
		
		groceryLine.offer("Customer 1");
		groceryLine.offer("Customer 2");
		groceryLine.offer("Customer 3");
		groceryLine.offer("Customer 4");
		
		// Display Queue before poll( )
		// System.out.println(groceryLine);
		
		groceryLine.poll();
		groceryLine.poll();
		
		System.out.println(groceryLine);
		
		//Display the element at the top head of the queue 
		//System.out.println(groceryLine.peek());
	}

}
