/**
 * @author Connor Shea
 * @assignment P5
 * @class CS161
 * @date March 19, 2016
 * @url https://www.cs.colostate.edu/~cs161/spring16/more_assignments/P5/P5.html
 */
import java.util.Arrays;

public class Recursion {

  // Each character in the provided string will be changed to two characters,
  // the character before it in the ASCII table and the character after it.
  // e.g. "BCD" becomes "ACBDCE"
  public String encrypt(String s) {
  	if (s.equals(null)) {
      return null;
    } else if (s.equals("")) {
      return "";
    } else if (s.length() == 1) {
      char c = s.charAt(0);
      char cBefore = (char)((int)(c) - 1);
      char cAfter = (char)((int)(c) + 1);
      String returnString = (String)(cBefore + "" + cAfter);
      return returnString;
    } else {
      String returnString = "";
      char c = s.charAt(0);
      char cBefore = (char)((int)(c) - 1);
      char cAfter = (char)((int)(c) + 1);
      returnString = cBefore + "" + cAfter + encrypt(s.substring(1, s.length()));
      return returnString;
    }
  }

  // Each item in the array is added recursively to the element following it.
  // e.g. [5, 6, 7, 2, 3, 1] becomes [24, 19, 13, 6, 4, 1].
  public int[] reverseCumulative(int[] numbers) {
    // Started from the bottom.
    reverseCumulativeHelper(numbers, 0);
    // Now we're here.
    return numbers;
  }

  // Arrays are pass-by-reference so modifications made here will be made in
  // the original array variable passed from the above function.
  private int reverseCumulativeHelper(int[] numbers, int counter) {
    // If the counter is equal to the length of the numbers array minus 1,
    // return it since it's the last item in the array and therefore won't
    // have any items following it.
    if (counter == numbers.length - 1) {
      return numbers[counter];
    } else {
      // If it's not the last item in the array, it should be summed
      // recursively with each following item.
      numbers[counter] += reverseCumulativeHelper(numbers, counter + 1);
      // Return the number that's wanted.
      return numbers[counter];
    }
  }

  // if/else statements looping col versus row
  public Pair search2D(int[][] data, int element) {
  	Pair pair = new Pair(0, 0);
  	
    pair = searchHelper(data, pair, element);

    if (pair == null) {
      return null;
    } else if (data[pair.row][pair.column] == element) {
      return pair;
    } else {
    	return null;
    }
  }

  // "Drills down" until we find the matching element, then sends the pair up
  // through every level to the top.
  public Pair searchHelper(int[][] data, Pair pair, int element) {
    // If last column and last row, the element was not found and null should
    // be returned.
    if (pair.row == data.length - 1 && pair.column == data[pair.row].length - 1) {
      return null;

    // If the item at the pair of row and column is the element we're looking
    // to find, return it.
    } else if (data[pair.row][pair.column] == element) {
      return pair;

    // If last column, iterate row.
    } else if (pair.column == data[pair.row].length - 1) {
      pair.row += 1;
      pair.column = 0;
      pair = searchHelper(data, pair, element);
      return pair;

    // If not last column, iterate column.
    } else if (pair.column < data[pair.row].length - 1) {
      pair.column += 1;
      pair = searchHelper(data, pair, element);
      return pair;

    // Quit Eclipse's complaining.
    } else {
    	return null;
    }
  }

  /*
   * P5. Pair stores the row and column numbers
   * Authors: Asa Ben-Hur and Sudipto Ghosh
   * Date: Feb 23, 2016
   */
  private class Pair {
    private int row;
    private int column;

    public Pair(int row, int column) {
      this.row = row;
      this.column = column;
    }
  
    public String toString() {
      return "(" + row + ", " + column + ")";
    }
  }

  public static void main(String[] args) {
    Recursion r = new Recursion();
    System.out.println("encrypt(View!) = " + r.encrypt("View!"));
    
    if (r.encrypt("View!").equals("UWhjdfvx \"")) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }

    if (r.encrypt("BCD").equals("ACBDCE")) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }

    int[] numbers = new int[] {5, 6, 7, 2, 3};
    System.out.print("reverseCumulative(numbers) = ");
    int[] resultArray = r.reverseCumulative(numbers);
    System.out.println(Arrays.toString(resultArray));
    		
    if (Arrays.toString(resultArray).equals("[23, 18, 12, 5, 3]")) {
    	System.out.println("true");
    } else {
      System.out.println("false");
    }

    int[] numbers2 = new int[] {7, 9, 5, 10};


    System.out.print("reverseCumulative(numbers2) = ");
    int[] resultArray2 = r.reverseCumulative(numbers2);
    System.out.println(Arrays.toString(resultArray2));

    if (Arrays.toString(resultArray2).equals("[31, 24, 15, 10]")) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }

    int[][] table1 = new int[][] {
      {3, 2, 8},
      {3, 5, 6}
    };

    int[][] table2 = new int[][] { 
      {3, 2, 8, 5, 61},
      {3, 5, 6},
      {10, 42, 53, 45}
    };

    System.out.println(r.search2D(table1, 5));
    System.out.println(r.search2D(table2, 5));

    Pair pair1 = r.search2D(table1, 5);
    Pair pair2 = r.search2D(table2, 5);
    
    if (pair1.toString().equals("(1, 1)")) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
    
    if (pair2.toString().equals("(0, 3)")) {
        System.out.println("true");
      } else {
        System.out.println("false");
      }

    System.out.println(r.search2D(table1, 10));
  }
}
