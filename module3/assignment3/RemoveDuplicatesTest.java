//Name: Arun Sharma
//Date: 11/03/2024
//Assignment name and number: Module 3: Generics - Assignment 3

//Sources : https://www.w3schools.com/ , https://www.geeksforgeeks.org/
//Purpose of code: The purpose of the code is to create a program that demonstrates the use of generics by implementing a method to remove duplicates from an ArrayList and testing it with an ArrayList populated with 50 random integers.
//Github link: https://github.com/SharmaArun017/CSD-420

package module3.assignment3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RemoveDuplicatesTest {

    // Static method to remove duplicates from an ArrayList using generics
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // Using HashSet to remove duplicates
        HashSet<E> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        // Create an ArrayList and fill it with 50 random values from 1 to 20
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1); // Random value between 1 and 20
        }

        // Print the original list
        System.out.println("Original List (with duplicates):");
        System.out.println(originalList);

        // Call the generic removeDuplicates method
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        // Print the new list without duplicates
        System.out.println("\nList After Removing Duplicates:");
        System.out.println(uniqueList);
    }
}

/*
Step-by-Step Explanation of the Code:

1. Import Statements:
   - The code imports `ArrayList`, `HashSet`, and `Random` from the `java.util` package to use collections and generate random numbers.

2. Class Declaration:
   - The class `RemoveDuplicatesTest` is defined as a public class containing the main logic and methods for the task.

3. Generic Method - removeDuplicates(ArrayList<E> list):
   - This method is declared as `public static <E>`, indicating it is a generic method that can work with any type `E`.
   - The method takes an `ArrayList<E>` as input and uses a `HashSet<E>` to remove duplicates by converting the list into a set and back to an `ArrayList`.
   - The method returns a new `ArrayList` containing only unique elements from the input list.

4. Main Method - main(String[] args):
   - The `main` method serves as the program's entry point.
   - An `ArrayList<Integer>` named `originalList` is created and populated with 50 random integers between 1 and 20 using a `for` loop and the `Random` class.

5. Printing the Original List:
   - The original list is printed to the console to show the values, including duplicates.

6. Calling removeDuplicates Method:
   - The `removeDuplicates` method is called with `originalList` as the argument, and the result is stored in `uniqueList`.

7. Printing the Unique List:
   - The modified list `uniqueList` is printed to the console to show the values after duplicates have been removed.

8. Purpose:
   - This program demonstrates the use of generics in a static method to remove duplicates from an `ArrayList` and tests the method by populating the list with random values.
*/
