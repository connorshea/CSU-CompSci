// P2 TwitterDB
// Author: Connor Shea
// Date:   1/31/2016
// Class:  CS161
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs161/spring16/more_assignments/P2/P2.html

import java.io.IOException;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class TwitterDB {
  private Tweet[] tweets = new Tweet[0]; // Stores all the tweets, initially there are none
  private int numberOfTweets = 0; // Stores the number of tweets in the tweets array

  public TwitterDB(String fileName) {
    // Creates a new File object from the fileName passed in.
    File file = new File(fileName);

    int numTweets = 0;

    try {
      Scanner lineScanner = new Scanner(file);
    
      // Iterate through every line in the file and add 1 to the numberOfTweets
      // variable each time.
      while (lineScanner.hasNextLine()) {
        lineScanner.nextLine();
        numTweets++;
      }

      lineScanner.close();
    } catch(IOException e) {
      System.out.println(e);
    }

    // Another scanner for the same file, this time for populating the tweets
    // array with the actual tweets.
    try {
      Scanner lineScanner2 = new Scanner(file);

      for (int i = 0; i < numTweets; i++) {
        String line = lineScanner2.nextLine();
      
        // Divide each line into 3 parts, with each tab character acting as
        // a divider.
        String[] parts = new String[3];
        parts = line.split("\t"); // parts[2] (zero-indexed) will contain the tweet

        Tweet tweet = new Tweet(parts[0], parts[1], parts[2]);

        addTweet(tweet);
      }
      
      lineScanner2.close();
    } catch(IOException e) {
      System.out.println(e);
    }
  }

  public void addTweet(Tweet tweet) {
    // Create a temporary array of tweets.
    Tweet[] tempTweets = new Tweet[numberOfTweets + 1];

    // Copy every element in the current tweets array over to the temporary
    // array.
    for (int i = 0; i < tweets.length; i++) {
      tempTweets[i] = tweets[i];
    }

    // Add the new tweet to the last element of the array.
    // (Zero-indexed, so numberOfTweets is the index of the last element.)
    tempTweets[numberOfTweets] = tweet;

    // Replace tweets with tempTweets.
    tweets = tempTweets;

    // Increment numberOfTweets now that there's an additional tweet in the array.
    numberOfTweets++;
  }

  public int getNumberOfTweets() {
    return numberOfTweets;
  }

  public Tweet earliestTweet() {
	  int earliestTweet = 0;
    
    for (int i = 0; i < tweets.length; i++) {
      if (tweets[i].getDate().before(tweets[earliestTweet].getDate())) {
        earliestTweet = i;
      }
    }

    return tweets[earliestTweet];
  }

  public Tweet[] tweetsBy(String userID) {
    ArrayList<Tweet> tweetsByUser = new ArrayList<Tweet>();

    for (int i = 0; i < tweets.length; i++) {
      if (tweets[i].getUserID().equals(userID)) {
        tweetsByUser.add(tweets[i]);
      }
    }
    
    Tweet[] tweetsByUserArray = tweetsByUser.toArray(new Tweet[tweetsByUser.size()]);
    
    return tweetsByUserArray;
  }

  public Tweet[] tweetsBefore(String dateTime) {
    ArrayList<Tweet> tweetsBefore = new ArrayList<Tweet>();

    Date dateTimeDate = Date.parse(dateTime);
    
    for (int i = 0; i < tweets.length; i++) {
      if (tweets[i].getDate().before(dateTimeDate)) {
        tweetsBefore.add(tweets[i]);
      }
    }
    
    Tweet[] tweetsBeforeArray = tweetsBefore.toArray(new Tweet[tweetsBefore.size()]);

    return tweetsBeforeArray;
  }

  public Tweet[] tweetsBefore(Tweet tweet) {
	  ArrayList<Tweet> tweetsBefore = new ArrayList<Tweet>();

    for (int i = 0; i < tweets.length; i++) {
      if (tweets[i].getDate().before(tweet.getDate())) {
        tweetsBefore.add(tweets[i]);
      }
    }
    
    Tweet[] tweetsBeforeArray = tweetsBefore.toArray(new Tweet[tweetsBefore.size()]);

    return tweetsBeforeArray;
  }

  public Tweet getTweet(int i) {
    return tweets[i];
  }

  public String toString() {
	  String returnString = "";
    
    for (int i = 0; i < numberOfTweets; i++) {
      returnString += tweets[i].getUserID() + " " + tweets[i].getDate() + " " + tweets[i].getTweet() + "\n";
    }

    return returnString;
  }

  public static void main(String[] args) {
    TwitterDB tdb = new TwitterDB("tweets.txt"); 
    
    System.out.println(tdb.toString());

    Tweet t = tdb.earliestTweet();
    System.out.println("Earliest tweeted message: " + t.getTweet());
    
    Tweet[] tweets = tdb.tweetsBy("USER_989b85bb");
    System.out.println("Number of tweets by USER_989b85bb: " + tweets.length);

    tweets = tdb.tweetsBefore("2010-03-07T18:26:13");
    System.out.println("Number of tweets before 2010-03-07T18:26:13: " + tweets.length);

    tweets = tdb.tweetsBefore(tdb.tweets[0]);
    System.out.println("Number of tweets before test tweet: " + tweets.length);
  }

}
