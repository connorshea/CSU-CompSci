// R20 Assignment
// Author: Connor Shea
// Date:   12/5/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/recitations/R20.html

public class R20 {
	
	public static void main(String[] args) {
		System.out.println(funcOne(8));
		System.out.println(funcTwo(3, 4));
		System.out.println(funcThree(3));
		System.out.println(funcFour(3));
		funcFive(3);
		funcSix(3, 7);
	}

	//#1
	//Precondition: -10 <= x <= 7  
	//Postcondition: ?
	//QUESTION: What is the postcondition?
	// The postcondition must be: -1195 <= value <= -436
	public static int funcOne(int x) {

		// Enforce specified precondition in method
		assert (x >= -10 && x <= 7);
		return (3 * x * x * x) - (2 * x * x) + 5;
	}

	//#2
	//Preconditions: -5 <= x <= -2, 6 <= y <= 13   
	//Postcondition: ?
	//QUESTION: What is the postcondition?
	// The postcondition must be: -689 <= value <= -48
	public static int funcTwo(int x, int y) {

		// Enforce specified precondition in method
		assert (x >= -5 && x <= -2);
		assert (y >= 6  && y <= 13);
		return (3 * x * x * x) - (y * x * x) + 11;
	}

	//#3
	//Precondition: ?
	//Postcondition: 0.25 <= return value <= 1.0
	//QUESTION: What is the precondition?
	// The precondition must be: 1.0 <= value <= 4.0
	public static double funcThree(double x) {
		return 1.0 / x; 
	}


	//#4
	//Precondition: x is an integer  
	//Postcondition: returns an even integer
	//QUESTION: Is the postcondition true? Why or why not?
	// The postcondition is true because "x^2 - x" will always be even
	// if x is even, and "4x^2" will always be even if x is odd.
	public static int funcFour(int x) {

		int retVal;
		if (x % 2 == 0) {
			retVal = x * x - x;
		} else {
			retVal = (x + x) * (x + x);
		}
		assert(retVal % 2 == 0);
		return retVal;
	}

	//#5
	//Precondition: x >= 1
	//QUESTION: Find the loop invariants for all variables before, during, and after the loop.
	public static void funcFive(int x) {

		int result = 1;
		int i = 0;
		System.out.println(i < x);
		do {
			System.out.println(i < x);
			i++;
			result = result * i;
			System.out.println(i < x);
		} while (i < x);
		System.out.println(i < x);
	}

	//#6
	//QUESTION: Does this correct swap the locals a and b? Why or why not?
	// Yes it does, because if a is less than b, "a % b" will always return a,
	// then in either case a temporary variable will be used for the swap.
	public static void funcSix(int a, int b) {

		System.out.println("Before: a = " + a + " and b = " + b);
		if (a < b) {
			int r = a % b;
			a = b;
			b = r;
		}
		else {
			int r = b;
			b = a;
			a = r;
		}
		System.out.println("After: a = " + a + " and b = " + b);
	}
}
