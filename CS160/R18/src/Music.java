// R18 Assignment
// Author: Connor Shea
// Date:   11/18/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/recitations/R18.html

public class Music {
  private String songTitle;
  private String albumName;
  private String artistName;
  private int releaseYear;

  // Constructor
  public Music(String title, String album, String artist, int year) {
    songTitle = title;
    albumName = album;
    artistName = artist;
    releaseYear = year;
  }

  // Accessor methods
  public String getTitle() {
    return songTitle;
  }

  public String getAlbum() {
    return albumName;
  }

  public String getArtist() {
    return artistName;
  }

  public int getYear() {
    return releaseYear;
  }

  public String toString() {
    String returnString = "";
    returnString += getTitle() + ", ";
    returnString += getAlbum() + ", ";
    returnString += getArtist() + ", ";
    returnString += getYear();
    return returnString;
  }

  public double getPrice() {
    double price;
    int year = getYear();

    if (year >= 2010) {
      price = 0.59;
    } else if (year >= 2000 && year <= 2009) {
      price = 1.39;
    } else if (year >= 1990 && year <= 1999) {
      price = 0.99;
    } else if (year >= 1980 && year <= 1989) {
      price = 0.69;
    } else if (year >= 1970 && year <= 1979) {
      price = 1.89;
    } else if (year < 1970) {
      price = 1.29;
    } else {
      price = 0.00;
    }

    return price;
  }
}
