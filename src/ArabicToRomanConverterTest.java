// /**
//  * Unit test class for the ArabicToRomanConverter.
//  * This test suite verifies both valid and invalid conversions between Arabic and Roman numerals.
//  * It ensures that valid inputs produce the correct results and invalid inputs are handled gracefully.
//  * The tests cover edge cases such as out of range Arabic numbers and malformed Roman numerals,
//  * and incorrect repetition or subtraction patterns.
//  *
//  * @author Amit Boodhoo
//  * @since 2025-10-08
//  */

// import static org.junit.jupiter.api.Assertions.*;

// class ArabicToRomanConverterTest {
//     /**
//      * Tests the ArabicToRoman method to verify that Arabic numbers
//      * between 1 and 3999 are correctly converted to their Roman numeral equivalents.
//      * Also tests invalid inputs such as zero, negative numbers, and numbers past 3999.
//      */

//     @org.junit.jupiter.api.Test
//     void arabicToRoman() {
//         // Creates a new object of the ArabicToRomanConverter class to use its methods
//         ArabicToRomanConverter arabicToRomanConverter = new ArabicToRomanConverter();
//         // Check for valid numbers
//         String romanResult1 = arabicToRomanConverter.ArabicToRoman(10);
//         assertEquals("X", romanResult1, "10 should convert to X");

//         String romanResult2 = arabicToRomanConverter.ArabicToRoman(2);
//         assertEquals("II", romanResult2, "2 should convert to II");

//         String romanResult3 = arabicToRomanConverter.ArabicToRoman(4);
//         assertEquals("IV", romanResult3, "4 should convert to IV");

//         String romanResult4 = arabicToRomanConverter.ArabicToRoman(9);
//         assertEquals("IX", romanResult4, "9 should convert to IX");

//         String romanResult5 = arabicToRomanConverter.ArabicToRoman(50);
//         assertEquals("L", romanResult5, "50 should convert to L");

//         String romanResult6 = arabicToRomanConverter.ArabicToRoman(932);
//         assertEquals("CMXXXII", romanResult6, "92 should convert to CMXXXII");

//         // Check for invalid Arabic to Roman inputs
//         // Too big of a number
//         String romanResult7 = arabicToRomanConverter.ArabicToRoman(1345342);
//         assertEquals("Arabic number must be between 1 and 3999", romanResult7, "1345342 should convert to CMXXXII");

//         // Invalid negative number
//         String romanResult8 = arabicToRomanConverter.ArabicToRoman(-123);
//         assertEquals("Arabic number must be between 1 and 3999", romanResult8, "Input too small must be greater than 1 and less than 399");

//         // Invalid number being 0
//         String romanResult9 = arabicToRomanConverter.ArabicToRoman(0);
//         assertEquals("Arabic number must be between 1 and 3999", romanResult9, "Input too small must be greater than 1 and less than 399");

//     }

//     /**
//      * Tests the RomanToArabic method to verify that valid Roman numerals
//      * are correctly converted to their Arabic numeric equivalents.
//      * Also ensures that invalid, empty, or malformed Roman numerals
//      * return 0 and are properly identified as invalid.
//      */

//     @org.junit.jupiter.api.Test
//     void romanToArabic() {
//         // Creates a new object of the ArabicToRomanConverter class to use its methods
//         ArabicToRomanConverter romanToArabicConverter = new ArabicToRomanConverter();
//         // Check for valid options
//         int arabicResult1 = romanToArabicConverter.RomanToArabic("X");
//         assertEquals(10, arabicResult1, "X should convert to 10");

//         int arabicResult2 = romanToArabicConverter.RomanToArabic("IV");
//         assertEquals(4, arabicResult2, "IV should convert to 4");

//         int arabicResult3 = romanToArabicConverter.RomanToArabic("MMCDLVI");
//         assertEquals(2456, arabicResult3, "MMCDLVI should convert to 2456");

//         int arabicResult4 = romanToArabicConverter.RomanToArabic("XXXII");
//         assertEquals(32, arabicResult4, "XXXII should convert to 32");

//         int arabicResult5 = romanToArabicConverter.RomanToArabic("MCMLXXXIX");
//         assertEquals(1989, arabicResult5, "MCMLXXXIX should convert to 1989");

//         int arabicResult13 = romanToArabicConverter.RomanToArabic("MMM");
//         assertEquals(3000, arabicResult13, "MCMLXXXIX should convert to 3000");

//         int arabicResult15 = romanToArabicConverter.RomanToArabic("MMMDCCCLXXXVIII");
//         assertEquals(3888, arabicResult15, "MMMDCCCLXXXVIII should convert to 3888");

//         int arabicResult16 = romanToArabicConverter.RomanToArabic("CDXC");
//         assertEquals(490, arabicResult16, "CDXC should convert to 490");

//         // Check for invalid inputs
//         int arabicResult6 = romanToArabicConverter.RomanToArabic("");
//         assertEquals(0, arabicResult6, "Input is empty or null. Invalid input.");

//         int arabicResult7 = romanToArabicConverter.RomanToArabic("A");
//         assertEquals(0, arabicResult7, "A is not a Roman numeral");

//         // Should not output 5
//         int arabicResult8 = romanToArabicConverter.RomanToArabic("IIV");
//         assertEquals(0, arabicResult8, "Invalid Roman subtraction pattern");

//         // IL should not be 49 it is invalid
//         int arabicResult9 = romanToArabicConverter.RomanToArabic("IL");
//         assertEquals(0, arabicResult9, "Invalid Roman subtraction pattern");

//         int arabicResult10 = romanToArabicConverter.RomanToArabic("IIII");
//         assertEquals(0, arabicResult10, "Invalid repeat pattern in Roman numeral");

//         int arabicResult11 = romanToArabicConverter.RomanToArabic("IXXIV");
//         assertEquals(0, arabicResult11, "Invalid Roman Numeral ");

//         int arabicResult12 = romanToArabicConverter.RomanToArabic("IIIIXXIV");
//         assertEquals(0, arabicResult12, "Invalid Roman Numeral ");

//         int arabicResult14 = romanToArabicConverter.RomanToArabic("MMMM");
//         assertEquals(0, arabicResult14, "Invalid repeat pattern in Roman numeral");

//     }
// }