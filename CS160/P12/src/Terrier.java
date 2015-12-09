// Terrier.java - terrier behavior in "Terriers and Squirrels"
// Author: Ethan Lambert
// Date: 11/6/2015
// Course: cs160

// P12 Assignment
// Author: Connor Shea
// Date:   12/6/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/assignments/P12.html

import java.lang.Math;

public class Terrier implements AnimalInterface {

  //
  // DO NOT MODIFY BELOW 
  //
  private int currentRow;
  private int currentCol;
  private int previousRow = -1;
  private int previousCol = -1;
  private int closestRow;
  private int closestCol;
  private char[][] field;

  // Initializes position and field
  public Terrier(int row, int col, char[][] field) {
    this.currentRow = row;
    this.currentCol = col;
    this.field = field;
  }

  // Getters
  public int getCurrentRow() {
    return currentRow;
  }

  public int getCurrentCol() {
    return currentCol;
  }

  public int getPreviousRow() {
    return previousRow;
  }

  public int getPreviousCol() {
    return previousCol;
  }

  public int getClosestRow() {
    return closestRow;
  }

  public int getClosestCol() {
    return closestCol;
  }

  //
  // DO NOT MODIFY ABOVE 
  //


  // Find closest squirrel
  public void findClosest() {

    int closestSquirrelRow = 0;
    int closestSquirrelCol = 0;
    double closestSquirrelDist = 0.0;

    // int[row][col]
    // Scan the board to find closest Squirrel
    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[i].length; j++) {
        if (field[i][j] == 'S') {
          // Calculate the Euclidean distance
          int horizontalDist = currentCol - j;
          int verticalDist = currentRow - i;
          double euclideanDist = Math.sqrt(Math.pow(horizontalDist, 2) + Math.pow(verticalDist, 2));

          // If the closest squirrel distance is 0, this is the first Squirrel we've found
          // so we should just use it. If the Euclidean Distance is less than the previous closest
          // Squirrel distance we should replace the closestSquirrel info.
          if (closestSquirrelDist == 0.0 || euclideanDist < closestSquirrelDist) {
            closestSquirrelDist = euclideanDist;
            closestSquirrelRow = i;
            closestSquirrelCol = j;
          }
        }
      }
    }

    closestRow = closestSquirrelRow;
    closestCol = closestSquirrelCol;

    previousRow = currentRow;
    previousCol = currentCol;
  }
  
  // Move terrier according to the rules
  public void moveAnimal() {

    eMove move;

    // Store previous position
    previousRow = currentRow;
    previousCol = currentCol;

    // If the squirrel is above on the same column, move up.
    if (currentCol == closestCol && currentRow > closestRow) {
      move = eMove.UP;
    }
    // If the squirrel is below on the same column, move down.
    else if (currentCol == closestCol && currentRow < closestRow) {
      move = eMove.DOWN;
    }
    // If the squirrel is left on the same row, move left.
    else if (currentRow == closestRow && currentCol > closestCol) {
      move = eMove.LEFT;
    }
    // If the squirrel is right on the same row, move right.
    else if (currentRow == closestRow && currentCol < closestCol) {
      move = eMove.RIGHT;
    }
    // If the squirrel is above and on the left, move up left
    else if (currentRow > closestRow && currentCol > closestCol) {
      move = eMove.UP_LEFT;
    }
    // If the squirrel is above and on the right, move up right
    else if (currentRow > closestRow && currentCol < closestCol) {
      move = eMove.UP_RIGHT;
    }
    // If the squirrel is below and on the left, move down left
    else if (currentRow < closestRow && currentCol > closestCol) {
      move = eMove.DOWN_LEFT;
    }
    // If the squirrel is below and on the right, move down right
    else if (currentRow < closestRow && currentCol < closestCol) {
      move = eMove.DOWN_RIGHT;
    }
    // Otherwise, screw it.
    else {
      move = eMove.NO_MOVE;
    }

    // STEP 2
    // Validate the move
    boolean isMoveValid = validateMove(move);

    while (isMoveValid == false) {
      if (move == eMove.DOWN) {
        // If you can't move down, move down left
        move = eMove.DOWN_LEFT;
      }
      else if (move == eMove.UP) {
        // If you can't move up, move up right
        move = eMove.UP_RIGHT;
      }
      else if (move == eMove.RIGHT) {
        // If you can't move right, move down right
        move = eMove.DOWN_RIGHT;
      }
      else if (move == eMove.LEFT) {
        // If you can't move left, move up left
        move = eMove.UP_LEFT;
      }
      else if (move == eMove.DOWN_RIGHT) {
        // If you can't move down right, move down
        move = eMove.DOWN;
      }
      else if (move == eMove.DOWN_LEFT) {
        // If you can't move down left, move left
        move = eMove.LEFT;
      }
      else if (move == eMove.UP_RIGHT) {
        // If you can't move up right, move right
        move = eMove.RIGHT;
      }
      else if (move == eMove.UP_LEFT) {
        // If you can't move up left, move up
        move = eMove.UP;
      }

      isMoveValid = validateMove(move);
    }

    System.out.println("TERRIER: " + move);
    

    // STEP 3: MOVE TERRIER
    moveTerrier(move);
  }

  private boolean validateMove(eMove move) {
    boolean isMoveValid = true;

    // Make sure the move is valid
    if (move == eMove.DOWN) {
      // If you can't move down, return false
      if (currentRow + 1 > field.length || field[currentRow + 1][currentCol] == 'F' || field[currentRow + 1][currentCol] == 'T' || field[currentRow + 1][currentCol] == 'D') {
        isMoveValid = false;
      }
    }
    else if (move == eMove.UP) {
      // If you can't move up, return false
      if (currentRow - 1 < 0 || field[currentRow - 1][currentCol] == 'F' || field[currentRow - 1][currentCol] == 'T' || field[currentRow - 1][currentCol] == 'D') {
        isMoveValid = false;
      }
    }
    else if (move == eMove.RIGHT) {
      // If you can't move right, return false
      if (currentCol + 1 > field[currentRow].length || field[currentRow][currentCol + 1] == 'F' || field[currentRow][currentCol + 1] == 'T' || field[currentRow][currentCol + 1] == 'D') {
        isMoveValid = false;
      }
    }
    else if (move == eMove.LEFT) {
      // If you can't move left, return false
      if (currentCol - 1 < 0 || field[currentRow][currentCol - 1] == 'F' || field[currentRow][currentCol - 1] == 'T' || field[currentRow][currentCol - 1] == 'D') {
        isMoveValid = false;
      }
    }
    else if (move == eMove.DOWN_RIGHT) {
      // If you can't move down right, return false
      if (currentRow + 1 > field.length || currentCol + 1 > field[currentRow].length || field[currentRow + 1][currentCol + 1] == 'F' || field[currentRow + 1][currentCol + 1] == 'T' || field[currentRow + 1][currentCol + 1] == 'D') {
        isMoveValid = false;
      }
    }
    else if (move == eMove.DOWN_LEFT) {
      // If you can't move down left, return false
      if (currentRow + 1 > field.length || currentCol - 1 < 0 || field[currentRow + 1][currentCol - 1] == 'F' || field[currentRow + 1][currentCol - 1] == 'T' || field[currentRow + 1][currentCol - 1] == 'D') {
        isMoveValid = false;
      }
    }
    else if (move == eMove.UP_RIGHT) {
      // If you can't move up right, return false
      if (currentRow - 1 < 0 || currentCol + 1 > field[currentRow].length || field[currentRow - 1][currentCol + 1] == 'F' || field[currentRow - 1][currentCol + 1] == 'T' || field[currentRow - 1][currentCol + 1] == 'D') {
        isMoveValid = false;
      }
    }
    else if (move == eMove.UP_LEFT) {
      // If you can't move up left, return false
      if (currentRow - 1 < 0 || currentCol - 1 < 0 || field[currentRow - 1][currentCol - 1] == 'F' || field[currentRow - 1][currentCol - 1] == 'T' || field[currentRow - 1][currentCol - 1] == 'D') {
        isMoveValid = false;
      }
    }

    return isMoveValid;
  }

  private void moveTerrier(eMove move) {
    if (move == eMove.DOWN) {
      currentRow++;
    }
    else if (move == eMove.UP) {
      currentRow--;
    }
    else if (move == eMove.RIGHT) {
      currentCol++;
    }
    else if (move == eMove.LEFT) {
      currentCol--;
    }
    else if (move == eMove.DOWN_RIGHT) {
      currentRow++;
      currentCol++;
    }
    else if (move == eMove.DOWN_LEFT) {
      currentRow++;
      currentCol--;
    }
    else if (move == eMove.UP_RIGHT) {
      currentRow--;
      currentCol++;
    }
    else if (move == eMove.UP_LEFT) {
      currentRow--;
      currentCol--;
    }
    else if (move == eMove.NO_MOVE) {
      System.out.println("No move.");
    }
  }
 
}

