package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AvailableAthletesScreen {

	private JFrame frmAvailableAthletes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvailableAthletesScreen window = new AvailableAthletesScreen();
					window.frmAvailableAthletes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AvailableAthletesScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAvailableAthletes = new JFrame();
		frmAvailableAthletes.setTitle("Available Athletes");
		frmAvailableAthletes.setBounds(100, 100, 793, 470);
		frmAvailableAthletes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAvailableAthletes.getContentPane().setLayout(null);
		
		JLabel lblChooseAnAthlete = new JLabel("Choose an athlete to purchase:");
		lblChooseAnAthlete.setBounds(40, 54, 277, 15);
		frmAvailableAthletes.getContentPane().add(lblChooseAnAthlete);
		
		JLabel lblTotalFunds = new JLabel("Total Funds:");
		lblTotalFunds.setBounds(40, 12, 132, 15);
		frmAvailableAthletes.getContentPane().add(lblTotalFunds);
		
		JButton btnAddToTeam = new JButton("Add to starters");
		btnAddToTeam.setBounds(90, 337, 173, 25);
		frmAvailableAthletes.getContentPane().add(btnAddToTeam);
		
		JButton btnAddToReserves = new JButton("Add to reserves");
		btnAddToReserves.setBounds(483, 337, 173, 25);
		frmAvailableAthletes.getContentPane().add(btnAddToReserves);
		
		JButton btnMarket = new JButton("Market");
		btnMarket.setBounds(654, 403, 117, 25);
		frmAvailableAthletes.getContentPane().add(btnMarket);
	}

}
