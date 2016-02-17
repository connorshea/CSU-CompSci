public abstract class Employee {

  private String name;
  private int id;

  public Employee(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public abstract int work();

  public String toString() {
    return name + " ID: " + id;
  } 

  public boolean equals(Object other) {
  	if (other instanceof Employee && other != null) {
	    return (name.equals(((Employee)other).name) && id == ((Employee)other).id);
  	}

  	return false;
  }
}
