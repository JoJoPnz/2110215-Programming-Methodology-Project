
public class Dice {
	
	public static final int MAXVALUE = 6;
	public static final int  NUMDICE = 2;

	private boolean isThrow;
	
	public Dice() {
		// TODO Auto-generated constructor stub
		setThrow(false);
		
	}
	
	public void randomDice() {
		setThrow(true);
		
	}
	

	public boolean isThrow() {
		return isThrow;
	}


	public void setThrow(boolean isThrow) {
		this.isThrow = isThrow;
	}

}
