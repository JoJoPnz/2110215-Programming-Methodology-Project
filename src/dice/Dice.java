package dice;

import java.util.Random;

public class Dice {
	
	public static final int MAXVALUE = 6;
	private int faceValue = 0;
	
	public Dice() {	
	}
	
	public void roll()
	    {
	        Random rand = new Random();
	        int rollNum = rand.nextInt(MAXVALUE) + 1;

	        faceValue = rollNum;

	    }
	 
	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
}
