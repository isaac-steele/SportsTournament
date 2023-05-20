package sportstournament.gui;

import java.util.ArrayList;

import sportstournament.main.Athlete;
import sportstournament.main.GameEnvironment;

public class Gui {
	
	/**
	 * The game environment it interacts with
	 */
	private GameEnvironment game;
	/**
	 * The setup screen
	 */
	private SetupScreen setupScreen;
	/**
	 * The main screen
	 */
	private MainScreen mainScreen;
	
	/**
	 * The club screen
	 */
	private ClubScreen clubScreen;
	
	/**
	 * The stadium screen
	 */
	private StadiumScreen stadiumScreen;
	
	/**
	 * The market screen
	 */
	private MarketScreen marketScreen;
	
	/**
	 * The take bye screen
	 */
	private TakeByeScreen takeByeScreen;
	
	
	/**
	 * the team properties screen
	 */
	private TeamPropertiesScreen teamPropertiesScreen;
	
	/**
	 * the inventory screen
	 */
	private InventoryScreen inventoryScreen;
	
	/**
	 * the screen where athletes can be purchased or sold
	 */
	private BuyAthleteScreen buyAthleteScreen;
	
	/**
	 * the screen where items can be purchased or sold
	 */
	private BuyItemScreen buyItemScreen;
	/**
	 * The end game screen
	 */
	private EndGameScreen endGameScreen;
	/**
	 * Launches the setup window
	 * @param game
	 */
	public void setup(GameEnvironment game) {
		this.game = game;
		ArrayList<Athlete> draftAthletes = game.getDraft();
		setupScreen = new SetupScreen(game, draftAthletes);	
	}
	
	/**
	 * Launches the main screen
	 */
	public void start() {
		setupScreen.closeWindow();
		mainScreen = new MainScreen(game, this);
		clubScreen = new ClubScreen(game, this);
		stadiumScreen = new StadiumScreen(game, this);
		marketScreen = new MarketScreen(game, this);
		buyAthleteScreen = new BuyAthleteScreen(game, this);
		buyItemScreen = new BuyItemScreen(game, this);
		takeByeScreen = new TakeByeScreen(game, this);
		teamPropertiesScreen = new TeamPropertiesScreen(game, this);
		inventoryScreen = new InventoryScreen(game, this);
		
		
		openMainScreen();
	}
	/**
	 * closes take bye screen
	 */
	public void takeBye() {
		closeTakeByeScreen();
		stadiumScreen = new StadiumScreen(game, this);
		marketScreen = new MarketScreen(game, this);
		takeByeScreen = new TakeByeScreen(game, this);
		openMainScreen();
	}
	/**
	 * Ends the game
	 */
	public void endGame() {
		closeMainScreen();
		endGameScreen = new EndGameScreen(game, this);
		endGameScreen.open();
	}	
	
	/**
	 * opens the main screen
	 */
	public void openMainScreen() {
		mainScreen = new MainScreen(game, this);
		mainScreen.open();
	}
	/**
	 * closes the main screen
	 */
	public void closeMainScreen() {
		mainScreen.closeWindow();
	}
	
	/**
	 * opens the club screen
	 */
	public void openClub() {
		clubScreen = new ClubScreen(game, this);
		clubScreen.open();
	}
	/**
	 * closes the club screen
	 */
	public void closeClub() {
		clubScreen.closeWindow();
	}
	
	/**
	 * opens the stadium screen
	 */
	public void OpenStadium() {
		stadiumScreen.open();
	}
	/**
	 * closes the stadium screen
	 */
	public void closeStadium() {
		stadiumScreen.closeWindow();
	}
	
	/**
	 * opens the market screen
	 */
	public void OpenMarket() {
		marketScreen = new MarketScreen(game, this);
		marketScreen.open();
	}
	/**
	 * closes the market screen
	 */
	public void closeMarket() {		
		marketScreen.closeWindow();
	}
	
	
	public void openTakeByeScreen() {
		takeByeScreen = new TakeByeScreen(game, this);
		takeByeScreen.open();
	}
	public void closeTakeByeScreen() {
		takeByeScreen.closeWindow();
	}
	
	/**
	 * opens the screen where the team can be viewed and substitutions can be made
	 */
	public void openTeamPropertiesScreen() {
		teamPropertiesScreen = new TeamPropertiesScreen(game, this);
		teamPropertiesScreen.open();
	}
	
	/**
	 * opens the screen where the inventory can be viewed and items can be used
	 */
	public void openInventoryScreen() {
		inventoryScreen = new InventoryScreen(game, this);
		inventoryScreen.open();
	}
	public void closeTeamPropertiesScreen() {
		teamPropertiesScreen.closeWindow();
	}
	public void closeInventoryScreen() {
		inventoryScreen.closeWindow();
	}
	
	public void openBuyAthleteScreen() {
		buyAthleteScreen = new BuyAthleteScreen(game, this);
		buyAthleteScreen.open();
	}
	public void openBuyItemScreen() {
		buyItemScreen = new BuyItemScreen(game, this);
		buyItemScreen.open();
	}
	public void closeBuyAthleteScreen() {
		buyAthleteScreen.closeWindow();
	}
	public void closeBuyItemScreen() {
		buyItemScreen.closeWindow();
	}
}
