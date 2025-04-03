
import java.util.Arrays;
import java.util.Random;

public class Mod2SortingComparison
{
	public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 50000}; // Array sizes to test

        for (int size : sizes) {
            int[] originalArray = generateLargeRandomArray(size);
            System.out.println("Testing with array size: " + size);

            // Selection Sort Timing
            int[] array = Arrays.copyOf(originalArray, originalArray.length);
            long startTime = System.nanoTime();
            selectionSort(array);
            long endTime = System.nanoTime();
            System.out.println("Selection Sort took " + (endTime - startTime) / 1e6 + " ms");

            // Insertion Sort Timing
            array = Arrays.copyOf(originalArray, originalArray.length);
            startTime = System.nanoTime();
            insertionSort(array);
            endTime = System.nanoTime();
            System.out.println("Insertion Sort took " + (endTime - startTime) / 1e6 + " ms");

            // Bubble Sort Timing
            array = Arrays.copyOf(originalArray, originalArray.length);
            startTime = System.nanoTime();
            bubbleSort(array);
            endTime = System.nanoTime();
            System.out.println("Bubble Sort took " + (endTime - startTime) / 1e6 + " ms");

            System.out.println("--------------------------------------");
        }
    }

    // Selection Sort Algorithm
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Insertion Sort Algorithm
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Bubble Sort Algorithm
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Helper Method to Generate Large Random Arrays
    public static int[] generateLargeRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000); // Random numbers between 0 and 9999
        }
        return array;
    }
}
