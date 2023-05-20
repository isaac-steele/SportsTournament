package sportstournament.main;

import java.util.ArrayList;

/**
 * This class implements a Market where Athlete's and Item's can be purchased and sold.
 * 
 * @author rsc103
 *
 */

public class Market {
	
	/**
	 * List of available Items for purchase
	 */
	private ArrayList<Item> availableItems = new ArrayList<Item>();
	/**
	 * List of available Athletes for purchase.
	 */
	private ArrayList<Athlete> freeAgents = new ArrayList<Athlete>();
	/**
	 * The game environment. 
	 */
	private GameEnvironment game;
	/**
	 * Default constructor for Market
	 * Adds 3 items to the market
	 * Creates a list of random athletes to be available for purchase.
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
	 * View the available funds
	 * 
	 * @return The money in the current state of the game.
	 */
	public int getMoney() {
		return game.getMoneyAmount();
	}
	
	/**
	 * Returns a list of Items available for purchase.
	 * @return  A list of Items available for purchase.
	 */
	public ArrayList<Item> viewAvailableItems() {
		return availableItems;
	}
	/**
	 * Returns a list of available Athletes in the Market.
	 * 
	 * @return A list of available Athletes in the Market.
	 */
	public ArrayList<Athlete> getFreeAgents() {
		return freeAgents;
	}
	
	/**
	 * Adds a new Athlete to be available for purchase in the Market.
	 * 
	 * @param The Athlete to be added.
	 */
	public void addFreeAgent(Athlete athlete) {
		freeAgents.add(athlete);
	}
	/**
	 * Sets the list of available Athletes in the market.
	 * 
	 * @param a list of Athletes to be made available for purchase.
	 */
	public void setFreeAgents(ArrayList<Athlete> freeAgents) {
		this.freeAgents = freeAgents;
	}
	
	/**
	 * Adds an Athlete from the Market to the Club's reserves and removes the Athlete from the Market.
	 * 
	 * @param newAthlete The Athlete to be bought and added to the reserves
	 * @param club The instance of Club that the Athlete will join their reserves.
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
	
	public void sellItem(Item item, Club club) {
		club.removeItem(item);
		game.setMoneyAmount(game.getMoneyAmount() + item.getPrice());
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
