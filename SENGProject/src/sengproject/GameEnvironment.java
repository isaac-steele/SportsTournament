package sengproject;

/**
 * This class contains the main game. It keeps track of the game and handles requests from the UI.
 * The player starts off in week 1 with a default amount of money. They can draft players and improve their stats with items.
 * The player can view their money, the current week and the weeks remaining.
 * If they go to the Club, they can view properties of their team and/or view their inventory.
 * If they go to the Stadium, they can see a few matches and they can choose to play them.
 * If they go to the Market:
 * - They can see their current money.
 * - Athletes and Items can be drafted back to the Market.
 * - They can view Athletes that are available for contracting including their price and their stats.
 * - They can view Items that are for sale including their price and effect
 * The player can take a bye:
 * - All items/athletes in the market are updated randomly
 * - All matches are updated
 * - All Athletes' stamina's are restored.
 * - An option will appear to give the chance to improve an Athlete's stats through a boot camp.
 * The game will end once either:
 * - No more weeks remaining
 * - The player has insufficient funds to purchase more Athletes or their team is not full enough.
 * 
 * Should be the same for GUI and command line UI
 * 
 * @author Isaac Steele
 *
 */

public class GameEnvironment {

	/**
	 * The total number of weeks.
	 */
	private int totalWeeks;
	/**
	 * The current week. Starts at 1 by default.
	 */
	private int currentWeek = 1;
	/**
	 * The number of weeks remaining.
	 */
	private int weeksRemaining = totalWeeks - currentWeek;
	/**
	 * The amount of money the player has. Varies based on difficulty
	 */
	private int moneyAmount;
	
	/**
	 * Returns the total number of weeks.
	 * 
	 * @return The total number of weeks.
	 */
	public int getTotalWeeks() {
		return totalWeeks;
	}
	/**
	 * Sets the total number of weeks.
	 * 
	 * @param totalWeeks The desired number of weeks chosen by the player, ranging from 5 - 15.
	 */
	public void setTotalWeeks(int totalWeeks) {
		this.totalWeeks = totalWeeks;
	}
	/**
	 * Returns the current week of the game.
	 * 
	 * @return The current week of the game.
	 */
	public int getCurrentWeek() {
		return currentWeek;
	}
	/**
	 * Returns the number of weeks remaining.
	 * 
	 * @return The number of weeks remaining.
	 */
	public int getWeeksRemaining() {
		return weeksRemaining;
	}
	/**
	 * Returns the amount of money the player currently has.
	 * 
	 * @return The amount of money the player currently has.
	 */
	public int getMoneyAmount() {
		return moneyAmount;
	}
	/**
	 * Sets the amount of money the player has if they choose hard as their difficulty.
	 * 
	 * @param hardMoneyAmount The amount of money the player gets if their difficulty is hard.
	 */
	public void setHardMoneyAmount(int hardMoneyAmount) {
		this.moneyAmount = hardMoneyAmount;
	}
	/**
	 * Sets the amount of money the player has if they choose easy as their difficulty.
	 * 
	 * @param easyMoneyAmount The amount of money the player gets if their difficulty is easy.
	 */
	public void setEasyMoneyAmount(int easyMoneyAmount) {
		this.moneyAmount = easyMoneyAmount;
	}
	/**
	 * Updates the current week. This will occur after a bye.
	 */
	public void updateCurrentWeek() {
		currentWeek += 1;
	}
	/**
	 * Updates the weeks remaining. This will occur after a bye.
	 */
	public void updateWeeksRemaining() {
		weeksRemaining -= 1;
	}
	
	/*
	 * On the main user interface, the options printed out will be:
	 * -Go to Club: 1
	 * -Go to Stadium: 2
	 * -Go to Market: 3
	 * -Take a bye: 4
	 */
	
	/*
	 * If 1 is selected:
	 * - View properties: 1
	 * - View inventory: 2
	 */
	
	/*
	 * If 2 is selected:
	 * - Match 1: 1
	 * - Match 2: 2
	 * - Match 3 : 3
	 */
	
	/*
	 * If 3 is selected:
	 * - call getMoneyAmount()
	 * - Draft Athlete back to market: 1
	 * - Draft Item back to market: 2
	 * - View available Athletes: 3
	 * - View available Items: 4
	 */
	
	/*
	 * If 4 is selected:
	 * - All Purchasable Items/Athletes update randomly
	 * - For all Athletes call restoreStamina()
	 * - Randomly generate new matches
	 * - Specially train Athlete: 1
	 * - call random events method
	 */
	
		
	
	
}
