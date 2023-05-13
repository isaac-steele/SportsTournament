package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class StadiumScreen {

	private JFrame frmStadium;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StadiumScreen window = new StadiumScreen();
					window.frmStadium.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StadiumScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStadium = new JFrame();
		frmStadium.setTitle("Stadium");
		frmStadium.setBounds(100, 100, 788, 464);
		frmStadium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStadium.getContentPane().setLayout(null);
		
		JButton btnMatch = new JButton("Match 1");
		btnMatch.setBounds(110, 151, 117, 25);
		frmStadium.getContentPane().add(btnMatch);
		
		JButton btnMatch_1 = new JButton("Match 2");
		btnMatch_1.setBounds(327, 151, 117, 25);
		frmStadium.getContentPane().add(btnMatch_1);
		
		JButton btnMatch_2 = new JButton("Match 3");
		btnMatch_2.setBounds(554, 151, 117, 25);
		frmStadium.getContentPane().add(btnMatch_2);
		
		JLabel lblChooseAMatch = new JLabel("Choose a match to play:");
		lblChooseAMatch.setBounds(76, 45, 229, 15);
		frmStadium.getContentPane().add(lblChooseAMatch);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(649, 383, 117, 25);
		frmStadium.getContentPane().add(btnMainMenu);
	}

}
