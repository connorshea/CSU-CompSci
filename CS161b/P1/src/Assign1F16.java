// PROVIDED CLASS,    DON'T CHANGE IT
// WE WILL USE DIFFERENT CLIENTS TO TEST YOUR CODE

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Assign1F16 {
  /**
   * @param args: String file name:
   *                  int array size
   *                  array size ints
   *              5 command line arguments:
         *                      String fName
   *                int sizeA
   *                int sizeB
   *                int tupleNum
   *                int setNum
   *     
   */
  public static void main(String[] args) {    
    // There are 5 command line arguments:
    // one String filename and 4 ints: problem sizes 

    Assign1 A1 = new Assign1(false);

    System.out.println("Reading input array");
    int[] in = {};
    String fName = args[0];
    try {
      Scanner scan = new Scanner(new File(fName));
      int size;
      size = scan.nextInt();
      in = new int[size];
      // loop through numbers in input file and sum them
      for (int i = 0; i < size; i++) {
        in[i] = scan.nextInt();
      }
    } catch (IOException E) {
      System.out.println("readIn: IOException!!");
      System.exit(1);
    }
  
    int sizeA = Integer.parseInt(args[1]);
    int sizeB = Integer.parseInt(args[2]);
    int sizeT = Integer.parseInt(args[3]);
    int sizeS = Integer.parseInt(args[4]);
    
    System.out.println("Checking isOdd");
    System.out.println("-2: " + A1.isOdd(-2));
    System.out.println("-1: " + A1.isOdd(-1));
    System.out.println(" 0; " + A1.isOdd(0));
    System.out.println(" 1: " + A1.isOdd(1));
    System.out.println(" 2: " + A1.isOdd(2));
    
    System.out.println("testing makeCumul:");
    int[] cumul = A1.makeCumul(in);
    System.out.println("in: " + Arrays.toString(in));   
    System.out.println("cumul: " + Arrays.toString(cumul));
      
    System.out.println("making arrays A and B");    
    int[] A = new int[sizeA];
    int[] B = new int[sizeB];
    for(int i=0;i<sizeA;i++) A[i]=i;
    for(int i=0;i<sizeB;i++) B[i]=i+100;
    System.out.println("A: " + Arrays.toString(A));   
    System.out.println("B: " + Arrays.toString(B));
    
    int[] C = A1.shuffle(A,B);
    System.out.println("testing shuffle:");
    System.out.println("C: " + Arrays.toString(C)); 

    System.out.println("testing tuples and subsets:");
    A1.doTuplesVsSubsets(sizeT,sizeS);
  }
}
