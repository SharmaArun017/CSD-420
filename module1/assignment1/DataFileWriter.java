//Name: Arun Sharma
//Date: 10/27/2024
//Assignment name and number: Module 1: Binary I/O - Assignment 1

//Sources : https://www.w3schools.com/ , https://www.geeksforgeeks.org/
//Purpose of code : This program generates random integers and doubles along with the current date, storing them in a file for future retrieval.
//Github link: https://github.com/SharmaArun017/CSD-420

package module1.assignment1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
public class DataFileWriter {
    public static void main(String[] args) {
        // Create an array of five random integers
        int[] randomIntegers = new int[5];
        Random random = new Random();
        for (int i = 0; i < randomIntegers.length; i++) {
            randomIntegers[i] = random.nextInt(100); // Generate random integers between 0 and 99
        }

        // Store the current date
        Date currentDate = new Date();

        // Create an array of five random double values
        double[] randomDoubles = new double[5];
        for (int i = 0; i < randomDoubles.length; i++) {
            randomDoubles[i] = random.nextDouble(); // Generate random double values between 0.0 and 1.0
        }

        // Write data to file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("ArunDatafile.dat"))) {
            // Write integers to file
            for (int value : randomIntegers) {
                dos.writeInt(value);
            }

            // Write the current date (long representation)
            dos.writeLong(currentDate.getTime());

            // Write doubles to file
            for (double value : randomDoubles) {
                dos.writeDouble(value);
            }

            System.out.println("Data successfully written to ArunDatafile.dat");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

/*
Step-by-Step Explanation:

Program 1 - DataFileWriter:

1. Class Declaration:
   - The `DataFileWriter` class is created to handle generating random data (integers and doubles) and saving them along with the current date to a file.

2. Import Statements:
   - The `java.io.*` and `java.util.*` packages are imported to access classes like `DataOutputStream`, `FileOutputStream`, `Date`, and `Random`.

3. Method Declaration - main(String[] args):
   - The `main` method is the program's entry point, handling the entire data generation and storage process.

4. Generating an Array of Random Integers:
   - An integer array named `randomIntegers` with five elements is created.
   - The program uses a `Random` object to generate five random integers, each between 0 and 99, and stores them in the `randomIntegers` array.

5. Creating a Date Object:
   - The program creates a `Date` object called `currentDate`, which is automatically initialized to the current date and time.

6. Generating an Array of Random Doubles:
   - A double array named `randomDoubles` with five elements is created.
   - The program uses the same `Random` object to generate five random double values, each between 0.0 and 1.0, and stores them in the `randomDoubles` array.

7. Writing Data to File:
   - A `DataOutputStream` object is created to write the generated data to a file named "ArunDatafile.dat". Replace "Arun" with your name for your assignment.
   - The program writes each integer from `randomIntegers`, the `currentDate` (converted to a `long` timestamp), and each double from `randomDoubles` to the file in sequence.
   - Once the data is written, a confirmation message is displayed, and resources are automatically closed using the try-with-resources statement.
*/