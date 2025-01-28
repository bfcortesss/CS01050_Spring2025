/*
 * Arrays Class, Sorting and Searching Searching
 * Explore this code to understand array concepts
 * Add comments to explain the code and help you remember
 * 
 */

import java.util.Scanner;
//import arrays class
import java.util.Arrays;

public class ArraysClass {
	
	public static void main(String[] args) {

		//add comments to explain code
		final int ARRAY_SIZE = 10;
		final int RANDOM_MIN = 50;
		final int RANDOM_MAX= 105;
		
		int searchResult = -1;

		Scanner input = new Scanner(System.in);	
		
		//What is happening when  an array is created in a method and returned?
		int[] arrayToSearch = createRandomIntArray(ARRAY_SIZE, RANDOM_MIN, RANDOM_MAX); 
		
		displayArray(arrayToSearch);
		
		// PART1 Linear Search Method
		System.out.println("****** Part 1: Linear Search ******\n");
		System.out.println("What value should we search for? ");
		int key = input.nextInt();
		
		searchResult = linearSearch(arrayToSearch, key);
		
		System.out.println("Linear Search Results");
		if (searchResult != -1) {
			System.out.println(key + " was found in location " + searchResult);
		}
		else {
			System.out.println(key + " was not found in the array");			
		}
		
		
		// PART2 Selection Sort and Binary Search Methods
		System.out.println("\n****** Part 2: Linear Search ******\n");
		System.out.println("What value should we search for? ");
		
		
		//how are arrays passed to methods?
		//What does that mean?
		selectionSort(arrayToSearch);
		
		System.out.println("Sorted Array");
		displayArray(arrayToSearch);


		System.out.println("\nBinary Search: What value should we search for? ");
		key = input.nextInt();
		
		searchResult = binarySearch(arrayToSearch, key);
		
		System.out.println("\nBinary Search Results");
		if (searchResult != -1) {
			System.out.println(key + " was found in location " + searchResult);
		}
		else {
			System.out.println(key + " was not found in the array");			
		}

		// Part 3: Array Class Methods
		
		System.out.println("\n****** Part 3: Use Arrays Class to sort and search ******\n");
		
		System.out.println("Add little pices of code and test");
		
		//create new array with 10 integers 
			
		// call arrays class method to fill with 13 for each element

		
		//call method to display the array
				
		// Update the new array by calling method to update with random numbers

		
		//call method to display the array
				
		// call arrays class method to sort
				
		// call method to display the array
		
		// Prompt and read from keyboard what to search for
		
		//call arrays class binary search method 
		
		//display whether the value was found or not

		input.close();

	} // main

	

	/*
	Finds a key value in an array searching from first index to last
	Parameters: integer array, key value to search for
	Return: index of where key value found, otherwise -1 if not found
	*/
	public static int linearSearch(int[] array, int key) {

		int foundKey = -1;
		for (int i = 0; i < array.length; i++) {
			if (key == array[i]) {
				foundKey = i;
			}
		}
		return foundKey;
	} // linearSearch

	/*
	Add comments
	
	Parameters: 
	Return: 
	*/
	public static void selectionSort(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;

			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}

			// Swap list[i] with list[currentMinIndex] if necessary;
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}

	/*
	Add comments
	
	Parameters: 
	Return: 
	*/
	public static int binarySearch(int[] list, int key) {
		int low = 0;
		int high = list.length - 1;

		while (high >= low) {
			int mid = (low + high) / 2;
			if (key < list[mid])
				high = mid - 1;
			else if (key == list[mid])
				return mid;
			else
				low = mid + 1;
		}

		return -low - 1; // Now high < low
	}


	/*
	Add comments
	
	Parameters: 
	Return: 
	*/
	public static void displayArray(int passedArray[])
	{
		System.out.println("Array Contents");
		for (int i = 0; i < passedArray.length; i++) {

			System.out.printf("array1[%d] = %d \n",i, passedArray[i]);
		}

	}
	
	
	/*
	Add comments
	
	Parameters: 
	Return: 
	*/                 
	public static int[] createRandomIntArray (int arraySize, int min, int max)
	{
		int[] newArray = new int[arraySize];
		for (int i = 0; i < newArray.length; i++) {
			
			newArray[i] = (int)(Math.random() *(max - min + 1) + min); 
		} 

		return newArray;
	}

}
