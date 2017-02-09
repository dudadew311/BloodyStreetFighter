package Game;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public abstract class Player implements Max{
	
	/** The level. */
	private int level;
	
	/**
	 * Instantiates a new player.
	 *
	 * @param level the level
	 */
	public Player (int level) {
	this.level= level;
	}// end player constructor
	
	/**
	 * Gets the hitpoints.
	 *
	 * @return the hitpoints
	 */
	//abstract method
	public abstract int getHitpoints() ;

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	} //end level getter

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(int level) {
		this.level = level;
	} // end level setter
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ("This Player has " + level + " level");
	} // end another useless to string
} // end Player class
