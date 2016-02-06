public class Animal {
	private String name;
	private int topSpeed;

	// Create a constructor that takes in a String for the name and an int for the topSpeed
	// Use only the setters initialize the instance variables
	public Animal(String name, int topSpeed) {
		this.name = name;
		this.topSpeed = topSpeed;
	}

	// Create the getters and setters for the instance variables
  // There is a shortcut by hovering over the variable names
	public String getName() {
		return name;
	}

	// Gets the top speed of the Animal.
	public int getTopSpeed() {
		return topSpeed;
	}

	// Sets the name of the Animal.
	public void setName(String _name) {
		name = _name;
	}

	// For the setter associated with topSpeed make sure the values are between 0 and 70
  // Raise an exception if it is not within these values.
	public void setTopSpeed(int _topSpeed) throws Exception {
		if (_topSpeed <= 70 && _topSpeed >= 0) {
			topSpeed = _topSpeed;
		} else {
			throw new Exception("Top speed out of bounds.");
		}
	}

  // Create an equals(Object other) method that returns True if the two Animal objects have 
	// Top speeds that are within 2 mph of each other
	public boolean equals(Object other) {
		Animal otherAnimal = (Animal) other;

		// If (Animal1 - Animal2) or (Animal2 - Animal1) is less than or equal to
		// 2 and greater than or equal to -2, then return true.
		if ((topSpeed - otherAnimal.topSpeed <= 2 && topSpeed - otherAnimal.topSpeed >= -2) || (otherAnimal.topSpeed - topSpeed <= 2 && otherAnimal.topSpeed - topSpeed >= -2)) {
			return true;
		}

		return false;
	}
	
	// Create a toString method
	// Formatting of the returned String should follow this example:
	// Name: elephant     Top Speed: 25
	public String toString() {
		String returnString = "Name: ";

		returnString += name;
		returnString += " Top Speed: ";
		returnString += topSpeed;

		return returnString; 
	}
}
