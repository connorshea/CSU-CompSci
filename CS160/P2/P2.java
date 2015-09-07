// P2 Assignment
// Author: Connor Shea
// Date:   9/2/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// https://www.cs.colostate.edu/~cs160/.Fall15/assignments/P2.html

public class P2 {
    public static void main(String[] args) {
        byte byte1 = 32;
        short short1 = 15477;
        int int1 = 664422;
        // The long value goes outside the allowed range for integers of type long, therefore a lower-case L is appended to the value.
        long long1 = 3984759871l;
        // Ditto the above, albeit with the type float and a lower-case F.
        float float1 = 8.112f;
        double double1 = 56.4444;
        char char1 = '&',
                char2 = 'S',
                char3 = '5';
        String string1 = "Computer",
                string2 = "Science",
                string3 = "Excellent";

        System.out.println(byte1 + ":" + short1 + ":" + int1 + ":" + long1);
        System.out.println(float1 + "," + double1);
        // Print the sum of all the integer variables divided by 99999
        System.out.println((byte1 + short1 + int1 + long1) / 99999);

        double sqrt = Math.sqrt(float1 + double1);

        System.out.printf("%.3f\n", sqrt);

        double quotient = byte1 / float1;

        System.out.printf("%.5f\n", quotient);

        System.out.println(char1 + "=" + char2 + "=" + char3);

        // Decrement the char variables by 3.
        char1 -= 3;
        char2 -= 3;
        char3 -= 3;

        System.out.println(char1 + "~" + char2 + "~" + char3);

        System.out.printf("%s %s is %s!\n", string1, string2, string3);

        System.out.println(string1.length() + "," + string2.length() + "," + string3.length());

        System.out.println(string3.toUpperCase());

        System.out.println(string1.substring(2,7));

        System.out.println(string2.indexOf("e"));

        // We want the fourth character, but the index starts at 0, so we use 3.
        System.out.println(string1.charAt(3));
    }
}
