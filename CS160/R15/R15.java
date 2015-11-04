// R15 Assignment
// Author: Connor Shea
// Date:   11/4/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// https://www.cs.colostate.edu/~cs160/.Fall15/recitations/R15.html

import java.io.*;
import java.util.Scanner;

public class R15 {
  public static void readFile(String inputFile) {

  }

  public static void writeFile(String outputFile) {
    try {
      PrintWriter fileOutput = new PrintWriter(new File(outputFile));
      
      System.out.println("Enter text:");
      Scanner scan = new Scanner(System.in);

      while (true) {
        String nextline = scan.nextLine();

        // If next line is "stop", break out of loop.
        // Otherwise, print the nextline to the output file.
        if (nextline.equals("stop")) {
          break;
        } else {
          fileOutput.println(nextline);
        }
      }

      fileOutput.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found.");
      System.exit(0);
    }
  }

  public static double computeAreaCircle(double radius) {
    // π(r^2)
    return Math.PI * Math.pow(radius, 2);
  }

  public static double computeAreaRectangle(double height, double width) {
    return height * width;
  }

  public static double computeAreaTriangle(double height, double base) {
    return (height * base) / 2;
  }

  public static void main(String[] args) {
    readFile(args[0]);
    writeFile(args[1]);
    System.out.println(computeAreaCircle(5));
    System.out.println(computeAreaRectangle(5, 5));
    System.out.println(computeAreaTriangle(5, 5));
  }
}










// // Example of reading a file
// try {
//   // make sure TA explains this line and the try/catch block
//   Scanner fileReader = new Scanner(new File(args[0]));
  
//   // Examples: (not meant to be run as a program)
//   String example1a = fileReader.next();
//   String example1b = fileReader.nextLine();
//   double example2 = fileReader.nextDouble();
//   int example3 = fileReader.nextInt();
//   char example4 = fileReader.next().charAt(0);
  
//   if (fileReader.hasNext()) {
//     // I can grab a string token safely
//     String example5 = fileReader.next();
//   }
  
//   if (fileReader.hasNextDouble()) {
//     // I can grab a double safely
//     double example6 = fileReader.nextDouble();
//   }
  
//   if (fileReader.hasNextInt()) {
//     // I can grab a int safely
//     int example7 = fileReader.nextInt();
//   }
  
//   fileReader.close();
  
// } catch (FileNotFoundException e) {
//   System.out.println("ERROR!");
//   System.exit(0);
// }


// // Example of writing to a file
// try {
//   // make sure TA explains this line and the try/catch block
//   PrintWriter fileOutput = new PrintWriter(new File(args[1]));
  
//   // Examples:
//   fileOutput.println("Hey...");
//   fileOutput.print("I've seen...");
//   fileOutput.print("this stuff before.\n");
//   fileOutput.printf("%.3f\n", 3.456789);
  
//   // Important! Save the file
//   fileOutput.close();
  
// } catch (FileNotFoundException e) {
//   System.out.println("ERROR!");
//   System.exit(0);
// }

