// P8 Assignment
// Author: Connor Shea
// Date:   10/20/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/assignments/P8.html

import java.util.Arrays;

public class P8 {
  public static int[] createIntegers() {
    int[] intArray = {16, 21, 34, 49, 55, 60, 72, 83, 101};

    return intArray;
  }

  public static double[] createDoubles() {
    double[] doubleArray = new double[7];

    double d = 10.0;
    for (int i = 0; i < 7; i++) {
      doubleArray[i] = Math.pow(d, 2);
      d += 0.5;
    }

    return doubleArray;
  }

  public static String[] createStrings(String input) {
    String[] stringArray = new String[4];
    
    stringArray[0] = input;
    stringArray[1] = input.toUpperCase();
    stringArray[2] = input.toLowerCase();
    
    String modifiedInput = input.substring(1, input.length());
    stringArray[3] = modifiedInput;

    return stringArray;
  }
  
  public static char[] createChars(String input) {
    char[] charArray = new char[input.length()];

    for (int i = 0; i < input.length(); i++) {
      charArray[i] = input.charAt(i);
    }

    return charArray;
  }

  public static int sumArray(int[] input) {
    int sum = 0;

    for (int i = 0; i < input.length; i++) {
      sum += input[i];
    }

    return sum;
  }

  public static double findLargest(double[] input) {
    double largest = 0.0;

    for (int i = 0; i < input.length; i++) {
      largest = (input[i] > largest) ? input[i] : largest;
    }

    return largest;
  }

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

    // // Test processing
    System.out.println("Sum of integer array = " + sumArray(integerArray));
    System.out.println("Largest of double array = " + findLargest(doubleArray));
    System.out.println("Frequency of 'e' = " + charFrequency(stringArray, 'e'));
    System.out.println("Translated characters = " + Arrays.toString(translateChars(charArray)));
  }
}
