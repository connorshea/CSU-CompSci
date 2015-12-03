// AnimalInterface.java - defines animal behavior in "Terriers and Squirrels"
// Author: Ethan Lambert
// Date: 11/6/2015
// Course: cs160

public interface AnimalInterface{
   
    public enum eMove {
        NO_MOVE,
        LEFT,
        UP_LEFT,
        UP,
        UP_RIGHT,
        RIGHT,
        DOWN_RIGHT,
        DOWN,
        DOWN_LEFT
    }
    
    // Find the closest squirrel or terrier
    public void findClosest();

    // Report the closest position
    public int getClosestCol();
    public int getClosestRow();
    
    // Move the animal, according to the rules 
    public void moveAnimal();
    
    // Report the current position
    public int getCurrentRow();
    public int getCurrentCol();

    // Report the previous position
    public int getPreviousRow();
    public int getPreviousCol();
}
