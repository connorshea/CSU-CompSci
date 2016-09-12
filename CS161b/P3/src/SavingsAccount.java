public class SavingsAccount {
  public SavingsAccount(String id, double initialBalance) throws Exception {

  }

  // The quarterly rate is provided as a percentage by the caller of the
  // method. The method calculates the interest on the balance and adds
  // the interest to the balance. The return value of the method is the
  // interest that was calculated (not the new balance, just the
  // interest). Note that the caller takes care of determining when
  // a month is over. The addInterest method only needs to be aware of
  // the formula to calculate interest (= balance*rate_in_percent/100.).
  // For example, if the quarterly rate of interest is 0.25%, and the
  // balance is $10,000, then the interest is $25, and the new balance
  // becomes $10,025.
  public double addInterest(double rate) {

  }

  public static void main(String[] args) {
    SavingsAccount a1 = null;
    
    try {
        a1 = new SavingsAccount ("ghosh", 2000.05);
    } catch(Exception e) {
        System.err.println(e);
    }
    
    try {
        a1.deposit(10);
    } catch (Exception e) {
        System.err.println(e);
    }

    double interest = a1.addInterest(0.75);
    System.out.println("Interest: " + interest);
    System.out.println("Remaining balance in " + a1.getID() + "'s account: $" + a1.getBalance());
  }
}
