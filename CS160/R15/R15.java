// R15 Assignment
// Author: Connor Shea
// Date:   11/4/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// https://www.cs.colostate.edu/~cs160/.Fall15/recitations/R15.html

import java.io.*;
import java.util.Scanner;

public class R15 {
  public static void readFile(String filename) {
    try {
      File file = new File(filename);
      Scanner scan = new Scanner(file);

      do {
        if (scan.next().equals("circle:")) {
          double circleRadius = scan.nextDouble();
          System.out.printf("Circle\n computeAreaCircle()\n Radius: %.2f\n Area: %.2f\n", circleRadius, computeAreaCircle(circleRadius));
        }

        if (scan.next().equals("rectangle:")) {
          double rectangleHeight = scan.nextDouble();
          double rectangleWidth = scan.nextDouble();
          System.out.printf("Rectangle\n computeAreaRectangle()\n Input: %.2f, %.2f\n Area: %.2f\n", rectangleHeight, rectangleWidth, computeAreaRectangle(rectangleHeight, rectangleWidth));
        }

        if (scan.next().equals("triangle:")) {
          double triangleHeight = scan.nextDouble();
          double triangleWidth = scan.nextDouble();
          System.out.printf("Triangle\n computeAreaTriangle()\n Input: %.2f, %.2f\n Area: %.2f\n", triangleHeight, triangleWidth, computeAreaTriangle(triangleHeight, triangleWidth));
        }
      } while ( scan.hasNextLine() );

      scan.close();

    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());
    }
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
  }
}

