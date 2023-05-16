package sportstournament.gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import sportstournament.main.Athlete;
import sportstournament.main.GameEnvironment;
import sportstournament.main.Market;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;

public class buyAthleteScreen extends Screen{

	private JFrame frame;
	private Market market;
	private ArrayList<Athlete> freeAgents;
	private ArrayList<Athlete> activeTeam;
	private ArrayList<Athlete> reserves;
 
	/**
	 * Create the application.
	 */
	public buyAthleteScreen(GameEnvironment game, Gui gui) {
		super(game,gui);
		market = game.getMarket();
		freeAgents = market.getFreeAgents();
		activeTeam = game.getActiveTeam();
		reserves = game.getReserves();
		initialize();
		this.window = frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 766, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeBuyAthleteScreen();
				gui.OpenMarket();
			}
		});
		backBtn.setBounds(39, 34, 117, 25);
		frame.getContentPane().add(backBtn);
		
		
		DefaultListModel<Athlete> availableAthletesModel= new DefaultListModel<Athlete>();
		availableAthletesModel.addAll(freeAgents);
		JList availableAthletesList = new JList(availableAthletesModel);
		
		
		availableAthletesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		availableAthletesList.setBounds(39, 93, 262, 229);
		frame.getContentPane().add(availableAthletesList);
		
		DefaultListModel<Athlete> reservesModel = new DefaultListModel<>();
		reservesModel.addAll(reserves);
		JList<Athlete> reservesList = new JList<>(reservesModel);
		reservesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reservesList.setBounds(377, 38, 325, 137);
		frame.getContentPane().add(reservesList);
		
		DefaultListModel<Athlete> activeTeamModel = new DefaultListModel<>();
		activeTeamModel.addAll(activeTeam);
		JList<Athlete> activeTeamList = new JList<>(activeTeamModel);
		activeTeamList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		activeTeamList.setBounds(377, 245, 325, 137);
		frame.getContentPane().add(activeTeamList);
		
		JButton sellStarterBtn = new JButton("Sell starter");
		sellStarterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sellIndex = activeTeamList.getSelectedIndex();
				int replaceIndex = reservesList.getSelectedIndex();
				market.returnStarter(activeTeam.get(sellIndex), reserves.get(replaceIndex), game.getClub());
				gui.closeBuyAthleteScreen();
				gui.OpenMarket();
				
			}
		});
		sellStarterBtn.setBounds(491, 200, 117, 25);
		frame.getContentPane().add(sellStarterBtn);
		
		JButton sellReserveBtn = new JButton("Sell reserve");
		sellReserveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sellIndex = reservesList.getSelectedIndex();
				market.returnReserve(reserves.get(sellIndex), game.getClub());
				gui.closeBuyAthleteScreen();
				gui.OpenMarket();
			}
		});
		sellReserveBtn.setBounds(491, 408, 144, 25);
		frame.getContentPane().add(sellReserveBtn);
		
		JLabel lblPleaseSelectA = new JLabel("Please select a starter to take off ");
		lblPleaseSelectA.setFont(new Font("Dialog", Font.BOLD, 10));
		lblPleaseSelectA.setBounds(192, 413, 203, 15);
		frame.getContentPane().add(lblPleaseSelectA);
		
		JButton buyReserveBtn = new JButton("Buy as reserve");
		buyReserveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int buyIndex = availableAthletesList.getSelectedIndex();
				market.buyReserve(freeAgents.get(buyIndex), game.getClub());
				gui.closeBuyAthleteScreen();
				gui.OpenMarket();
			}
		});
		buyReserveBtn.setBounds(12, 350, 170, 60);
		frame.getContentPane().add(buyReserveBtn);
		
		JButton buyStarterBtn = new JButton("Buy as starter ");
		buyStarterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Please select an athlete to replace the starter");
				int buyIndex = availableAthletesList.getSelectedIndex();
				int subOffIndex = activeTeamList.getSelectedIndex();
				market.buyStarter(freeAgents.get(buyIndex), activeTeam.get(subOffIndex), game.getClub());
				gui.closeBuyAthleteScreen();
				gui.OpenMarket();
				
			}
		});
		buyStarterBtn.setBounds(192, 334, 157, 60);
		frame.getContentPane().add(buyStarterBtn);
		
		
		availableAthletesList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				if (!listSelectionEvent.getValueIsAdjusting()) {
					if (availableAthletesList.getSelectedIndex() != -1) {
						buyReserveBtn.setEnabled(true);
						if (activeTeamList.getSelectedIndex() != -1) {
							buyStarterBtn.setEnabled(true);
						}
					}
					
				}
			}
		});
		
		/**
		 * enables the sell reserve button
		 */
		reservesList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				if (!listSelectionEvent.getValueIsAdjusting()) {
					if (reservesList.getSelectedIndex() != -1 && availableAthletesList.getSelectedIndex() == -1) {
						sellReserveBtn.setEnabled(true);
					}
					
					
				}
			}
		});
		/**
		 * enables the sell starter button
		 */
		activeTeamList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				if (!listSelectionEvent.getValueIsAdjusting()) {
					if (activeTeamList.getSelectedIndex() != -1 && availableAthletesList.getSelectedIndex() == -1 && reservesList.getSelectedIndex() != -1) {
						sellStarterBtn.setEnabled(true);
					}
					
					
				}
			}
		});
		
		
		
		
	}
}
