package sportstournament.gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JToolBar;

import sportstournament.main.Athlete;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class SetupScreen {

	private JFrame frmSportstournamentSetup;
	private JTextField textField;
	private static ArrayList<Athlete> athletesToDraft;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen(athletesToDraft);
					window.frmSportstournamentSetup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupScreen(ArrayList<Athlete> athletesToDraft ) {
		SetupScreen.athletesToDraft = athletesToDraft;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSportstournamentSetup = new JFrame();
		frmSportstournamentSetup.setTitle("4-A-Side Football");
		frmSportstournamentSetup.setBounds(100, 100, 821, 447);
		frmSportstournamentSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSportstournamentSetup.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToaside = new JLabel("Welcome to 4-A-Side Football!");
		lblWelcomeToaside.setBounds(285, 12, 313, 15);
		frmSportstournamentSetup.getContentPane().add(lblWelcomeToaside);
		
		JLabel lblNewLabel = new JLabel("Choose your team name:");
		lblNewLabel.setBounds(71, 50, 202, 15);
		frmSportstournamentSetup.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(285, 48, 212, 19);
		frmSportstournamentSetup.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblmustBeBetween = new JLabel("(Must be between 3 - 15 characters and no special characters)");
		lblmustBeBetween.setBounds(285, 67, 458, 15);
		frmSportstournamentSetup.getContentPane().add(lblmustBeBetween);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(295, 104, 74, 24);
		frmSportstournamentSetup.getContentPane().add(comboBox);
		
		JLabel lblSelectTheLength = new JLabel("Select the length of the season:");
		lblSelectTheLength.setBounds(28, 104, 245, 20);
		frmSportstournamentSetup.getContentPane().add(lblSelectTheLength);
		
		JLabel lblChooseDifficulty = new JLabel("Choose difficulty:");
		lblChooseDifficulty.setBounds(129, 150, 144, 15);
		frmSportstournamentSetup.getContentPane().add(lblChooseDifficulty);
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.setBounds(285, 145, 117, 25);
		frmSportstournamentSetup.getContentPane().add(btnEasy);
		
		JButton btnHard = new JButton("Hard");
		btnHard.setBounds(485, 145, 117, 25);
		frmSportstournamentSetup.getContentPane().add(btnHard);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(666, 380, 117, 25);
		frmSportstournamentSetup.getContentPane().add(btnAccept);
		
		JLabel lblDraftStarting = new JLabel("Draft 4 starting athletes:");
		lblDraftStarting.setBounds(77, 193, 212, 15);
		frmSportstournamentSetup.getContentPane().add(lblDraftStarting);
		
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		athleteListModel.addAll(athletesToDraft);
		JList<Athlete> draftAthletes = new JList<Athlete>(athleteListModel);
		draftAthletes.setBounds(556, 391, -448, -170);
		frmSportstournamentSetup.getContentPane().add(draftAthletes);
		
	}
}
