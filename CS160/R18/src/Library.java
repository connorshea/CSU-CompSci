// R18 Assignment
// Author: Connor Shea
// Date:   11/18/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/recitations/R18.html

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Library {
	public static Music[] arrayTitles;
	
	public static void readLibrary(String inputFile) {
		try {
      File file = new File(inputFile);
      Scanner scan = new Scanner(file);

      int numTitles = scan.nextInt();

      // Throw away the rest of the line.
      scan.nextLine();
      
      // Create an array of Music objects based on the number in the input file.
      arrayTitles = new Music[numTitles];

      for (int i = 0; i < arrayTitles.length; i++) {
        String title = scan.nextLine();
        String album = scan.nextLine();
        String artist = scan.nextLine();
        int year = scan.nextInt();
        
        // Throw away the rest of the year line.
        scan.nextLine();
        arrayTitles[i] = new Music(title, album, artist, year);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
	}

  public static void writeLibrary(String outputFile) {
    try {
      PrintWriter output = new PrintWriter(new File(outputFile));
      
      double price = 0.00;
      for (int i = 0; i < arrayTitles.length; i++) {
        output.println((i + 1) + ": " + arrayTitles[i].toString());
        price += arrayTitles[i].getPrice();
      }

      output.printf("Total cost: $%.2f", price);
      output.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void searchTitles(String search) {
    double price = 0.00;

    for (int i = 0; i < arrayTitles.length; i++) {
      if (arrayTitles[i].getTitle().contains(search)) {
        System.out.println(arrayTitles[i].toString());
        price += arrayTitles[i].getPrice();
      }
    }
  }
  
  public static void sortTitles() {
    for (char c = 'A'; c <= 'Z'; c++) {
      for (int i = 0; i < arrayTitles.length; i++) {
        if (arrayTitles[i].getTitle().charAt(0) == c) {
          System.out.println(arrayTitles[i].toString());
        }
      }
    }
  }
	
	public static void main(String[] args) {
    readLibrary(args[0]);
    writeLibrary(args[1]);
    System.out.println("SEARCH RESULTS:");
    searchTitles(args[2]);
    System.out.println("");
    System.out.println("SORTED TITLES:");
    sortTitles();
	}
}
