// Connor Shea
// Lab Section 2
// February 24, 2016

public abstract class Account {
	String id = "";
	protected double balance;
	
	public Account(String id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public String getID() {
		return id;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean equals(Object other) {
		if (other instanceof Account && ((Account) other).getID() == id) {
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		String returnString = "";
		returnString += "ID: " + id + "; ";
		returnString += "balance: $" + balance;
				
		return returnString;
	}
	
	public boolean hasLowerBalance(Account other) {
		if (other.getBalance() > this.getBalance()) {
			return true;
		} else {
			return false;
		}	
	}
	
	public abstract boolean deposit(double amount);
	public abstract boolean withdraw(double amount);
}
