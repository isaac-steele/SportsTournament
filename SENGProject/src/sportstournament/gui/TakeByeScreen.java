package sportstournament.gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sportstournament.main.Athlete;
import sportstournament.main.GameEnvironment;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TakeByeScreen extends Screen {

	private JFrame takeByeWindow;
	private ArrayList<Athlete> starters;
	private ArrayList<Athlete> reserves;
	private Athlete chosenAthlete;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public TakeByeScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		starters = game.getActiveTeam();
		reserves = game.getReserves();
		initialize();
		super.window = takeByeWindow;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		takeByeWindow = new JFrame();
		takeByeWindow.setTitle("Bye");
		takeByeWindow.setBounds(100, 100, 791, 468);
		takeByeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		takeByeWindow.getContentPane().setLayout(null);
		
		JLabel lblChooseAthleteTo = new JLabel("Choose athlete to specially train:");
		lblChooseAthleteTo.setBounds(43, 25, 317, 15);
		takeByeWindow.getContentPane().add(lblChooseAthleteTo);
		
		JButton btnTrainAthlete = new JButton("Train athlete");
		btnTrainAthlete.setEnabled(false);
		btnTrainAthlete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.trainAthlete(chosenAthlete);
				gui.takeBye();
			}
		});
		btnTrainAthlete.setBounds(548, 357, 167, 25);
		takeByeWindow.getContentPane().add(btnTrainAthlete);
		
		JLabel lblTheChosenAthlete = new JLabel("<html>The chosen athlete will get a +10 boost for<br/>both their offence and defence stats.<html>");
		lblTheChosenAthlete.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheChosenAthlete.setBounds(43, 344, 317, 38);
		takeByeWindow.getContentPane().add(lblTheChosenAthlete);
		
		JLabel lblStarters = new JLabel("Starters:");
		lblStarters.setBounds(53, 55, 70, 15);
		takeByeWindow.getContentPane().add(lblStarters);
		
		JLabel lblReserves = new JLabel("Reserves:");
		lblReserves.setBounds(53, 203, 70, 15);
		takeByeWindow.getContentPane().add(lblReserves);
		
		DefaultListModel<Athlete> startersListModel = new DefaultListModel<Athlete>();
		startersListModel.addAll(starters);
		JList<Athlete> startersList = new JList<Athlete>(startersListModel);
		startersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		startersList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnTrainAthlete.setEnabled(true);
				chosenAthlete = startersList.getSelectedValue();
			}
		});
		startersList.setBounds(43, 82, 672, 102);
		takeByeWindow.getContentPane().add(startersList);
		
		DefaultListModel<Athlete> reservesListModel = new DefaultListModel<Athlete>();
		reservesListModel.addAll(reserves);
		JList<Athlete> reservesList = new JList<Athlete>(reservesListModel);
		reservesList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnTrainAthlete.setEnabled(true);
				chosenAthlete = reservesList.getSelectedValue();
			}
		});
		reservesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reservesList.setBounds(43, 230, 672, 102);
		takeByeWindow.getContentPane().add(reservesList);
		
		JLabel lblTheLastClicked = new JLabel("The last clicked athlete will be the chosen athlete.");
		lblTheLastClicked.setBounds(43, 388, 365, 15);
		takeByeWindow.getContentPane().add(lblTheLastClicked);
	}
}
