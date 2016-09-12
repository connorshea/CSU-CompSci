public class MoneyMarketAccount {
  public MoneyMarketAccount(String id, double initialBalance) throws Exception {

  }

  // store how many deposits and withdrawals were performed
  private int numberOfTransactions;

  // the monthly rate is known to and provided by the caller. The method calculates the interest on the balance and adds the interest to the balance. The method returns the interest that was calculated.
  public double addInterest(double rate) {

  }
  
  // resets the number of transactions to zero. Note that the main method will take care of calling this method at the appropriate time and thus, the method implementation does not need to track months.
  public void resetNumberOfTransactions() {

  }
}
