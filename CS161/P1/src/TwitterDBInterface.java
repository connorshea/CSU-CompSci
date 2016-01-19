/*
 * P1: Review of CS160 Material - Classes, Methods, Files, Arrays
 * Authors: Sudipto Ghosh and Asa Ben-Hur
 * Date: Jan 12th 2016
 *
 * The objective of this assignment is to refresh your knowledge of 
 * how to solve simple programming problems involving loops, arrays, 
 * methods, and files. Analysis of social media data is a major topic 
 * of research these days both in industry and academia. In this 
 * assignment we will focus on performing a simple analysis of tweets. 
 * 
 * Assumptions:
 * - There is at least one tweet. 
 * - Each tweet has at least one word.
 */

public interface TwitterDBInterface {

/*
 * populates the class with the tweets contained in the file given as input.
 * Argument: the file name where the tweets are stored.
 */
    public void loadTweets(String fileName);

/*
 * Returns the word that appears the largest number of times in the tweets
 * stored in the database.
 * Argument: None
 * Returns: the most common word
 */
    public String mostCommonWord();

/*
 * Computes the distribution of tweet lengths.
 * 
 */
    
    public int [] tweetLengths();

/*
 * computes the frequency of the given word in the database
 * Argument:  the word to be searched
 * Returns:  an integer which counts the number of occurrences 
 * of the given word in the database
 */
    public int frequency(String word);
}
