package sengproject;

import java.util.List;

public class Team {
	/**
	 * This class contains the source code for the team interface 
	 */

	private String name;
	private List<Athlete> activeTeam;
	private List<Athlete> reserves;
	private int points;
	private int money;
	private List<Item> inventory;
	
	public String viewName() {
		return name;
	}
	
	public List<Athlete> viewActiveTeam() {
		// returns list of players on the current team
		return activeTeam;
	}
	
	public List<Athlete> viewReserves() {
		// returns list of players on the bench
		return reserves;
	}
	
	public List<Item> viewItems(){
		return inventory;
	}
	
	public Athlete viewAthlete(Athlete athlete) {
		
	}
	
	public void useItem(Item item, Athlete athlete) {
		// boosts the attribute of a given player with the property and value of a given item
		// removes the item from the inventory
		String statType = item.getProperty();
		athlete.statType -= item.getStatValue();
		inventory.remove(item);
	}
	
	public void subPlayer(Athlete player, Athlete sub){
		// swaps a reserve with an active player
		activeTeam.remove(sub);
		activeTeam.add(player);
		reserves.remove(player);
		reserves.add(player);
	
	
}

