package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class EndGameScreen {

	private JFrame frmGameComplete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndGameScreen window = new EndGameScreen();
					window.frmGameComplete.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EndGameScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGameComplete = new JFrame();
		frmGameComplete.setTitle("Game Complete");
		frmGameComplete.setBounds(100, 100, 794, 462);
		frmGameComplete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameComplete.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Team Name:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(42, 28, 228, 102);
		frmGameComplete.getContentPane().add(lblNewLabel);
		
		JLabel lblSeasonDuration = new JLabel("Season Duration:");
		lblSeasonDuration.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSeasonDuration.setBounds(42, 142, 243, 50);
		frmGameComplete.getContentPane().add(lblSeasonDuration);
		
		JLabel lblMoneyGained = new JLabel("Money Gained:");
		lblMoneyGained.setFont(new Font("Dialog", Font.BOLD, 20));
		lblMoneyGained.setBounds(42, 231, 228, 57);
		frmGameComplete.getContentPane().add(lblMoneyGained);
		
		JLabel lblPointsGained = new JLabel("Points Gained:");
		lblPointsGained.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPointsGained.setBounds(42, 326, 243, 57);
		frmGameComplete.getContentPane().add(lblPointsGained);
		
		JLabel lblCongratulationsYourSeason = new JLabel("Congratulations! Your season is complete.");
		lblCongratulationsYourSeason.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCongratulationsYourSeason.setBounds(244, 22, 419, 15);
		frmGameComplete.getContentPane().add(lblCongratulationsYourSeason);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(655, 395, 117, 25);
		frmGameComplete.getContentPane().add(btnQuit);
	}

}
