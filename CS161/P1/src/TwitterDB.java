// P1 TwitterDB
// Author: Connor Shea
// Date:   1/18/2016
// Class:  CS161
// Email:  coshea@cs.colostate.edu
// 

import java.io.IOException;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

public class TwitterDB implements TwitterDBInterface {
	private String[] tweets; // stores the tweets loaded from a file containing tweets.

	/*
	 * populates the class with the tweets contained in the file given as input.
	 * Argument: the file name where the tweets are stored.
	 */
	@Override
	public void loadTweets(String fileName) {
		// Creates a new File object from the fileName passed in.
		File file = new File(fileName);

		try {
			Scanner lineScanner = new Scanner(file); // file is an instance of class File

			int numberOfTweets = 0;
    
    	// Iterate through every line in the file and add 1 to the numberOfTweets
    	// variable each time.
			while (lineScanner.hasNextLine()) {
				lineScanner.nextLine();
				numberOfTweets++;
			}

			// Create the tweets array with the number of tweets we've determined are in the file.
			tweets = new String[numberOfTweets];

			lineScanner.close();
    } catch(IOException e) {
  		System.out.println(e);
    }

    // Another scanner for the same file, this time for populating the tweets
    // array with the actual tweets.
    try {
    	Scanner lineScanner2 = new Scanner(file);

    	for (int i = 0; i < tweets.length; i++) {
    		String line = lineScanner2.nextLine();
      
      	// Divide each line into 3 parts, with each tab character acting as
      	// a divider.
    		String[] parts = new String[3];
    		parts = line.split("\t"); // parts[2] (zero-indexed) will contain the tweet

    		tweets[i] = parts[2];
    	}
      
    	lineScanner2.close();
    } catch(IOException e) {
  		System.out.println(e);
    }

    System.out.println("Done loading tweets.");
	}

	/*
	 * Returns the word that appears the largest number of times in the tweets
	 * stored in the database.
	 * Argument: None
	 * Returns: the most common word
	 */
	@Override
	public String mostCommonWord() {

		int numberOfWords = 0;

		for (int i = 0; i < tweets.length; i++) {
		  Scanner s = new Scanner(tweets[i]);
		  s.useDelimiter("[ *\\-,!?.]+");
		  
		  // Add to numberOfWords variable for every word in every tweet.
		  while (s.hasNext()) {
				s.next();
		  	numberOfWords++;
		  }
		  
		  s.close();
	  }

	  System.out.println(numberOfWords);

	  String[] tweetWords = new String[numberOfWords];

	  int numberOfWords2 = 0;
	  
	  for (int i = 0; i < tweets.length; i++) {
		  
		  Scanner s = new Scanner(tweets[i]);
		  s.useDelimiter("[ *\\-,!?.]+");
		  
		  while (s.hasNext()) {
		  	String word = s.next();
			  word = word.toLowerCase();
			  tweetWords[numberOfWords2] = word;
		  	numberOfWords2++;
		  }
		  
		  s.close();
	  }
	  
	  System.out.println(Arrays.toString(tweetWords));

		return null;
	}

	/*
	 * Computes the distribution of tweet lengths.
	 * 
	 */
	@Override
	public int[] tweetLengths() {
		int[] tweetLengths = {0, 0, 0, 0, 0, 0, 0};

		for (int i = 0; i < tweets.length; i++) {
			int tweetLength = tweets[i].length();

      if (tweetLength >= 1 && tweetLength <= 20) {
      	tweetLengths[0] += 1;
      } else if (tweetLength >= 21 && tweetLength <= 40) {
      	tweetLengths[1] += 1;
      } else if (tweetLength >= 41 && tweetLength <= 60) {
      	tweetLengths[2] += 1;
      } else if (tweetLength >= 61 && tweetLength <= 80) {
      	tweetLengths[3] += 1;
      } else if (tweetLength >= 81 && tweetLength <= 100) {
      	tweetLengths[4] += 1;
      } else if (tweetLength >= 101 && tweetLength <= 120) {
      	tweetLengths[5] += 1;
      } else if (tweetLength >= 121 && tweetLength <= 140) {
      	tweetLengths[6] += 1;
      }
		}

		return tweetLengths;
	}

	/*
	 * computes the frequency of the given word in the database
	 * Argument:  the word to be searched
	 * Returns:  an integer which counts the number of occurrences 
	 * of the given word in the database
	 */
	@Override
	public int frequency(String word) {
		word = word.toLowerCase();

		int frequency = 0;

		for (int i = 0; i < tweets.length; i++) {
		  Scanner s = new Scanner(tweets[i]);
		  s.useDelimiter("[ *\\-,!?.]+");
			
		  while (s.hasNext()) {
		  	String thisWord = s.next();
			  thisWord = thisWord.toLowerCase();

			  if (thisWord.equals(word)) {
			  	frequency++;
			  }
			}
		}

		return frequency;
	}
	
	public static void main(String[] args) {
    TwitterDB tdb = new TwitterDB();
    tdb.loadTweets(args[0]);

    System.out.println(tdb.mostCommonWord());
    System.out.println(Arrays.toString(tdb.tweetLengths()));
    System.out.println(tdb.frequency("Radio"));
	}
}
