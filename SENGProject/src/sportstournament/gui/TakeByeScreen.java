package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sportstournament.main.GameEnvironment;

import javax.swing.JButton;

public class TakeByeScreen extends Screen {

	private JFrame takeByeWindow;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public TakeByeScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		initialize();
		super.window = takeByeWindow;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		takeByeWindow = new JFrame();
		takeByeWindow.setTitle("Bye");
		takeByeWindow.setBounds(100, 100, 812, 471);
		takeByeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		takeByeWindow.getContentPane().setLayout(null);
		
		JLabel lblChooseAthleteTo = new JLabel("Choose athlete to specially train:");
		lblChooseAthleteTo.setBounds(43, 25, 317, 15);
		takeByeWindow.getContentPane().add(lblChooseAthleteTo);
		
		JButton btnTrainAthlete = new JButton("Train athlete");
		btnTrainAthlete.setBounds(328, 338, 167, 25);
		takeByeWindow.getContentPane().add(btnTrainAthlete);
	}

}
