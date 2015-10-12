// P7 Assignment
// Author: Connor Shea
// Date:   10/12/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/assignments/P7.html


public class Pseudo {
  // Get it, because it's a char array.
  private char[] charray = new char[80];
  private int lengthOfString = 0;

  public void setString(String input) {
    for (int i = 0; i < input.length(); i++) {
      charray[i] = input.charAt(i);
    }

    lengthOfString = input.length();
  }

  public String getString() {
    String string = "";
    
    for (int i = 0; i < lengthOfString; i++) {
      string += charray[i];
    }

    return string;
  }

  public char charAt(int index) {
    return charray[index];
  }

  public int indexOf(char character) {
    for (int i = 0; i < lengthOfString; i++) {
      if (charray[i] == character) {
        return i;
      }
    }

    return -1;
  }

  // Initially I did this with a switch statement, but that was dumb.
  // Now it uses the ASCII table, where lower case letters are converted
  // to uppercase by subtracting 32 from their ASCII value.
  public String toUpperCase() {
    String uppercaseCharray = "";

    for (int i = 0; i < lengthOfString; i++) {
      if ( charray[i] >= 'a' && charray[i] <= 'z' ) {
        char character = (char)(charray[i] - 32);
        uppercaseCharray += character;
      } else {
        uppercaseCharray += charray[i];
      }
    }

    return uppercaseCharray;
  }

  public String substring(int start, int end) {
    String substring = "";
    for (int i = start; i <= end; i++) {
      substring += charray[i];
    }

    return substring;
  }

  public boolean equals(String input) {
    for (int i = 0; i < input.length(); i++) {
      if (charray[i] == input.charAt(i)) {
        continue;
      }

      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    // Instantiate class    
    Pseudo pseudo = new Pseudo();

    // Verify class
    System.out.println("Verifying Pseudo:");
    pseudo.setString("1234567890 Computer Science !(*@&#)*&");
    System.out.println("pseudo = " + pseudo.getString());
    System.out.println("pseudo.charAt(5) = " + pseudo.charAt(5));
    System.out.println("pseudo.indexOf('C') = " + pseudo.indexOf('C'));
    System.out.println("pseudo.toUpperCase() = " + pseudo.toUpperCase());
    System.out.println("pseudo.substring(11, 19) = " + pseudo.substring(11, 19));
    pseudo.setString("Compare");
    System.out.println("pseudo.equals(\"Compare\") = " + pseudo.equals("Compare"));
    System.out.println("pseudo.equals(\"Compare!\") = " + pseudo.equals("Compare!"));
    
    // String equivalent (should match!)
    System.out.println("\nComparing String:");
    String string = "1234567890 Computer Science !(*@&#)*&";
    System.out.println("string = " + string);
    System.out.println("string.charAt(5) = " + string.charAt(5));
    System.out.println("string.indexOf('C') = " + string.indexOf('C'));
    System.out.println("string.toUpperCase() = " + string.toUpperCase());
    System.out.println("string.substring(11, 19) = " + string.substring(11, 19));
    string = "Compare";
    System.out.println("string.equals(\"Compare\") = " + string.equals("Compare"));
    System.out.println("string.equals(\"Compare!\") = " + string.equals("Compare!"));
  }
}
