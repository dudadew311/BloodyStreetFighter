package Game;

public class GoodGuy extends Player{

	private int heals;
	private int hitpoints;
	private int maxHitpoints; 
	
	// good guy has what ever the level times 25 hitpoints
	// good guy starts with 3 heals always
	
	public GoodGuy(int level){
		super(level);
		this.heals = 3;
		maxHitpoints = level * 25;
		hitpoints = level * 25;
	} // end good guy constructor

	public int getMaxHitpoints() {
		return maxHitpoints;
	} // end maxHitpoints getter

	public void setMaxHitpoints(int maxHitpoints) {
		this.maxHitpoints = maxHitpoints;
	} // end maxHitpoints setter

	public int getHeals() {
		return heals;
	} // end heals getter
	
	public void setHeals(int heals) {
		this.heals = heals;
	} // end heals setter
	
	public int getHitpoints() {
		return hitpoints;
	} // end hitpoints getter

	public void setHitpoints(int hitpoint) {
		if (hitpoint > getMaxHitpoints() )
			this.hitpoints = getMaxHitpoints();
		else 
			this.hitpoints = hitpoint;
	} // hitpoints setter

	public String toString(){
		return ("This Player is level " + super.getLevel() + ", has " + getHitpoints());
	}// end useless toString
}//end goodGuy class
