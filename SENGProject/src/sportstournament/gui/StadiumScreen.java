package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import sportstournament.main.Athlete;
import sportstournament.main.GameEnvironment;
import sportstournament.main.Team;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.awt.Font;

public class StadiumScreen extends Screen {

	private JFrame stadiumWindow;
	
	private ArrayList<Team> matches;


	/**
	 * Create the application.
	 */
	public StadiumScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		matches = game.getMatches();
		initialize();
		super.window = stadiumWindow;
	}
	/**
	 * message to display
	 */
	public void displayMessage(String result) {
		String message = "The result of the match is: " + result + "\nThe updated status of your team is:\n\n" + game.getClub() + "\n\nYour total points are now: " + game.getPoints() + "\nYour total money is now: " + game.getMoneyAmount();
		JOptionPane.showMessageDialog(stadiumWindow, message, "Match Result", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		stadiumWindow = new JFrame();
		stadiumWindow.setTitle("Stadium");
		stadiumWindow.setBounds(100, 100, 788, 464);
		stadiumWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stadiumWindow.getContentPane().setLayout(null);
		
		JButton btnMatch_1 = new JButton("Match 1");
		btnMatch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = game.startMatch(0);
				if (result == "Cannot start match! Must have at least one healthy athlete") {
					JOptionPane.showMessageDialog(stadiumWindow, result, "Match Result", JOptionPane.ERROR_MESSAGE);
				} else {
					displayMessage(result);
					btnMatch_1.setEnabled(false);
				}
					
			}
		});
		btnMatch_1.setBounds(677, 123, 89, 25);
		stadiumWindow.getContentPane().add(btnMatch_1);
		
		JButton btnMatch_2 = new JButton("Match 2");
		btnMatch_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = game.startMatch(1);
				if (result == "Cannot start match! Must have at least one healthy athlete") {
					JOptionPane.showMessageDialog(stadiumWindow, result, "Match Result", JOptionPane.ERROR_MESSAGE);
				} else {
					displayMessage(result);
					btnMatch_2.setEnabled(false);
				}
			}
		});
		btnMatch_2.setBounds(677, 234, 89, 25);
		stadiumWindow.getContentPane().add(btnMatch_2);
		
		JButton btnMatch_3 = new JButton("Match 3");
		btnMatch_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = game.startMatch(2);
				if (result == "Cannot start match! Must have at least one healthy athlete") {
					JOptionPane.showMessageDialog(stadiumWindow, result, "Match Result", JOptionPane.ERROR_MESSAGE);
				} else {
					displayMessage(result);
					btnMatch_3.setEnabled(false);
				}
			}
		});
		btnMatch_3.setBounds(677, 351, 89, 25);
		stadiumWindow.getContentPane().add(btnMatch_3);
		
		JLabel lblChooseAMatch = new JLabel("Choose a match to play:");
		lblChooseAMatch.setBounds(30, 17, 229, 15);
		stadiumWindow.getContentPane().add(lblChooseAMatch);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeStadium();
				gui.openMainScreen();
			}
		});
		btnMainMenu.setBounds(649, 12, 117, 25);
		stadiumWindow.getContentPane().add(btnMainMenu);
		
		DefaultListModel<Athlete> match1ListModel = new DefaultListModel<>();
		match1ListModel.addAll(game.getPlayers(matches, 0));
		JList<Athlete> match1 = new JList<>(match1ListModel);
		match1.setFont(new Font("Dialog", Font.BOLD, 11));
		match1.setBounds(81, 98, 584, 71);
		stadiumWindow.getContentPane().add(match1);
		
		DefaultListModel<Athlete> match2ListModel = new DefaultListModel<>();
		match2ListModel.addAll(game.getPlayers(matches, 1));
		JList<Athlete> match2 = new JList<>(match2ListModel);
		match2.setFont(new Font("Dialog", Font.BOLD, 11));
		match2.setBounds(81, 209, 584, 71);
		stadiumWindow.getContentPane().add(match2);
		

		DefaultListModel<Athlete> match3ListModel = new DefaultListModel<>();
		match3ListModel.addAll(game.getPlayers(matches, 2));
		JList<Athlete> match3 = new JList<>(match3ListModel);
		match3.setFont(new Font("Dialog", Font.BOLD, 11));
		match3.setBounds(81, 328, 584, 71);
		stadiumWindow.getContentPane().add(match3);
		
		JLabel teamName1 = new JLabel("");
		teamName1.setText(game.getTeamName(matches, 0));
		teamName1.setBounds(91, 71, 131, 15);
		stadiumWindow.getContentPane().add(teamName1);
		
		JLabel teamName2 = new JLabel("");
		teamName2.setText(game.getTeamName(matches, 1));
		teamName2.setBounds(91, 182, 131, 15);
		stadiumWindow.getContentPane().add(teamName2);
		
		JLabel teamName3 = new JLabel("");
		teamName3.setText(game.getTeamName(matches, 2));
		teamName3.setBounds(91, 301, 141, 15);
		stadiumWindow.getContentPane().add(teamName3);
		
		JButton btnViewCurrentTeam = new JButton("View Current Team");
		btnViewCurrentTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(stadiumWindow, game.getClub(), "Current Team", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnViewCurrentTeam.setBounds(434, 12, 168, 25);
		stadiumWindow.getContentPane().add(btnViewCurrentTeam);
		
		JLabel lblAttacker = new JLabel("Defender:");
		lblAttacker.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAttacker.setBounds(12, 98, 70, 15);
		stadiumWindow.getContentPane().add(lblAttacker);
		
		JLabel lblDefender_6 = new JLabel("Defender:");
		lblDefender_6.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblDefender_6.setBounds(12, 112, 70, 15);
		stadiumWindow.getContentPane().add(lblDefender_6);
		
		JLabel lblDefender_1 = new JLabel("Defender:");
		lblDefender_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblDefender_1.setBounds(12, 209, 70, 15);
		stadiumWindow.getContentPane().add(lblDefender_1);
		
		JLabel lblDefender_7 = new JLabel("Defender:");
		lblDefender_7.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblDefender_7.setBounds(12, 225, 70, 15);
		stadiumWindow.getContentPane().add(lblDefender_7);
		
		JLabel lblDefender_2 = new JLabel("Defender:");
		lblDefender_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblDefender_2.setBounds(12, 328, 70, 15);
		stadiumWindow.getContentPane().add(lblDefender_2);
		
		JLabel lblDefender_3 = new JLabel("Defender:");
		lblDefender_3.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblDefender_3.setBounds(12, 343, 70, 15);
		stadiumWindow.getContentPane().add(lblDefender_3);
		
		JLabel lblDefender = new JLabel("Attacker:");
		lblDefender.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblDefender.setBounds(12, 128, 70, 15);
		stadiumWindow.getContentPane().add(lblDefender);
		
		JLabel lblAttacker_1 = new JLabel("Attacker:");
		lblAttacker_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAttacker_1.setBounds(12, 144, 70, 15);
		stadiumWindow.getContentPane().add(lblAttacker_1);
		
		JLabel lblAttacker_2 = new JLabel("Attacker:");
		lblAttacker_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAttacker_2.setBounds(12, 239, 70, 15);
		stadiumWindow.getContentPane().add(lblAttacker_2);
		
		JLabel lblAttacker_3 = new JLabel("Attacker:");
		lblAttacker_3.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAttacker_3.setBounds(12, 252, 70, 15);
		stadiumWindow.getContentPane().add(lblAttacker_3);
		
		JLabel lblAttacker_4 = new JLabel("Attacker:");
		lblAttacker_4.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAttacker_4.setBounds(12, 356, 70, 15);
		stadiumWindow.getContentPane().add(lblAttacker_4);
		
		JLabel lblAttacker_5 = new JLabel("Attacker:");
		lblAttacker_5.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAttacker_5.setBounds(12, 371, 70, 15);
		stadiumWindow.getContentPane().add(lblAttacker_5);
		
		JButton btnInfoButton = new JButton("Info");
		btnInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "During a match, the athletes in your team will face off against the athletes in the opposition team.\n"
						+ "Each of your defenders will face off against their respective defender in the opposition team.\n"
						+ "The defender with the highest defence stat will gain their team 10 points. If their stats are the same, both teams will gain 5 points.\n"
						+ "However, if your defender is injured they will lose their face off.\n"
						+ "The same applies for attackers, except their offence stat will be compared.\n"
						+ "The team with the highest score will be victorious.\n"
						+ "Caution: If your whole team is injured you cannot compete in a match. Also, if your whole team is injured during a match you will lose.\n\n"
						+ "Rewards for winning:\n\nEasy - 3 points, $10\nHard - 5 points, $5\n\n"
						+ "Rewards for a draw:\n\nEasy - 1 point, $5\nHard - 2 points, $3\n\n"
						+ "No rewards for a loss.\n\n"
						+ "Have fun!";
				JOptionPane.showMessageDialog(stadiumWindow, message, "How to Play", JOptionPane.INFORMATION_MESSAGE );
			}
		});
		btnInfoButton.setBounds(278, 12, 117, 25);
		stadiumWindow.getContentPane().add(btnInfoButton);
	}
}
