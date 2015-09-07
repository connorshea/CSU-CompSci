// P4 Assignment
// Author: Connor Shea
// Date:   9/17/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Gross Salary: ");

        double grossSalary = inputScanner.nextDouble();

        System.out.print("Number of Exemptions: ");

        int numExemptions = inputScanner.nextInt();

        System.out.print("Interest Income: ");

        double interestIncome = inputScanner.nextDouble();

        System.out.print("Capital Gains: ");

        double capitalGains = inputScanner.nextDouble();

        double totalIncome = grossSalary + interestIncome + capitalGains;

        System.out.printf("Total Income: $%.2f\n", totalIncome);

        double adjustedIncome = totalIncome - (numExemptions * 1800);

        System.out.printf("Adjusted Income: $%.2f\n", adjustedIncome);


        // 0% - $0 - $12,000
        // 12% - $12,000 - $26,000
        // 23% - $26,000 - $38,500
        // 30% - above $38,500

        double totalTax = 0;

        if (adjustedIncome <= 12000) {
            totalTax = 0;
        } else if (adjustedIncome > 12000 && adjustedIncome <= 26000) {
            totalTax = (adjustedIncome - 12000) * 0.12;
        } else if (adjustedIncome > 2600 && adjustedIncome <= 38500) {
            totalTax = (adjustedIncome - 26000) * 0.23;
            totalTax += 0.12 * (26000 - 12000);
        } else if (adjustedIncome > 38500) {
            totalTax = (adjustedIncome - 38500) * 0.30;
            totalTax += 0.23 * (38500 - 26000);
            totalTax += 0.12 * (26000 - 12000);
        }

        System.out.printf("Total Tax: $%.2f\n", totalTax);

        double stateTax = adjustedIncome * 0.055;

        System.out.printf("State Tax: $%.2f\n", stateTax);

    }
}
