// P3 Assignment
// Author: Connor Shea
// Date:   9/8/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu

import java.util.Scanner;

public class P3 {
  public static void main(String[] args) {
    double       assign0,
                 assign1,
                 assign2,
                 assign3,
                    lab0,
                    lab1,
                    lab2,
                    lab3,
                   exam0,
                   exam1,
           assignAverage,
              labAverage,
             examAverage,
              classGrade;

    Scanner gradeScanner = new Scanner(System.in);

    System.out.print("First assignment: ");
    assign0 = gradeScanner.nextDouble();

    System.out.print("Second assignment: ");
    assign1 = gradeScanner.nextDouble();
    
    System.out.print("Third assignment: ");
    assign2 = gradeScanner.nextDouble();

    System.out.print("Fourth assignment: ");
    assign3 = gradeScanner.nextDouble();
    
    System.out.print("First lab: ");
    lab0 = gradeScanner.nextDouble();
    
    System.out.print("Second lab: ");

    lab1 = gradeScanner.nextDouble();

    System.out.print("Third lab: ");

    lab2 = gradeScanner.nextDouble();

    System.out.print("First exam: ");

    exam0 = gradeScanner.nextDouble();

    System.out.print("Second exam: ");

    exam1 = gradeScanner.nextDouble();

    assignAverage = ((assign0 + assign1 + assign2 + assign3) / 4);

    labAverage = ((lab0 + lab1 + lab2) / 3);

    examAverage = ((exam0 + exam1) / 2);

    classGrade = (assignAverage * 0.25) + (labAverage * 0.15) + (examAverage * 0.6);

    System.out.printf("Assignment average: %.2f\n", assignAverage);

    System.out.printf("Lab average: %.2f\n", labAverage);

    System.out.printf("Exam average: %.2f\n", examAverage);

    System.out.printf("Class total: %.2f\n", classGrade);
  }
}
