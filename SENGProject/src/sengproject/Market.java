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
	
	public void buyReserve(newAthlete Athlete, oldAthlete Athlete) {
		
		if (Team.reserves.length() == 5) {
			
		}
		Team.addNewAthlete(newAthlete, oldAthlete);
		
	}
	public void buyStarter(newAthlete Athlete, oldAthlete Athlete) {
		
		Team.addNewAthlete(newAthlete, oldAthlete);
		Team.subAthlete(newAthlete, oldAthlete);
	}


	
	

}
