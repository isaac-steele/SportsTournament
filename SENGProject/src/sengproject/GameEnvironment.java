package sengproject;

import java.util.ArrayList;

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
 * @author Isaac Steele + Reuben Schoonbee
 *
 */

public class GameEnvironment {
	/**
	 * The list of athletes available to be drafted
	 */
	private ArrayList<Athlete> draft;
	/**
	 * A random event object
	 */
	private RandomEvent randomEvent;
	/**
	 * the club object which will be used for the entirety of the game
	 */
	private Club club;
	/**
	 * the market object which will be used for the entirety of the game
	 */
	private Market market;
	
	/**
	 * the stadium object which will be used for the entirety of the game
	 */
	private Stadium stadium;
	/**
	 * user interface instance
	 * final variable
	 */
	private CommandLine ui;

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
	 * The difficulty of the game.
	 */
	private String difficulty;
	/**
	 * The points gained
	 */
	private int points = 0;
	
	/**
	 * constructor for game environment, used once at the beginning of the game form the main method
	 * @param ui
	 * @param draft
	 */
	public GameEnvironment(CommandLine ui, ArrayList<Athlete> draft ) {
		
		this.draft = draft;
		this.ui = ui;
	}	
	/**
	 * starts the game
	 */
	public void Start() {
		ui.SetUp(this);
	}
	/**
	 * finishes setup and starts the main game
	 */
	public void finishSetup(String name, ArrayList<Athlete> team, int numWeeks) {
		this.totalWeeks = numWeeks;
		this.weeksRemaining = this.totalWeeks - this.currentWeek;
		this.club = new Club(name,team);
		this.market = new Market();
		this.stadium = new Stadium(this);
		ui.start(); 	
	}
	/**
	 * Gets the club
	 * 
	 * @return the club
	 */
	public Club getClub() {
		return club;
	}	
	/**
	 * @return the market
	 */
	public Market getMarket() {
		return market;
	}
	/*
	 * Gets the stadium
	 * 
	 * @return the stadium
	 */
	public Stadium getStadium() {
		return stadium;
	}
	/**
	 * @return the draft
	 */
	public ArrayList<Athlete> getDraft() {
		return draft;
	}
	/**
	 * @return the amount of weeks the game shall be played for
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
	 * Sets the amount of money the player has based on their difficulty setting.
	 * 
	 *@param money The amount of money the player gets.
	 */
	public void setMoneyAmount(int money) {
		this.moneyAmount = money;
	}
	/**
	 * Updates the amount of money the player wins.
	 */
	public void updateMoney(int gains) {
		this.moneyAmount += gains;
	}
	/** 
	 * The amount of points the player has
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * Adds points for winning a match.
	 * 
	 * @param points number of points to add
	 */
	public void updatePoints(int points) {
		this.points += points;
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
	/**
	 * Sets the difficulty of the game
	 * 
	 * @param difficulty The difficulty chosen in the setup
	 */
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	/**
	 * Gets the difficulty of the game.
	 * 
	 * @return The game difficulty
	 */
	public String getDifficulty() {
		return difficulty;
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
	
	
	
	/**
	 * takes and handles users input selection from the club screen
	 * @param selection
	 */
	public void handleClubOptions(int selection) {
		
		switch (selection) {
			
		default:
			throw new IllegalArgumentException("Unexpected value");
			
		case(1):
			for (Athlete athlete: club.viewActiveTeam()) {
				System.out.println(athlete);
			}
			System.out.println("1: Return to club");
			ui.singleIntegerInput(1);
			returnToClub();
			break;
			
		case(2):
			for (Athlete athlete: club.viewReserves()) {
				System.out.println(athlete);
			}
			System.out.println("1: Return to club");
			ui.singleIntegerInput(1);
			returnToClub();
			break;
			
		case(3):
			ui.printInventoryOptions(club);
			int itemIndex = ui.getIntegerInput(club.viewItems().size()+1);
			if (itemIndex == club.viewItems().size()+1) {
				returnToClub();
				break;
			}
			ui.printWholeTeam(club);
			int athleteIndex = ui.getIntegerInput(club.viewActiveTeam().size() + club.viewReserves().size() + 1);
			if (athleteIndex == club.viewActiveTeam().size() + club.viewReserves().size() + 1) {
				returnToClub();
				break;
			}
			handleItemUse(itemIndex - 1, athleteIndex - 1);
			break;
			
		case(4):
			ui.printSubOffOptions(club);
			int subOffIndex = ui.getIntegerInput(5);
			if (subOffIndex == 5) {
				returnToClub();
				break;
			}
			ui.printSubOnOptions(club);
			int subOnIndex = ui.getIntegerInput(club.viewReserves().size() + 1);
			if (subOnIndex == club.viewReserves().size() + 1) {
				returnToClub();
				break;
			}
			club.subAthlete(club.viewActiveTeam().get(subOffIndex - 1), club.viewReserves().get(subOnIndex - 1));
			break;
		case(5):
			ui.start();
			break;
			
		}
	}
		
	public void takeBye() {
		//In command line print out option to specially train one athlete before calling this
		updateCurrentWeek();
		updateWeeksRemaining();
		market = new Market();
		stadium = new Stadium(this);
		randomEvent = new RandomEvent(club);
		randomEvent.doRandomEvent(difficulty);
		for(Athlete athlete : club.activeTeam) {
			athlete.restoreStamina();
		}
	}
	
	/**
	 * takes the users selection for item and athlete and uses the item on the athlete
	 * @param itemIndex
	 * @param athleteIndex
	 */
	public void handleItemUse(int itemIndex, int athleteIndex) {
		
		Item item = club.viewItems().get(itemIndex);
		Athlete athlete;
		
		if (athleteIndex > 4) {
			athleteIndex -= 4;
			athlete = club.viewReserves().get(athleteIndex);	
		}
		else {
			athlete = club.viewActiveTeam().get(athleteIndex);
		}
		club.useItem(item, athlete);
	}
	

	/**
	 * called from within club to return to the main club screen
	 * 
	 */
	public void returnToClub() {
		ui.printClubOptions();
		int selection = ui.getIntegerInput(5);
		handleClubOptions(selection);
	}
	
	/**
	 * handles bye and offers the user the option of specially training an athlete
	 */
	public void handleBye() {
		

	   	ArrayList<Athlete> activeTeam = club.viewActiveTeam();
		ArrayList<Athlete> reserves = club.viewReserves();
		int i = 1;
		System.out.println("Choose an athlete to specially train:");
		for(Athlete starter : activeTeam) {
			System.out.println("("+i+") " + starter);
			i += 1;
		}
		for(Athlete reserve : reserves) {
			System.out.println("("+i+") " + reserve);
			i += 1;	
		}
		int chosenAthleteNum = ui.getIntegerInput(activeTeam.size() + reserves.size()) - 1;
		if (chosenAthleteNum < activeTeam.size()) {
			Athlete chosenAthlete = activeTeam.get(chosenAthleteNum);
			chosenAthlete.increaseDefence(10);
			chosenAthlete.increaseOffence(10);
		} 
		else if (chosenAthleteNum >= activeTeam.size() && chosenAthleteNum < (reserves.size() + activeTeam.size())) {
			chosenAthleteNum -= activeTeam.size();
			Athlete chosenAthlete = reserves.get(chosenAthleteNum);
			chosenAthlete.increaseDefence(10);
			chosenAthlete.increaseOffence(10);
		}
	}
}
	
	
	

		
	
	 
		
		

