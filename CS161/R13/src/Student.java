import java.util.Random;

public class Student implements Comparable<Student> {
	private String name;
	private int score;
	private boolean grad;

	public Student() {
		String[] firstNames = {"Andrew", "Thad", "Manny", "Ryan", "Bob", "Jane", "Jamie", "Sam", "Sarah",
				"Janie", "Adrian", "Tony", "Lisa", "Melissa", "Sandra"};
		String[] lastNames = {"Huffman", "Turing", "Dijkstra", "Johnston", "Cook", "Watts", "Newton",
				"Boole", "Hawking", "Freeman", "Walsh", "Richards", "Paul", "Estrada", "Perez", "Greer", "Hammond", "Smith", "Harrison", "Rivera", "Martin", 
			"Wood", "Thornton", "Singleton", "Grant", "Roberson", "Carpenter", "Ramirez", "Lindsey", "Ellis", "Hunt", "Craig", 
			"Williams", "Ward", "Newman", "Dixon", "Rodriquez", "Henderson", "Rios", "Carson", "Meyer", "Mcgee", "Hernandez", 
			"Mclaughlin", "Cook", "Fernandez", "Garcia", "Norman", "Ryan", "Watts", "Wheeler", "Snyder", "Nelson", "Bush", 
			"Holmes", "Hayes", "Lamb", "Lowe", "Alexander", "Obrien", "Simmons", "Allen", "Walker", "Fields", "Massey", 
			"Huff", "Francis", "Cruz", "Cortez", "Park", "Simon", "Chambers", "Patrick", "Mcbride", "Ball", "Robinson", 
			"Sutton", "Edwards", "Flowers", "Hardy", "Black", "Frank", "Floyd", "Figueroa", "Rogers", "Jacobs", "Price", 
			"Fletcher", "Cain", "Ross", "Watson", "Curry", "Harris", "Marshall", "Allison", "Hawkins", "Mullins", 
			"Gregory", "Buchanan", "Benson", "Cox", "Powers", "May", "Chandler", "Love", "Green", "Knight", "Henry", 
			"Barnett", "Willis"};;
		Random random = new Random();
		setName(lastNames[random.nextInt(lastNames.length)] + ", " + firstNames[random.nextInt(firstNames.length)]);
		setScore(random.nextInt(101));
		grad = random.nextBoolean();
	}
	
	public Student(String studentName, int score, boolean undergradStatus) {
		setName(studentName);
		setScore(score);
		grad = undergradStatus;
	}

	public void setName(String name) {
		if (name.length() == 0 || name == null) {
			this.name = "Unknown Student";
		} else {
			this.name = name;
		}
	}

	public void setScore(int score) {
		if (score < 0) {
			this.score = 0;
		} else if (score > 100) {
			this.score = 100;
		} else {
			this.score = score;
		}
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public boolean getGrad() {
		return grad;
	}

	public String toString() {
		String temp = "";
		temp += "Name: " + getName();
		temp += "\tScore: " + getScore();
		temp += "\tGrad? " + getGrad();
		return temp;
	}

	@Override
	public int compareTo(Student other) {
		if (grad == other.grad) {
			if (score - other.score != 0) {
				return score - other.score;
			} else {
				return name.compareTo(other.name);
			}
		} else {
			if (!grad) {
				return -1;
			} else {
				return 1;
			}
		}
	}

}
