package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import sportstournament.main.GameEnvironment;
import sportstournament.main.Market;

public class buyItemScreen extends Screen{

	private JFrame frame;
	private Market market;


	/**
	 * Create the application.
	 */
	public buyItemScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		market = game.getMarket();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
