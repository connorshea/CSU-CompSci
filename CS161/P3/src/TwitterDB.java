// P3 TwitterDB
// Author: Connor Shea
// Date:   2/8/2016
// Class:  CS161
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs161/spring16/more_assignments/P3/P3.html

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class TwitterDB {
  private String comment;
  private ArrayList<Tweet> tweets; // describes the contents of the tweets database

  public TwitterDB(String comment) {
    this.comment = comment;
    tweets = new ArrayList<Tweet>();
  }

  public void addTweet(Tweet tweet) {
    tweets.add(tweet);
  }

  public int getNumberOfTweets() {
    return tweets.size();
  }

  public Tweet getTweet(int i) {
    return tweets.get(i);
  }

  public Tweet earliestTweet() {
    // Index of the earliest tweet.
    int earliestTweet = 0;

    for (int i = 0; i < tweets.size(); i++) {
      if ( tweets.get(i).getDate().before(tweets.get(earliestTweet).getDate()) ) {
        earliestTweet = i;
      }
    }

    if (tweets.isEmpty()) {
      return null;
    }

    return tweets.get(earliestTweet);
  }

  public TwitterDB tweetsBy(String userID) {
    String userComment = "tweets by " + userID;

    TwitterDB tweetsByUser = new TwitterDB(userComment);

    for (int i = 0; i < tweets.size(); i++) {
      if ( tweets.get(i).getUserID().equals(userID) ) {
        tweetsByUser.tweets.add(tweets.get(i));
      }
    }

    return tweetsByUser;
  }

  public TwitterDB tweetsBefore(String dateTime) {
    String timeComment = "tweets before " + dateTime;

    TwitterDB tweetsBefore = new TwitterDB(timeComment);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    Date dateTimeDate = new Date();
    
    try {
      dateTimeDate = sdf.parse(dateTime);
    } catch(ParseException e) {
      System.exit(0);
    }
    
    for (int i = 0; i < tweets.size(); i++) {
      if (tweets.get(i).getDate().before(dateTimeDate)) {
        tweetsBefore.addTweet(tweets.get(i));
      }
    }

    return tweetsBefore;
  }

  public TwitterDB tweetsBefore(Tweet tweet) {
    String tweetComment = "tweets before this tweet: " + tweet;

    TwitterDB tweetsBefore = new TwitterDB(tweetComment);

    for (int i = 0; i < tweets.size(); i++) {
      if (tweets.get(i).getDate().before(tweet.getDate())) {
        tweetsBefore.addTweet(tweets.get(i));
      }
    }

    return tweetsBefore;
  }

  public String toString() {
    String returnString = "";

    returnString += comment + "\n";
    
    for (int i = 0; i < tweets.size(); i++) {
      returnString += tweets.get(i).toString() + "\n";
    }

    return returnString;
  }

  public String whoTweetedThat(String tweet) {
    for (int i = 0; i < tweets.size(); i++) {
      if (tweets.get(i).getTweet().equals(tweet)) {
        return tweets.get(i).getUserID();
      }
    }

    return null;
  }

  public static void main(String[] args) {
    TwitterDB tdb = new TwitterDB("These are tweets.");

    File file = new File("tweets.txt");

    try {
      Scanner lineScanner = new Scanner(file);
    
      // Iterate through every line in the file and add 1 to the numberOfTweets
      // variable each time.
      while (lineScanner.hasNextLine()) {
        String line = lineScanner.nextLine();
        String[] parts = new String[3];
        parts = line.split("\t"); // parts[2] (zero-indexed) will contain the tweet
        Tweet tweet = new Tweet(parts[0], parts[1], parts[2]);
        tdb.addTweet(tweet);
      }

      lineScanner.close();
    } catch(IOException e) {
      System.out.println(e);
    }
    
    System.out.println(tdb.toString());

    System.out.println(tdb.whoTweetedThat("superstar "));
    
    System.out.println(tdb.tweetsBy("USER_b98a9e78"));

    Tweet t = tdb.earliestTweet();
    System.out.println("Earliest tweeted message: " + t.getTweet());

    System.out.println(tdb.tweets.get(0));
  }
}
