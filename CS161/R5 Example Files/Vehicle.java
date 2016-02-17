
public class Vehicle {
	protected String color;


	public Vehicle(String color) {
		this.color = color;
	}

	public String toString() {
		return "color: " + color;
	}

	public boolean equals(Object other) {
            if (!(other instanceof Vehicle)) {
                    return false;
		}
            return other != null && color.equals(((Vehicle)other).color);
	}
	
	public void move() {
		System.out.println("Vehicle: how do I move...?");
	}
}
