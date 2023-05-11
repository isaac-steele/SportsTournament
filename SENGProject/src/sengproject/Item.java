package sengproject;
/**
 * An enum with three possible types of items.
 * Sets a default price and stat boost for each type
 * @author rsc103
 *
 */
public enum Item implements Purchasable {
	
	PROTEIN_SHAKE(3, 5, "Defence"), 
	ENERGY_DRINK(5,10, "Stamina"),
	KNEE_SLEEVE(4,5, "Offence");
	
	/**
	 * items price
	 */
	private int price;
	/**
	 * the items stat boost value
	 */
	private int statBoost;
	
	/**
	 * type of stat the item boosts
	 */
	private String stat;
	
	public String toString() {
		return this.name()+": Boosts a players "+getStat()+" by "+getStatBoost();
	}
	
	/**
	 * @return the stat type the item boosts
	 */
	public String getStat() {
		return stat;
	}

	/**
	 * @return the items price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @return the items stat boost
	 */
	public int getStatBoost() {
		return statBoost;
	}


	/**
	 * @param price
	 * @param statBoost
	 * default constructor for item
	 */
	Item(int price, int statBoost, String stat){
		this.price = price;
		this.statBoost = statBoost;
		this.stat = stat;
	}
}
