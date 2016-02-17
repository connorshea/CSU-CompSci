
public class SignThenDriveEvent {

	public static void main(String[] args) {
		Vehicle v = new Vehicle("Red");
		System.out.println(v);
		
		Vehicle car = new Aveo("Black", 43234);
		System.out.println(car);
		
		if (v.equals(car)) {
			System.out.println("v equals car");
		} else {
			System.out.println("v !equals car");
		}
                
		v.move();
		car.move();

		SR71 sr71 = new SR71(20000);
		if (car.equals(sr71)) {
			System.out.println("car equals sr71");
		} else {
			System.out.println("car !equals sr71");
		}
		
	}

}
