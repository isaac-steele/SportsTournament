package sengproject;

import java.util.List;

public class Market {
	
	private List<Item> availableItems;
	private List<Athlete> freeAgents;
	


	public void setAvailableItems(List<Item> availableItems) {
		this.availableItems = availableItems;
	}
	
	public List<Item> viewAvailableItems() {
		
		return availableItems;
	}

	public List<Athlete> getFreeAgents() {
		return freeAgents;
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
