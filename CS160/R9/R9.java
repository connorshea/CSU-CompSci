// R9 Assignment
// Author: Connor Shea
// Date:   10/2/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/recitations/R9.html

import java.util.Scanner;

public class R9 {
  public static void reverseString(String s) {
    for (int i = s.length() - 1; i >= 0; i--) {
      System.out.print(s.charAt(i));
    }

    System.out.println("");
  }

  public static void printAscii(char start, char end) {
    for (char i = start; i <= end; i++) {
      System.out.print(i);
    }

    System.out.println("");
  }

  public static int computeFactorial(int num) {
    int factorial = 1;
    
    while (num > 0) {
      factorial *= num;
      num--;
    }

    return factorial;
  }

  public static void areWeThereYet(Scanner keyboard) {
    String response = "";
    do {
      System.out.print("Are we there yet? ");
      response = keyboard.next().toLowerCase();
    } while (!response.equals("yes"));

    System.out.println("Finally!");
    return;
  }

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    String string = "test string";

    reverseString(string);
    printAscii('A', 'Z');
    System.out.println(computeFactorial(5));
    areWeThereYet(keyboard);
  }
}
