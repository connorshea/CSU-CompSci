// P3 Tweet
// Author: Connor Shea
// Date:   2/8/2016
// Class:  CS161
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs161/spring16/more_assignments/P3/P3.html

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tweet {
  // Stores the user ID (column 1 in tweets file)
  private String userID;
  // Convert the date-time string (column 2 in the tweets file) to a java.util.Date format
  private Date date;
  // Stores the tweeted message (column 3 in the tweets file)
  private String tweet;

  public Tweet(String userID, String dateTime, String tweet) {
	  this.userID = userID;
    this.tweet = tweet;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    try {
      this.date = sdf.parse(dateTime);
    } catch(ParseException e) {
      System.exit(0);
    }
  }

  public String getUserID() {
	  return userID;
  }

  public Date getDate() {
	  return date;
  }

  public String getTweet() {
	  return tweet;
  }

  public boolean isBefore(Tweet other) {
    return this.date.before(other.date);
  }

  public String toString() {;
	  return userID + "\t" + date.toString() + "\t" + tweet;
  }

  public boolean equals(Object other) {
    if (other instanceof Tweet && ((Tweet) other).getTweet().equals(this.tweet)) {
      return true;
    }

    return false;
  }

}
