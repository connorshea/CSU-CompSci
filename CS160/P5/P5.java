// P5 Assignment
// Author: Connor Shea
// Date:   10/3/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/recitations/P5.html

import java.util.Scanner;

public class P5 {
  public static void main(String[] args) {
      // Preliminary testing
      printPrimes(1, 50);
      System.out.println(removeVowels("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
      double result = evaluateExponent(2.0,16);
      System.out.println("2.0 to the 16 = " + result);
      computeStatistics(-1);
  }

  // Method to check whether an integer is prime.
  public static boolean isPrime(int number) {
    // If a number is not prime, return false.
    // Otherwise return true.
    // Note that upon returning a value the method is exited, so returning
    // false doesn't lead to the "return true" line being run.
    for (int i = 2; i <= number / 2; i++) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }

  // Method to print primes in a specified range
  public static void printPrimes(int start, int end) {
    for (int i = start; i <= end; i++) {
      if (isPrime(i)) {
        System.out.print(i + ", ");
      }
    }

    System.out.println("");
  }

  // Method to remove vowels from a string
  public static String removeVowels(String input) {
    String stringWithoutVowels = "";

    for (int i = 0; i < input.length(); i++) {
      // If the character being evaluated is any of the listed vowels the
      // switch statement breaks. Otherwise, the character is appended to the
      // "stringWithoutVowels" variable which is later returned a few lines down.
      switch (input.charAt(i)) {
        case 'a':
        case 'A':
        case 'e':
        case 'E':
        case 'i':
        case 'I':
        case 'o':
        case 'O':
        case 'u':
        case 'U':
          break;
        default:
          stringWithoutVowels += input.charAt(i);
          break;
      }
    }

    return stringWithoutVowels;
  }

  // Method to generate and print the value of a number raised to an exponent
  public static double evaluateExponent(double number, int exponent) {
    double result = 1.0;
    int loop;

    // If the exponent is 0, the result will always be 1
    if (exponent == 0) {
      return result;
    } else {
      loop = 0;
    }

    // 2^5, where 2 is the number and 5 is the exponent.
    // Multiply "1" (result) by the number and iterate upon the loop variable until
    // you've multiplied the value as many times as the exponent requires
    // (e.g. 2^5 is: 1 * 2 * 2 * 2 * 2 * 2)
    do {
      result = result * number;
      ++loop;
    } while(loop != exponent);

    return result;
  }

  // Method to find and print the minimum/maximum/mean of a set of positive numbers
  public static void computeStatistics(int sentinel) {
    Scanner keyboard = new Scanner(System.in);

    int value = 0;
    int count = 0;
    double mean = 0.0;
    int minimum = Integer.MAX_VALUE;
    int maximum = Integer.MIN_VALUE;

    while (count >= 0) {
      value = keyboard.nextInt();

      if (value == sentinel) {
        break;
      } else if (value < minimum) {
        minimum = value;
      } else if (value > maximum) {
        maximum = value;
      }

      mean += value;
      count++;
    }

    mean = mean / count;

    System.out.println("Count: " + count);
    System.out.println("Average: " + mean);
    System.out.println("Maximum: " + maximum);
    System.out.println("Minimum: " + minimum);
  }
}
