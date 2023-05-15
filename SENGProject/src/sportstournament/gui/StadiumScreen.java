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
		btnMatch_1.setBounds(649, 123, 117, 25);
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
		btnMatch_2.setBounds(649, 234, 117, 25);
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
		btnMatch_3.setBounds(649, 351, 117, 25);
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
		match1.setBounds(12, 99, 625, 80);
		stadiumWindow.getContentPane().add(match1);
		
		DefaultListModel<Athlete> match2ListModel = new DefaultListModel<>();
		match2ListModel.addAll(game.getPlayers(matches, 1));
		JList<Athlete> match2 = new JList<>(match2ListModel);
		match2.setFont(new Font("Dialog", Font.BOLD, 11));
		match2.setBounds(12, 211, 625, 80);
		stadiumWindow.getContentPane().add(match2);
		

		DefaultListModel<Athlete> match3ListModel = new DefaultListModel<>();
		match3ListModel.addAll(game.getPlayers(matches, 2));
		JList<Athlete> match3 = new JList<>(match3ListModel);
		match3.setFont(new Font("Dialog", Font.BOLD, 11));
		match3.setBounds(12, 328, 625, 80);
		stadiumWindow.getContentPane().add(match3);
		
		JLabel teamName1 = new JLabel("");
		teamName1.setText(game.getTeamName(matches, 0));
		teamName1.setBounds(30, 72, 131, 15);
		stadiumWindow.getContentPane().add(teamName1);
		
		JLabel teamName2 = new JLabel("");
		teamName2.setText(game.getTeamName(matches, 1));
		teamName2.setBounds(30, 184, 131, 15);
		stadiumWindow.getContentPane().add(teamName2);
		
		JLabel teamName3 = new JLabel("");
		teamName3.setText(game.getTeamName(matches, 2));
		teamName3.setBounds(30, 301, 141, 15);
		stadiumWindow.getContentPane().add(teamName3);
	}
}
