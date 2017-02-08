package Game;

public class BadGuy extends Player {
	private int hitpoints;
	private int maxHitpoints;
	
	// badGuy has what ever the level times 27 hitpoints
	
	public BadGuy(int level) {
		super(level);
		this.hitpoints = level * 27;
		this.maxHitpoints = level * 27;
	} // end badGuy constructor

	public int getHitpoints() {
		return hitpoints;
	} // end hitpoints getter

	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	} // end hitpoints setter
	
	public int getMaxHitpoints() {
		return maxHitpoints;
	} // end maxHitpoints getter

	public void setMaxHitpoints(int maxHitpoints) {
		this.maxHitpoints = maxHitpoints;
	} // end maxHitpoints setter

	public String toString() {
		return ("This bad guy is lvl " + super.getLevel() + " has " + getHitpoints() + " hitpoints");
	} // end useless toString
} //end BadGuy class
