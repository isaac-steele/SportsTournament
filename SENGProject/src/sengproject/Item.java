package sengproject;

/**
 * class for an individual item objects. 
 * @author rsc103
 *
 */
public class Item {
	
	/**
	 * price of item
	 */
	private int price;
	/**
	 * amount an athletes stat is boosted by
	 */
	private int statValue;
	/**
	 * items name, either protein shake, energy drink or knee sleeve
	 */
	private String name;
	
	public void Item(int price, int statValue, )
	/**
	 * @return name of item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name Name to be given to item
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getStatValue() {
		return statValue;
	}

	public void setStatValue(int statValue) {
		this.statValue = statValue;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
