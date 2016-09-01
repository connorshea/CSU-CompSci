import java.io.File;
import java.io.IOException;
import java.util.*;

public class Assign1 {

	// PROVIDED INSTANCE VAR and METHODS
	// DON'T CHANGE THESE

	boolean debug = true;
	
	public Assign1(Boolean debug){
		this.debug = debug;
	}

	/**
	 * Print a 3-Tuple
	 */
	public void print3Tuple(int a, int b, int c) {
		System.out.println("(" +a+ "," +b+ "," +c+ ")" );
	}
	
	/**
	 * Print a 3-Set
	 */
	public void print3Set(int a, int b, int c) {
		System.out.println("{" +a+ "," +b+ "," +c+ "}" );
	}

	/**
	 * 
	 * @param n: problem size
	 * 
	 * Print 3 tuples and 3 subsets
	 */
	public void doTuplesVsSubsets(int t, int s) {
		System.out.println("3-Tuples with elements 0 to " + (t-1));
		print3Tuples(t);
	
		System.out.println("3-Subsets with elements 0 to " +(s-1));
		print3Subsets(s);	
	}


	// YOUR METHODS
	// IMPLEMENT THESE

	/**
	 * 
	 * @param n any integer
	 * @return: true if n is odd, false otherwise
	 * Deal with all cases!!         
	 */
	public boolean isOdd(int n) {
    if (n < 0) {
    	n = n * -1;
    }

    if (n % 2 == 0) {
    	return false;
    } else if (n % 2 == 1) {
    	return true;
    } else {
    	return true;
    }
	}
	
	/**
	 * 
	 * @param n: bound
	 * pre: n>=0 
	 * post: all ordered 3 tuples (i,j,k) 
	 *       i in 0..(n-1), j in 0 .. (n-1), k in 0..(n-1) 
	 *       printed in *** Lexicographical *** order
	 *       Use print3Tuple() to print
	 * (0,0,0)
	 * (0,0,1)
	 *  etc.
	 */
	public void print3Tuples(int n) {
            // Replace this body with your solution
	    System.out.println("print3Tuples NOT IMPLEMENTED YET");
	    // to print a 3-tuple call print3Tuple(a,b,c);
	}
	
	/**
	 * 
	 * @param n: sub set size 
	 * pre: n>=0 
	 * post: all subsets size 3 {i,j,k} printed ONCE
	 *       notice {i,j,k} = {i,k,j} = {j,i,k} ...
	 *       only the lexicographically lowest is printed 
	 *       each subset is printed on one line
	 *       in lexicographical order
	 *       use print3Set to print
	 * {0,1,2}      
	 * {0,1,3}
	 * etc 
	 */
	public void print3Subsets(int n) {
            // Replace this body with your solution
		System.out.println("print3Subsets NOT IMPLEMENTED YET");
	    // to print a 3-set call print3Set(a,b,c);
	}

	
	/**
	 * 
	 * @param A
	 * @param B
	 * @return A and B shuffled: A[0], B[0], A[1], B[1] ...
	 * 
	 * Do not change A and B
	 * 
	 * 
	 * When A and B are of different length, the rest of 
	 * the longest array is appended to the result, eg
	 * 
	 * shuffle({1,2,3},{10,20,30,40,50}) returns
	 *   {1,10,2,20,3,30,40,50}
	 *   
	 * and
	 * 
	 * shuffle({1,2,3,4,5},{10,20}) returns
	 *   {1,10,2,20,3,4,5}
	 */
	public int[] shuffle(int[]A, int[]B){
            // Replace this body with your solution
		System.out.println("shuffle NOT IMPLEMENTED YET");
		int[] out = {};
		return out;
	}	
	
	/**
	 * 
	 * @param in input array of ints
	 * @return an array res with cumulative sums of in
	 *   res[0] = in[0], res[1] = in[0]+in[1],
	 *   res[i] = in[0]+in[1]+...+in[i]
	 * 
	 * Do not change array in  
	 *   
	 * pre:  in has at least one element
	 * post: in has not changed and 
	 *       res contains cumulative sums
	 */
	public int[] makeCumul(int[] in){
		int[] out = new int[in.length];

		for (int i = 0; i < in.length; i++) {
			out[i] = in[i];
			System.out.println("Out: " + out[i] + ", In: " + in[i] + ", i: " + i);

			for (int j = i - 1; j >= 0; j--) {
				out[i] += in[j];
				System.out.println("Inner loop");
				System.out.println("Out: " + out[i] + ", In: " + in[i] + ", i: " + i + ", j: " + j);
			}
		}
    
		return out;
	}
	
	/**
	 * Use main to test individual methods    
	 */
	public static void main(String[] args) {
		Assign1 test = new Assign1(true);
		
		// testing isOdd
		if(test.isOdd(1))
			System.out.println("odd 1 OK");
		else
			System.out.println("odd 1 ERROR");
		if(test.isOdd(0))
			System.out.println("odd 0 ERROR");
		else
			System.out.println("odd 0 OK");
	}

}
