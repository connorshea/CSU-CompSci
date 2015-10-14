// R11 Assignment
// Author: Connor Shea
// Date:   10/14/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// https://www.cs.colostate.edu/~cs160/.Fall15/recitations/R11.html

import java.util.Arrays;

public class R11 {
  public static double arrayAverage(double[] array) {
    double average = 0;
    for (int i = 0; i < array.length; i++) {
      average += array[i];
    }
    average /= array.length;
    
    return average;
  }

  public static double[] reverseArray(double[] array) {
    double[] reversedArray = new double[array.length];
    int j = 0;
    for (int i = array.length - 1; i >= 0; i--) {
      reversedArray[j] = array[i];
      j++;
    }

    return reversedArray;
  }

  public static void main(String[] args) {
    double[] grades = {81.2, 92.5, 48.9, 78.8};
    int[] numbers = {12, 42, 33, 67, 92, 58};
    String[] arguments = new String[9];

    System.out.println(grades.length);
    System.out.println(numbers.length);
    System.out.println(arguments.length);
    System.out.println(grades[3]);
    System.out.println(grades[1]);
    System.out.println(numbers[2]);
    numbers[0] = 99;
    grades[grades.length - 1] = 90.5;
    arguments[6] = "HelloThere";

    for (int i = 0; i < grades.length; i++) {
      System.out.print(grades[i] + ",");
    }
    System.out.println();

    for (int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i] + " ");
    }
    System.out.println();

    for (int i = 0; i < arguments.length; i++) {
      System.out.print(arguments[i] + "_");
    }
    System.out.println();

    System.out.println( Arrays.toString(grades) );
    System.out.println( Arrays.toString(numbers) );
    System.out.println( Arrays.toString(arguments) );

    System.out.printf("%.3f\n", arrayAverage(grades));

    double[] reversedGrades = reverseArray(grades);

    System.out.println( Arrays.toString(reversedGrades) );
  }
}
