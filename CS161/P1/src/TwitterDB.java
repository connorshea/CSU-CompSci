// P1 TwitterDB
// Author: Connor Shea
// Date:   1/18/2016
// Class:  CS161
// Email:  coshea@cs.colostate.edu
// 

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
		File file = new File(fileName);

			Scanner lineScanner = new Scanner(file); // file is an instance of class File

		int numberOfTweets = 0;
    
    while (lineScanner.hasNextLine()) {
    	String line = lineScanner.nextLine();
    	numberOfTweets++;
    }

    tweets = new String[numberOfTweets];

    Scanner lineScanner2 = new Scanner(file);

    for (int i = 0; i < tweets.length; i++) {
    	String line = lineScanner2.nextLine();
      
      String[] parts = new String[3];
      parts = line.split("\t"); // parts[2] will contain the tweet

    	tweets[i] = parts[2];
    }

    for (int i = 0; i < tweets.length; i++) {
	    Scanner s = new Scanner(tweets[i]).useDelimiter("[ *\\-,!?.]+");
	    
	    while (s.hasNext()) {
	      String word = s.next();
	      word = word.toLowerCase();
	    }
	  }
	}

	/*
	 * Returns the word that appears the largest number of times in the tweets
	 * stored in the database.
	 * Argument: None
	 * Returns: the most common word
	 */
	@Override
	public String mostCommonWord() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Computes the distribution of tweet lengths.
	 * 
	 */
	@Override
	public int[] tweetLengths() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * computes the frequency of the given word in the database
	 * Argument:  the word to be searched
	 * Returns:  an integer which counts the number of occurrences 
	 * of the given word in the database
	 */
	@Override
	public int frequency(String word) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
    TwitterDB tdb = new TwitterDB();
    tdb.loadTweets("../tweets.txt");
    System.out.println(tdb.mostCommonWord());
    System.out.println(tdb.tweetLengths());
    System.out.println(tdb.frequency("Radio"));
	}
}
