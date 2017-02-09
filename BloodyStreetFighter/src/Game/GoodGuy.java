package Game;

// TODO: Auto-generated Javadoc
/**
 * The Class GoodGuy.
 */
public class GoodGuy extends Player{

	/** The heals. */
	private int heals;
	
	/** The hitpoints. */
	private int hitpoints;
	
	/** The max hitpoints. */
	private int maxHitpoints; 
	
	// good guy has what ever the level times 25 hitpoints
	// good guy starts with 3 heals always
	
	/**
	 * Instantiates a new good guy.
	 *
	 * @param level the level
	 */
	public GoodGuy(int level){
		super(level);
		this.heals = 3;
		maxHitpoints = level * 25;
		hitpoints = level * 25;
	} // end good guy constructor

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

	/**
	 * Gets the heals.
	 *
	 * @return the heals
	 */
	public int getHeals() {
		return heals;
	} // end heals getter
	
	/**
	 * Sets the heals.
	 *
	 * @param heals the new heals
	 */
	public void setHeals(int heals) {
		this.heals = heals;
	} // end heals setter
	
	/* (non-Javadoc)
	 * @see Game.Player#getHitpoints()
	 */
	public int getHitpoints() {
		return hitpoints;
	} // end hitpoints getter

	/**
	 * Sets the hitpoints.
	 *
	 * @param hitpoint the new hitpoints
	 */
	public void setHitpoints(int hitpoint) {
		if (hitpoint > getMaxHitpoints() )
			this.hitpoints = getMaxHitpoints();
		else 
			this.hitpoints = hitpoint;
	} // hitpoints setter

	/* (non-Javadoc)
	 * @see Game.Player#toString()
	 */
	public String toString(){
		return ("This Player is level " + super.getLevel() + ", has " + getHitpoints());
	}// end useless toString
}//end goodGuy class
