/**
 * This ArabicToRomanConverter converts numbers between Arabic numerals and Roman numerals.
 * It lets users select if they want to convert form Arabic to Roman or Roman to Arabic.
 * The program checks for valid inputs to make sure Arabic numbers are between 1 and 3999 and Roman numerals follow
 * Invalid inputs such as zero, negatives, or other invalid Roman numerals will produce an error message.
 * Uses parallel arrays to match the corresponding Arabic and Roman numeral values
 * The Driver class demonstrates the functionality, and a JUnit 5 test suite is there to automatically
 * test both valid and invalid cases. The program ensures valid input handling and accurate conversion for all supported numeral values.
 *
 * @author Amit Boodhoo
 * @since 2025-09-25
 */


public class ArabicToRomanConverter {
    /**
     * Fixed array of Arabic numeral values corresponding to Roman symbols.
     * Includes special subtractive cases such as 900 (CM) and 4 (IV).
     */
    // These are all the values that are possible to use include the special cases such as 4 and so on.
    // Made final so that this reference variable arabicValues always points to the same array of fixed values
    // Private variable since it is only accessible within the class where it is defined ArabicToRomanConverter
    private final int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    /**
     * Fixed array of Roman numeral symbols corresponding to Arabic values.
     * Used in parallel with the Arabic values during conversion.
     */
    // These are the corresponding Roman numerals that match up with the arabic values. Final since this array will not change
    // Made final so that this reference variable romanSymbols always points to the same array of fixed values
    // Private variable since it is only accessible within the class where it is defined ArabicToRomanConverter
    private final String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * Converts an Arabic number to its equivalent Roman numeral representation.
     *
     * @param arabicNumber the integer to convert that's a number from 1 to 3999
     * @return the Roman numeral as a String
     * @throws IllegalArgumentException if the input number is out of range (less than 1 or greater than 3999)
     */

    // Method to convert an Arabic number to its equivalent Roman numeral value.
    public String ArabicToRoman(int arabicNumber)
    {
        // Using try and catch to safely handle any invalid Arabic number input values
        try
        {
            // Blank string to add new roman numerals to match the arabic number
            String roman = "";
            // Check if the Arabic number is out of the valid range from 1 to 399 and if it is not then it will throw and exception to prevent invalid conversion
            if (arabicNumber < 1 || arabicNumber > 3999)
            {
                // The words throw makes and sends out an exception object from Java’s built-in library
                // The IllegalArgumentException comes from the java.lang package which is included automatically
                // The new keyword creates the exception object and then throw sends it up the call stack
                // The program will then look for a matching catch block to handle it and show a message
                // Thrown to show that a method has been passed an illegal or inappropriate argument.
                throw new IllegalArgumentException("Arabic number must be between 1 and 3999");
            }
            // This is index integer variable that will help check each value in arabicValues
            // Start at value 0 since it will check the largest value of arabicValue first which is 1000
            int i = 0;
            // Loops while Arabic number is greater than or equal to 0 and is within array length which is 13
            while (arabicNumber > 0 && i < arabicValues.length)
            {
                // Checks if the Arabic number is greater than or equal to the Arabic value at index i
                if (arabicNumber >= arabicValues[i]) {
                    // This will then append the Roman symbol of its corresponding Arabic value
                    roman = roman + romanSymbols[i];
                    // This will subtract the Arabic value from the current number
                    arabicNumber -= arabicValues[i];
                }
                // Checks if the current Arabic number is less than the value at index i
                else
                {
                    // Increment index value by one and moves to the next smallest Arabic value
                    i += 1;
                }
            }

            // This will then return the final Roman value
            return roman;
        }

        // This will catch any invalid input and prevent the program from stopping
        catch (IllegalArgumentException e)
        {
            // This will return a message instead of just crashing
            // telling user that the Arabic number must be between 1 and 3999
            // Must return a string since function returns a string
            return "Arabic number must be between 1 and 3999";
        }
    }

