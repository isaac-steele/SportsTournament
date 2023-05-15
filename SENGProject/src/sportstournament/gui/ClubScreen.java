package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import sportstournament.main.Athlete;
import sportstournament.main.Club;
import sportstournament.main.GameEnvironment;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ClubScreen extends Screen {

	protected JFrame clubWindow;
	private Club club;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ClubScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		club = game.getClub();
		initialize();
		super.window = clubWindow;
		
		
	
		
	}
	
	public void closeWindow() {
		clubWindow.dispose();
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
		
		
		DefaultListModel<Athlete> activeTeamModel = new DefaultListModel<Athlete>();
		activeTeamModel.addAll(club.viewActiveTeam());
			}
}
