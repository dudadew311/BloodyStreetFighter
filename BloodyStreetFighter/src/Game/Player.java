package Game;

public abstract class Player implements Max{
	
	private int level;
	
	public Player (int level) {
	this.level= level;
	}// end player constructor
	//abstract method
	public abstract int getHitpoints() ;

	public int getLevel() {
		return level;
	} //end level getter

	public void setLevel(int level) {
		this.level = level;
	} // end level setter
	
	public String toString() {
		return ("This Player has " + level + " level");
	} // end another useless to string
} // end Player class
