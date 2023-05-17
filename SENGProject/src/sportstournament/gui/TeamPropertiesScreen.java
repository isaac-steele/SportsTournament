package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sportstournament.main.Athlete;
import sportstournament.main.Club;
import sportstournament.main.GameEnvironment;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TeamPropertiesScreen extends Screen {

	private JFrame teamWindow;
	private Club club;
	private ArrayList<Athlete> activeTeam;
	private ArrayList<Athlete> reserves;

	/**
	 * Create the application.
	 */
	public TeamPropertiesScreen(GameEnvironment game, Gui gui) {
		super(game,gui);
		club = game.getClub();
		activeTeam = club.viewActiveTeam();
		reserves = club.viewReserves();
		initialize();
		super.window = teamWindow;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		teamWindow = new JFrame();
		teamWindow.setTitle("Team");
		teamWindow.setBounds(100, 100, 780, 461);
		teamWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		teamWindow.getContentPane().setLayout(null);
		
		JLabel lblTeamName = new JLabel("Team Name:");
		lblTeamName.setBounds(53, 12, 101, 15);
		teamWindow.getContentPane().add(lblTeamName);
		
		JLabel lblStarters = new JLabel("Starters:");
		lblStarters.setBounds(53, 39, 84, 15);
		teamWindow.getContentPane().add(lblStarters);
		
		JLabel lblReserves = new JLabel("Reserves:");
		lblReserves.setBounds(53, 219, 101, 15);
		teamWindow.getContentPane().add(lblReserves);
		
		
		
		JButton btnClub = new JButton("Club");
		btnClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeTeamPropertiesScreen();
				gui.openClub();
			}
		});
		btnClub.setBounds(576, 363, 117, 25);
		teamWindow.getContentPane().add(btnClub);
		
		JLabel teamName = new JLabel("");
		teamName.setText(club.viewName());
		teamName.setBounds(171, 13, 226, 14);
		teamWindow.getContentPane().add(teamName);
		
		DefaultListModel<Athlete> activeTeamModel = new DefaultListModel<>();
		activeTeamModel.addAll(activeTeam);
		JList<Athlete> activeTeamList = new JList<>(activeTeamModel);
		activeTeamList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		activeTeamList.setBounds(53, 79, 441, 111);
		teamWindow.getContentPane().add(activeTeamList);
		
		DefaultListModel<Athlete> reservesModel = new DefaultListModel<>();
		reservesModel.addAll(reserves);
		JList<Athlete> reservesList = new JList<>(reservesModel);
		reservesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reservesList.setBounds(53, 271, 441, 121);
		teamWindow.getContentPane().add(reservesList);
		
		JButton btnSwapAthletes = new JButton("Swap Athletes");
		btnSwapAthletes.setEnabled(false);
		
		 ListSelectionListener selectionListener = new ListSelectionListener() {
		        public void valueChanged(ListSelectionEvent event) {
		            if (activeTeamList.getSelectedIndex()!= -1 && reservesList.getSelectedIndex()!= -1) {
		            	btnSwapAthletes.setEnabled(true);
		            }
		            else {
		            	btnSwapAthletes.setEnabled(false);
		            }
		        }
		 };
		   
		activeTeamList.addListSelectionListener(selectionListener);
		reservesList.addListSelectionListener(selectionListener);
		
		btnSwapAthletes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int activeIndex = activeTeamList.getSelectedIndex();
				int reserveIndex = reservesList.getSelectedIndex();
				String message =  activeTeam.get(activeIndex).getName()+" subbed off for "+reserves.get(reserveIndex).getName();
				club.subAthlete(reserves.get(reserveIndex), activeTeam.get(activeIndex));
				JOptionPane.showMessageDialog(teamWindow, message, "Athletes swapped", JOptionPane.INFORMATION_MESSAGE);
				gui.closeTeamPropertiesScreen();
				gui.openClub();
				
			}
		});
		btnSwapAthletes.setBounds(532, 214, 146, 25);
		teamWindow.getContentPane().add(btnSwapAthletes);
	}
}
