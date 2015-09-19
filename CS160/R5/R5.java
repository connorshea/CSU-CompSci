// R5 Assignment
// Author: Connor Shea
// Date:   9/16/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/recitations/R5.html

import java.util.Scanner;

public class R5 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Please enter your age: ");
    int age = keyboard.nextInt();

    if (age > 20) {
      System.out.println("You can legally buy and consume alcohol in the USA.");
    }   

    keyboard.close(); // not necessary, but good practice
    System.out.println("End of program.");
    
    // Notice that this code does the exact same thing:
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Please enter your age: ");
    int age = keyboard.nextInt();

    if (age >= 21) {
      System.out.println("You can legally buy and consume alcohol in the USA.");
    }   

    keyboard.close();
    System.out.println("End of program.");
    // What's different?

    // Part 2: More with if
    // Consider this code:
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Please enter your age: ");
    int age = keyboard.nextInt();

    if (age == 21) {
      System.out.println("Wow!  You are 21 years old!");
    }   

    if (age != 21) {
      System.out.println("Interesting!  You are NOT 21 years old!");
    } 

    keyboard.close();
    System.out.println("End of program.");
    // What happens?

    // Part 3: if.. else..
    // Wouldn't it be nice to combine Part 2 into one block? Well, if we add an else, we can do just that (note: from now on, I'm omitting the code that creates a Scanner, gets input from the user, and closes the Scanner.):
    if (age == 21) {
      System.out.println("Wow!  You are 21 years old!");
    } else {
      System.out.println("Interesting!  You are NOT 21 years old!");
    }

    System.out.println("End of program.");

    // What's going on now?

    // Now try this:
    if (age >= 21) {
      System.out.println("You can legally buy and consume alcohol in the USA.");
    } else {
      System.out.println("You are under 21 and cannot legally buy and consume alcohol in the USA.");
    }   

    System.out.println("End of program.");

    // Cool, huh?
    // Part 4: if.. else if..

    // Now suppose I want to write something special for being 21 and 18, but nothing for all other ages. How could we do this? Well, there's else if too:
    if (age == 21) {
      System.out.println("Boom!  You are 21!");
    } else if (age == 18) {
      System.out.println("Hey-o!  You're 18 years old!");
    }   

    System.out.println("End of program.");

    // In fact, we can add as many else if's as we want:
    if (age == 21) {
      System.out.println("You are 21 and the same age as Miley Cyrus!  Not sure if that's good or bad.");
    } else if (age == 18) {
      System.out.println("You're 18 years old! and the same age as Zendaya.  No idea who she was -- I had to Google her.");
    } else if (age == 20) {
      System.out.println("You're 20 years old and the same age as Justin Bieber!  Has he retired yet?");
    } else if (age == 16) {
      System.out.println("You're 16 years old and the same age as Jaden 'Don't call me Will' Smith!");
    }   

    System.out.println("End of program.");

    // Part 5: Bring it together: if.. else if.. else..

    // We can even use all three things together to cover all the bases:
    if (age == 21) {
      System.out.println("You are 21 and the same age as Miley Cyrus!  Not sure if that's good or bad.");
    } else if (age == 18) {
      System.out.println("You're 18 years old! and the same age as Zendaya.  No idea who she was -- I had to Google her.");
    } else if (age == 20) {
      System.out.println("You're 20 years old and the same age as Justin Bieber!  Has he retired yet?");
    } else if (age == 16) {
      System.out.println("You're 16 years old and the same age as Jaden 'Don't call me Will' Smith!");
    } else {
      System.out.println("Oops! You're not the age of any people I know.");
    }   

    System.out.println("End of program.");
    Now we always will get some response from our program!
    Part 6: Question to solve


    // Question: Does this code have a problem? If so, what is it and how could one fix it?:
    // The canDrive boolean isn't initially set to anything in its declaration, the false option would never be run.
    boolean canDrive = false;

    if (age >= 16) {
      canDrive = true;
    }

    if (canDrive) {
      System.out.println("According to our records, you can legally drive a car in the USA.");
    } else {
      System.out.println("According to our records, you are prohibited from driving a car in the USA.");
    }

    System.out.println("End of program.");

    // Question: How could you rewrite this so if the user enters 22, both facts are printed?
    if (age >= 21) {
      System.out.println("You can legally buy and consume alcohol in the USA.");
      System.out.println("You can legally drive a car in the USA.");
    } else if (age >= 18) {
      System.out.println("Can legally drive a car in the USA.");
    } else {
      System.out.println("You're under 18 years old.");
    }

    System.out.println("End of program.");
    
    // Part 7: Getting even more control with && and || (logical AND and OR)
    // Now we're going to slightly change our program to do something else:
    if ( (age > 11) && (age < 20) ) {
      System.out.println("You are a teenager!");
    } else if (age > 100 || age < 2) {
      System.out.println("You are either Gandalf or learning to walk.");
    } else {
      System.out.println("I have nothing interesting to say.");
    }

    System.out.println("End of program.");   
  }
}
