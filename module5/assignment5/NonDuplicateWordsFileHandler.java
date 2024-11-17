//Name: Arun Sharma
//Date: 11/17/2024
//Assignment name and number: Module 5: Collections - Sets and Maps - Assignment 5

//Sources : https://www.w3schools.com/ , https://www.geeksforgeeks.org/
//Purpose of code: This program writes a predefined set of words to a file, reads and processes those words to remove duplicates, and displays them in both ascending and descending order, ensuring correctness and fulfilling the assignment requirements.
//Github link: https://github.com/SharmaArun017/CSD-420

package module5.assignment5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NonDuplicateWordsFileHandler {

    public static void main(String[] args) {
        // File name for the collection of words
        String fileName = "collection_of_words.txt";

        // Input words to write to the file
        String inputWords = "apple banana fruit grape orange peach";

        // Step 1: Write words to the file
        writeToFile(fileName, inputWords);

        // Step 2: Read and process words from the file
        readAndProcessFile(fileName);
    }

    public static void writeToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Words written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    public static void readAndProcessFile(String fileName) {
        try {
            // Read words from the file
            Set<String> words = new TreeSet<>();
            Scanner fileScanner = new Scanner(new File(fileName));

            while (fileScanner.hasNext()) {
                String word = fileScanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
            fileScanner.close();

            // Display words in ascending order
            System.out.println("\nNon-duplicate words in ascending order:");
            for (String word : words) {
                System.out.print(word + " ");
            }
            System.out.println();

            // Display words in descending order
            System.out.println("\nNon-duplicate words in descending order:");
            for (String word : ((TreeSet<String>) words).descendingSet()) {
                System.out.print(word + " ");
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

/*
Step-by-step Explanation of the Code:

1. File Writing (writeToFile):
   - The `writeToFile` method creates or overwrites the file `collection_of_words.txt` with the content "apple banana fruit grape orange peach".
   - It uses `FileWriter` within a try-with-resources block to ensure proper resource management.
   - This ensures the file exists with predefined input for subsequent processing.

2. File Reading and Processing (readAndProcessFile):
   - The `readAndProcessFile` method reads words from the `collection_of_words.txt` file.
   - A `TreeSet` is used to store words in sorted order and automatically eliminate duplicates.
   - Words are converted to lowercase and stripped of non-alphabetic characters using `replaceAll`.

3. Display Non-duplicate Words:
   - Words are displayed in ascending order using the `TreeSet`.
   - The `descendingSet()` method is used to generate a reverse view of the `TreeSet`, displaying words in descending order.

4. Main Method:
   - The `main` method orchestrates the program by calling `writeToFile` to create the file and `readAndProcessFile` to process and display the results.

Includes Test Code:
   - The program writes predefined input ("apple banana fruit grape orange peach") to the file and then reads it back, ensuring that both the writing and reading processes are tested within the same program.

Purpose:
   - This program writes a predefined set of words to a file, reads and processes those words to remove duplicates, and displays them in both ascending and descending order, ensuring correctness and fulfilling the assignment requirements.
*/
