package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class ClubScreen {

	private JFrame frmClub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubScreen window = new ClubScreen();
					window.frmClub.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClubScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClub = new JFrame();
		frmClub.setTitle("Club");
		frmClub.setBounds(100, 100, 784, 470);
		frmClub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClub.getContentPane().setLayout(null);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setBounds(63, 122, 284, 169);
		frmClub.getContentPane().add(btnInventory);
		
		JButton btnTeam = new JButton("Team");
		btnTeam.setBounds(400, 122, 307, 169);
		frmClub.getContentPane().add(btnTeam);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(634, 405, 111, 25);
		frmClub.getContentPane().add(btnMainMenu);
	}

}
