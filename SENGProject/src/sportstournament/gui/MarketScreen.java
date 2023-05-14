package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sportstournament.main.GameEnvironment;

import javax.swing.JButton;

public class MarketScreen extends Screen{

	private JFrame marketWindow;
	private GameEnvironment game;
	private Gui gui;


	/**
	 * Create the application.
	 */
	public MarketScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		initialize();
		super.window = marketWindow;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		marketWindow = new JFrame();
		marketWindow.setTitle("Market");
		marketWindow.setBounds(100, 100, 804, 463);
		marketWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marketWindow.getContentPane().setLayout(null);
		
		JLabel lblTotalFunds = new JLabel("Total Funds:");
		lblTotalFunds.setBounds(53, 33, 111, 15);
		marketWindow.getContentPane().add(lblTotalFunds);
		
		JLabel lblYourAthletes = new JLabel("Your Athletes:");
		lblYourAthletes.setBounds(37, 92, 127, 15);
		marketWindow.getContentPane().add(lblYourAthletes);
		
		JLabel lblYourItems = new JLabel("Your Items:");
		lblYourItems.setBounds(430, 92, 111, 15);
		marketWindow.getContentPane().add(lblYourItems);
		
		JButton btnDraftAthletesBack = new JButton("Draft athletes back");
		btnDraftAthletesBack.setBounds(37, 339, 197, 25);
		marketWindow.getContentPane().add(btnDraftAthletesBack);
		
		JButton btnDraftItemsBack = new JButton("Draft items back");
		btnDraftItemsBack.setBounds(412, 339, 164, 25);
		marketWindow.getContentPane().add(btnDraftItemsBack);
		
		JButton btnViewAvailableAthletes = new JButton("View available athletes");
		btnViewAvailableAthletes.setBounds(26, 376, 227, 25);
		marketWindow.getContentPane().add(btnViewAvailableAthletes);
		
		JButton btnViewAvailableItems = new JButton("View Available Items");
		btnViewAvailableItems.setBounds(408, 376, 179, 25);
		marketWindow.getContentPane().add(btnViewAvailableItems);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(648, 396, 117, 25);
		marketWindow.getContentPane().add(btnMainMenu);
	}

}
