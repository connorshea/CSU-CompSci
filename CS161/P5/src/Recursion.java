/**
 * @author Connor Shea
 * @assignment P5
 * @class CS161
 * @date March 19, 2016
 * @url https://www.cs.colostate.edu/~cs161/spring16/more_assignments/P5/P5.html
 */
import java.util.Arrays;

public class Recursion {
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

  public int[] reverseCumulative(int[] numbers) {
    return null;
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
    System.out.println(Arrays.toString(r.reverseCumulative(numbers)));


    int[][] table = new int[][] { {3, 2, 8}, {3, 5, 6} };
    System.out.println(r.search2D(table, 5));
    System.out.println(r.search2D(table, 10));
  }
}
