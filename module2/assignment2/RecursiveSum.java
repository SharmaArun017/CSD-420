//Name: Arun Sharma
//Date: 11/03/2024
//Assignment name and number: Module 2: Recursion - Assignment 2

//Sources : https://www.w3schools.com/ , https://www.geeksforgeeks.org/
//Purpose of code: The purpose of the code is to implement a recursive method that calculates the sum of the series defined by m(i) = 1/2 + 2/3 + 3/4 + 4/5 + 5/6 … i/(i + 1), and to test this method with different input values to ensure it functions correctly. 
//Github link: https://github.com/SharmaArun017/CSD-420

package module2.assignment2;

public class RecursiveSum {

    // Recursive method to calculate the sum m(i) = 1/2 + 2/3 + 3/4 + ... + i/(i + 1)
    public static double sumSeries(int i) {
        // Base case: when i is 1, return 1/2
        if (i == 1) {
            return 1.0 / 2;
        }
        // Recursive case: sum of the series up to i
        return (double) i / (i + 1) + sumSeries(i - 1);
    }

    public static void main(String[] args) {
        // Test the recursive method with different input values
        int[] testValues = {4, 9, 14};
        
        for (int value : testValues) {
            double result = sumSeries(value);
            System.out.printf("m(%d) = %.5f\n", value, result);
        }
    }
}

/*
Step-by-Step Explanation of the Code:

1. Class Declaration:
   - The class `RecursiveSum` is defined to implement the recursive method and test it.

2. Method Declaration - sumSeries(int i):
   - The method `sumSeries` is declared as `public static double`, meaning it can be called without creating an instance of the class and returns a `double`.
   - Base Case: The method checks if `i` is 1 and returns `1/2` as the first term of the series.
   - Recursive Case: If `i` is greater than 1, the method adds the current term `i/(i + 1)` to the result of `sumSeries(i - 1)`, recursively calculating the sum.

3. Main Method - main(String[] args):
   - The `main` method is declared as `public static void`, serving as the entry point for the program.
   - An array `testValues` is created with the values 4, 9, and 14 to test the recursive method with different input sizes.
   - A `for-each` loop iterates over the `testValues` array, calling `sumSeries` with each value and storing the result.
   - The `System.out.printf` method is used to print the result of each call to `sumSeries`, formatted to five decimal places.

4. Purpose:
   - The program demonstrates recursion by calculating the sum of a series using a recursive method and tests the function with three different input values.
*/
