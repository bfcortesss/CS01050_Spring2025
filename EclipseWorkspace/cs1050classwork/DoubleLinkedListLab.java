/**
 * 
 */

/**
 * 
 */
public class DoubleLinkedListLab
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		//Declaring a class that has already been created. 
		
		DoublyLinkedListL18 list = new DoublyLinkedListL18();

		System.out.println("Inserting at the End:");
		list.insertAtEnd(10);
		list.insertAtEnd(20);
		list.insertAtEnd(30);
		list.printForward();
		list.printBackward();

		System.out.println("\nInserting at the Head:");
		list.insertAtHead(5);
		list.insertAtHead(1);
		list.printForward();
		list.printBackward();

		System.out.println("\nDeleting Node 20:");
		list.deleteNode(20);
		list.printForward();
		list.printBackward();

		System.out.println("\nReversing the List:");
		list.reverseList();
		list.printForward();
		list.printBackward();

	}

}


// Including in our code not just a Next but a Previous //

class NodeL18
{
	int data;
	NodeL18 next;
	NodeL18 prev;

	public NodeL18(int data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}



class DoublyLinkedListL18
{
	NodeL18 head;

	// Insert at the end (already implemented)
	public void insertAtEnd(int data)
	{
		NodeL18 newNode = new NodeL18(data);
		if (head == null)
		{
			head = newNode;
		} else
		{
			NodeL18 temp = head;
			while (temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp; // Backward link
		}
	}
	
	// Print the list forward
	public void printForward()
	{
		NodeL18 current = head;
		System.out.print("Forward: ");
		while (current != null)
		{
			System.out.print(current.data + " ⇄ ");
			current = current.next;
		}
		System.out.println("null"); // Continuous iteration until we get to NULL
	}

	// Students must complete this method
	public void insertAtHead(int data)
	{
		// Implement this
		System.out.println("Implement Insert at the Head:");
	}

	// Students must complete this method
	public void deleteNode(int data)
	{
		// Implement this
		System.out.println("Implement delete node:");
	}

	// Students must complete this method
	public void reverseList()
	{
		
		NodeL18 current = head;
		NodeL18 temp = null;
		
		
		while (current != null) {
			
			temp = current;
			
	
			current = current.prev; 
			
			
			
		}
		// Implement this
		System.out.println("Implement reverse list:");
	}
	
	// Print the list backward
	public void printBackward()
	{
		// Implement this
		System.out.println("Implement printbackward:");
	}
}
