package sengproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class contains the source code for the team/club interface 
 * This is where the player can manage the team
 * 
 * author @Reuben Schoonbee
 */
public class Team {
	

	/**
	 * The teams name
	 */
	private String name;
	/**
	 * List of active players
	 */
	private List<Athlete> activeTeam;
	/**
	 * List of reserves
	 */
	private List<Athlete> reserves;
	/**
	 * The current amount of points the team has
	 */
	private int points;
	/**
	 * Current amount of money the team has
	 */
	private int money;
	/**
	 * List of items available for use
	 */
	private List<Item> inventory;
	/**
	 * A boolean that is true only when the reserves are full
	 * (when a player cannot be added to the team without replacing another)
	 */
	static boolean TeamFull;
	
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
	public List<Athlete> viewActiveTeam() {
		return activeTeam;
	}
	
	/**
	 * returns list of players on the bench
	 * @return reserves
	 */
	public List<Athlete> viewReserves() {
		return reserves;
	}
	
	/**
	 * returns list of items in inventory
	 * @return inventory
	 */
	public List<Item> viewItems(){
		return inventory;
	}
	
	/**
	 * returns a hash map of attribute type to attribute value for the given athlete
	 * @param Athlete The athlete
	 * @return properties The given athletes stats
	 */
	public Map<String, Integer> viewAthlete(Athlete athlete) {
		
	
		Map<String, Integer> properties = new HashMap();
		
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
		
		String itemName = item.getName();
		switch(itemName) {
		case "Protein Shake":
			athlete.setDefenceStat(athlete.getDefenceStat() - item.getStatValue());
		case "Energy Drink":
			athlete.setStamina(athlete.getStamina() - item.getStatValue());
		case "Knee Sleeve":
			athlete.setOffenceStat(athlete.getOffenceStat() - item.getStatValue());		
		}
		
		inventory.remove(item);
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
	
	
	
}
	

