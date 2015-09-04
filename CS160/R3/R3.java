// R3 Assignment
// Author: Connor Shea
// Date:   9/4/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// https://www.cs.colostate.edu/~cs160/.Fall15/recitations/R3.html

import java.util.Scanner;

public class R3 {
	public static void main(String[] args) {
    	
        String myString0 = "Java";
        String myString1 = "Programming";
        String myString2 = "Language";
        
        // Print the concatenation of myString0 + " is a " + myString1 + " " + myString2 + ".".
        System.out.println(myString0 + " is a " + myString1 + " " + myString2 + ".");

        // Print the sum of the lengths of myString1 and myString2 (must call the length() method).
        int myStringLength = myString1.length() + myString2.length();
        System.out.println(myStringLength);

        System.out.println(myString1.charAt(1) + "," + myString1.charAt(3) + "," + myString1.charAt(6));
        System.out.println(myString0.indexOf("a"));
        System.out.println(myString2.toUpperCase());
        System.out.println(myString1.substring(2,8));

        Scanner keyboard = new Scanner(System.in);

        int myInteger = 0;
        double myDouble = 0.0;

        System.out.print("Enter an integer: ");

        myInteger = keyboard.nextInt();

        System.out.println("myInteger = " + myInteger);

        System.out.print("Enter a double: ");

        myDouble = keyboard.nextDouble();

        // Prints "myDouble = " and the double input by the user.
        // Uses "%.5f" to print only the first 5 decimals.
        System.out.printf("myDouble = %.5f\n", myDouble);
	}
}
