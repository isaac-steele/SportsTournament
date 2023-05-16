package sportstournament.main;

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
	private ArrayList<Item> availableItems = new ArrayList<Item>();
	/**
	 * list of available free agents
	 */
	private ArrayList<Athlete> freeAgents = new ArrayList<Athlete>();
	/**
	 * The game environment
	 */
	private GameEnvironment game;
	/**
	 * default constructor for market
	 * sets availableItems to all possible items
	 * creates a list of random athletes to be available for purchase
	 */
	public Market(GameEnvironment game) {
		this.game = game;
		for (Item item : Item.values()) {
			availableItems.add(item);
		}
		
		for (int i = 0; i < 5; i++ ) {
			freeAgents.add(Athlete.randomAthleteGenerator());
		}
		

	}
	/**
	 * view the teams money
	 * @param team
	 */
	public int getMoney() {
		return game.getMoneyAmount();
	}
	/**
	 * sets the list of items in the market
	 * @param availableItems
	 */
	
	
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
	public String buyReserve(Athlete newAthlete, Club club) {
		try {
			game.decreaseMoney(newAthlete.getPrice());
			club.addNewAthlete(newAthlete);
			freeAgents.remove(newAthlete);
		
			if (freeAgents.size() == 2) {
				freeAgents.add(Athlete.randomAthleteGenerator());
			}
			return newAthlete.getName() + " purchased.";
		}
		catch(ArithmeticException error) {
			return error.getMessage();
		}
	}
	/**
	 * buys a new athlete from the market and puts them on the reserves
	 * then substitutes the other given player for the new one
	 * @param newAthlete
	 * @param subAthlete
	 * @param team
	 */
	public String buyStarter(Athlete newAthlete, Athlete subAthlete, Club club) {
		try {
			game.decreaseMoney(newAthlete.getPrice());
			club.addNewAthlete(newAthlete);
			club.subAthlete(newAthlete, subAthlete);
			freeAgents.remove(newAthlete);
			
			if (freeAgents.size() == 2) {
				freeAgents.add(Athlete.randomAthleteGenerator());
			}
			return newAthlete.getName() + " purchased.";
		}
		catch (ArithmeticException error) {
			return error.getMessage();
			
		}
	}
	
	/**
	 * purchase item from market 
	 * @param item
	 * @param team
	 */
	public String buyItem(Item item, Club club) {
		try {
		game.decreaseMoney(item.getPrice());
		club.addItem(item);
		return item.name() + " purchased.";
		}
		catch(ArithmeticException error) {
			return error.getMessage();
		}
	}
	
	/**
	 * returns a reserve to the market
	 * @param athlete
	 * @param team
	 */
	public void returnReserve(Athlete athlete, Club club) {
		
		game.updateMoney((athlete.getPrice() / 2));
		freeAgents.add(athlete);
		club.removeReserve(athlete);
	}
	
	/**
	 * subs the athlete to be returned with another then returns the original athlete to the market
	 * @param athlete
	 * @param replacement
	 * @param team
	 */
	public void returnStarter(Athlete athlete, Athlete replacement,Club club) {
		game.updateMoney((athlete.getPrice() / 2));
		club.subAthlete(replacement, athlete);
		club.removeReserve(athlete);
		freeAgents.add(athlete);
	}


	
	

}
