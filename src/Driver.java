// Import scanner for the user input
import java.util.Scanner;

/**
 * The Driver class runs the Arabic to Roman numeral converter and Roman to Arabic converter program.
 * It prompts the user to choose which conversion they want to do and
 * accepts input, checks the inputs, does the conversion, and displays the result.
 */

public class Driver {

    /**
     * Converts between Arabic numbers that are form 1 to 3999 and Roman numerals.
     * Provides methods for Arabic to Roman and Roman to Arabic conversions,
     * and validates Roman numeral format and input correctness.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Create a new scanner object to read the user input
        Scanner scanner = new Scanner(System.in);
        // Creates a new instance of ArabicToRomanConverter for the conversion test
        ArabicToRomanConverter converter = new ArabicToRomanConverter();
        // Initialize a String for the users input choice
        String choice = " ";
        // This will keep asking the user to type valid option until user types 1 or 2
        while (!choice.equals("1") && !choice.equals("2"))
        {
            // Print statement to let the user pick what type Arabic to Roman or Roman to Arabic
            System.out.println("Click 1 for Arabic to Roman or 2 for Roman to Arabic: ");
            // This will read the user's input choice
            choice = scanner.nextLine();
            // If the users input does nto equal 1,2, or 3 it will tell them to pick one of those correct options
            if (!choice.equals("1") && !choice.equals("2")) {
                System.out.println("Not a valid choice. Please click 1 or 2");
            }
        }
        // If choice equals to 1 then it will be Arabic to Roman
        // Since it's a string, used .equals to check if the strings have the same sequence of characters, since == only used if they have the exact same object in memory
        if (choice.equals("1"))
        {
            System.out.print("Enter an Arabic number (1–3999): ");
            // Read the user's input as a String so it can check it before converting
            String userInput = scanner.nextLine();
            // Attempt to convert the string input into an integer since scanner.nextLine() returns a String,
            // and ArabicToRoman() requires an int parameter. Iff the input contains any invalid characters
            // like letters, Integer.parseInt() will automatically throw a NumberFormatException
            try
            {
                // Attempt to convert the string input into an integer
                // Integer.parseInt() will automatically throw a NumberFormatException if not an integer
                // NumberFormatException is apart Java built in library, part of java.lang package. Is a runtime exception
                int arabicNumber = Integer.parseInt(userInput);

                // Call the conversion method ArabicToRoman with the valid integer
                // Sets the roman value to the corresponding arabic integer input value
                String roman = converter.ArabicToRoman(arabicNumber);

                // Print the String result of the conversion
                System.out.println("Roman numeral: " + roman);
            }
            // The catch block handles the automatic NumberFormatException if string not integer so the program doesn't crash
            catch (NumberFormatException e)
            {
                // Instead of crashing, prompts user to enter only numbers
                System.out.println("Invalid input — please enter only numbers.");
            }
            // Close the scanner to prevent resource leaks
            scanner.close();

        }

        // This is for when the user input is 2 for Roman to Arabic
        else
        {
            System.out.print("Enter A Valid Uppercase Roman Numeral: ");
            // Read the user's input as a string.
            String roman = scanner.nextLine();
            // Call RomanToArabic to convert the Roman numeral to an Arabic number.
            int arabicNumber = converter.RomanToArabic(roman);
            // Print the converted Arabic number to console
            System.out.println("Arabic number: " + arabicNumber);
            // Close the scanner to prevent resource leaks
            scanner.close();
        }

    }
}
