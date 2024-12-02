//Name: Arun Sharma
//Date: 12/01/2024
//Assignment name and number: Module 8: Multithreading - Assignment 8

//Sources: https://www.w3schools.com/, https://www.geeksforgeeks.org/
//Purpose of code: This program uses multithreading to generate and display random characters in three categories: letters, numbers, and special characters. 
//Each thread outputs 10,000 characters of its respective type in the console, demonstrating multithreading in a simple Java program.
//Github link: https://github.com/SharmaArun017/CSD-420

package module8.assignment8;

public class ArunThreeThreads {

  public static void main(String[] args) {
      // Create and start three threads for letters, numbers, and special characters
      Thread letterThread = new Thread(() -> outputCharacters("letters"));
      Thread numberThread = new Thread(() -> outputCharacters("numbers"));
      Thread specialCharThread = new Thread(() -> outputCharacters("special"));

      // Start all threads
      letterThread.start();
      numberThread.start();
      specialCharThread.start();
  }

  // Method to generate and output characters
  private static synchronized void outputCharacters(String type) {
      // Determine the character set based on the type
      String characters = switch (type) {
          case "letters" -> "abcdefghijklmnopqrstuvwxyz";
          case "numbers" -> "0123456789";
          case "special" -> "!@#$%^&*";
          default -> "";
      };

      // Print a header indicating the start of the output for this type
      System.out.println("\n--- START OF " + type.toUpperCase() + " OUTPUT ---\n");

      // Generate and print 10,000 random characters
      for (int i = 0; i < 10000; i++) {
          char randomChar = characters.charAt((int) (Math.random() * characters.length()));
          System.out.print(randomChar);

          // Add a newline every 100 characters for better readability
          if ((i + 1) % 100 == 0) {
              System.out.println();
          }
      }

      // Print a footer indicating the end of the output for this type
      System.out.println("\n--- END OF " + type.toUpperCase() + " OUTPUT ---\n");
  }
}

/*
Step-by-Step Explanation of the Code:

1. Class Definition:
 - The program defines a public class named ArunThreeThreads, adhering to the assignment requirement to use the my first name.

2. Main Method:
 - This is the entry point of the program. It creates three threads:
   - letterThread: Outputs random letters (a-z).
   - numberThread: Outputs random digits (0-9).
   - specialCharThread: Outputs random special characters (!, @, #, $, %, &, *).
 - Each thread runs the outputCharacters method with the appropriate type passed as an argument.
 - The start() method is called on each thread, initiating the multithreaded execution.

3. outputCharacters Method:
 - This method generates and outputs 10,000 random characters based on the specified type.
 - A switch statement is used to determine the character set for the given type:
   - "letters": Uses the lowercase English alphabet.
   - "numbers": Uses digits 0 through 9.
   - "special": Uses common special characters (!, @, #, $, %, &, *).
 - For each iteration of the loop:
   - A random character is selected using Math.random().
   - The character is printed to the console.
   - Every 100 characters, a newline is added for better readability.

4. Readability:
 - The loop ensures that characters are grouped in blocks of 100 per line.
 - After generating all characters for a type, a completion message is printed, indicating which type is done.

5. Expected Output:
 - The program displays 10,000 random letters, numbers, and special characters in the console.
 - The output is grouped in blocks, with a clear indication when each type is completed.

6. Testing:
 - Running the program serves as a functional test. Observing the console ensures that:
   - All threads generate the correct type of characters.
   - Each thread produces exactly 10,000 characters.
   - Multithreading is demonstrated as characters from different threads may interleave in the output.

Purpose:
This program demonstrates the use of multithreading to generate and display random characters in the console, fulfilling all assignment requirements.
*/