public class Account {
  protected String id; // some form of account identification
  protected double balance; // stores the current balance

  public Account(String id, double initialBalance) {
    this.id = id;
    this.balance = initialBalance;
  }

  // The provided amount gets taken out of the account as a result of an ATM transaction. No transaction fees apply. Assume amount is greater than 0. You will declare the "throws Exception" clause even though the implementation will not throw "Exception". The subclasses might throw an Exception.
  public void withdraw(double amount) throws Exception {

  }

  // The provided amount is added to the account as a result of an ATM transaction. No transaction fees apply. Assume amount is greater than 0. You will declare the "throws Exception" clause even though the implementation will not throw "Exception". The subclasses might throw an Exception.
  public void deposit(double amount) throws Exception {

  }

  // Returns the account id.
  public String getID() {
    return this.id;
  }

  // Returns the current balance.
  public double getBalance() {
    return this.balance;
  }

  public static void main(String[] args) {
    Account a1 = new Account ("csclub", 200.05);
    
    try {
        a1.withdraw(10);
    } catch(Exception e) {
        System.err.println(e);
    }

    System.out.println("Remaining balance in " + a1.getID() + "'s account: $" + a1.getBalance());
  }
}
