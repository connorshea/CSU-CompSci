public class Stopwatch {
  private long start;
  private long stop;
  
  public void start() {
    start = System.currentTimeMillis(); // start timing
  	//start = System.nanoTime(); // start timing
  }
  
  public void stop() {
    stop = System.currentTimeMillis(); // stop timing
    //stop = System.nanoTime(); // stop timing
  }
  
  public long elapsedTimeMillis() {
    return stop - start;
  }
  
  public String toString() {
    return "elapsed time in milliseconds: " + Long.toString(elapsedTimeMillis()); // print execution time
  }

  /* example */
  public static void main(String[] args) {
    Stopwatch stopwatch = new Stopwatch();
    stopwatch.start();
    long f = fib(10);
    stopwatch.stop();
    System.out.println("fib(10) = " + f + "  " + stopwatch);

    stopwatch.start();
    f = fib(30);
    stopwatch.stop();
    System.out.println("fib(30) = " + f + "  " + stopwatch);

    stopwatch.start();
    f = fib(40);
    stopwatch.stop();
    System.out.println("fib(40) = " + f + "  " + stopwatch);

    stopwatch.start();
    f = fib(41);
    stopwatch.stop();
    System.out.println("fib(40) = " + f + "  " + stopwatch);

    stopwatch.start();
    f = fib(42);
    stopwatch.stop();
    System.out.println("fib(40) = " + f + "  " + stopwatch);
    
  }
    
  public static final long fib(int n) {
    if (n <= 2) {
      return 1;
    } else {
      return fib(n - 1) + fib(n - 2);
    }
  }
}
