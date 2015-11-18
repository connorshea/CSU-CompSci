// P11 Interface File
// Author: Chris Wilcox
// Date:   11/16/2015
// Class:  CS160
// Email:  wilcox@cs.colostate.edu

public interface TestInterface {

    // Returns a reversed version of the specified string,
    // which can contain any ASCII character.
    // For example, returns "edcba" for "abcde" 
    public String reverseString(String s);

    // Returns the specified string duplicated.
    // For example, returns "Hello There!Hello There!" for "Hello There!" 
    public String duplicateString(String s);

    // Creates an array of strings with
    // [0] = original, [1] = toUppercase(), [2] = toLowercase().
    // For example, returns {"Whatever", "WHATEVER", "whatever"} for "Whatever"
    public String[] createStrings(String s);

    // Cubes all elements in array of doubles.
    // For example, changes {2.0, 3.0, 4.0} to {8.0, 27.0, 64.0}
    public void cubeArray(double[] array);

    // Adds the elements in array of integers,
    // returning the sum as an integer.
    // For example, returns 21 for {1, 2, 3, 4, 5, 6}
    public int sumArray(int[] array);

    // Sorts an array of integers from low to high.
    // For example, changes {2, 6, 4, 9, 1} to {1, 2, 4, 6, 9}
    public void sortArray(int[] array);

}
