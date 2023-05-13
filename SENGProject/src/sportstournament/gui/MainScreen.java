package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class MainScreen {

	private JFrame frmasideFootballMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frmasideFootballMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmasideFootballMain = new JFrame();
		frmasideFootballMain.setTitle("4-A-Side Football Main Menu");
		frmasideFootballMain.setBounds(100, 100, 770, 464);
		frmasideFootballMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmasideFootballMain.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Main Menu!");
		lblWelcomeToThe.setBounds(268, 12, 244, 15);
		frmasideFootballMain.getContentPane().add(lblWelcomeToThe);
		
		JButton btnClub = new JButton("Club");
		btnClub.setBounds(123, 154, 161, 76);
		frmasideFootballMain.getContentPane().add(btnClub);
		
		JButton btnStadium = new JButton("Stadium");
		btnStadium.setBounds(397, 154, 192, 76);
		frmasideFootballMain.getContentPane().add(btnStadium);
		
		JButton btnMarket = new JButton("Market");
		btnMarket.setBounds(117, 248, 167, 76);
		frmasideFootballMain.getContentPane().add(btnMarket);
		
		JButton btnNewButton = new JButton("Take Bye");
		btnNewButton.setBounds(397, 248, 192, 76);
		frmasideFootballMain.getContentPane().add(btnNewButton);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(616, 397, 117, 25);
		frmasideFootballMain.getContentPane().add(btnQuit);
		
		JLabel lblTotalFunds = new JLabel("Total Funds:");
		lblTotalFunds.setBounds(60, 37, 117, 15);
		frmasideFootballMain.getContentPane().add(lblTotalFunds);
		
		JLabel lblgetFunds = new JLabel("");
		lblgetFunds.setBounds(172, 37, 70, 15);
		frmasideFootballMain.getContentPane().add(lblgetFunds);
		
		JLabel lblCurrentWeek = new JLabel("Current Week:");
		lblCurrentWeek.setBounds(60, 64, 117, 15);
		frmasideFootballMain.getContentPane().add(lblCurrentWeek);
		
		JLabel lblWeeksRemaining = new JLabel("Weeks Remaining:");
		lblWeeksRemaining.setBounds(60, 97, 147, 15);
		frmasideFootballMain.getContentPane().add(lblWeeksRemaining);
	}
}
