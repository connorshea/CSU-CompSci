public class Tester extends Employee {

  int linesOfCodeTestedPerDay;

  public Tester(String name, int id, int linesOfCodeTestedPerDay) {
    super(name, id);
    this.linesOfCodeTestedPerDay = linesOfCodeTestedPerDay;
  }
  
  public int work() {
    // A random number between 75% and 125% of linesOfCodeTestedPerDay
    int linesOfCodeForToday = (int)(((0.75 + (Math.random() / 2)) * linesOfCodeTestedPerDay));

    return linesOfCodeForToday;
  }

}
