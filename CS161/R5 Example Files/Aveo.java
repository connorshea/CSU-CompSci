
public class Aveo extends Vehicle {

	protected int model;
	
	public Aveo(String color, int model) {
		super(color);
		this.model = model;
	}

	public String toString() {
		return "Aveo model #" + model + " " + super.toString();
	}
	
	public boolean equals(Object other) {
            if (!(other instanceof Aveo)) {
                return false;
            }
            return other != null && model == ((Aveo)other).model && super.equals(other);
	}
	
	public void move() {
		System.out.println("Aveo: driving");
	}
	
}
