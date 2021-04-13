package dice;

import java.util.Random;

public class Dice {
	
	public static final int MAXVALUE = 6;
	private int faceValue = 0;

	private boolean isThrow;
	
	public Dice() {
		// TODO Auto-generated constructor stub
		setThrow(false);
		
	}
	
	public void randomDice() {
		setThrow(true);
		
	}
	
	 public void roll()
	    {
	        Random rand = new Random();
	        int rollNum = rand.nextInt(MAXVALUE) + 1;

	        faceValue = rollNum;
	        
	        setThrow(true);
	    }
	 
	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}

	public boolean isThrow() {
		return isThrow;
	}


	public void setThrow(boolean isThrow) {
		this.isThrow = isThrow;
	}

}
