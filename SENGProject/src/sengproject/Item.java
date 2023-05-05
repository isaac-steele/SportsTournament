package sengproject;


public class Item {
	/**
	 * item
	 */
	
	private int price;
	private int statValue;
	private String name;
	
	public String getName() {
		return name;
	}
	
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
