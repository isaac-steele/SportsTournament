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
import java.awt.Font;

public class TeamPropertiesScreen extends Screen {

	private JFrame teamWindow;
	private Club club;
	private ArrayList<Athlete> activeTeam;
	private ArrayList<Athlete> reserves;
	private JList<Athlete> activeTeamList;
    private JList<Athlete> reservesList;

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
		lblTeamName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeamName.setBounds(23, 13, 101, 27);
		teamWindow.getContentPane().add(lblTeamName);
		
		JLabel lblStarters = new JLabel("Starters:");
		lblStarters.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStarters.setBounds(23, 52, 84, 15);
		teamWindow.getContentPane().add(lblStarters);
		
		JLabel lblReserves = new JLabel("Reserves:");
		lblReserves.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReserves.setBounds(23, 228, 101, 15);
		teamWindow.getContentPane().add(lblReserves);
		
		
		
		JButton btnClub = new JButton("Back to club");
		btnClub.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeTeamPropertiesScreen();
				gui.openClub();
			}
		});
		btnClub.setBounds(599, 367, 142, 52);
		teamWindow.getContentPane().add(btnClub);
		
		JLabel teamName = new JLabel("");
		teamName.setFont(new Font("Tahoma", Font.BOLD, 14));
		teamName.setText(club.viewName());
		teamName.setBounds(136, 13, 226, 26);
		teamWindow.getContentPane().add(teamName);
		
		DefaultListModel<Athlete> activeTeamModel = new DefaultListModel<>();
		activeTeamModel.addAll(activeTeam);
		activeTeamList = new JList<>(activeTeamModel);
		activeTeamList.setFont(new Font("Dialog", Font.BOLD, 11));
		activeTeamList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		activeTeamList.setBounds(94, 79, 644, 84);
		teamWindow.getContentPane().add(activeTeamList);
		
		DefaultListModel<Athlete> reservesModel = new DefaultListModel<>();
		reservesModel.addAll(reserves);
		reservesList = new JList<>(reservesModel);
		reservesList.setFont(new Font("Dialog", Font.BOLD, 11));
		reservesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reservesList.setBounds(23, 255, 715, 100);
		teamWindow.getContentPane().add(reservesList);
		
		JButton btnSwapAthletes = new JButton("Sub athlete");
		btnSwapAthletes.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSwapAthletes.setEnabled(false);
		
		JButton btnSwapPositions = new JButton("Swap positions");
		btnSwapPositions.setBounds(424, 191, 154, 52);
		btnSwapPositions.setEnabled(false);
		teamWindow.getContentPane().add(btnSwapPositions);
		
		 ListSelectionListener selectionListener = new ListSelectionListener() {
		        public void valueChanged(ListSelectionEvent event) {
		        	int[] selections = activeTeamList.getSelectedIndices();
		        	if (selections.length == 2) {
			        	System.out.println("2");

		        		btnSwapPositions.setEnabled(true);
		        		btnSwapAthletes.setEnabled(false);
		        	}
		        	else if (selections.length == 1 && reservesList.getSelectedIndex()!= -1) {
			        	System.out.println("1");

		            	btnSwapAthletes.setEnabled(true);
		            	btnSwapPositions.setEnabled(false);
		            }
		            else {
			        	System.out.println("else");

		            	btnSwapAthletes.setEnabled(false);
		            	btnSwapPositions.setEnabled(false);
		            }
		        }
		 };
		   
		activeTeamList.addListSelectionListener(selectionListener);
		reservesList.addListSelectionListener(selectionListener);
		
		btnSwapAthletes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int activeIndex = activeTeamList.getSelectedIndices()[0];
				int reserveIndex = reservesList.getSelectedIndex();
				String message =  activeTeam.get(activeIndex).getName()+" subbed off for "+reserves.get(reserveIndex).getName();
				club.subAthlete(reserves.get(reserveIndex), activeTeam.get(activeIndex));
				JOptionPane.showMessageDialog(teamWindow, message, "Athletes swapped", JOptionPane.INFORMATION_MESSAGE);
				gui.closeTeamPropertiesScreen();
				gui.openClub();
				
			}
		});
		
		btnSwapPositions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] indices = activeTeamList.getSelectedIndices();
				club.swapPositions(indices[0], indices[1]);
				String message = activeTeam.get(indices[0]).getName()+" swapped position with "+ activeTeam.get(indices[1]).getName();
				JOptionPane.showMessageDialog(teamWindow, message, "Athletes swapped positions", JOptionPane.INFORMATION_MESSAGE);
				gui.closeTeamPropertiesScreen();
				gui.openClub();
				
			}
		});
		
		
		
		
		
		btnSwapAthletes.setBounds(590, 193, 146, 52);
		teamWindow.getContentPane().add(btnSwapAthletes);
		
		JLabel lblNewLabel = new JLabel("Defender");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel.setBounds(22, 79, 70, 15);
		teamWindow.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Defender");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_1.setBounds(23, 95, 70, 15);
		teamWindow.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Attacker");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_2.setBounds(23, 110, 70, 15);
		teamWindow.getContentPane().add(lblNewLabel_2);
		
		JLabel lblAttacker = new JLabel("Attacker");
		lblAttacker.setFont(new Font("Dialog", Font.BOLD, 11));
		lblAttacker.setBounds(23, 126, 70, 15);
		teamWindow.getContentPane().add(lblAttacker);
		
		
	}
}
