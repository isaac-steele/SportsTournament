package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import sportstournament.main.GameEnvironment;

import javax.swing.JButton;

public class ClubScreen extends Screen {

	protected JFrame clubWindow;
	private GameEnvironment game;
	private Gui gui;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ClubScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		initialize();
		super.window = clubWindow;
	}
	
	public void closeWindow() {
		clubWindow.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		clubWindow = new JFrame();
		clubWindow.setTitle("Club");
		clubWindow.setBounds(100, 100, 784, 470);
		clubWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clubWindow.getContentPane().setLayout(null);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setBounds(63, 122, 284, 169);
		clubWindow.getContentPane().add(btnInventory);
		
		JButton btnTeam = new JButton("Team");
		btnTeam.setBounds(400, 122, 307, 169);
		clubWindow.getContentPane().add(btnTeam);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(634, 405, 111, 25);
		clubWindow.getContentPane().add(btnMainMenu);
	}

}
