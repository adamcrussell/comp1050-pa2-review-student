package edu.wit.cs.comp1050;

import java.util.Scanner;
import java.io.*;


//TODO: document this class
public class PA2c {
	
	/**
	 * Error to display if given name could not be located in the datafile
	 */
	final static String ERR_NONAME = "Name could not be located in given file.";
	
	/**
	 * Error to display from main() if datafile cannot be opened
	 */
	final static String ERR_IOMAIN = "File I/O error at main()";
	
	/**
	 * First year of data being available
	 */
	final static int STARTYEAR = 1890;
	
	/**
	 * Number of lines in the given names list
	 */
	final static int NO_OF_LINES = 5870;
	
	/**
	 * Number of decades of data given for each name
	 */
	final static int NO_OF_DECADES = 13;
	
	/**
	 * User prompt to gather datafile name
	 */
	final static String pf = "Enter a filename: ";
	
	/**
	 * User prompt to gather name to search for
	 */
	final static String p0 = "Enter the name to search for: ";
	
	/**
	 * User prompt to gather the gender to search for
	 */
	final static String p1 = "Enter the gender to search for, M or F: ";
	
	/**
	 * User prompt to repeat the search process
	 */
	final static String p2 = "Would you like to search again? y or n: ";

	/**
	 * Displays given string to console and collects a String
	 * 
	 * @param prompt String to display
	 * @param in Scanner object
	 * @return String collected from the user
	 */
	public static String displayStringGetString(String prompt, Scanner in ) {

		return null;
	}
	
	/**
	 * Convert the user given name to valid format. For instance:
	 * "JACK" to "Jack"
	 * "bette" to "Bette"
	 * "TrOy" to "Troy"
	 * @param uname
	 * @return valid version of uname
	 */
	public static String formatName (String uname) {
		return null;
	}

	/**
	 * Given a file name, open a Scanner object to read this file. 
	 * If file not found:
	 * 	-Catch the exception
	 * 	-Rethrow the exception, so that you can catch it again in main()
	 * @param filename name of the file to open
	 * @return Scanner object to be used to collect input from file
	 * @throws Exception
	 */
	public static Scanner getFile(String filename) throws Exception {
		java.io.File file = new java.io.File(filename);
		Scanner inputFromFile = null; 
		// ToDo: try/catch file opening errors
		return inputFromFile;
	}


	/**
	 *  Given an array of names and genders, 
	 *  find and return the index of user specified name / gender
	 *  If no match is found: return -1. 
	 *  Note: it should work for an array of any size. 
	 *  
	 * @param nameArray list of names read from datafile
	 * @param genderArray list of genders read from datafile
	 * @param name name to search for
	 * @param gender gender to search for
	 * @return index of name/gender or -1 if not found
	 */
	public static int findName(String[] nameArray, String[] genderArray, String name, String gender) {
		return -1;
	}

	/**
	 * Given a 2D matrix of popularity of names throughout decades,
	 * and a name index
	 * print to console the most popular decade for the given name. 
	 * If name does not exit: 
	 * 		print ERR_NONAME and exit. 
	 * @param pops 2D array of names ranking
	 * @param pi index of a name
	 */
	public static void printPopular (int[][] pops, int pi) {

	}

	/**
	 * Main method to read a text file,
	 * store its information into arrays
	 * search these arrays to find a particular name/gender and to display its popularity. 
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		Scanner inputFromConsole = new Scanner(System.in); 

		// Prompt the user to enter a file name
		System.out.print(pf);
		String filename = inputFromConsole.nextLine();

		Scanner inputFromFile = null;
		
		//Try to open file with getFile
		//In case of error:
		//	Catch rethrown error and print ERR_IOMAIN and exit. 
						
		//read from file
	
		//store names here
		String[] names = new String[NO_OF_LINES];
		//store genders here
		String[] genders = new String[NO_OF_LINES];
		//store ranking of each name here
		int[][] pops = new int[NO_OF_LINES][NO_OF_DECADES];


		//Get a name using displayStringGetString()

		//Get a gender using displayStringGetString()

		//Format both name and gender
		
		//Find name/gender index using findName
		//Print ranking using printPopular

		
		inputFromFile.close();
		inputFromConsole.close();
	}
}
