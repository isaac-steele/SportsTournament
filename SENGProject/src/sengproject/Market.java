package sengproject;

import java.util.ArrayList;

/**
 * contains the source code for the market interface
 * where items can be purchased and players can be added/released
 * @author rsc103
 *
 */

public class Market {
	
	/**
	 * list of available items for purchase
	 */
	private ArrayList<Item> availableItems;
	/**
	 * list of available free agents
	 */
	private ArrayList<Athlete> freeAgents;
	
	/**
	 * sets the list of available items for purchase
	 * @param availableItems
	 */
	
	/**
	 * view the teams money
	 * @param team
	 */
	public void getMoney(Team team) {
		team.getMoney();
	}
	/**
	 * sets the list of items in the market
	 * @param availableItems
	 */
	public void setAvailableItems(ArrayList<Item> availableItems) {
		this.availableItems = availableItems;
	}
	
	/**
	 * @return list of available items
	 */
	public ArrayList<Item> viewAvailableItems() {
		return availableItems;
	}
	/**
	 * @param item
	 * adds a new item to the market
	 */
	public void addAvailableItem(Item item) {
		availableItems.add(item);
	}

	/**
	 * @return list of available players to be drafted
	 */
	public ArrayList<Athlete> getFreeAgents() {
		return freeAgents;
	}
	
	/**
	 * @param athlete
	 * adds a new fre agent to the market
	 */
	public void addFreeAgent(Athlete athlete) {
		freeAgents.add(athlete);
	}
	/**
	 * sets the list of free agents
	 * @param freeAgents
	 */
	public void setFreeAgents(ArrayList<Athlete> freeAgents) {
		this.freeAgents = freeAgents;
	}
	
	/**
	 * adds an athlete from market to the teams reserves and removes the athlete from the market
	 * @param newAthlete
	 * @param team
	 */
	public void buyReserve(Athlete newAthlete, Team team) {
		
		team.addNewAthlete(newAthlete);
		freeAgents.remove(newAthlete);
		
	}
	/**
	 * buys a new athlete from the market and puts them on the reserves
	 * then substitutes the other given player for the new one
	 * @param newAthlete
	 * @param subAthlete
	 * @param team
	 */
	public void buyStarter(Athlete newAthlete, Athlete subAthlete, Team team) {
		
		team.addNewAthlete(newAthlete);
		team.subAthlete(newAthlete, subAthlete);
		freeAgents.remove(newAthlete);
	}
	
	/**
	 * purchase item from market 
	 * @param item
	 * @param team
	 */
	public void buyItem(Item item, Team team) {
		team.addItem(item);
		availableItems.remove(item);
		team.setMoney(team.getMoney() - item.getPrice());
		
	}
	
	/**
	 * returns a reserve to the market
	 * @param athlete
	 * @param team
	 */
	public void returnReserve(Athlete athlete, Team team) {
		
		freeAgents.add(athlete);
		team.removeReserve(athlete);
	}
	
	/**
	 * subs the athlete to be returned with another then returns the original athlete to the market
	 * @param athlete
	 * @param replacement
	 * @param team
	 */
	public void returnStarter(Athlete athlete, Athlete replacement,Team team) {
		team.subAthlete(replacement, athlete);
		team.removeReserve(athlete);
		freeAgents.add(athlete);
	}


	
	

}