    /**
     * Converts a Roman numeral to its equivalent Arabic number.
     *
     * @param roman the Roman numeral string to convert
     * @return the Arabic number as an integer
     * @throws IllegalArgumentException if the Roman numeral is invalid
     */
    // Method to convert a Roman number to Arabic
    public int RomanToArabic(String roman)
    {
        // Using try and catch to safely handle any invalid Roman number input values
        try
        {
            // Call boolean checks for invalid strings
            boolean emptyString = isRomanInputEmpty(roman);
            boolean upperCase = isUpperCase(roman);
            boolean validRepeats = isValidRomanRepeats(roman);
            boolean validSubtraction = isValidRomanSubtraction(roman);

            // Check for invalid Roman numerals
            if (emptyString == true || upperCase == false || validRepeats == false || validSubtraction == false)
            {
                // If there is invalid roman numerals, throw an IllegalArgumentException
                // Thrown to show that a method has been passed an illegal or inappropriate argument.
                throw new IllegalArgumentException("Invalid Roman numeral input");
            }

            // If all checks pass then it can do the conversion
            // Initialize a variable to keep tract of the arabic number to go along with the Roman number input
            int arabicNumber = 0;
            // This is the variable used to keep track of the popped piece from the front of the string
            String RomanPop;
            // Checks while there are still characters left in the Roman string and it is not empty
            while (roman.isEmpty() == false)
            {
                // boolean to check if there is a matched symbol this loop
                boolean symbolMatched = false;
                // Loop through the roman symbols. The length is 13
                for (int i = 0; i < romanSymbols.length; i++)
                {
                    // roman.equals(romanSymbols[i]) Checks if the entire Roman string matches the current symbol
                    // such as "IX" == "IX" or "M" = "M"
                    // Or roman.length() >= romanSymbols[i].length() Checks that the Roman input is long enough to compare
                    // (usually checks if roman length is greater than 2 or 1)
                    // && roman.substring(0, romanSymbols[i].length()).equals(romanSymbols[i])
                    // Gets the first part of the string (same length as the current symbol)
                    // For example, if roman = "IXL" and romanSymbols[i] = "IX"
                    // substring(0, 2) gets "IX" so we can check if it matches the symbol at the start
                    if (roman.equals(romanSymbols[i]) || roman.length() >= romanSymbols[i].length() && roman.substring(0, romanSymbols[i].length()).equals(romanSymbols[i]))
                    {
                        // Stores the matched Roman symbol to then remove it later
                        RomanPop = romanSymbols[i];
                        // Add its corresponding Arabic value to the total
                        arabicNumber += arabicValues[i];
                        // Remove the matched symbol from the front of the string and set roman to new substring
                        // without the already checked part
                        roman = roman.substring(RomanPop.length());
                        // Sets symbolMatched to true since there was a valid symbol value that was in romanSymbols array
                        symbolMatched = true;
                    }
                }
                // If no symbols matched or found in the romanSymbols array then it is invalid
                // Ex: "AB" is not a Roman numbers so no symbol is matched and symbolMatched now false so throw an exception
                if (symbolMatched == false)
                {
                    // Thrown to show that a method has been passed an illegal or inappropriate argument.
                    throw new IllegalArgumentException("Invalid Roman Numeral");
                }
            }
            // Return the arabic number that corresponds to the Roman number
            return arabicNumber;
        }
        // This will catch any invalid input and prevent the program from stopping
        // 'e' is the exception object holding details about the error
        // Prints an error message and returns 0 as a safe value since the method must return an int.
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid Roman Numeral");
            // Must return an integer since method returns an int so return safe value of 0;
            return 0;
        }

    }


    /**
     * Checks if all the roman numeral values are valid Uppercase letters
     *
     * @param roman is the Roman numeral string to check
     * @return true if the Roman numeral is valid, false otherwise
     */

    // Boolean method to check if there is any lowercase letters and if so return false
    public boolean isUpperCase(String roman)
    {
        // Check if there is a number that is not uppercase since Roman numerals should always be uppercase
        // Initialize a character value that will be used to check each character in the roman input
        char romanCharacter;
        // Loop through the roman numerals
        for (int i = 0; i < roman.length(); i++)
        {
            // Set romanCharacter to that character at the current index
            romanCharacter = roman.charAt(i);
            // Check if any character is lowercase by comparing ASCII values.
            // In Java, 'A' to 'Z' are 65–90. Lowercase letters like 'a' start at 97 which > 90
            // Values before 'A' are symbols and numbers
            // So if a char is less than 'A' or greater than 'Z' it is not uppercase and invalid.
            // Also checks if they are a valid roman letter like I,V,X,L,C,D, and M
            if (romanCharacter < 'A' || romanCharacter > 'Z' || !(romanCharacter == 'I' || romanCharacter == 'V' || romanCharacter == 'X' || romanCharacter == 'L' || romanCharacter == 'C' || romanCharacter == 'D' || romanCharacter == 'M'))
            {
                // Returns false if there is a lowercase letter ing the roman input
                return false;
            }
        }
        // Return true if all characters are uppercase
        return true;
    }


    /**
     * Checks if the given Roman numeral input is null or empty.
     *
     * @param roman the Roman numeral string to check
     * @return true if the input is null or empty, false otherwise
     */

    // Method to check if the Roman numeral input is null or empty
    public boolean isRomanInputEmpty(String roman) {
        // Checks if the input is null or is empty without characters
        if (roman == null || roman.length() == 0) {
            // Input is empty or null so invalid
            return true;
        }
        // Input is actually has characters
        return false;
    }

    /**
     * Validates that a Roman numeral does not contain invalid repeated symbols.
     * Ensures that I, X, C, and M are not repeated more than three times in a row,
     * and that V, L, and D never repeat consecutively.
     *
     * @param roman the Roman numeral string to validate
     * @return true if the Roman numeral has valid repeats, false if invalid repeats are found
     */
    // Check for invalid repeats
    public boolean isValidRomanRepeats(String roman) {

        // These are variables set to 0 to count if I, X, C, or M repeat
        int isymbolRepeat = 0;
        int xsymbolRepeat = 0;
        int csymbolRepeat = 0;
        int msymbolRepeat = 0;

        // Check for V, L, and D. Cannot repeat
        int vRepeatCount = 0;
        int lRepeatCount = 0;
        int dRepeatCount = 0;

        // Loop through the roman input string. Stop at length-1 to avoid being out of bounds
        for (int i = 0; i < roman.length() - 1; i++)
        {
            // Check if there is a repeat of a character
            if (roman.charAt(i) == roman.charAt(i + 1))
            {
                // Checks if the repeat was the letter I
                if (roman.charAt(i) == 'I')
                {
                    isymbolRepeat += 1;
                }
                // Checks if the repeat was the letter X
                if (roman.charAt(i) == 'X')
                {
                    xsymbolRepeat += 1 ;
                }
                // Checks if the repeat was the letter C
                if (roman.charAt(i) == 'C')
                {
                    csymbolRepeat += 1;
                }
                // Checks if the repeat was the letter M
                if (roman.charAt(i) == 'M')
                {
                    msymbolRepeat += 1;
                }
                // Check if there are back to back repeats of V,L, or D which there should not be
                if (roman.charAt(i) == 'V') {
                    vRepeatCount += 1;
                }
                if (roman.charAt(i) == 'L') {
                    lRepeatCount += 1;
                }
                if (roman.charAt(i) == 'D') {
                    dRepeatCount += 1;
                }
            }
        }
        // If there are repeats of v,l, and d back to back then return false
        if (vRepeatCount > 0 || lRepeatCount > 0 || dRepeatCount > 0)
        {
            return false;
        }
        // Checks if any of the variables repeat more than twice, if so it is invalid
        // Ex: MMM repeat twice msymbolRepeat = 2 with this MMM input
        if (isymbolRepeat > 2 || xsymbolRepeat > 2 || csymbolRepeat > 2 || msymbolRepeat > 2)
        {
            return false;
        }
        // Returns true if no invalid repeats
        return true;
    }


    /**
     * Checks whether the Roman numeral contains only valid subtractive pairs.
     * Detects invalid combinations such as IL, IC, XD, XM, VX, or any improper ordering
     * after a subtraction like IXXIV or IXC
     *
     * @param roman the Roman numeral string to validate
     * @return true if all subtractive pairs and ordering are valid, false otherwise
     */
    // Check for invalid Roman subtractions like IL or IC
    public boolean isValidRomanSubtraction(String roman) {
        // This will loop through each character besides last one
        for (int i = 0; i < roman.length() - 1; i++)
        {
            // Initialize current and next symbol
            char currentSymbol = roman.charAt(i);
            char nextSymbol = roman.charAt(i + 1);

            // Initialize the value that will be associated with the current symbol and next symbol
            int currentValue = 0;
            int nextValue = 0;

            // Find value for current symbol by looping through romanSymbols greatest to least
            for (int j = 0; j < romanSymbols.length; j++)
            {
                // Checks if both current index value being checked in
                // romanSymbols is length 1 since it is checking single characters
                // Also checks if that character in romanSymbols is equal to the current symbol at this index.
                // If so, assign its corresponding Arabic value to currentValue.
                if (romanSymbols[j].length() == 1 && romanSymbols[j].charAt(0) == currentSymbol)
                {
                    // Assign currentSymbol's character to corresponding Arabic value to currentValue integer
                    currentValue = arabicValues[j];
                }
                // Checks if both next index value being checked in
                // romanSymbols is length 1 since it is checking single characters
                // Also checks if that character in romanSymbols is equal to the next symbol at this index.
                // If so, assign its corresponding Arabic value to nextValue.
                if (romanSymbols[j].length() == 1 && romanSymbols[j].charAt(0) == nextSymbol)
                {
                    // Assign nextSymbol's character to corresponding Arabic value to nextValue integer
                    nextValue = arabicValues[j];
                }
            }

            // Check for any invalid subtractive pairs such as IL, IC, XD, XM, etc.
            String invalidPairs = "";
            // Join the two letters together
            invalidPairs += currentSymbol + nextSymbol;
            if (invalidPairs.equals("IL") || invalidPairs.equals("IC") || invalidPairs.equals("ID") || invalidPairs.equals("IM") ||  invalidPairs.equals("XD") || invalidPairs.equals("XM") ||  invalidPairs.equals("VX") || invalidPairs.equals("VL") || invalidPairs.equals("VC") || invalidPairs.equals("VD") || invalidPairs.equals("VM") ||  invalidPairs.equals("LC") || invalidPairs.equals("LD") || invalidPairs.equals("LM") ||  invalidPairs.equals("DM")) {
                // If any of these pairs exist, return false since it is not a valid Roman subtraction
                return false;
            }

            // if the current integer value less than next integers value for corresponding Roman characters
            // Like 'I' before 'X' since 'I' or 1 < 'X' or 10
            if (currentValue < nextValue) {
                // Check if currentSymbol is 'I' and nextSymbol is not 'V' or 'X'
                // Only valid values are 'I' behind 'V' or 'X' so if that not case its false
                if (currentSymbol == 'I' && nextSymbol != 'V' && nextSymbol != 'X') {
                    // Catches 'IL', 'IC', 'ID', and 'IM' and returns false
                    return false;
                }
                // Check if currentSymbol is 'X' and nextSymbol is not 'L' or 'C'
                // Only valid values are 'X' behind 'L' or 'C' so if that not case its false
                if (currentSymbol == 'X' && nextSymbol != 'L' && nextSymbol != 'C') {
                    // Catches XD, XM and reutrns false
                    return false;
                }
                // Check if currentSymbol is 'C' and nextSymbol is not 'D' or 'M'
                // Only valid values are 'C' behind 'D' or 'M' so if that not case its false
                if (currentSymbol == 'C' && nextSymbol != 'D' && nextSymbol != 'M') {
                    return false;
                }
                // This checks if the current symbol is not the first symbol in the string
                // and if the symbol immediately before the current one (at index i-1)
                // is the exact same as the current one.
                if (i >= 1 && roman.charAt(i - 1) == currentSymbol) {
                    // This catches cases like "IIV" where a symbol repeats before a subtraction, returns false
                    return false;
                }
                // Check for invalid ordering after subtraction such as IXC or IXXIV
                // Ensures there are at least two more characters ahead.
                if (i < roman.length() - 2) {
                    // Gets the symbol after the subtractive pair
                    char symbolAfterPair = roman.charAt(i + 2);
                    // Initialize value for the symbol after the pair
                    int valueAfterPair = 0;
                    // Loop through Roman symbols
                    for (int j = 0; j < romanSymbols.length; j++) {
                        // Only checks single character symbols
                        if (romanSymbols[j].length() == 1 && romanSymbols[j].charAt(0) == symbolAfterPair)
                        {
                            // Store the Arabic value of the matching symbol
                            valueAfterPair = arabicValues[j];
                        }
                    }
                    // If the value after the pair is greater than or equal to the value of the subtractive symbol then invalid
                    if (valueAfterPair >= nextValue && valueAfterPair != 0) {
                        return false;
                    }
                }
            }
        }
        // If there is a valid roman input without subtraction issues, return true
        return true;
    }

}


