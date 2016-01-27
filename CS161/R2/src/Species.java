public class Species {	

    // Put the instance variable here.
    public String name;
    public int population;
    public int growthRate;

    // Create a Species constructor that takes in a String for its name, an int for
    // its population, and an int for its growth rate per year as a percent.
    public Species(String constructorName, int constructorPopulation, int constructorGrowthRate) {
        name = constructorName;
        population = constructorPopulation;
        growthRate = constructorGrowthRate;

        if (population > 1500) {
            population = 1500;
        }

        if (population < 1) {
            population = 1;
        }

        if (growthRate > 20) {
            growthRate = 20;
        }

        if (growthRate < 1) {
            growthRate = 1;
        }
    }
    
    // mergeSpecies adds the populations of the two species, changes the name
    // of the species to the concatenation of the two names, and the growth
    // rate to the maximum of the two growth rates.
    public void mergeSpecies(Species other) {
        this.name += other.name;
        this.population += other.population;
        this.growthRate += other.growthRate;
        
        if (population > 1500) {
          population = 1500;
        }

        if (growthRate > 20) {
          growthRate = 20;
        }
    }

    public String toString(){
        String output = "Name of species: " + this.name + "\n";
        output += "Population: " + this.population + "\n";
        output += "Growth Rate: " + this.growthRate + "%\n";

        return output;
    }

    // Increases the population according to the growth rate of the species, i.e.
    // updates the population instance variable by adding to it the growth rate/100 times the current population.
    public void grow() {
        double tempPopulation = this.population * ((double)(100 + this.growthRate) / 100);
        
        this.population = (int) tempPopulation;
    }

    // Returns the population of the species in x years according to its growth rate.
    public int populationInXYears(int x) {
        double tempPopulation = this.population;
        
        // For every year, multiple the temporary population by (100% + x%)
        for (int i = 0; i < x; i++) {
            tempPopulation = (double)(tempPopulation + (tempPopulation * this.growthRate / 100));
        }

        return (int) tempPopulation;
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
