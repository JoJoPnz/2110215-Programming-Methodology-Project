package property;

public abstract class Property {
	
	private boolean occupy;
	private int rent;
	
	public Property() {
		// TODO Auto-generated constructor stub
	}

	public boolean isOccupy() {
		return occupy;
	}

	public void setOccupy(boolean occupy) {
		this.occupy = occupy;
	}

	public int getRent() {
		// TODO Auto-generated method stub
		return this.rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}



}
