package sportstournament.gui;

import javax.swing.JFrame;

import sportstournament.main.GameEnvironment;

public abstract class Screen {
	
	/**
	 * the window for the specific screen class
	 */
	protected JFrame window;
	
	/**
	 * the gui for the specific screen class
	 */
	protected final Gui gui;
	
	/**
	 * creates the given screen
	 * @param gui
	 */
	
	/**
	 * the game environment object
	 */
	protected final GameEnvironment game;
	
	
	public Screen(final GameEnvironment game, final Gui gui) {
		this.gui = gui;
		this.game = game;
	}
	
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void open() {
		window.setVisible(true);
	}
	

}
