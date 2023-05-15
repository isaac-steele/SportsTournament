package sportstournament.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import sportstournament.main.Athlete;
import sportstournament.main.Club;
import sportstournament.main.GameEnvironment;

import javax.swing.DefaultListModel;
import javax.swing.JButton;


public class ClubScreen extends Screen {

	protected JFrame clubWindow;
	private Club club;
	


	/**
	 * Create the application.
	 */
	public ClubScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		club = game.getClub();
		initialize();
		super.window = clubWindow;
		
		
	
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		clubWindow = new JFrame();
		clubWindow.setTitle("Club");
		clubWindow.setBounds(100, 100, 784, 470);
		clubWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clubWindow.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("View Team");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeClub();
				gui.openTeamPropertiesScreen();
			}
		});
		btnNewButton.setBounds(80, 130, 203, 148);
		clubWindow.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Inventory");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeClub();
				gui.openInventoryScreen();
			}
		});
		btnNewButton_1.setBounds(423, 130, 203, 148);
		clubWindow.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeClub();
				gui.openMainScreen();
			}
		});
		btnNewButton_2.setBounds(123, 365, 117, 25);
		clubWindow.getContentPane().add(btnNewButton_2);
		
		
		DefaultListModel<Athlete> activeTeamModel = new DefaultListModel<Athlete>();
		activeTeamModel.addAll(club.viewActiveTeam());
			}
}
