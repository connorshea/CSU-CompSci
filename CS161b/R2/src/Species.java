public class Species {  

  // Put the instance variable here.

  public String name;
  public int population;
  public double growthRate;

  // Create a Species constructor that takes in a String for its name, an int for
  // its population, and an int for its growth rate per year as a percent.
  public Species(String name, int population, double growthRate) {
    this.name = name;
    this.population = population;
    this.growthRate = growthRate;

    if (this.population < 1) {
      this.population = 1;
    } else if (this.population > 1500) {
      this.population = 1500;
    }

    if (this.growthRate < 1) {
      this.growthRate = 1;
    } else if (this.growthRate > 20) {
      this.growthRate = 20;
    }
  }
  
  // mergeSpecies adds the populations of the two species, changes the name
  // of the species to the concatenation of the two names, and the growth
  // rate to the maximum of the two growth rates.

  public void mergeSpecies(Species other) {
    
    this.name = other.name + "" + this.name;
    this.population = this.population + other.population;

    if (other.growthRate > this.growthRate) {
      this.growthRate = other.growthRate;
    }
  }

  public String toString(){
    String output = "";
    output += "Name of species: " + this.name + "\n";
    output += "Population: " + this.population + "\n";
    output += "Growth Rate: " + this.growthRate + "\n";
    return output;
  }

  // Increases the population according to the growth rate of the species, i.e.
  // updates the population instance variable by adding to it the growth rate/100 times the current population.

  public void grow() {
    this.population = (int) (this.population * (1 + (this.growthRate / 100)));
  }

  // Returns the population of the species in x years according to its growth rate.

  public int populationInXYears(int x){
    for (int i = 0; i < x; i++) {
      this.grow();
    }

    return this.population;
  }

  public static void main(String[] args) {

    // Put simple code here to test the Species class.  It is always a good idea to include
    // a main method in any class you define.

    Species a = new Species("Frog", 100, 10);
    System.out.println(a);

    a.grow();
    System.out.println(a);

    System.out.println("a.populationInXYears(10) returns " + a.populationInXYears(10));

    Species b = new Species("Rabbit", 10, 23);
    a.mergeSpecies(b);
    System.out.println("a.mergeSpecies(b) is " + a);
    
  }
}
