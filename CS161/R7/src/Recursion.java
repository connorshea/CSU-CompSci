
public class Recursion {
	
	// Precondition: n >= 0
  // Postcondition: returns the nth number in a sequence where each element is twice its predecessor, and starts with 1.
	public int sequence1(int n) {
	

    return -1;

    // 5 => 16
    // 5



    // 1 2 4 8 16 32 64 128 256 512 1024 2048
	}
	
	// Precondition: n >= 0
  // Postcondition: returns the nth number in a sequence where each element is the sum of the previous 3, and starts with 1,2,3
	public int sequence2(int n) {
		int result = 0;

    return result;
	}
		
  // Precondition: word is an instance of String
  // Postcondition: returns true if word is a palindrome, and false otherwise
  //
	public boolean palindrome(String word) {
		return false;
	}

  // Precondition: list is an array of size at least 1
  // Postcondition: return value is the largest element in the array
  public int maximum(int [] list) {
    return -1;
  }
    
	// Precondition: x >= 1
  // Postcondition: returns the appropriate star pattern for the value of x
	public String starPattern(int x) {
    String returnString = "";
    
    if (x > 0) {
		  returnString += starPattern(x - 1);
      return "*";
    }
    
    if (x > 0) {
      returnString += "\n" + starPattern(x - 1);
    }

		return returnString;
	}
	
	public static void main(String args[]) {

    Recursion rec = new Recursion();

    System.out.println("sequence1(int x):");
    System.out.println("Answer: " + rec.sequence1(5) + "   Expecting: 32");
    System.out.println("Answer: " + rec.sequence1(7) + "   Expecting: 128\n");
    
    System.out.println("sequence2(int x):");
    System.out.println("Answer: " + rec.sequence2(4) + "   Expecting: 11");
    System.out.println("Answer: " + rec.sequence2(5) + "   Expecting: 20\n");
    
    System.out.println("\'car\' is a palindrome?: " + rec.palindrome("car"));
    System.out.println("\'racecar\' is a palindrome?: " + rec.palindrome("racecar"));
    System.out.println("\'hannah\' is a palindrome?: " + rec.palindrome("hannah"));
    System.out.println("\'banana\' is a palindrome?: " + rec.palindrome("banana") + "\n");
    
    System.out.println(rec.starPattern(5));
	}
}

