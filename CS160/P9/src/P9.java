// P9 Assignment
// Author: Connor Shea
// Date:   11/1/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/assignments/P9.html

import java.io.*;
import java.util.Scanner;
import Plotter;

public class P9 implements Interface {
  public static String[] pieDataLabels;
  public static double[] pieDataElements;
  public static double[] barDataElements1;
  public static double[] barDataElements2;
  public static double[] lineDataElements1;
  public static double[] lineDataElements2;
  public static double[] lineDataElements3;
  
  @Override
  public boolean readFile(String filename) {
	  try {
      File file = new File(filename);
  	  Scanner scan = new Scanner(file);
    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());
    }
  }
  
  @Override
  public String getTitle(eType type) {
	  // TODO Auto-generated method stub
	  return null;
  }
  
  @Override
  public String[] getLabels(eType type) {
	  // TODO Auto-generated method stub
	  return null;
  }
  
  @Override
  public double[] getData(eType type, int series) {
	  // TODO Auto-generated method stub
	  return null;
  }
}
