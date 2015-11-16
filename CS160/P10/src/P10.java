// P10 Assignment
// Author: Connor Shea
// Date:   11/12/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/assignments/P10.html

public class P10 implements ImageInterface {
  
  PictureLibrary plObject = null;
  public int imageWidth = 0;
  public int imageHeight = 0;
  public int[][] imageData;

  public P10() {
    plObject = new PictureLibrary();
  }

  @Override
  public void readImage(String inFile) {
	  try {
			plObject.readPGM(inFile);
			imageWidth = plObject.getWidth();
			imageHeight = plObject.getHeight();
			imageData = plObject.getData();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
  }

  @Override
  public void writeImage(String outFile) {
	  try {
			plObject.setData(imageData);
			plObject.writePGM(outFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
  }

  @Override
  public int[][] imageData() {
	  return imageData;
  }

  @Override
  public void decode() {
      // Calling decode restores an image in which each pixel has had the upper four bits negated. To unscramble the image, your code should negate them again. You can use bitwise operators or the following algorithm: To get the upper bits, divide the pixel by 16. To get the lower bits, modulo the pixel by 16. The resulting upper and lower values should be in the range 0..15. Negate the upper bits as follows: upper = 15 - upper; Then put the bits back together by multiplying the upper bits by 16 and adding the result to lower. Here's an example for your testing:
      // original pixel = 115 = 0b01110011
      // upper value = 115 / 16 = 7 = 0b0111 (upper four bits of original)
      // lower value = 115 % 16 = 3 = 0b0011 (lower four bits of original)
      // negate upper value = 15 - 7 = 8 = 0b1000
      // new pixel = (upper * 16) + lower = (8 * 16) + 3 = 131 = 0b10000011


  }

  @Override
  public void swap() {
	  // TODO Auto-generated method stub

  }

  @Override
  public void mirror() {
    for (int i = 0; i < imageHeight; i++) {
      for (int j = 0; j < imageWidth; j++) {
        
      }
    }

  }

  @Override
  public void exchange() {
	  // TODO Auto-generated method stub

  }

}
