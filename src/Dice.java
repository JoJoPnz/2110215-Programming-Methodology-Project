
import java.util.Random;

public class Dice {
	
	public static final int MAXVALUE = 6;
	public static final int  NUMDICE = 2;
	private int firstValue = 0;
	private int secondValue = 0; 

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

	        Random rand2 = new Random();
	        int rollNum2 = rand2.nextInt(MAXVALUE) + 1;
	        
	        firstValue = rollNum;
	        secondValue = rollNum2;
	        
	        setThrow(true);
	    }
	 
	public int getFirstValue() {
		return firstValue;
	}

	public int getSecondValue() {
		return secondValue;
	}

	public void setFirstValue(int firstValue) {
		this.firstValue = firstValue;
	}

	public void setSecondValue(int secondValue) {
		this.secondValue = secondValue;
	}

	public boolean isThrow() {
		return isThrow;
	}


	public void setThrow(boolean isThrow) {
		this.isThrow = isThrow;
	}

}
