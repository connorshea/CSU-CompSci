// package demo;

public class Fraction {

  protected int numerator;
  protected int denominator;

  public Fraction(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public Fraction(int numerator) {
    this(numerator, 1);
  }

  public Fraction(String fraction) {
    String[] nums = fraction.split("/");
    this.numerator = Integer.parseInt(nums[0]);
    this.denominator = Integer.parseInt(nums[1]);
  }

  public Fraction add(Fraction that) {
    int num = (this.numerator * that.denominator)
        + (this.denominator * that.numerator);
    int den = this.denominator * that.denominator;
    Fraction sum = new Fraction(num, den);
    sum.simplify();
    return this;
  }

  public static int greatestCommonDivisor(int a, int b) {
    if (b == 0) {
      return a;
    } else if (a >= b && b > 0) {
      return greatestCommonDivisor(b, a % b);
    } else {
      return greatestCommonDivisor(b, a);
    }
  }

  public void simplify() {
    int gcd = greatestCommonDivisor(numerator,denominator);
    numerator = numerator / gcd;
    denominator = denominator / gcd;
  }

  public String toString() {
    return numerator + "/" + denominator;
  }

  public static void main(String[] args) {

  }
}
