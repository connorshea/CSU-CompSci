public class Programmer extends Employee {

  int linesOfCodePerDay;

  public Programmer(String name, int id, int linesOfCodePerDay) {
    super(name, id);
    this.linesOfCodePerDay = linesOfCodePerDay;
  }

  public int work() {
    // On a given day, a programmer can write between 50% and 150% of the
    // average linesOfCodePerDay.
    int linesOfCodeForToday = (int)(((0.50 + Math.random()) * linesOfCodePerDay));

    return linesOfCodeForToday;
  }
}
