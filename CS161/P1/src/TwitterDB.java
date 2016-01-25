// P1 TwitterDB
// Author: Connor Shea
// Date:   1/18/2016
// Class:  CS161
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs161/spring16/more_assignments/P1/P1.html

import java.io.IOException;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

public class TwitterDB implements TwitterDBInterface {
	// Stores the tweets loaded from a file containing tweets.
	private String[] tweets;

	/*
	 * Populates the class with the tweets contained in the file given as input.
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

		// Determines the number of words over all the tweets in the tweets array.
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

	  // Creates an array of Strings and an array of ints.
	  // They're the same size so the Strings map to the number of times they're
	  // found in the data we're provided.
	  String[] words = new String[numberOfWords];
	  int[] instancesOfWords = new int[numberOfWords];

	  // Set every element in the array to 0.
	  for (int i = 0; i < instancesOfWords.length; i++) {
	  	instancesOfWords[i] = 0;
	  }

	  // Iterator used to iterate through when a new unique word is added
	  // to the words array.
	  int iterator = 0;

	  // Goes through every tweet in the tweets array.
	  for (int i = 0; i < tweets.length; i++) {
		  Scanner s = new Scanner(tweets[i]);
		  s.useDelimiter("[ *\\-,!?.]+");

		  // While loop that goes through every word in the current tweet.
	    while (s.hasNext()) {
	  		String word = s.next();
	  		boolean unique = true;

	  		// Compares the String from the scanner with every String in the words
	  		// array. If they're the same, the "unique" variable is set to false
	  		// and the for loop is exited.
	  		for (int j = 0; j < words.length; j++) {
		  		if ( word.equals(words[j]) ) {
		  			instancesOfWords[j] += 1;
		  			unique = false;
		  			break;
		  		}
		  	}

		  	// If the for loop above goes through without finding a previous
		  	// match, the word is unique and should be given its own space in
		  	// the array of words.
		  	if (unique) {
			  	words[iterator] = word;
			  	instancesOfWords[iterator] += 1;
			  	iterator++;
			  }
	    }

	    s.close();
		}

		// Integer for storing the current biggest number in the instancesOfWords array.
		int currentBiggest = 0;
		// The index of the most frequent word.
		int mostFrequentWordIndex = -1;

		// Iterates through every element in the instancesOfWords array.
		for (int i = 0; i < instancesOfWords.length; i++) {
			// If the integer we're currently checking is a larger integer than the
			// one stored in the currentBiggest variable, replace the currentBiggest
			// variable with that integer and record the index of that integer in
			// the mostFrequentWordIndex variable for later use.
			if (currentBiggest < instancesOfWords[i]) {
				currentBiggest = instancesOfWords[i];
				mostFrequentWordIndex = i;
			}
		}

		// Returns the word in the words array that is located at the mostFrequentIndex.
		return words[mostFrequentWordIndex];
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
	 * Computes the frequency of the given word in the database
	 * Argument:  the word to be searched
	 * Returns:  an integer which counts the number of occurrences 
	 * of the given word in the database
	 */
	@Override
	public int frequency(String word) {
		word = word.toLowerCase();

		int frequency = 0;

		// Iterates through the tweets array.
		for (int i = 0; i < tweets.length; i++) {
		  Scanner s = new Scanner(tweets[i]);
		  s.useDelimiter("[ *\\-,!?.]+");
			
			// Iterates through every word in a given tweet.
		  while (s.hasNext()) {
		  	String currentWord = s.next();
			  currentWord = currentWord.toLowerCase();

			  // If the current word is equal to the word variable,
			  // up the frequency.
			  if (currentWord.equals(word)) {
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
