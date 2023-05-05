package sengproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Team {
	/**
	 * This class contains the source code for the team/club interface where the player can manage the team
	 */

	private String name;
	private List<Athlete> activeTeam;
	private List<Athlete> reserves;
	private int points;
	private int money;
	private List<Item> inventory;
	
	public String viewName() {
		/**
		 * returns the team name
		 */
		return name;
	}
	
	public List<Athlete> viewActiveTeam() {
		/**
		 * returns list of active players on the team
		 */
		return activeTeam;
	}
	
	public List<Athlete> viewReserves() {
		/**
		 * returns list of players on the bench
		 */
		return reserves;
	}
	
	public List<Item> viewItems(){
		/**
		 * returns list of items in inventory
		 */
		return inventory;
	}
	
	public Map<String, Integer> viewAthlete(Athlete athlete) {
		/**
		 * returns a hash map of attribute type to attribute value for the given athlete
		 */
	
		Map<String, Integer> properties = new HashMap();
		
		properties.put("Offence", athlete.getOffenceStat());
		properties.put("Defence", athlete.getDefenceStat());
		properties.put("Stamina", athlete.getStamina());
		return properties;
			
	}
	
	public void useItem(Item item, Athlete athlete) {
		/**
		 * boosts the attribute of a given player with the property and value of a given item
		 * then removes the item from the inventory
		 */
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
	
	public void subAthlete(Athlete player, Athlete sub){
		/**
		 * takes a reserve and an active player and swaps them
		 */
		activeTeam.remove(sub);
		activeTeam.add(player);
		reserves.remove(player);
		reserves.add(player);
	}
	
	public void addAthlete(Athlete newPlayer) {
		
		if  (reserves.size() == 5) {
			
			replaceAthlete(newPlayer, oldPlayer)
		}
		else {
			reserves.add(newPlayer);
		}
	}
	
	public void replaceAthlete(Athlete newPlayer) {
		
		reserves.remove(oldPlayer);
		reserves.add(newPlayer);
	}
	
}
	

