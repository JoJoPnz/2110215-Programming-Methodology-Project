package dice;

import java.util.Random;

public class Dice {
	
	public static final int MAXVALUE = 6;
	public static final int MINVALUE = 1;
	private int faceValue;
	
	public Dice() {	
	}
	
	public void roll()
	    {
	        Random random = new Random();
	        faceValue = random.nextInt(MAXVALUE) + 1;
	    }
	 
	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		if (faceValue > MAXVALUE) {
			this.faceValue = MAXVALUE;
		}
		else if (faceValue < MINVALUE) {
			this.faceValue = MINVALUE;
		}
		else {
			this.faceValue = faceValue;
		}
	}
}
