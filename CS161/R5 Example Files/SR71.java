
public class SR71 extends Vehicle {

	protected int flightHours;
	
	public SR71(int flightHours) {
		super("Black");
		this.flightHours = flightHours;
	}
	
	public boolean equals(Object other) {
            if (!(other instanceof SR71)) {
                return false;
            }
            return other != null && flightHours == ((SR71)other).flightHours && super.equals(other);
	}
	
	public String toString() {
		return "SR-71 Blackbird flight hours: " + flightHours + " " + super.toString();
	}
	
	public void move() {
		System.out.println("SR-71 Blackbird: ZOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOM");
	}
	
}
