// P6 Assignment
// Author: Connor Shea
// Date:   10/4/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/assignments/P6.html

import java.util.Scanner;

public class P5 {
  // Constructor, parameter is name of maze file
  public Maze(String fileName);

  // Get width and height of maze
  public int getWidth() {
    Scanner fileScanner = new Scanner(new File(fileName));

    mazeWidth = scan.nextInt();

    return mazeWidth;
  }
  public int getHeight();

  // Get location of Chihiro
  public int getColumn();
  public int getRow();

  // Commands to move Chihiro
  public void moveRight();
  public void moveLeft();
  public void moveDown();
  public void moveUp();

  // Returns true if Chihiro is on any edge, false otherwise
  public static boolean onEdge();

  // Moves Chihiro from the current column to the left edge
  public static void loopLeft();

  // Moves Chihiro from the current column to the right edge
  public static void loopRight();

  // Moves Chihiro from the current row to the top edge
  public static void loopUp();

  // Moves Chihiro from the current row to the bottom edge
  public static void loopDown();

  // Class variables
  public static Maze maze;
  public static int mazeWidth;
  public static int mazeHeight;

  public static void main(String[] args) {

    // Create maze
    String fileName = args[0];
    System.err.println("Maze name: " + fileName);

    // Get dimensions
    maze = new Maze(fileName);
    mazeWidth = maze.getWidth();
    mazeHeight = maze.getHeight();
    System.err.println("Maze width: " + mazeWidth);
    System.err.println("Maze height: " + mazeHeight);

    // Add code to move around maze
  }
}
