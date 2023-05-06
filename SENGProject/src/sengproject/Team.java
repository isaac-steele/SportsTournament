package sengproject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * This class contains the source code for the team/club interface 
 * This is where the player can manage the team
 * 
 * author @Reuben Schoonbee
 */
public class Team implements Purchasable {
	

	/**
	 * The teams name
	 */
	private String name;
	/**
	 * List of active players
	 */
	private ArrayList<Athlete> activeTeam;
	/**
	 * List of reserves
	 */
	private ArrayList<Athlete> reserves;
	/**
	 * The current amount of points the team has
	 * set to 0 initially
	 */
	private int points = 0;
	/**
	 * Current amount of money the team has
	 * set to 100 initially
	 */
	private int money = 100;
	/**
	 * List of items available for use
	 */
	private ArrayList<Item> inventory;
	/**
	 * A boolean that is true only when the reserves are full
	 * (when a player cannot be added to the team without replacing another)
	 */
	static boolean TeamFull;
	
	/**
	 * @return the money
	 */
	
	public Team(String name, ArrayList<Athlete> activeTeam) {
		setName(name);
		this.activeTeam = activeTeam;
	}
	/**
	 * @return the teams money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * @param money The money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * returns the team name
	 * @return name The name of team
	 */
	public String viewName() {
		return name;
	}
	
	/**
	 * sets team name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * returns list of active players on the team
	 * @ return activeTeam
	 */
	public ArrayList<Athlete> viewActiveTeam() {
		return activeTeam;
	}
	
	/**
	 * returns list of players on the bench
	 * @return reserves
	 */
	public ArrayList<Athlete> viewReserves() {
		return reserves;
	}
	
	/**
	 * returns list of items in inventory
	 * @return inventory
	 */
	public ArrayList<Item> viewItems(){
		return inventory;
	}
	
	/**
	 * returns a hash map of attribute type to attribute value for the given athlete
	 * @param Athlete The athlete
	 * @return properties The given athletes stats
	 */
	public HashMap<String, Integer> viewAthlete(Athlete athlete) {
		
		HashMap<String, Integer> properties = new HashMap();
		
		properties.put("Offence", athlete.getOffenceStat());
		properties.put("Defence", athlete.getDefenceStat());
		properties.put("Stamina", athlete.getStamina());
		return properties;
			
	}
	
	
	/**
	 * boosts the attribute of a given player with the property and value of a given item
	 * then removes the item from the inventory
	 * @param item The item to be used
	 * @param athlete The athlete to use the item on
	 */
	public void useItem(Item item, Athlete athlete) {
		
		
		switch(item) {
		case PROTEIN_SHAKE:
			athlete.setDefenceStat(athlete.getDefenceStat() - item.getStatBoost());
		case ENERGY_DRINK:
			athlete.setStamina(athlete.getStamina() - item.getStatBoost());
		case KNEE_SLEEVE:
			athlete.setOffenceStat(athlete.getOffenceStat() - item.getStatBoost());		
		}
		
		inventory.remove(item);
	}
	
	/**
	 * adds an item to the inventory
	 * @param item
	 */
	public void addItem(Item item) {
		inventory.add(item);
	}
	
	
	/**
	 * takes a reserve and an active player and adds the reserve to the active team and the active player to the reserves
	 * @param player Player to be put on team
	 * @param sub Player to be benched
	 */
	public void subAthlete(Athlete player, Athlete sub){
		
		activeTeam.remove(sub);
		activeTeam.add(player);
		reserves.remove(player);
		reserves.add(player);
	}
	
	/**
	 * Takes a new player and puts them on the reserves. 
	 * @param newPlayer
	 */
	public void addNewAthlete(Athlete newPlayer) {
		reserves.add(newPlayer);
		if (reserves.size() == 5) {
			TeamFull = true;
		}
		}
		
	/**
	 * removes given athlete from team
	 * @param athlete
	 */
	public void removeReserve(Athlete athlete) {
		
		activeTeam.remove(athlete);
			
	}
	
}
		
		
