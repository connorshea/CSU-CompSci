// R5

import java.util.ArrayList;

public class Project {
  // An estimate of the number of lines of code the project will require
  public int linesOfCode;
  // The number of lines of code that have been written by the programmers
  // working on it.
  public int linesOfCodeWritten;
  // the number of lines of code that have been tested so far.
  public int linesOfCodeTested;
  // How many days managers have given for completion of the project.
  public int duration;
  // An ArrayList that stores the employees that are associated with the
  // project.
  public ArrayList<Employee> employees = new ArrayList<Employee>();

  // Constructor
  public Project(int linesOfCode, int duration) {
    this.linesOfCode = linesOfCode;
    this.duration = duration;
  }

  // Adds an employee to the employees ArrayList.
  public void addEmployee(Employee employee) {
    employees.add(employee);
  }

  // Returns the number of days past the deadline that the project has gone
  // on for (can be negative).
  public int doProject() {
    int daysPassed = 0;

    // While the lines of code that have been written and/or the lines of code
    // that have been tested are less than the required lines of code, the
    // employees will work another day.
    do {
      // OPTIONAL: If the project looks to be behind schedule, you can
      // opt to add extra programmers/testers.
      
      // If it's not the first day and the lines of code that have been
      // written each day times the duration of the project is less than
      // the required lines of code, add another programmer.
      if (daysPassed > 0 && ((linesOfCodeWritten / daysPassed) * duration) < linesOfCode) {
        addEmployee(new Programmer("ExtraProgrammer", employees.size() + 1, 100));
      }

      // If it's not the first day and the lines of code that have been
      // tested each day times the duration of the project is less than
      // the required lines of code, add another tester.
      if (daysPassed > 0 && ((linesOfCodeTested / daysPassed) * duration) < linesOfCode) {
        addEmployee(new Tester("ExtraTester", employees.size() + 1, 100));
      }

      // Loops through every employee and has them contribute either to the
      // lines of code written or tested depending on their class type.
      for (int i = 0; i < employees.size(); i++) {
        if (employees.get(i) instanceof Programmer) {
          linesOfCodeWritten += employees.get(i).work();
        } else {
          linesOfCodeTested += employees.get(i).work();
        }
      }
      // Iterates the number of days that have passed.
      daysPassed++;

      System.out.println("Number of employees: " + employees.size());
      System.out.println("Days passed: " + daysPassed);
      System.out.println("LOC Tested: " + linesOfCodeTested);
      System.out.println("LOC Written: " + linesOfCodeWritten);
      System.out.println("");
    } while (linesOfCodeWritten < linesOfCode || linesOfCodeTested < linesOfCode);

    return daysPassed - duration;
  }

  // Outputs info about each of the project's primitive instance variables,
  // and calls the toString() method for each employee.
  public String toString() {
    String returnString = "";

    returnString += "Employees: " + employees.toString() + "\n";
    returnString += "Duration: " + duration + " days \n";
    returnString += "LOC Estimated: " + linesOfCode + "\n";
    returnString += "LOC Tested: " + linesOfCodeTested + "\n";
    returnString += "LOC Written: " + linesOfCodeWritten + "\n";

    return returnString;
  }
  
  public static void main(String[] args) {
    // A project with an estimated size of 1000 LOCs and a deadline of four
    // days.
    Project project = new Project(1000, 4);

    // Add programmers and testers to the project.
    project.addEmployee(new Programmer("John", 1, 100));
    project.addEmployee(new Programmer("Jane", 2, 120));
    project.addEmployee(new Tester("Jim", 3, 100));
    project.addEmployee(new Tester("Judy", 4, 80));

    // project.toString()
    System.out.println(project);
    // Do the project.
    project.doProject();
    // project.toString()
    System.out.println(project);
  }
}
