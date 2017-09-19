package edu.wit.cs.comp1050;

//TODO: document this class
public class PA2a {
	
	/**
	 * Error to display if input contains non-numeric characters
	 */
	public static final String ERR_NON_NUMERIC = "Non-numeric input";
	
	/**
	 * Error to display if input is too short
	 */
	public static final String ERR_SHORT = "Input is too short";
	
	/**
	 * Error to display if input is too long
	 */
	public static final String ERR_LONG = "Input is too long";
	
	/**
	 * Error to display if input contains an invalid prefix
	 */
	public static final String ERR_BAD_PREFIX = "Invalid prefix";
	
	/**
	 * Array of valid single-digit prefixes
	 */
	public static final int[] PREFIXES_ONE_DIGIT = {4, 5, 6};
	
	/**
	 * Array of valid double-digit prefixes
	 */
	public static final int[] PREFIXES_TWO_DIGIT = {37};
	
	/**
	 * Minimum input length
	 */
	public static final int LENGTH_MIN = 13;
	
	/**
	 * Maximum input length
	 */
	public static final int LENGTH_MAX = 16;
	
	/**
	 * Returns true if the supplied argument
	 * contains only numeric digits (0-9)
	 * 
	 * @param s input string
	 * @return true if input contains only numeric digits
	 */
	public static boolean isOnlyNumbers(String s) {
		return false;
	}
	
	/**
	 * Return the numeric value that
	 * the supplied character represents
	 * '0' -> 0
	 * '1' -> 1
	 * ...
	 * '9' -> 9
	 * 
	 * @param c input character (assumed to be a digit)
	 * @return integer represented by the input
	 */
	public static int digitCharToInt(char c) {
		return 0;
	}
	
	/**
	 * Returns the numeric value that
	 * the supplied characters represent
	 * in sequence (c1 is tens place, c2 is ones)
	 * '00' -> 0
	 * '01' -> 1
	 * ...
	 * '10' -> 10
	 * '11' -> 11
	 * ...
	 * '90' -> 90
	 * '91' -> 91
	 * '99' -> 99
	 * 
	 * @param c1 tens place digit (assumed to be a digit)
	 * @param c2 ones place digit (assumed to be a digit)
	 * @return integer represented by the inputs
	 */
	public static int digitCharToInt(char c1, char c2) {
		// Hint: digitCharToInt could be useful here...
		return 0;
	}
	
	/**
	 * Returns true if the supplied integer
	 * is contained within the array of integers
	 * 
	 * @param needle item to search for
	 * @param haystack valid list in which to search
	 * @return true if needle is in haystack
	 */
	public static boolean inArray(int needle, int[] haystack) {
		return false;
	}
	
	/**
	 * Returns true if the supplied string
	 * begins with a valid prefix
	 * 
	 * @param s credit card number (assumed to be comprised only of digits)
	 * @return true if begins with a valid CC prefix
	 */
	public static boolean validPrefix(String s) {
		// Hint: digitCharToInt and inArray
		// could be useful here
		return false;
	}
	
	/**
	 * Returns the number of digits
	 * in an integer
	 * 
	 * @param num number (assumed to be non-negative)
	 * @return number of digits in the number
	 */
	public static int numDigits(int num) {
		return 0;
	}
	
	/**
	 * Returns the digit in the specified "place"
	 * of an input number, where 0 is the ones,
	 * 1 is the ten's, ...
	 * 
	 * f(1234, 0) = 4
	 * f(1234, 1) = 3
	 * f(1234, 2) = 2
	 * f(1234, 3) = 1
	 * 
	 * @param num input number (assumed to be non-negative)
	 * @param place place from which to extract the digit (assumed to be [0, #digits-1])
	 * @return digit extracted
	 */
	public static int getDigitInPlace(int num, int place) {
		return 0;
	}
	
	/**
	 * Returns a single digit number resulting
	 * from repeatedly adding the digits of a
	 * number until it is reduced to a single digit...
	 * 5678 => 5 + 6 + 7 + 8 = 26 => 2 + 6 = 8 
	 * 
	 * @param num number (assumed to be non-negative)
	 * @return single-digit from repeated sums
	 */
	public static int reduceToDigit(int num) {
		// Hint: numDigits and getDigitInPlace
		// could be useful here
		return 0;
	}
	
	/**
	 * Sums every second digit, right to left.
	 * If doubling results in a double-digit,
	 * add up the digits to produce a single.
	 * 4388576018402626 =>
	 *  2*2 = 4
	 * +2*2 = 4
	 * +2*4 = 8
	 * +2*1 = 2
	 * +2*6 = 12 => 3
	 * +2*5 = 10 => 1
	 * +2*8 = 16 => 7
	 * +2*4 = 8
	 * = 37
	 * 
	 * @param s input string (assumed to be only digits)
	 * @return sum of doubled evens
	 */
	public static int sumOfDoubleEvens(String s) {
		// Hint: digitCharToInt and reduceToDigit
		// could be useful here
		return 0;
	}
	
	/**
	 * Sums every odd digit, right to left.
	 * 4388576018402626 =>
	 * 6+6+0+8+0+7+8+3=38
	 * 
	 * @param s input string (assumed to be only digits)
	 * @return sum of odds
	 */
	public static int sumOfOdds(String s) {
		// Hint: digitCharToInt and reduceToDigit
		// could be useful here
		return 0;
	}
	
	/**
	 * Returns true if the sum of the
	 * doubled sum of even digits +
	 * sum of odd digits is divisible
	 * by 10.
	 * 
	 * 4388576018402626: 37 + 38 = 75 % 10 != 0 => false
	 * 5117275325077359: 18 + 42 = 60 % 10 == 0 => true
	 * 
	 * @param s input string (assumed to be only digits)
	 * @return true if passes the Luhn check
	 */
	public static boolean luhnCheck(String s) {
		// Hint: sumOfDoubleEvens and sumOfOdds
		// could be useful here
		return false;
	}

	/**
	 * Inputs a credit card number
	 * and outputs either input-validation
	 * error or validation status of the
	 * card number
	 * 
	 * @param args command-line arguments, ignored
	 */
	public static void main(String[] args) {
		// Hint: MANY useful methods and constants here
		// - isOnlyNumbers()
		// - validPrefix()
		// - luhnCheck()
		// - ERR_ constants
		// - LENGTH_ constants
	}

}
