package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import sportstournament.main.GameEnvironment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends Screen {
	
	
	private JFrame mainWindow;


	/**
	 * Create the window.
	 */
	public MainScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		initialize();
		super.window = mainWindow;
	}
		


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainWindow = new JFrame();
		mainWindow.setTitle("4-A-Side Football Main Menu");
		mainWindow.setBounds(100, 100, 770, 464);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Main Menu!");
		lblWelcomeToThe.setBounds(268, 12, 244, 15);
		mainWindow.getContentPane().add(lblWelcomeToThe);

	
		JButton btnClub = new JButton("Club");
		btnClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeMainScreen();
				gui.openClub();

			}
		});
		btnClub.setBounds(117, 154, 192, 76);
		mainWindow.getContentPane().add(btnClub);
		
		JButton btnStadium = new JButton("Stadium");
		btnStadium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeMainScreen();
				gui.OpenStadium();

			}
		});
		btnStadium.setBounds(397, 154, 192, 76);
		mainWindow.getContentPane().add(btnStadium);
		
		JButton btnMarket = new JButton("Market");
		btnMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeMainScreen();
				gui.OpenMarket();

			}
		});
		btnMarket.setBounds(117, 248, 192, 76);
		mainWindow.getContentPane().add(btnMarket);
		
		JButton btnNewButton = new JButton("Take Bye");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gui.closeMainScreen();
				gui.openTakeByeScreen();
			}
		});
		btnNewButton.setBounds(397, 248, 192, 76);
		mainWindow.getContentPane().add(btnNewButton);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnQuit.setBounds(616, 397, 117, 25);
		mainWindow.getContentPane().add(btnQuit);
		
		JLabel lblTotalFunds = new JLabel("Total Funds:");
		lblTotalFunds.setBounds(60, 37, 117, 15);
		mainWindow.getContentPane().add(lblTotalFunds);
		
		JLabel lblgetFunds = new JLabel("");
		lblgetFunds.setBounds(172, 37, 70, 15);
		mainWindow.getContentPane().add(lblgetFunds);
		
		JLabel lblCurrentWeek = new JLabel("Current Week:");
		lblCurrentWeek.setBounds(60, 64, 117, 15);
		mainWindow.getContentPane().add(lblCurrentWeek);
		
		JLabel lblWeeksRemaining = new JLabel("Weeks Remaining:");
		lblWeeksRemaining.setBounds(60, 97, 147, 15);
		mainWindow.getContentPane().add(lblWeeksRemaining);
	}
}
