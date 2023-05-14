package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sportstournament.main.GameEnvironment;

import javax.swing.JButton;

public class TakeByeScreen extends Screen {

	private JFrame frmBye;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public TakeByeScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBye = new JFrame();
		frmBye.setTitle("Bye");
		frmBye.setBounds(100, 100, 812, 471);
		frmBye.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBye.getContentPane().setLayout(null);
		
		JLabel lblChooseAthleteTo = new JLabel("Choose athlete to specially train:");
		lblChooseAthleteTo.setBounds(43, 25, 317, 15);
		frmBye.getContentPane().add(lblChooseAthleteTo);
		
		JButton btnTrainAthlete = new JButton("Train athlete");
		btnTrainAthlete.setBounds(328, 338, 167, 25);
		frmBye.getContentPane().add(btnTrainAthlete);
	}

}
