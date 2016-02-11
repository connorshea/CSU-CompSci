import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

/**
 * Loads tweets from a file and processes them
 */
public class TwitterDB {
  //instance variables
  private String[] tweets; // contains the text for each tweet loaded from file
  private String[] wordArray; // contains each unique word occurring in the tweets
  private int[] countArray; // contains the count of each word in wordArray
  private Random r; // random number generator used for this class


  /**
   * Create a TwitterDB object
   */
  public TwitterDB() {
    // Instantiate the random number generator
    this.r = new Random();
  }

  /**
   * loads tweets from a file and populates tweets instance variable with them.
   * Must be called before any other methods.
   * @param fileName: name of the file containing Tweets
   */
  public void loadTweets(String fileName) {
    int nTweets = 0; 
    File f = new File(fileName);
    Scanner lineScanner;

    // Open and read through file to count tweets
    try {
      lineScanner = new Scanner(f);

      while ( lineScanner.hasNextLine() ){
        lineScanner.nextLine();
        nTweets++;
      }

      lineScanner.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Instantiate tweets
    this.tweets = new String[nTweets];

    try {
      lineScanner = new Scanner(f);
      
      // Read all tweets into array
      for (int i = 0; i < nTweets; i++) {
        String tweetLine = lineScanner.nextLine();
        tweets[i] = tweetLine.split("\t")[2]; // assumes no tabs in tweet 
      }

      lineScanner.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Returns the word with the highest frequency across all tweets
   * @return the word with the highest frequency
   */
  public String mostCommonWord() {
    // Count all words if it has not already been done
    if (this.wordArray == null) {
      countAllWords();
    }

    // Search countArray for highest count
    return getHighestCountWord();
  }

  /**
   * returns the distribution of tweets lengths for the bins:
   * 1-20, 21-40, 41-60, 61-80, 81-100, 101-120, 121-140
   * @return distribution array containing the counts for each bin
   */
  public int[] tweetLengths() {
    int[] distribution = {0, 0, 0, 0, 0, 0};
    
    for (int i = 0; i < this.tweets.length; i++) {
      int bin = (int)Math.floor( (this.tweets[i].length() - 1) / 20);
      distribution[bin] = bin;
    }
    
    return distribution;
  }

  /**
   * Returns the frequency of a word across all tweets
   * @param word: the word which frequency to return
   * @return the frequency of that word
   */
  public int frequency(String word) {
    // Count all words if it has not already been done
    if (this.wordArray == null) {
      countAllWords();
    }

    // Get the count of the passed word
    return getCount(word);
  }

  /**
   * Returns a random tweet from the database
   * @return a random tweet from the database
   */
  public String randomTweet() {
    // Pick an index from the tweets array
    int tweetIndex = r.nextInt(tweets.length);
    
    // Return the tweet at that index
    return this.tweets[tweetIndex];
  }

  /**
   * Generates a gibberish tweet using words from the twitter database
   * The end of the gibberish tweet will be padded with some number of exclamation points
   * @param maxLen: length of the generated tweet
   * @return a gibberish tweet
   */
  public String gibberishTweet(int len) {
    // Select a random word from wordArray to start
    String word;
    
    do {
      System.out.println("Test1");
      word = wordArray[r.nextInt(wordArray.length - 1)];
    } while (word.equals(null));

    String newTweet = "";

    // Add random words until the tweet is close to max size
    do {
      System.out.println("Test2");
      newTweet += word + " ";

      do {
        word = wordArray[r.nextInt(wordArray.length - 1)];
        System.out.println("Test3");
      } while (word == null);

    } while (newTweet.length() + word.length() < len);
    
    // Pad the end with exclamation points
    for (int i = newTweet.length(); i < len; i++) {
      newTweet += "!";
    }
    
    return newTweet;
  }

  /**
   * Makes a tweet with a set of consecutive o's
   * @param len: number of consecutive o's to include in the tweet
   * @return a tweet which is a shout out to all my bros
   */
  public String broTweet(int len) {
    // Make sure overall length is less than 140
    len = Math.max(len, 140 - 19);
    return "I love climbing br" + makeSomeOs(len) + "!";
  }

  private String makeSomeOs(int numberOfOs) {
    String returnString = "";
    
    for (int i = 0; i < numberOfOs; i++) {
      returnString += "o";
    }
    
    return returnString;
  }

  /**
   * Helper method that determines the frequency of each word in the database
   * Stores each unique word in wordArray and the count in countArray under the same index
   */
  private void countAllWords() {
    // Count number of words, will instantiate arrays to that size.
    int maxWords = 0;
    Scanner s;

    for (int i = 0; i < this.tweets.length; i++) {
      s = new Scanner(tweets[i]).useDelimiter("[ *\\-,!?.]+");

      while (s.hasNext()) {
        s.next();
        maxWords++;
      }

      s.close();
    }

    // Instantiate arrays
    this.wordArray = new String[maxWords];
    this.countArray = new int[maxWords];

    for (int i = 0; i < maxWords; i++) {
      countArray[i] = 0;
    }

    // Process each word in each tweet
    for (int i = 0; i < this.tweets.length; i++) {
      s = new Scanner(tweets[i]).useDelimiter("[ *\\-,!?.]+");

      while (s.hasNext()) {
        String word = s.next();
        processWord(word);
      }

      s.close();
    }
  }

  /**
   * Helper method that processes a single word by adding it to wordArray if necessary
   * and incrementing its count in countArray.
   * @param word: word to process
   */
  private void processWord(String word) {
    String wordLower = word.toLowerCase();

    for (int i = 0; i < this.wordArray.length; i++) {
      // If wordArray[i] is null then this word is not in the word array yet, so put it in
      if (this.wordArray[i] == null) {
        this.wordArray[i] = wordLower;
        this.countArray[i] = 1;
        return;
      } else if (this.wordArray[i].equals(wordLower)) {
        // The word already exists in the array and increments its count in countArray
        this.countArray[i]++;
        return;
      }
    }
  }

  /**
   * Helper method that searches countArray for the highest value and returns the corresponding word from wordArray
   * Assumes wordArray and countArray are already populated
   * @return the word with the highest frequency
   */
  private String getHighestCountWord() {
    int maxCount = 0;
    int maxIndex = 0;

    for (int i = 0; i < this.wordArray.length; i++) {
      if (this.wordArray[i] == null) { // we have reached end of list of words, so return the word with the highest count
        break;
      } else {
        if (countArray[i] > maxCount) {
          maxCount = countArray[i];
          maxIndex = i;
        }
      }
    }

    return wordArray[maxIndex];
  }

  /**
   * Helper method that returns the count of the given word
   * Assumes wordArray and countArray are already populated
   * @return the frequency of the passed word
   */
  private int getCount(String word) {
    int count = 0;

    for (int i = 0; i < this.wordArray.length; i++) {
      if (this.wordArray[i] == null) {
        // Have reached end of list of words, so word is not contained in the list
        break;
      } else if (this.wordArray[i] == word) {
        count++;
      }
    }

    return count;
  }

  /**
   * Main method used for testing the TwitterDB class
   */
  public static void main(String args[]) {
    //setup twitter database
    TwitterDB tdb = new TwitterDB();
    tdb.loadTweets("tweets.txt");

    //print some statistics about the database
    System.out.println(String.format("The most common word is: %s", tdb.mostCommonWord()));
    System.out.println(String.format("It has a frequency of: %d", tdb.frequency(tdb.mostCommonWord())));
    System.out.println(String.format("The distribution of tweets is: %s", Arrays.toString(tdb.tweetLengths())));
    System.out.println();

    //print out some random tweets from the database
    System.out.println(String.format("Random tweet 1: %s", tdb.randomTweet()));
    System.out.println(String.format("Random tweet 2: %s", tdb.randomTweet()));
    System.out.println(String.format("Random tweet 3: %s", tdb.randomTweet()));
    System.out.println();

    //generate some gibberish tweets 
    System.out.println(String.format("Gibberish tweet 1: %s", tdb.gibberishTweet(30)));
    System.out.println(String.format("Gibberish tweet 2: %s", tdb.gibberishTweet(50)));
    System.out.println(String.format("Gibberish tweet 3: %s", tdb.gibberishTweet(40)));
    System.out.println();

    //generate some bro tweets 
    System.out.println(String.format("Bro tweet 1: %s", tdb.broTweet(0)));
    System.out.println(String.format("Bro tweet 2: %s", tdb.broTweet(1)));
    System.out.println(String.format("Bro tweet 3: %s", tdb.broTweet(2)));
    System.out.println(String.format("Bro tweet 4: %s", tdb.broTweet(10)));
  }
}
