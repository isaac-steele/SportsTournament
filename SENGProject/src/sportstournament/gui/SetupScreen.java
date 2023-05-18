package sportstournament.gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import sportstournament.main.Athlete;
import sportstournament.main.GameEnvironment;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.AbstractListModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SetupScreen {

	private JFrame setupWindow;
	private JTextField textField;
	private ArrayList<Athlete> athletesToDraft;
	private GameEnvironment game;
	private String teamName;
	private String difficulty;
	private ArrayList<Athlete> chosenAthletes;
	private int numWeeks;
	private List<Athlete> selectedAthletes =  new ArrayList<Athlete>();
	private int draftFunds = 30;
	private List<Athlete> oldAthletes = new ArrayList<Athlete>();

	

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
		chosenAthletes = (ArrayList<Athlete>) selectedAthletes;
		game.finishSetup(teamName, chosenAthletes, numWeeks, difficulty);;
	}
	public boolean checkAllSelected() {
		String name = textField.getText();
		boolean acceptableName = (Pattern.matches("[a-zA-Z0-9]+(\\s)?[a-zA-Z0-9]+", name) && name.length() <= 15 && name.length() >=3);
		// enable button if a difficulty is chosen, name is right, season lenght is selected, anmd 4 players are selected
		return (acceptableName && difficulty!= null && numWeeks >=5 && numWeeks<=15 && selectedAthletes.size() == 4 && draftFunds >= 0);
	}
	
	public void changeChecker() {
		for (Athlete oldAthlete : oldAthletes) {
			if (!selectedAthletes.contains(oldAthlete)) {
				draftFunds += oldAthlete.getPrice();
			}
		}
		for (Athlete newAthlete : selectedAthletes) {
			if (!oldAthletes.contains(newAthlete)) {
				draftFunds -= newAthlete.getPrice();
			}
		}
		oldAthletes = selectedAthletes;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setupWindow = new JFrame();
		setupWindow.setTitle("4-A-Side Football");
		setupWindow.setBounds(100, 100, 866, 454);
		setupWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupWindow.getContentPane().setLayout(null);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Athlete athlete: selectedAthletes) {
					String message = "Choose a nickname for " + athlete.getName() +"\n(Between 3 to 15 characters)";
					String selection = (String) JOptionPane.showInputDialog(setupWindow, message, "Nickname athlete", JOptionPane.PLAIN_MESSAGE);
					if (selection != null) {
						while (selection.length() < 3 | selection.length() > 15 | !(Pattern.matches("[a-zA-Z0-9]+(\\s)?[a-zA-Z0-9]+", selection))) {
							if (selection.length() == 0) {
								break;
							}
							JOptionPane.showMessageDialog(setupWindow, "Please enter a valid nickname!", "Invalid Nickname", JOptionPane.ERROR_MESSAGE);
							selection = (String) JOptionPane.showInputDialog(setupWindow, message, "Nickname athlete", JOptionPane.PLAIN_MESSAGE);
							if (selection == null) {
								break;
							}
						}
					}
					if (selection != null) {
						if (selection.length() >=3 && selection.length() <=15 && (Pattern.matches("[a-zA-Z0-9]+(\\s)?[a-zA-Z0-9]+", selection))) {
							athlete.setName(selection);
						}	
					}
				}
				setupComplete();
			}
		});
		btnAccept.setEnabled(false);
		btnAccept.setBounds(700, 380, 117, 25);
		setupWindow.getContentPane().add(btnAccept);
		
		JLabel lblWelcomeToaside = new JLabel("Welcome to 4-A-Side Football!");
		lblWelcomeToaside.setBounds(285, 12, 313, 15);
		setupWindow.getContentPane().add(lblWelcomeToaside);
		
		JLabel lblNewLabel = new JLabel("Choose your team name:");
		lblNewLabel.setBounds(71, 50, 202, 15);
		setupWindow.getContentPane().add(lblNewLabel);
		
		JLabel lblmustBeBetween = new JLabel("(Must be between 3 - 15 characters and no special characters)");
		lblmustBeBetween.setBounds(285, 67, 458, 15);
		setupWindow.getContentPane().add(lblmustBeBetween);
		
		Integer[] weeks = {5,6,7,8,9,10,11,12,13,14,15};
		JComboBox comboBox = new JComboBox(weeks);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numWeeks = (int) comboBox.getSelectedItem();
				if(checkAllSelected()) {
					btnAccept.setEnabled(true);
				}
				else {
					btnAccept.setEnabled(false);
				}
			}
		});
		comboBox.setBounds(295, 104, 74, 24);
		setupWindow.getContentPane().add(comboBox);
		
		JLabel lblSelectTheLength = new JLabel("Select the length of the season:");
		lblSelectTheLength.setBounds(28, 104, 245, 20);
		setupWindow.getContentPane().add(lblSelectTheLength);
		
		JLabel lblChooseDifficulty = new JLabel("Choose difficulty:");
		lblChooseDifficulty.setBounds(115, 149, 144, 15);
		setupWindow.getContentPane().add(lblChooseDifficulty);
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = "Easy";
				if(checkAllSelected()) {
					btnAccept.setEnabled(true);
				}
				else {
					btnAccept.setEnabled(false);
				}
			}
		});
		btnEasy.setBounds(285, 145, 117, 25);
		setupWindow.getContentPane().add(btnEasy);
		
		JButton btnHard = new JButton("Hard");
		btnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = "Hard";
				if(checkAllSelected()) {
					btnAccept.setEnabled(true);
				}
				else {
					btnAccept.setEnabled(false);
				}
			}
		});
		btnHard.setBounds(485, 145, 117, 25);
		setupWindow.getContentPane().add(btnHard);
		
		JLabel lblDraftStarting = new JLabel("Draft 4 starting athletes:");
		lblDraftStarting.setBounds(71, 177, 212, 15);
		setupWindow.getContentPane().add(lblDraftStarting);
		
		textField = new JTextField();
		textField.setBounds(285, 48, 212, 19);
		setupWindow.getContentPane().add(textField);
		textField.setColumns(10);
		textField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(checkAllSelected()) {
					btnAccept.setEnabled(true);
				}
				else {
					btnAccept.setEnabled(false);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if(checkAllSelected()) {
					btnAccept.setEnabled(true);
				}
				else {
					btnAccept.setEnabled(false);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				if(checkAllSelected()) {
					btnAccept.setEnabled(true);
				}
				else {
					btnAccept.setEnabled(false);
				}
			}
		});
		
		JLabel lblBalance = new JLabel("Balance:  $"+ draftFunds);
		lblBalance.setBounds(700, 308, 117, 16);
		setupWindow.getContentPane().add(lblBalance);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		athleteListModel.addAll(athletesToDraft);
		JList<Athlete> draftAthletes = new JList<Athlete>(athleteListModel);
		draftAthletes.setVisibleRowCount(10);
		draftAthletes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				selectedAthletes = draftAthletes.getSelectedValuesList();
				changeChecker();
				lblBalance.setText("Balance:  $"+ draftFunds);
				
				if(checkAllSelected()) {
					btnAccept.setEnabled(true);
				}
				else {
					btnAccept.setEnabled(false);
				}
			}
		});
		draftAthletes.setBounds(23, 220, 659, 185);
		draftAthletes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		setupWindow.getContentPane().add(draftAthletes);
		
		JLabel lblholdCtrlWhile = new JLabel("(Hold Ctrl while selecting)");
		lblholdCtrlWhile.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblholdCtrlWhile.setBounds(78, 193, 195, 15);
		setupWindow.getContentPane().add(lblholdCtrlWhile);
		
		JLabel lblBudgetWarning = new JLabel("<html>Choose wisely and<br/>be aware of your budget!");
		lblBudgetWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblBudgetWarning.setBounds(700, 233, 144, 47);
		setupWindow.getContentPane().add(lblBudgetWarning);
		
		
	}
}
