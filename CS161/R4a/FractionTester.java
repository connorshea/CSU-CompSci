// package demo;

public class FractionTester {

  public static void main(String[] args) {
    // Make some fractions
    Fraction f = new Fraction(3, 4);
    Fraction g = new Fraction("3/4");
    Fraction h = new Fraction(5);
    Fraction[] myFractions = {f, g, h};

    // Print all three fractions
    for (int i = 0; i <= myFractions.length; i++) {
      System.out.println(String.format("myFractions[%d]=%s", i, myFractions[i]));
    }

    // Add two fractions, store the result
    Fraction sum = f.add(g);
    System.out.println(String.format("%s + %s = %s", f, g, sum));
  }
}
