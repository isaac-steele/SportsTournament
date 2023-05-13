package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TeamPropertiesScreen {

	private JFrame frmTeam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamPropertiesScreen window = new TeamPropertiesScreen();
					window.frmTeam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeamPropertiesScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeam = new JFrame();
		frmTeam.setTitle("Team");
		frmTeam.setBounds(100, 100, 780, 461);
		frmTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeam.getContentPane().setLayout(null);
		
		JLabel lblTeamName = new JLabel("Team Name:");
		lblTeamName.setBounds(53, 12, 101, 15);
		frmTeam.getContentPane().add(lblTeamName);
		
		JLabel lblStarters = new JLabel("Starters:");
		lblStarters.setBounds(53, 39, 84, 15);
		frmTeam.getContentPane().add(lblStarters);
		
		JLabel lblReserves = new JLabel("Reserves:");
		lblReserves.setBounds(53, 219, 101, 15);
		frmTeam.getContentPane().add(lblReserves);
		
		JButton btnSwapAthletes = new JButton("Swap Athletes");
		btnSwapAthletes.setBounds(574, 214, 146, 25);
		frmTeam.getContentPane().add(btnSwapAthletes);
		
		JButton btnClub = new JButton("Club");
		btnClub.setBounds(619, 394, 117, 25);
		frmTeam.getContentPane().add(btnClub);
	}

}
