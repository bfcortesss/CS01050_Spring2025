// Program to implement the Bubble Sorting algorithm //
// By: Brian Flores //

// Bubble Sort = Pairs id adjacent elements are compared, and the elements are 
//               swapped if they are not in order. Bubble sort continues this 
//               until all of the elements are sorted from least to greatest. 


// Quadratic runtime complexity = O(n^2) 
// Small data set = Not too shabby. 
// Large data set = Not efficient at all. 


public class BubbleSort {

	
	

	public static void main(String[] args) {
		
		
		int array[] = {1, 6, 7, 4, 9, 4, 3, 2, 10};
		
		
		
		for(int i: array) {
			System.out.print(i);
			
		bubbleSort(array);
			
		}	
			
		}
			
			// Bubble Sort Code // 
	
	
		public static void bubbleSort(int array[]) {
			
			// Nested For loop // 
			
			for (int i = 0; i < array.length - 1; i++) {
				
				for (int j = 0; j < array.length - 1; j++) {
					
					if (array[j] > array[j+1]) {
						int temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
						
						
						
						
					}
				}
			
			
		}
		
		
		

	}
		

}





