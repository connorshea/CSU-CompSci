// Terrier.java - terrier behavior in "Terriers and Squirrels"
// Author: Ethan Lambert
// Date: 11/6/2015
// Course: cs160

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
    public Terrier(int row, int col, char[][] field){
        this.currentRow = row;
        this.currentCol = col;
        this.field = field;
    }

    // Getters
    public int getCurrentRow(){ return currentRow; }
    public int getCurrentCol(){ return currentCol; }
    public int getPreviousRow(){ return previousRow; }
    public int getPreviousCol(){ return previousCol; }
    public int getClosestRow(){ return closestRow; }
    public int getClosestCol(){ return closestCol; }
    //
    // DO NOT MODIFY ABOVE 
    //

    // Find closest squirrel
    public void findClosest(){

         // TO DO: Replace with code to find closest
         closestRow = -1;
         closestCol = -1;

    }
    
    // Move terrier according to the rules
    public void moveAnimal() {

        eMove move;

        // Store previous position
        previousRow = currentRow;
        previousCol = currentCol;

        // TO DO: replace with code to select move (Step 1)
        move = eMove.LEFT;

        // TO DO: replace with code to adjust move (Step 2)
        move = move;

        // TO DO: replace with code to make move (Step 3)
        currentCol--;
    }
    
    //
    // Private Methods, if you need them
    //
 
}

