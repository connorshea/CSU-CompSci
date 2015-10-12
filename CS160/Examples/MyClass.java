import java.util.Scanner;

public class MyClass {
  public static int factorial = 1234;
  public int number = 5678;
  
  public static void main(String[] args) {
    incrementFactorial();

    System.out.println(MyClass.factorial);
    
    MyClass class0 = new MyClass();
    System.out.println(class0.number);

    MyClass class1 = new MyClass();
    System.out.println(class1.number);

  }

  public static void incrementFactorial() {
    factorial++;
  }
}
