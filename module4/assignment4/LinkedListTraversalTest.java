//Name: Arun Sharma
//Date: 11/10/2024
//Assignment name and number: Module 4: Collections - List - Assignment 4

//Sources : https://www.w3schools.com/ , https://www.geeksforgeeks.org/
//Purpose of code: The purpose of the code is to compare the traversal performance of a LinkedList using an iterator versus the get(index) method for large datasets, demonstrating the efficiency difference between sequential access and indexed access in a linked list structure.
//Github link: https://github.com/SharmaArun017/CSD-420


package module4.assignment4;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTraversalTest {
    
    public static void main(String[] args) {
        // Test the program with 50,000 and 500,000 integers
        testLinkedListTraversal(50000);
        testLinkedListTraversal(500000);
    }

    public static void testLinkedListTraversal(int size) {
        // Initialize LinkedList and populate with integers
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }

        System.out.println("Testing LinkedList traversal with " + size + " elements:");

        // Measure time taken to traverse using an iterator
        long startTime = System.nanoTime();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.nanoTime();
        long iteratorTime = endTime - startTime;
        System.out.println("Time using iterator: " + iteratorTime + " ns");

        // Measure time taken to traverse using get(index) method
        startTime = System.nanoTime();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        long getTime = endTime - startTime;
        System.out.println("Time using get(index): " + getTime + " ns");

        // Print a summary for this size
        System.out.println("Summary for " + size + " elements:");
        System.out.println("Iterator traversal time: " + iteratorTime + " ns");
        System.out.println("get(index) traversal time: " + getTime + " ns");
        System.out.println("Difference (get(index) - iterator): " + (getTime - iteratorTime) + " ns\n");
    }
}

/*
Step-by-Step Explanation of the Code:

1. Class Declaration:
   - The `LinkedListTraversalTest` class is defined to perform LinkedList traversal tests using both an iterator and the `get(index)` method.

2. Main Method - main(String[] args):
   - The `main` method is the program's entry point and calls `testLinkedListTraversal` with values 50,000 and 500,000 to test the traversal time for different LinkedList sizes.

3. Method Declaration - testLinkedListTraversal(int size):
   - This method performs the actual test on a LinkedList with a specified size (50,000 or 500,000).
   - **LinkedList Initialization**: A `LinkedList<Integer>` is created and populated with integers from 0 to `size - 1`.

4. Traversal using Iterator:
   - The time taken to traverse the LinkedList using an iterator is measured by recording the start and end times with `System.nanoTime()`.
   - An `Iterator` is created for the `LinkedList`, and a `while` loop iterates over each element using `iterator.next()`.

5. Traversal using get(index):
   - The time taken to traverse the LinkedList using the `get(index)` method is measured similarly.
   - A `for` loop accesses each element by its index using `linkedList.get(i)`.

6. Results Summary:
   - The program prints the time taken for each traversal method (iterator vs. get(index)) and the difference in times for comparison.

Discussion:
   - With smaller lists (e.g., 50,000 elements), the difference in traversal time between `get(index)` and the iterator might be noticeable but not as extreme.
   - With larger lists (e.g., 500,000 elements), the `get(index)` approach becomes significantly slower, illustrating why `LinkedList` is not ideal for random access compared to sequential traversal with an iterator.
   - In a `LinkedList`, accessing elements using `get(index)` is slower for larger lists because each call to `get` must traverse from the beginning to the specified index, resulting in O(n) time for each access.
   - The iterator approach is faster since it traverses the list sequentially without repeatedly starting from the beginning.
*/
