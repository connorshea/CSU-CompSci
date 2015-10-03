// Q1 Assignment
// Author: Connor Shea
// Date:   9/29/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/quizzes/Q1.html

public class R7 {
  public static void main(String[] args) {
    // Declare variables
    int int0 = 0,
        int1 = 0,
        int2 = 0;
    double real0 = 0.0,
           real1 = 0.0,
           real2 = 0.0;
    String string0 = "",
           string1 = "",
           string2 = "";
    boolean p = true,
            q = true,
            r = false;

    try {
      // Open input stream
      Scanner scan = new Scanner(new File("data.txt"));

      // Read contents
      string0 = scan.nextLine();
      string1 = scan.nextLine();
      string2 = scan.nextLine();
      int0 = scan.nextInt();
      int1 = scan.nextInt();
      int2 = scan.nextInt();
      real0 = scan.nextDouble();
      real1 = scan.nextDouble();
      real2 = scan.nextDouble();
      p = scan.nextBoolean();
      q = scan.nextBoolean();
      r = scan.nextBoolean();

      // Close input stream
      scan.close();

    } catch (IOException e) {
      System.out.println("Cannot read file: data.txt");
      System.exit(0);
    }
  }
}
