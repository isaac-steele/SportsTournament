package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MarketScreen {

	private JFrame frmMarket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketScreen window = new MarketScreen();
					window.frmMarket.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MarketScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMarket = new JFrame();
		frmMarket.setTitle("Market");
		frmMarket.setBounds(100, 100, 804, 463);
		frmMarket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarket.getContentPane().setLayout(null);
		
		JLabel lblTotalFunds = new JLabel("Total Funds:");
		lblTotalFunds.setBounds(53, 33, 111, 15);
		frmMarket.getContentPane().add(lblTotalFunds);
		
		JLabel lblYourAthletes = new JLabel("Your Athletes:");
		lblYourAthletes.setBounds(37, 92, 127, 15);
		frmMarket.getContentPane().add(lblYourAthletes);
		
		JLabel lblYourItems = new JLabel("Your Items:");
		lblYourItems.setBounds(430, 92, 111, 15);
		frmMarket.getContentPane().add(lblYourItems);
		
		JButton btnDraftAthletesBack = new JButton("Draft athletes back");
		btnDraftAthletesBack.setBounds(37, 339, 197, 25);
		frmMarket.getContentPane().add(btnDraftAthletesBack);
		
		JButton btnDraftItemsBack = new JButton("Draft items back");
		btnDraftItemsBack.setBounds(412, 339, 164, 25);
		frmMarket.getContentPane().add(btnDraftItemsBack);
		
		JButton btnViewAvailableAthletes = new JButton("View available athletes");
		btnViewAvailableAthletes.setBounds(26, 376, 227, 25);
		frmMarket.getContentPane().add(btnViewAvailableAthletes);
		
		JButton btnViewAvailableItems = new JButton("View Available Items");
		btnViewAvailableItems.setBounds(408, 376, 179, 25);
		frmMarket.getContentPane().add(btnViewAvailableItems);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(648, 396, 117, 25);
		frmMarket.getContentPane().add(btnMainMenu);
	}

}
