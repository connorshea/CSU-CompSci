// P8 Assignment
// Author: Connor Shea
// Date:   10/20/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/assignments/P8.html

import java.util.Arrays;

public class P8 {
  // Write a method named createIntegers that allocates, initializes, and
  // returns an array of integers with the following entries:
  // 16, 21, 34, 49, 55, 60, 72, 83, 101
  // The method has no parameters and returns an array of 9 integers.
  public static int[] createIntegers() {
    int[] intArray = {16, 21, 34, 49, 55, 60, 72, 83, 101};

    return intArray;
  }

  // Write a method named createDoubles that builds an array of floating point
  // values that represent the squares of the numbers from 10.0 to 13.0, in
  // steps of 0.5, inclusive of both boundaries. The method has no parameters
  // and returns an array of doubles. There are exactly 7 numbers in this array.
  public static double[] createDoubles() {
    double[] doubleArray = new double[7];

    double d = 10.0;
    for (int i = 0; i < 7; i++) {
      doubleArray[i] = Math.pow(d, 2);
      d += 0.5;
    }

    return doubleArray;
  }

  // Write a method named createStrings that takes a String as an input parameter,
  // and returns an array of string with 4 elements. The first element is the
  // original string passed in, the second element is the same string converted
  // to uppercase, the third element is the same string converted to lowercase,
  // and the fourth element is the same string with the first character removed.
  public static String[] createStrings(String input) {
    String[] stringArray = new String[4];
    
    stringArray[0] = input;
    stringArray[1] = input.toUpperCase();
    stringArray[2] = input.toLowerCase();
    
    String modifiedInput = input.substring(1, input.length());
    stringArray[3] = modifiedInput;

    return stringArray;
  }
  
  // Write a method named createChars that extracts the characters from a
  // string and builds an array with them. The method takes a parameter of
  // type String and returns an array of characters.
  public static char[] createChars(String input) {
    char[] charArray = new char[input.length()];

    for (int i = 0; i < input.length(); i++) {
      charArray[i] = input.charAt(i);
    }

    return charArray;
  }

  // Write a method called sumArray that takes an array of integers as a parameter,
  // and returns an integer equal to the sum of all elements in the array.
  public static int sumArray(int[] input) {
    int sum = 0;

    for (int i = 0; i < input.length; i++) {
      sum += input[i];
    }

    return sum;
  }

  // Write a method called findLargest that takes an array of doubles as a
  // parameter, and returns a double equal to the largest element in the array.
  public static double findLargest(double[] input) {
    double largest = 0.0;

    for (int i = 0; i < input.length; i++) {
      largest = (input[i] > largest) ? input[i] : largest;
    }

    return largest;
  }

  // Write a method called charFrequency that takes an array of strings and a
  // single character as parameters. The method should iterate the array,
  // counting instances of the character passed in. For example, if the array
  // is ["Hello", "There"] and we are asked to count the character 'e', the
  // return value will be three. If the character is not found in any of the 
  // elements in the array, the return value should be zero.
  public static int charFrequency(String[] inputStrings, char inputChar) {
    int numInstances = 0;

    for (int i = 0; i < inputStrings.length; i++) {
      for (int j = 0; j < inputStrings[i].length(); j++) {
        if (inputStrings[i].charAt(j) == inputChar) {
          numInstances++;
        }
      }
    }

    return numInstances;
  }

  // Write a method called translateChars that takes an array of characters and
  // returns an array of integers with the values that correspond to each
  // element of the character array.
  public static int[] translateChars(char[] input) {
    int[] translatedChars = new int[input.length];

    for (int i = 0; i < input.length; i++) {
      translatedChars[i] = (int) input[i];
    }

    return translatedChars;
  }

  public static void main(String[] args) {
    // Create arrays
    int[] integerArray = createIntegers();
    System.out.println(Arrays.toString(integerArray));
    double[] doubleArray = createDoubles();
    System.out.println(Arrays.toString(doubleArray));
    String[] stringArray = createStrings("Hello There");
    System.out.println(Arrays.toString(stringArray));
    char[] charArray = createChars("Java1234!&");
    System.out.println(Arrays.toString(charArray));

    // Test processing
    System.out.println("Sum of integer array = " + sumArray(integerArray));
    System.out.println("Largest of double array = " + findLargest(doubleArray));
    System.out.println("Frequency of 'e' = " + charFrequency(stringArray, 'e'));
    System.out.println("Translated characters = " + Arrays.toString(translateChars(charArray)));
  }
}
