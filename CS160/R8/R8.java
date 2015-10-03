// R8 Assignment
// Author: Connor Shea
// Date:   9/30/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/recitations/R8.html

import java.util.Scanner;

public class R8 {
  public static void main(String[] args) {
    // Declare variables
    String restaurantName;
    String serverName;
    double subTotal;
    double tax;
    double total;
    double taxRate = 0.05;
    double tipRate1 = 0.10;
    double tipRate2 = 0.15;
    double tipRate3 = 0.20;
        
    // Ask and receive input from the user
    Scanner keyboard = new Scanner(System.in);

    System.out.println("What is the name of the restaurant?");

    restaurantName = keyboard.nextLine();

    System.out.println("Who is your server?");

    serverName = keyboard.next();
    keyboard.nextLine();

    System.out.println("What is the cost of your bill?");

    subTotal = keyboard.nextDouble();

    tax = computeTax(subTotal, taxRate);

    total = subTotal + tax;


    // Print receipt
    System.out.println("=====================================");
    System.out.println("" + restaurantName);
    System.out.println("Your server was: " + serverName.toUpperCase() );
    System.out.printf("Subtotal: $%.2f\n", subTotal);
    System.out.printf("Tax: $%.2f\n", tax);
    System.out.println("=====================================");
    System.out.printf("Total: $%.2f\n", total);
    System.out.println("");
    System.out.println("Suggested tips:");
    System.out.printf("10%%: $%.2f\n", computeTip(total, tipRate1) );
    System.out.printf("15%%: $%.2f\n", computeTip(total, tipRate2) );
    System.out.printf("20%%: $%.2f\n", computeTip(total, tipRate3) );
    System.out.println("");
    System.out.println("Thank you!");
    System.out.println("=====================================");
  }

  public static double computeTax(double amount, double rate) {
    return amount * rate;
  }

  public static double computeTip(double amount, double rate) {
    return amount * rate;
  }
}
