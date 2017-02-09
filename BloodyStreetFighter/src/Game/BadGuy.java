package Game;

// TODO: Auto-generated Javadoc
/**
 * The Class BadGuy.
 */
public class BadGuy extends Player {
	
	/** The hitpoints. */
	private int hitpoints;
	
	/** The max hitpoints. */
	private int maxHitpoints;
	
	// badGuy has what ever the level times 27 hitpoints
	
	/**
	 * Instantiates a new bad guy.
	 *
	 * @param level the level
	 */
	public BadGuy(int level) {
		super(level);
		this.hitpoints = level * 27;
		this.maxHitpoints = level * 27;
	} // end badGuy constructor

	/* (non-Javadoc)
	 * @see Game.Player#getHitpoints()
	 */
	public int getHitpoints() {
		return hitpoints;
	} // end hitpoints getter

	/**
	 * Sets the hitpoints.
	 *
	 * @param hitpoints the new hitpoints
	 */
	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	} // end hitpoints setter
	
	/* (non-Javadoc)
	 * @see Game.Max#getMaxHitpoints()
	 */
	public int getMaxHitpoints() {
		return maxHitpoints;
	} // end maxHitpoints getter

	/**
	 * Sets the max hitpoints.
	 *
	 * @param maxHitpoints the new max hitpoints
	 */
	public void setMaxHitpoints(int maxHitpoints) {
		this.maxHitpoints = maxHitpoints;
	} // end maxHitpoints setter

	/* (non-Javadoc)
	 * @see Game.Player#toString()
	 */
	public String toString() {
		return ("This bad guy is lvl " + super.getLevel() + " has " + getHitpoints() + " hitpoints");
	} // end useless toString
} //end BadGuy class
