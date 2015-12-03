// GameEngine.java - game engine for "Terriers and Squirrels"
// Author: Ethan Lambert, modified by Chris Wilcox
// Date: 11/6/2015
// Course: cs160

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GameEngine{

    // Playing field
    public char[][] field;
    private int width;
    private int height;

    // Game variables
    private static GameEngine game;
    private static int counter = 0;
    public boolean done = false;

    // Animal arrays
    public ArrayList<Terrier> dogs = new ArrayList<Terrier>();
    public ArrayList<Squirrel> squirrels = new ArrayList<Squirrel>();

    // Entry point
    public static void main(String[] args) {

        // Create game, based on specified file
        game = new GameEngine();
        game.readFile(args[0]);
        game.height = game.field.length;
        game.width = game.field[0].length;

        // Initialize user interface
        UserInterface ui = new UserInterface(game.height, game.width, game.field);
        ui.redrawField();
        ui.setVisible(true);

        // Main loop
        while(game.done != true){

            // Wait for awhile
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            // Advance game and redraw
            game.done = game.next();
            ui.redrawField();
        }
    }

    // Advance game
    public boolean next(){

        // Move squirrels
        moveSquirrels();
        
        // Process terriers
        moveTerriers();

        // Limit iterations
        if (++counter > 30){
            System.out.println("Game stopped after 30 rounds!");
            return true;
        }

        // Any squirrels left?
        if (squirrels.size() == 0) {
            System.out.println("Oh my, all the squirrels are gone!");
            return true;
        }
        
        return false;
    }
    
    // Move squirrels
    private void moveSquirrels() {
        
        // Use iterator to allow dynamic removal
        for (Iterator<Squirrel> iterator = squirrels.iterator(); iterator.hasNext();) {
            
            // Get next squirrel
            Squirrel s = iterator.next();

            // Call squirrel to find closest terrier
            s.findClosest();

            // Call squirrel to move and get position
            s.moveAnimal();
            int currentRow = s.getCurrentRow();
            int currentCol = s.getCurrentCol();
            int previousRow = s.getPreviousRow();
            int previousCol = s.getPreviousCol();

            // Leave squirrel tracks, if it's not a fence or terrier or squirrel
            if ((previousRow != -1) && 
                (field[previousRow][previousCol] != 'F') &&
                (field[previousRow][previousCol] != 'D'))
                    field[previousRow][previousCol] = 's';

            // Check for invalid move
            if (currentRow < 0 || currentRow >= field.length ||
            	currentCol < 0 || currentCol >= field[0].length) {
                System.out.print("Squirrel[" + squirrels.indexOf(s) + "] exited the board at ");
                System.out.println("(" + currentRow + "," + currentCol + ")");
                System.exit(0);
            }
            
            if (field[currentRow][currentCol] == 'D')
                System.out.print("Squirrel[" + squirrels.indexOf(s) + "] moved into  Terrier at ");
            else if (field[currentRow][currentCol] == 'S')
                System.out.print("Squirrel[" + squirrels.indexOf(s) + "] moved into Squirrel at ");
            else if (field[currentRow][currentCol] == 'T')
                System.out.print("Squirrel[" + squirrels.indexOf(s) + "] climbed tree at ");
            else if (field[currentRow][currentCol] == 'F')
                System.out.print("Squirrel[" + squirrels.indexOf(s) + "] under fence at ");
            else
                System.out.print("Squirrel[" + squirrels.indexOf(s) + "] moved to ");
            System.out.println("(" + currentRow + "," + currentCol + ")");

            // Special handling
            if (field[currentRow][currentCol] == 'T') {

                // Squirrel found tree
                iterator.remove();
                
            } else if (field[currentRow][currentCol] == 'F') {
                
                // Squirrel under fence

            } else {

                // Valid move
                field[currentRow][currentCol] = 'S';
            }
        }
    }

    // Move terriers
    private void moveTerriers() {
            
        // Without squirrels, don't bother
        if (squirrels.size() == 0)
            return;

        // Iterate terriers
        for (Terrier d : dogs) {

            // Call terrier to find closest squirrel
            d.findClosest();

            // Call terrier to move and get position
            d.moveAnimal();
            int currentRow = d.getCurrentRow();
            int currentCol = d.getCurrentCol();
            int previousRow = d.getPreviousRow();
            int previousCol = d.getPreviousCol();
            
            // Leave terrier tracks
            if (previousRow != -1) field[previousRow][previousCol] = 'd';

            // Check for invalid move
            if (currentRow < 0 || currentRow >= field.length ||
            	currentCol < 0 || currentCol >= field[0].length) {
                System.out.print("Terrier[" + dogs.indexOf(d) + "] exited the board at ");
                System.out.println("(" + currentRow + "," + currentCol + ")");
                System.exit(0);
            }
            
            if (field[currentRow][currentCol] == 'D')
                System.out.println("Terrier[" + dogs.indexOf(d) + "] moved into Terrier at ");
            else if (field[currentRow][currentCol] == 'F')
                System.out.println("Terrier[" + dogs.indexOf(d) + "] moved into Fence at ");
            else if (field[currentRow][currentCol] == 'T')
                System.out.println("Terrier[" + dogs.indexOf(d) + "] moved into Tree at");
            else if (currentRow < 0)
                System.out.println("Terrier[" + dogs.indexOf(d) + "] exited the top at ");
            else if (currentRow >= field.length)
                System.out.println("Terrier[" + dogs.indexOf(d) + "] exited the bottom at ");
            else if (currentCol < 0)
                System.out.println("Terrier[" + dogs.indexOf(d) + "] exited the left at ");
            else if (currentCol >= field[0].length)
                System.out.println("Terrier[" + dogs.indexOf(d) + "] exited the right at ");
            else
                System.out.print("Terrier[" + dogs.indexOf(d) + "] moved to ");

            if (field[currentRow][currentCol] == 'S') {

                // Munched squirrel
                System.out.print("Terrier[" + dogs.indexOf(d) + "] ate Squirrel at ");
                field[currentRow][currentCol] = 'M';
                removeSquirrel(currentRow, currentCol);

            } else {
                
                // Valid move
                field[currentRow][currentCol] = 'D';
            }

            // Print location
            System.out.println("(" + currentRow + "," + currentCol + ")");
        }
    }
    
    // Remove a squirrel
    private void removeSquirrel(int row, int col) {
        
        Squirrel r = null;
        for (Squirrel s : squirrels){

            if (s.getCurrentRow() == row && s.getCurrentCol() == col)
                r = s;
        }
        squirrels.remove(r);
    }

    // Read maze
    private void readFile(String filename) {
        try {

            // Open file
            Scanner scan = new Scanner(new File(filename));

            // Read numbers
            height = scan.nextInt();
            width = scan.nextInt();

            // Allocate maze
            field = new char[height][width];

            // Read maze
            for (int row = 0; row < height; row++) {

                // Read line
                String line = scan.next();
                for (int col = 0; col < width; col++) {
                    
                    // Fill in character
                    field[row][col] = line.charAt(col);

                    // Make objects
                    if (field[row][col] == 'D') {
                        Terrier dog = new Terrier(row, col, field);
                        dogs.add(dog);
                    } else if (field[row][col] == 'S') {
                        Squirrel squirrel = new Squirrel(row, col, field);
                        squirrels.add(squirrel);
                    }
                }
            }
            scan.close();

        } catch (IOException e) {
            System.out.println("Cannot read maze: " + filename);
            System.exit(0);
        }
    }
}
