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
		MainScreen mainWindow = new MainScreen(game, this);
	}
}
