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
		takeByeScreen = new TakeByeScreen(game, this);
		teamPropertiesScreen = new TeamPropertiesScreen(game, this);
		inventoryScreen = new InventoryScreen(game, this);
		
		openMainScreen();
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
		stadiumScreen.open();
	}
	/**
	 * closes the market screen
	 */
	public void closeMarket() {
		marketScreen.closeWindow();
	}
	
	public void openTakeByeScreen() {
		takeByeScreen.open();
	}
	public void closeTakeByeScreen() {
		takeByeScreen.closeWindow();
	}
	
	public void openTeamPropertiesScreen() {
		teamPropertiesScreen.open();
	}
	public void closeTeamPropertiesScreen() {
		teamPropertiesScreen.closeWindow();
	}
	public void openInventoryScreen() {
		inventoryScreen.open();
	}
	public void closeInventoryScreen() {
		inventoryScreen.closeWindow();
	}
}
