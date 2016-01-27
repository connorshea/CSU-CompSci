public class CircleOfLife {

    public static void main(String args[]) {

    // Create a new Species object here, passing in the appropriate arguments
		Species dog = new Species("Dog", 10, 5);

        // Print out the species' growth rate
        System.out.println(dog.growthRate);

        // Use the species' toString here
        System.out.println(dog);
		
        // Call populationInXYears here
        dog.populationInXYears(5);
		
        // Create a new Species object here, passing in the appropriate arguments
        // using a very large number for the population (e.g. 100000000)
        Species cat = new Species("Cat", 999999, 10);

        // Print out the species' population to make sure it is set to 1500
        System.out.println(cat.population);

        // Call populationInXYears here, feel free to hardcode in the int to be passed to the method
        cat.populationInXYears(5);
        System.out.println(cat.population);

        // Call mergeSpecies here. Test that mergeSpecies is doing what you expected it to
        cat.mergeSpecies(dog);
        System.out.println(cat);
    }
}
