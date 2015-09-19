// R6 Assignment
// Author: Connor Shea
// Date:   9/18/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/recitations/R6.html

import java.util.Scanner;

public class R6 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    // Here we print a welcome message
    System.out.println("Welcome to a simple calculator program!");
    System.out.println("---------------------------------------");
    System.out.println("All we know how to do is add, subtract, multiply, divide, and compute modulo.");
    System.out.println();

    // Here we get input from the user
    System.out.print("Please enter a the first number of your calculation: ");
    double firstNum = keyboard.nextDouble();

    System.out.print("Please enter the operator (+|-|*|/|%): ");
    char operator = keyboard.next().charAt(0);

    System.out.print("Please enter a the second number of your calculation: ");
    double secondNum = keyboard.nextDouble();

    // Here we will calculate the result:
    double result = 0.0;

    switch (operator) {
      case '+':
        result = firstNum + secondNum;
        break;
      case '-':
        result = firstNum - secondNum;
        break;
      case '*':
        result = firstNum * secondNum;
        break;
      case '/':
        result = firstNum / secondNum;
        break;
      case '%':
        result = firstNum % secondNum;
        break;
      default:
        System.out.println("Incorrect operator entered");
        break;
    }

    // Here we will print the result
    System.out.println("---------------------------------------");
    System.out.println("Result:");
    System.out.printf("%.2f %c %.2f = %.2f\n", firstNum, operator, secondNum, result);
    System.out.println("---------------------------------------");


    keyboard.close();
    System.out.println("End of program.");
  }
}
