// Squirrel.java - squirrel behavior in "Terriers and Squirrels"
// Author: Ethan Lambert
// Date: 11/6/2015
// Course: cs160

import java.lang.Math;

public class Squirrel implements AnimalInterface {

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
  public Squirrel(int row, int col, char[][] field) {
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


  // Find closest terrier
  public void findClosest() {

    int closestTerrierRow = 0;
    int closestTerrierCol = 0;
    double closestTerrierDist = 0.0;

    // int[row][col]
    // Scan the board to find closest Terrier
    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[i].length; j++) {
        if (field[i][j] == 'D') {
          // Calculate the Euclidean distance
          int horizontalDist = currentCol - j;
          int verticalDist = currentRow - i;
          double euclideanDist = Math.sqrt(Math.pow(horizontalDist, 2) + Math.pow(verticalDist, 2));

          // If the closest terrier distance is 0, this is the first terrier we've found
          // so we should just use it. If the Euclidean Distance is less than the previous closest
          // Terrier distance we should replace the closestTerrier info.
          if (closestTerrierDist == 0.0 || euclideanDist < closestTerrierDist) {
            closestTerrierDist = euclideanDist;
            closestTerrierRow = i;
            closestTerrierCol = j;
          }
        }
      }
    }

    closestRow = closestTerrierRow;
    closestCol = closestTerrierCol;

    previousRow = currentRow;
    previousCol = currentCol;
  }
  
  // Move squirrel according to the rules
  public void moveAnimal() {

    eMove move;

    // Store previous position
    previousRow = currentRow;
    previousCol = currentCol;
    

    System.out.println(closestRow + " " + closestCol);
    System.out.println(currentRow + " " + currentCol);
    

    // If the terrier is above on the same column, move down.
    if (currentCol == closestCol && currentRow > closestRow) {
      move = eMove.DOWN;
    }
    // If the terrier is below on the same column, move up.
    else if (currentCol == closestCol && currentRow < closestRow) {
      move = eMove.UP;
    }
    // If the terrier is left on the same row, move right.
    else if (currentRow == closestRow && currentCol > closestCol) {
      move = eMove.RIGHT;
    }
    // If the terrier is right on the same row, move left.
    else if (currentRow == closestRow && currentCol < closestCol) {
      move = eMove.LEFT;
    }
    // If the terrier is above and on the left, move down right
    else if (currentRow > closestRow && currentCol > closestCol) {
      move = eMove.DOWN_RIGHT;
    }
    // If the terrier is above and on the right, move down left
    else if (currentRow > closestRow && currentCol < closestCol) {
      move = eMove.DOWN_LEFT;
    }
    // If the terrier is below and on the left, move down right
    else if (currentRow < closestRow && currentCol > closestCol) {
      move = eMove.UP_RIGHT;
    }
    // If the terrier is below and on the right, move down left
    else if (currentRow < closestRow && currentCol < closestCol) {
      move = eMove.UP_LEFT;
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

    System.out.println("SQUIRREL: " + move);
    

    // STEP 3: MOVE SQUIRREL
    moveSquirrel(move);
  }

  private boolean validateMove(eMove move) {

    // Make sure the move is valid
    if (move == eMove.DOWN) {
      // If you can't move down, return false
      if (currentRow + 1 > field.length || field[currentRow + 1][currentCol] == 'D' || field[currentRow + 1][currentCol] == 'S') {
        return false;
      }
    }
    else if (move == eMove.UP) {
      // If you can't move up, return false
      if (currentRow - 1 < 0 || field[currentRow - 1][currentCol] == 'D' || field[currentRow - 1][currentCol] == 'S') {
        return false;
      }
    }
    else if (move == eMove.RIGHT) {
      // If you can't move right, return false
      if (currentCol + 1 > field[currentRow].length || field[currentRow][currentCol + 1] == 'D' || field[currentRow][currentCol + 1] == 'S') {
        return false;
      }
    }
    else if (move == eMove.LEFT) {
      // If you can't move left, return false
      if (currentCol - 1 < 0 || field[currentRow][currentCol - 1] == 'D' || field[currentRow][currentCol - 1] == 'S') {
        return false;
      }
    }
    else if (move == eMove.DOWN_RIGHT) {
      // If you can't move down right, return false
      if (currentRow + 1 > field.length || currentCol + 1 > field[currentRow].length || field[currentRow + 1][currentCol + 1] == 'D' || field[currentRow + 1][currentCol + 1] == 'S') {
        return false;
      }
    }
    else if (move == eMove.DOWN_LEFT) {
      // If you can't move down left, return false
      if (currentRow + 1 > field.length || currentCol - 1 < 0 || field[currentRow + 1][currentCol - 1] == 'D' || field[currentRow + 1][currentCol - 1] == 'S') {
        return false;
      }
    }
    else if (move == eMove.UP_RIGHT) {
      // If you can't move up right, return false
      if (currentRow - 1 < 0 || currentCol + 1 > field[currentRow].length || field[currentRow - 1][currentCol + 1] == 'D' || field[currentRow - 1][currentCol + 1] == 'S') {
        return false;
      }
    }
    else if (move == eMove.UP_LEFT) {
      // If you can't move up left, return false
      if (currentRow - 1 < 0 || currentCol - 1 < 0 || field[currentRow - 1][currentCol - 1] == 'D' || field[currentRow - 1][currentCol - 1] == 'S') {
        return false;
      }
    }

    return true;
  }

  private void moveSquirrel(eMove move) {
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
