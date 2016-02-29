// Connor Shea
// Lab Section 2
// February 24, 2016

import java.util.ArrayList;

public class CheckingAccount extends Account {
	public int numberOfChecksAvailable;
	
	public CheckingAccount(String id, double initialBalance, int numberOfChecksAvailable) {
		super(id, initialBalance);
		this.numberOfChecksAvailable = numberOfChecksAvailable; 
	}
	
	public int getNumberOfChecksAvailable() {
		return numberOfChecksAvailable;
	}

	@Override
	public boolean deposit(double amount) {
		if (super.getBalance() - 1 + amount > 0) {
			this.balance += amount - 1;
			return true;
		}
		
		System.out.println("I'm sorry, but I can't let you do that.");
		return false;
		
	}

	@Override
	public boolean withdraw(double amount) {
		if (super.getBalance() - 1.00 > amount) {
			this.balance -= amount + 1;
			return true;
		}
		
		System.out.println("I'm sorry, but I can't let you do that.");
		return false;
	}
	
	@Override
	public String toString() {
		String returnString = "";
		returnString += "ID: " + id + "; ";
		returnString += "balance: $" + super.getBalance() + "; ";
		returnString += "number of checks available: " + numberOfChecksAvailable;
		
		return returnString;
	}
	
	public boolean withdrawUsingCheck(double amount) {
		if (numberOfChecksAvailable > 0 && super.getBalance() > amount) {
			this.balance -= amount;
			numberOfChecksAvailable--;
			return true;
		}
		
		System.out.println("I'm sorry, but I can't let you do that.");
		return false;
	}
	
	public void replenishChecks(int numChecks) {
		numberOfChecksAvailable += numChecks;
	}
	
	public static void main(String[] args) {
		CheckingAccount c1 = new CheckingAccount("john", 10.0, 5);
		CheckingAccount c2 = new CheckingAccount("jane", 15.0, 5);
		CheckingAccount c3 = new CheckingAccount("jim", 20.0, 5);
		CheckingAccount c4 = new CheckingAccount("june", 25.0, 2);
		CheckingAccount c5 = new CheckingAccount("jay", 30.0, 5);
		
		c1.withdraw(11.0);
		c2.deposit(15.0);
		System.out.println(c2.getBalance());
		
		c3.withdraw(5.0);
		System.out.println(c3.getBalance());
		
		c4.withdrawUsingCheck(10);
		c4.withdrawUsingCheck(10);
		c4.withdrawUsingCheck(1);
		System.out.println(c4.getBalance());
		c4.replenishChecks(5);
		
		System.out.println(c5.getBalance());
		
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		accounts.add(c1);
		accounts.add(c2);
		accounts.add(c3);
		accounts.add(c4);
		accounts.add(c5);
		
		CheckingAccount c6 = new CheckingAccount("jonathan", 25.0, 10);
		
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).hasLowerBalance(c6)) {
				System.out.println(accounts.get(i));
			}
		}
		
		if ( accounts.contains( new CheckingAccount("john", 25.0, 10) ) ) {
			System.out.println("John has an account.");
		} else {
			System.out.println("John does not have an account.");
		}
	}
}
