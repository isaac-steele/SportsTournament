package sportstournament.gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JToolBar;

import sportstournament.main.Athlete;
import sportstournament.main.GameEnvironment;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetupScreen {

	private JFrame setupWindow;
	private JTextField textField;
	private ArrayList<Athlete> athletesToDraft;
	private GameEnvironment game;
	private String teamName;
	private String difficulty;
	private ArrayList<Athlete> chosenAthletes;
	private int numWeeks;

	

	/**
	 * Create the application.
	 */
	public SetupScreen(GameEnvironment game, ArrayList<Athlete> athletesToDraft) {
		this.game = game;
		this.athletesToDraft = athletesToDraft;
		initialize();
		setupWindow.setVisible(true);
	}
	
	/**
	 * Closes the window
	 */
	public void closeWindow() {
		
		setupWindow.dispose();
	}
	
	/**
	 * Allows for the gui manager to close the window
	 */
	public void setupComplete() {
		teamName = textField.getText();
		game.finishSetup(teamName, chosenAthletes, numWeeks, difficulty);;
	}
	public void checkAllSelected() {
		String name = textField.getText();
		boolean acceptableName = (Pattern.matches("[a-zA-Z0-9]+", name) && name.length() <= 15 && name.length() >=3);
		// enable button if a difficulty is chosen, name is right
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setupWindow = new JFrame();
		setupWindow.setTitle("4-A-Side Football");
		setupWindow.setBounds(100, 100, 821, 447);
		setupWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupWindow.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToaside = new JLabel("Welcome to 4-A-Side Football!");
		lblWelcomeToaside.setBounds(285, 12, 313, 15);
		setupWindow.getContentPane().add(lblWelcomeToaside);
		
		JLabel lblNewLabel = new JLabel("Choose your team name:");
		lblNewLabel.setBounds(71, 50, 202, 15);
		setupWindow.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(285, 48, 212, 19);
		setupWindow.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblmustBeBetween = new JLabel("(Must be between 3 - 15 characters and no special characters)");
		lblmustBeBetween.setBounds(285, 67, 458, 15);
		setupWindow.getContentPane().finishedWindowadd(lblmustBeBetween);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(295, 104, 74, 24);
		setupWindow.getContentPane().add(comboBox);
		
		JLabel lblSelectTheLength = new JLabel("Select the length of the season:");
		lblSelectTheLength.setBounds(28, 104, 245, 20);
		setupWindow.getContentPane().add(lblSelectTheLength);
		
		JLabel lblChooseDifficulty = new JLabel("Choose difficulty:");
		lblChooseDifficulty.setBounds(129, 150, 144, 15);
		setupWindow.getContentPane().add(lblChooseDifficulty);
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.setBounds(285, 145, 117, 25);
		setupWindow.getContentPane().add(btnEasy);
		
		JButton btnHard = new JButton("Hard");
		btnHard.setBounds(485, 145, 117, 25);
		setupWindow.getContentPane().add(btnHard);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(e -> setupComplete());
		btnAccept.setBounds(666, 380, 117, 25);
		setupWindow.getContentPane().add(btnAccept);
		
		JLabel lblDraftStarting = new JLabel("Draft 4 starting athletes:");
		lblDraftStarting.setBounds(77, 193, 212, 15);
		setupWindow.getContentPane().add(lblDraftStarting);
		
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		athleteListModel.addAll(athletesToDraft);
		JList<Athlete> draftAthletes = new JList<Athlete>(athleteListModel);
		draftAthletes.setBounds(556, 391, -448, -170);
		setupWindow.getContentPane().add(draftAthletes);
		
	}
}
