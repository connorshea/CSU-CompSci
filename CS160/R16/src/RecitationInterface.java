// RecitationInterface.java
// Interface for imaging program
// Chris Wilcox
// 11/16/2014

public interface RecitationInterface {

	// Read the image
	public void readImage(String inFile);

	// Write the image
	public void writeImage(String outFile);

	// Get image data
	public int[][] imageData();

	// Negates a black and white image
	public void negateImage();

	// Increases the contrast in an image
	public void increaseContrast();

	// Decreases the contrast in an image 
	public void decreaseContrast();
}


