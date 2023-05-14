package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import sportstournament.main.GameEnvironment;

public class StadiumScreen extends Screen {

	private JFrame stadiumWindow;
	private GameEnvironment game;
	private Gui gui;


	/**
	 * Create the application.
	 */
	public StadiumScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		initialize();
		super.window = stadiumWindow;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		stadiumWindow = new JFrame();
		stadiumWindow.setTitle("Stadium");
		stadiumWindow.setBounds(100, 100, 788, 464);
		stadiumWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stadiumWindow.getContentPane().setLayout(null);
		
		JButton btnMatch = new JButton("Match 1");
		btnMatch.setBounds(110, 151, 117, 25);
		stadiumWindow.getContentPane().add(btnMatch);
		
		JButton btnMatch_1 = new JButton("Match 2");
		btnMatch_1.setBounds(327, 151, 117, 25);
		stadiumWindow.getContentPane().add(btnMatch_1);
		
		JButton btnMatch_2 = new JButton("Match 3");
		btnMatch_2.setBounds(554, 151, 117, 25);
		stadiumWindow.getContentPane().add(btnMatch_2);
		
		JLabel lblChooseAMatch = new JLabel("Choose a match to play:");
		lblChooseAMatch.setBounds(76, 45, 229, 15);
		stadiumWindow.getContentPane().add(lblChooseAMatch);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(649, 383, 117, 25);
		stadiumWindow.getContentPane().add(btnMainMenu);
	}

}
