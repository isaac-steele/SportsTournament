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
	 * @return list of available players to be drafted
	 */
	public ArrayList<Athlete> getFreeAgents() {
		return freeAgents;
	}

	/**
	 * sets the list of free agents
	 * @param freeAgents
	 */
	
	public void addFreeAgent(Athlete athlete) {
		setFreeAgents()
	}
	public void setFreeAgents(List<Athlete> freeAgents) {
		this.freeAgents = freeAgents;
	}
	
	public void buyReserve(Athlete newAthlete, Team team) {
		
		team.addNewAthlete(newAthlete);
		
	}
	public void buyStarter(Athlete newAthlete, Athlete subAthlete, Team team) {
		
		team.addNewAthlete(newAthlete);
		team.subAthlete(newAthlete, subAthlete);
	}


	
	

}
