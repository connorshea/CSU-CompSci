// Art Commissions
// Author: Connor Shea

import java.util.Scanner;

// ImageHex: y = 0.88x - 0.30
// Artists&Clients: y = 0.85x - 0.30
// ArtCorgi: y = 0.80x
// DeviantArt: y = 0.80x
// 99designs: y = 0.70x

public class commissions {
  public static double feesImageHex(double commission) {
    return (commission * 0.88) - 0.30;
  }

  public static double feesDeviantArt(double commission) {
    return commission * 0.80;
  }

  public static double feesArtCorgi(double commission) {
    return (commission * 0.80);
  }

  public static double feesArtistsClients(double commission) {
    return (commission * 0.85) - 0.30;
  }

  public static double fees99Designs(double commission) {
    return (commission * 0.70);
  }

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("How much is the commission?: $");
    double commission = keyboard.nextDouble();

    System.out.println("You'll earn this much on these platforms:");
    System.out.printf("ImageHex: $%.2f\n", feesImageHex(commission) );
    System.out.printf("DeviantArt: $%.2f\n", feesDeviantArt(commission) );
    System.out.printf("ArtCorgi: $%.2f\n", feesArtCorgi(commission) );
    System.out.printf("Artists&Clients: $%.2f\n", feesArtistsClients(commission) );
    System.out.printf("99designs: $%.2f\n", fees99Designs(commission) );
  }
}
