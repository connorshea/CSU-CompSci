// P4 Assignment
// Author: Connor Shea
// Date:   9/15/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu

import java.util.Scanner;

public class P4 {
  public static void main(String[] args) {
    // Initialize scanner
    Scanner inputScanner = new Scanner(System.in);

    // Gross Salary
    System.out.print("Gross Salary: ");
    double grossSalary = inputScanner.nextDouble();

    // Number of Exemptions
    System.out.print("Number of Exemptions: ");
    int numExemptions = inputScanner.nextInt();
    
    // Set exemptions to an upper limit of 5 if it goes anywhere above 5.
    if (numExemptions > 5) {
      numExemptions = 5;
    }

    // Interest Income
    System.out.print("Interest Income: ");
    double interestIncome = inputScanner.nextDouble();

    // Capital Gains
    System.out.print("Capital Gains: ");
    double capitalGains = inputScanner.nextDouble();

    // Total Income
    double totalIncome = grossSalary + interestIncome + capitalGains;
    System.out.printf("Total Income: $%.2f\n", totalIncome);

    // Adjusted Income
    double adjustedIncome = totalIncome - (numExemptions * 1800);
    System.out.printf("Adjusted Income: $%.2f\n", adjustedIncome);


    // Calculations for Tax
    // 0%: $0 - $15,000
    // 15%: $15,000 - $25,000
    // 25%: $25,000 - $45,000
    // 30%: above $45,000

    double totalTax = 0.0;

    // Compounding values for tax
    if (adjustedIncome < 15000) {
      totalTax = 0;
    } else if (adjustedIncome >= 15000 && adjustedIncome < 25000) {
      totalTax = (adjustedIncome - 15000) * 0.15;
    } else if (adjustedIncome >= 25000 && adjustedIncome < 45000) {
      totalTax = (adjustedIncome - 25000) * 0.25;
      totalTax += 0.15 * (25000 - 15000);
    } else if (adjustedIncome >= 45000) {
      totalTax = (adjustedIncome - 45000) * 0.30;
      totalTax += 0.25 * (45000 - 25000);
      totalTax += 0.15 * (25000 - 15000);
    }

    System.out.printf("Total Tax: $%.2f\n", totalTax);

    // State Tax
    double stateTax = adjustedIncome * 0.055;
    System.out.printf("State Tax: $%.2f\n", stateTax);
  }
}
