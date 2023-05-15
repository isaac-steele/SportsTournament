package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sportstournament.main.GameEnvironment;

import java.awt.Font;
import javax.swing.JButton;

public class EndGameScreen extends Screen{

	private JFrame endGameWindow;


	/**
	 * Create the application.
	 */
	public EndGameScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		initialize();
		super.window = endGameWindow;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		endGameWindow = new JFrame();
		endGameWindow.setTitle("Game Complete");
		endGameWindow.setBounds(100, 100, 794, 462);
		endGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		endGameWindow.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Team Name:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(42, 28, 228, 102);
		endGameWindow.getContentPane().add(lblNewLabel);
		
		JLabel lblSeasonDuration = new JLabel("Season Duration:");
		lblSeasonDuration.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSeasonDuration.setBounds(42, 142, 243, 50);
		endGameWindow.getContentPane().add(lblSeasonDuration);
		
		JLabel lblMoneyGained = new JLabel("Money Gained:");
		lblMoneyGained.setFont(new Font("Dialog", Font.BOLD, 20));
		lblMoneyGained.setBounds(42, 231, 228, 57);
		endGameWindow.getContentPane().add(lblMoneyGained);
		
		JLabel lblPointsGained = new JLabel("Points Gained:");
		lblPointsGained.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPointsGained.setBounds(42, 326, 243, 57);
		endGameWindow.getContentPane().add(lblPointsGained);
		
		JLabel lblCongratulationsYourSeason = new JLabel("Congratulations! Your season is complete.");
		lblCongratulationsYourSeason.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCongratulationsYourSeason.setBounds(244, 22, 419, 15);
		endGameWindow.getContentPane().add(lblCongratulationsYourSeason);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(655, 395, 117, 25);
		endGameWindow.getContentPane().add(btnQuit);
	}

}
