public class CircleOfLife {

    public static void main(String args[]) {

        // Create a new Species object here, passing in the appropriate arguments
		Species turtle = new Species("Turtle", 100, 10);

        // Print out the species' growth rate

        System.out.println(turtle.growthRate);

        // Use the species' toString here
        System.out.println(turtle);
		
        // Call populationInXYears here
        turtle.populationInXYears(2);
        System.out.println(turtle);
		
        // Create a new Species object here, passing in the appropriate arguments
        // using a very large number for the population (e.g. 100000000)

        Species rabbit = new Species("Rabbit", 100000000, 10);

        // Print out the species' population to make sure it is set to 1500
        System.out.println(rabbit.population);

        // Call populationInXYears here, feel free to hardcode in the int to be passed to the method
        rabbit.populationInXYears(5);

        // Call mergeSpecies here. Test that mergeSpecies is doing what you expected it to
        rabbit.mergeSpecies(turtle);
        System.out.println(rabbit);
    }
}
