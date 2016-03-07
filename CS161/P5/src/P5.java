/**
 * @author Connor Shea
 * @assignment P4
 * @class CS161
 * @date February 29, 2016
 * @url http://www.cs.colostate.edu/~cs161/spring16/more_assignments/P4/P4.html
 */
import java.util.Arrays;

public class P5 {
  public String encrypt(String s) {
    
  }

  public int[] reverseCumulative(int[] numbers) {
    
  }

  public Pair search2D(int[][] data, int element) {

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
    int[] numbers = new int[] {5, 6, 7, 2, 3, 1};
    System.out.print("reverseCumulative(numbers) = ");
    System.out.println(Arrays.toString(r.reverseCumulative(numbers)));
    int[][] table = new int[][] { {3, 2, 8}, {3, 5, 6} };
    System.out.println(r.search2D(table, 5));
    System.out.println(r.search2D(table, 10));
  }
}
