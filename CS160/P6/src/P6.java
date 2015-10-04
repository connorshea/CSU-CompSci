// P6 Assignment
// Author: Connor Shea
// Date:   10/4/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/assignments/P6.html

import java.io.File;
import java.util.Scanner;

public class P6 {

  // Returns true if Chihiro is on any edge, false otherwise
  public static boolean onEdge() {
    int currRow = maze.getRow();
    int currCol = maze.getColumn();

    if (currRow == 0 || currRow == mazeHeight - 1 || currCol == 0 || currCol == mazeWidth - 1 ) {
      return true;
    }

    return false;
  }

  // Moves Chihiro from the current column to the left edge
  public static void loopLeft() {
    int i;
    for (i = maze.getColumn(); i > 0; i--) {
      maze.moveLeft();
    }
  }

  // Moves Chihiro from the current column to the right edge
  public static void loopRight() {
    int i;
    for (i = maze.getColumn(); i < mazeWidth - 1; i++) {
      maze.moveRight();
    }
  }

  // Moves Chihiro from the current row to the top edge
  public static void loopUp() {
    int i;
    for (i = maze.getRow(); i > 0; i--) {
      maze.moveUp();
    }
  }

  // Moves Chihiro from the current row to the bottom edge
  public static void loopDown() {
    int i;
    for (i = maze.getRow(); i < mazeHeight - 1; i++) {
      maze.moveDown();
    }
  }

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
    
    // If Chihiro is not on any edge, move straight up to the top row.
    if (!onEdge()) {
      loopUp();
    }

    // If Chihiro is on the top edge, move right to the top-right corner.
    if (maze.getRow() == 0) {
      loopRight();
    }
    
    // If Chihiro is on the right edge, move down to the bottom-right corner.
    if (maze.getColumn() == mazeWidth - 1) {
      loopDown();
    }

    // If Chihiro is on the bottom edge, move left to the bottom-left corner.
    if (maze.getRow() == mazeHeight - 1) {
      loopLeft();
    }

    // If Chihiro is on the left edge, move up to the top-left corner.
    if (maze.getColumn() == 0) {
      loopUp();
    }

  }
}
