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


  public Pair search2D(int[][] data, int element) {
  	return null;
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

    int[] numbers = new int[] {5, 6, 7, 2, 3, 1};
    System.out.print("reverseCumulative(numbers) = ");
    int[] resultArray = r.reverseCumulative(numbers);
    System.out.println(Arrays.toString(resultArray));
    		
    if (Arrays.toString(resultArray).equals("[24, 19, 13, 6, 4, 1]")) {
    	System.out.println("true");
    } else {
      System.out.println("false");
    }

    int[][] table = new int[][] { {3, 2, 8}, {3, 5, 6} };
    System.out.println(r.search2D(table, 5));

    if (r.search2D(table, 5).toString().equals("(2, 2)")) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }

    System.out.println(r.search2D(table, 10));
  }
}
