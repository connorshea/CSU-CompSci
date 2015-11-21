// P11 Assignment
// Author: Connor Shea
// Date:   11/20/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/assignments/P11.html

import java.util.Arrays;

public class P11 {

  // Returns a reversed version of the specified string,
  // which can contain any ASCII character.
  // For example, returns "edcba" for "abcde"
	// public String reverseString(String s)

  // Returns the specified string duplicated.
  // For example, returns "Hello There!Hello There!" for "Hello There!" 
	// public String duplicateString(String s) {

  // Creates an array of strings with
  // [0] = original, [1] = toUppercase(), [2] = toLowercase().
  // For example, returns {"Whatever", "WHATEVER", "whatever"} for "Whatever"
	// public String[] createStrings(String s)

  // Cubes all elements in array of doubles.
  // For example, changes {2.0, 3.0, 4.0} to {8.0, 27.0, 64.0}
	// public void cubeArray(double[] array)

  // Adds the elements in array of integers,
  // returning the sum as an integer.
  // For example, returns 21 for {1, 2, 3, 4, 5, 6}
	// public int sumArray(int[] array)

	// Sorts an array of integers from low to high.
  // For example, changes {2, 6, 4, 9, 1} to {1, 2, 4, 6, 9}
	// public void sortArray(int[] array)

	public static void main(String[] args) {
		// Instantiate test class
		TestInterface inter = new TestClass();
		
		// It doesn't like numbers.
		String testString = "420 blaze it";
		System.out.println(inter.reverseString(testString));
		
		// Six character strings break it
		String testString2 = "SIXSIX";
		System.out.println(inter.reverseString(testString2));
		
		// What's this, an empty string?
		String testString3 = "";
		System.out.println(inter.duplicateString(testString3));
		
		// Spaces to Underscores
		String testString4 = "The moon landing really underscores the importance of space.";
		System.out.println(inter.duplicateString(testString4));
		
		String testString5 = "LOLOLOLOLOLOLO";
		System.out.println(inter.duplicateString(testString5));
		
		// It doesn't like X's
		String testString6 = "SIX-SIX-SIX";
		String[] stringArray = inter.createStrings(testString6);
		System.out.println(Arrays.toString(stringArray));
		
		String[] stringArrayAlt = new String[3]; 
		stringArrayAlt[0] = testString6;
		stringArrayAlt[1] = testString6.toUpperCase();
		stringArrayAlt[2] = testString6.toLowerCase();
		
		System.out.println(Arrays.toString(stringArrayAlt));
		
		String testString7 = "LoLolol";
		String[] stringArray2 = inter.createStrings(testString7);
		System.out.println(Arrays.toString(stringArray2));
		
		String[] stringArrayAlt2 = new String[3]; 
		stringArrayAlt2[0] = testString7;
		stringArrayAlt2[1] = testString7.toUpperCase();
		stringArrayAlt2[2] = testString7.toLowerCase();
		
		System.out.println(Arrays.toString(stringArrayAlt2));
		
		int[] intArray = {0, 0, 2, 3, 10};
		int sumArrayResult = inter.sumArray(intArray);
		
		int sum = 0;
		for (int i = 0; i < intArray.length; i++) {
			sum += intArray[i];
		}
		
		// Compare sumArray results with fool-proof version.
		System.out.println(sumArrayResult);
		System.out.println(sum);
		
		int[] intArray2 = {0, 0, 2, 3, 10, 99, 100, 500};
		// If the intArray is already in order, it reverses it.
		System.out.println(Arrays.toString(intArray2));
		inter.sortArray(intArray2);
		System.out.println(Arrays.toString(intArray2));
		
		// Something to do with duplicates in the array? Or zeros, or something? Honestly I have no idea why this breaks.
		int[] intArray3 = {0, 10, 2, 2, 0, 3, 101, 3, 13, -1};
		System.out.println(Arrays.toString(intArray3));
		inter.sortArray(intArray3);
		System.out.println(Arrays.toString(intArray3));
		
	}
}
