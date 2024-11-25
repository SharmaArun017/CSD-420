//Name: Arun Sharma
//Date: 11/24/2024
//Assignment name and number: Module 6: Sorting - Assignment 6

//Sources : https://www.w3schools.com/ , https://www.geeksforgeeks.org/
//Purpose of code: This program implements a generic bubble sort algorithm using both Comparable and Comparator interfaces. 
//It demonstrates sorting of elements with natural ordering and custom ordering provided by a Comparator.
//Github link: https://github.com/SharmaArun017/CSD-420

package module5.assignment5;

import java.util.Arrays;
import java.util.Comparator;

public class GenericBubbleSort {

    // Bubble Sort method using Comparator for both Comparable and Comparator cases
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    // Swap elements
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Stop if no swaps occurred
        }
    }

    // Overloaded Bubble Sort for Comparable, delegates to the Comparator version
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        bubbleSort(list, Comparable::compareTo); // Use lambda for Comparable comparison
    }

    // Main method to test the program
    public static void main(String[] args) {
        // Test with Comparable
        Integer[] numbers = {5, 3, 8, 4, 2};
        System.out.println("Original array (Comparable): " + Arrays.toString(numbers));
        bubbleSort(numbers);
        System.out.println("Sorted array (Comparable): " + Arrays.toString(numbers));

        // Test with Comparator using lambda for descending order
        String[] names = {"Arun", "Aman", "Agam", "Zara", "Elon"};
        System.out.println("\nOriginal array (Comparator): " + Arrays.toString(names));
        bubbleSort(names, (s1, s2) -> s2.compareTo(s1)); // Descending order
        System.out.println("Sorted array (Comparator - Descending): " + Arrays.toString(names));
    }
}

/*
Step-by-Step Explanation of the Code:

1. Class Declaration:
   - The `GenericBubbleSort` class contains two bubble sort methods (one using Comparable and one using Comparator) and a `main` method to test the program.

2. Bubble Sort with Comparator:
   - The method `bubbleSort(E[] list, Comparator<? super E> comparator)` is a generic bubble sort that accepts an array and a `Comparator` to define the sorting logic.
   - The `Comparator` compares adjacent elements in the array using the `compare` method. If the result is greater than 0, the elements are swapped.
   - The `swapped` flag is used to optimize the sorting process by stopping early if no swaps occur during a pass.

3. Bubble Sort with Comparable:
   - The method `bubbleSort(E[] list)` uses the natural ordering of elements by delegating to the Comparator version with a lambda expression (`Comparable::compareTo`).

4. Main Method:
   - The `main` method tests both bubble sort methods:
     a. **Test with Comparable**:
        - An array of integers (`numbers`) is sorted using natural ordering.
        - The output shows the original array and the sorted array.
     b. **Test with Comparator**:
        - An array of strings (`names`) is sorted in descending order using a custom `Comparator` defined with a lambda expression.
        - The output shows the original array and the sorted array.

5. Output:
   - The program prints the results of both sorting methods, demonstrating correct functionality.

6. Purpose:
   - The program demonstrates the use of generic methods in Java to implement bubble sort, highlighting flexibility with both Comparable and Comparator for custom sorting.
