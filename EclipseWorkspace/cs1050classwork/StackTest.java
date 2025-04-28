/*
 * Stack Example
 * Add comments to explain the code
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackTest {
    public static void main(String[] args) {
    	
    	Stack<String> stringStack = new Stack<>();
    	
    	// Pushing Hi, Hello, Goodbye onto the stack // 
    	System.out.println("Pushing Hi, Hello, Goodbye"); 
    	stringStack.push("Hi");
    	stringStack.push("Hello");
    	stringStack.push("Goodbye");
    	
    	System.out.println("String stack after pushing: " + stringStack);
    	
    	String popped = stringStack.pop();
    	System.out.println("Popped Element: " + stringStack.pop());
    	
    	
    	// Finish after class and add to your technical documentations // March 17th // 

    	
        Stack<Integer> stack = new Stack<>();


        System.out.println("Pushing elements: 10, 20, 30");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        

        System.out.println("Stack after pushing: " + stack);


        int pop = stack.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after popping: " + stack);


        int topElement = stack.peek();
        System.out.println("Top element: " + topElement);


        System.out.println("Is stack empty? " + stack.isEmpty());
        
        popped = stack.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after popping: " + stack);
        
        popped = stack.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after popping: " + stack);
        
        popped = stack.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after popping: " + stack);
    }
}


// Generic because T specifies that it can be any type. //
// If it were to specify any primitive data type then it would not be generic //

class Stack<T> {
	

    private ArrayList<T> items; 


    public Stack() {
        this.items = new ArrayList<>();
    }


    public boolean isEmpty() {
        return this.items.isEmpty();
    }


    public void push(T item) {
        this.items.add(item);
    }


    public T pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return this.items.remove(items.size() - 1);
    }


    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return this.items.get(items.size() - 1);
    }


    public int size() {
        return this.items.size();
    }


    @Override
    public String toString() {
        if (!this.items.isEmpty()) {
            return "bottom ->" + this.items.toString() + "<- top";
        } else {
            return "<<empty stack>>";
        }
    }
}

