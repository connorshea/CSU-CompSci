// R16 Assignment
// Author: Connor Shea
// Date:   11/11/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/recitations/R16.html

public class R16 implements RecitationInterface {
	
	PictureLibrary plObject = null;
	public int imageWidth = 0;
	public int imageHeight = 0;
	public int[][] imageData;
	
	public R16() {
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
	public void negateImage() {
		for (int i = 0; i < imageHeight; i++) {
			for (int j = 0; j < imageWidth; j++) {
				imageData[i][j] = PictureLibrary.MAXVAL - imageData[i][j];
			}
		}
	}

	@Override
	public void increaseContrast() {
		// subtracts 16 from pixels with 0 <= value <= 127 and adds 16 to pixels with 128 <= value <= MAXVAL.
		// Do not allow pixel values to overflow MAXVAL or become negative, i.e. clamp the pixels to 0 when
		// subtracting and MAXVAL when adding. Your TA will explain what is meant by clamping.
		
		for (int i = 0; i < imageHeight; i++) {
			for (int j = 0; j < imageWidth; j++) {
				if (imageData[i][j] >= 0 && imageData[i][j] <= 127) {
					if (imageData[i][j] - 16 < 0) {
						imageData[i][j] = 0;
					} else {
						imageData[i][j] -= 16;
					}
				} else if (imageData[i][j] >= 128 && imageData[i][j] <= PictureLibrary.MAXVAL) {
					if (imageData[i][j] + 16 > PictureLibrary.MAXVAL) {
						imageData[i][j] = PictureLibrary.MAXVAL;
					} else {
						imageData[i][j] += 16;
					}
				}
			}
		}
		
	}

	@Override
	public void decreaseContrast() {
		for (int i = 0; i < imageHeight; i++) {
			for (int j = 0; j < imageWidth; j++) {
				if (imageData[i][j] >= 0 && imageData[i][j] <= 127) {
					imageData[i][j] += 16;
				} else if (imageData[i][j] >= 128 && imageData[i][j] <= PictureLibrary.MAXVAL) {
					imageData[i][j] -= 16;
				}
			}
		}
	}
}
