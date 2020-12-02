//  Assignment
// Author: Tiffany Miao
// Date:   Mar 4, 2019
// Class:  CS163
// Email:  tmiao@rams.colostate.edu

public class Transforms implements ImageInterface {
	private PictureLibrary pic = null;
	int width = 0;
	int height = 0;
	int [][] imageData;
	
	public Transforms() {
		pic = new PictureLibrary();
	}
	
	public void readImage (String infile) {
		try {
			pic.readPGM(infile);
			
			height = pic.getHeight();
			width = pic.getWidth();
			imageData = pic.getData();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void writeImage (String outfile) {
		try {
			pic.setData(imageData);
			pic.writePGM(outfile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public int [][] imageData() {
		return imageData;
	}
	
	public void decode() {
		int origPix;
		int upper;
		int lower;

		
		for(int i=0; i < imageData.length;i++) {
			for (int j=0; j < imageData[i].length;j++) {
				origPix = imageData[i][j];
				upper = origPix / 16;
				lower = origPix % 16;
				upper = 15 - upper;
				imageData[i][j] = (upper * 16) + lower;
				
			}
		}
	}
	
	public void swap() {
		int origPix;
		int upper;
		int middle;
		int lower;
		int newPix;
		
		for(int i=0; i < imageData.length;i++) {
			for (int j=0; j < imageData[i].length;j++) {
				origPix = imageData[i][j];
				upper = origPix & 0b11000000;
				middle = origPix & 0b00111100;
				lower = origPix & 0b00000011;
				imageData[i][j] = (lower << 6) | middle | (upper >> 6);
			}
		}
	}
	
	public void mirror () {
		int[] temp;
		int left =0;
		int right = (imageData.length/2);
		
		for (left =0; left < right;left++) {
			temp = imageData[left];
			imageData[left] = imageData[imageData.length - left -1];
			imageData[imageData.length - left - 1] = temp;
			
		}
	}
	
	public void exchange() {
		for (int i =0; i < 300; i++) {
			for (int j =0; j < 200; j++) {
				int temp = imageData[20 + i][20 + j];
				imageData[20 + i][20 + j] = imageData[20 + i][280 + j];
				imageData[20 + i][280 + j] = temp;
			}
	}
}
}
