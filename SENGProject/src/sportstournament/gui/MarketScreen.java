package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sportstournament.main.GameEnvironment;
import sportstournament.main.Market;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MarketScreen extends Screen{

	private JFrame marketWindow;
	private Market market;


	/**
	 * Create the application.
	 */
	public MarketScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		market = game.getMarket();
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
		lblTotalFunds.setText(String.valueOf(market.getMoney()));
		lblTotalFunds.setBounds(53, 33, 270, 48);
		marketWindow.getContentPane().add(lblTotalFunds);
		
		JButton btnDraftAthletesBack = new JButton("Buy and sell athletes");
		btnDraftAthletesBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeMarket();
				gui.openBuyAthleteScreen();
			}
		});
		btnDraftAthletesBack.setBounds(37, 105, 244, 259);
		marketWindow.getContentPane().add(btnDraftAthletesBack);
		
		JButton btnViewAvailableItems = new JButton("Buy and sell items");
		btnViewAvailableItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeMarket();
				gui.openBuyItemScreen();
			}
		});
		btnViewAvailableItems.setBounds(383, 105, 260, 259);
		marketWindow.getContentPane().add(btnViewAvailableItems);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeMarket();
				gui.openMainScreen();
			}
		});
		btnMainMenu.setBounds(648, 396, 117, 25);
		marketWindow.getContentPane().add(btnMainMenu);
	}

}
