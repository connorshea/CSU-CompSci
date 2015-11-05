// P9 Assignment
// Author: Connor Shea
// Date:   11/4/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/assignments/P9.html

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

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

      int numPieDataItems = scan.nextInt();
      int numBarDataItems = scan.nextInt();
      int numLineDataItems = scan.nextInt();

      pieDataLabels = new String[numPieDataItems];

      for (int i = 0; i < numPieDataItems; i++) {
        pieDataLabels[i] = scan.next();
      }
      
      pieDataElements = new double[numPieDataItems];
      
      for (int i = 0; i < numPieDataItems; i++) {
    	pieDataElements[i] = scan.nextDouble();
      }
      
      barDataElements1 = new double[numBarDataItems];
      
      for (int i = 0; i < numBarDataItems; i++) {
      	barDataElements1[i] = scan.nextDouble();
      }
      
      barDataElements2 = new double[numBarDataItems];
      
      for (int i = 0; i < numBarDataItems; i++) {
    	barDataElements2[i] = scan.nextDouble();
      }
      
      lineDataElements1 = new double[numLineDataItems];
      
      for (int i = 0; i < numLineDataItems; i++) {
      	lineDataElements1[i] = scan.nextDouble();
      }
      
      lineDataElements2 = new double[numLineDataItems];

      for (int i = 0; i < numLineDataItems; i++) {
        lineDataElements2[i] = scan.nextDouble();
      }

      lineDataElements3 = new double[numLineDataItems];

      for (int i = 0; i < numLineDataItems; i++) {
        lineDataElements3[i] = scan.nextDouble();
      }

      System.out.println(Arrays.toString(pieDataLabels) + " " + Arrays.toString(pieDataElements));
      System.out.println(Arrays.toString(barDataElements1) + " " + Arrays.toString(barDataElements2));
      System.out.println(Arrays.toString(lineDataElements1) + " " + Arrays.toString(lineDataElements2) + " " + Arrays.toString(lineDataElements3));
    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());
    }

    return true;
  }
  
  @Override
  public String getTitle(Interface.eType type) {
	  if (type == eType.PIECHART) {
      return "My Pie Chart";
    } else if (type == eType.BARCHART) {
      return "My Bar Chart";
    } else if (type == eType.LINEGRAPH) {
      return "My Line Graph";
    } else {
      return null;
    }
  }
  
  @Override
  public String[] getLabels(Interface.eType type) {
	  if (type == eType.PIECHART) {
      
    } else {
  	  return null;
    }

    return null;
  }
  
  @Override
  public double[] getData(Interface.eType type, int series) {
	  return null;
  }
}
