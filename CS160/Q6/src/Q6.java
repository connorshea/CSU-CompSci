// Q6 Assignment
// Author: Connor Shea
// Date:   12/9/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/quizzes/Q6Code.html

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Q6 implements QuizInterface {

	public static int numberLines = 0;
	public static int numberChars = 0;
	public static int numberLower = 0;
	public static int numberUpper = 0;
	public static int numberDigits = 0;
	public static String[] fileContents;
	public static double[] testArray = {1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9};
	
	public static void main(String[] args) {
		Q6 q6 = new Q6();
    q6.readFile(args[0]);
    q6.computeStatistics(fileContents);
    q6.printStatistics();
    q6.writeFile(args[1], fileContents);
        
    System.out.println("Array = " + Arrays.toString(testArray));
    System.out.println("Smallest value = " + q6.findSmallest(testArray));
	}


	@Override
	public void readFile(String filename) {
		try {
			Scanner scan = new Scanner(new File(filename));
			numberLines = scan.nextInt();
			scan.nextLine();
			fileContents = new String[numberLines];
			
			for (int i = 0; i < numberLines; i++) {
				fileContents[i] = scan.nextLine();
			}
			
			scan.close();
			
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}
	}


	@Override
	public void computeStatistics(String[] strings) {
	
		for (int i = 0; i < strings.length; i++) {
			for (int j = 0; j < strings[i].length(); j++) {
				numberChars++;
				
				if (strings[i].charAt(j) >= 'a' && strings[i].charAt(j) <= 'z') {
					numberLower++;
				}
				
				if (strings[i].charAt(j) >= 'A' && strings[i].charAt(j) <= 'Z') {
					numberUpper++;
				}
				
				if (strings[i].charAt(j) >= '0' && strings[i].charAt(j) <= '9') {
					numberDigits++;
				}
			}
		}
		
	}


	@Override
	public void printStatistics() {
		System.out.println("Number of lines: " + numberLines);
		System.out.println("Number of characters: " + numberChars);
		System.out.println("Number of uppercase letters: " + numberUpper);
		System.out.println("Number of lowercase letters: " + numberLower);
		System.out.println("Number of digits: " + numberDigits);
	}


	@Override
	public void writeFile(String filename, String[] strings) {
		try {
			PrintWriter outputFile = new PrintWriter(new File(filename));
			
			for (int i = 0; i < strings.length; i++) {
				outputFile.println((i + 1) + ": " + strings[i]);
			}
			
			outputFile.close();
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}
	}


	@Override
	public double findSmallest(double[] values) {
		double lowestValue = values[0];
		
		for (int i = 0; i < values.length; i++) {
			if (values[i] < lowestValue) {
				lowestValue = values[i];
			}
		}
		
		return lowestValue;
	}

}
