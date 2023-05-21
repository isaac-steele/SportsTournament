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

public class BuyAthleteScreen extends Screen{

	private JFrame frame;
	private Market market;
	private ArrayList<Athlete> freeAgents;
	private ArrayList<Athlete> activeTeam;
	private ArrayList<Athlete> reserves;
	private JList<Athlete> availableAthletesList;
	private JList<Athlete> reservesList;
	private JList<Athlete> activeTeamList;
	private JButton sellStarterBtn;
	private JButton sellReserveBtn;
	private JButton buyReserveBtn;
	private JButton buyStarterBtn;
 
	/**
	 * Create the application.
	 */
	public BuyAthleteScreen(GameEnvironment game, Gui gui) {
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
	    frame.setBounds(100, 100, 998, 604);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);

	    JButton backBtn = new JButton("Back");
	    backBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            gui.closeBuyAthleteScreen();
	            gui.OpenMarket();
	        }
	    });
	    backBtn.setBounds(853, 518, 117, 25);
	    frame.getContentPane().add(backBtn);

	    DefaultListModel<Athlete> availableAthletesModel = new DefaultListModel<>();
	    availableAthletesModel.addAll(freeAgents);
	    availableAthletesList = new JList<>(availableAthletesModel);
	    availableAthletesList.setFont(new Font("Dialog", Font.BOLD, 11));
	    availableAthletesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    availableAthletesList.setBounds(25, 65, 709, 146);
	    frame.getContentPane().add(availableAthletesList);

	    DefaultListModel<Athlete> reservesModel = new DefaultListModel<>();
	    reservesModel.addAll(reserves);
	    reservesList = new JList<>(reservesModel);
	    reservesList.setFont(new Font("Dialog", Font.BOLD, 11));
	    reservesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    reservesList.setBounds(25, 410, 718, 133);
	    frame.getContentPane().add(reservesList);

	    DefaultListModel<Athlete> activeTeamModel = new DefaultListModel<>();
	    activeTeamModel.addAll(activeTeam);
	    activeTeamList = new JList<>(activeTeamModel);
	    activeTeamList.setFont(new Font("Dialog", Font.BOLD, 11));

	    activeTeamList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    activeTeamList.setBounds(25, 241, 718, 133);
	    frame.getContentPane().add(activeTeamList);

	    sellStarterBtn = new JButton("Sell starter");
	    sellStarterBtn.setEnabled(false);
	    sellStarterBtn.setBounds(777, 268, 174, 60);
	    frame.getContentPane().add(sellStarterBtn);

	    sellReserveBtn = new JButton("Sell reserve");
	    sellReserveBtn.setEnabled(false);
	    sellReserveBtn.setBounds(777, 424, 174, 60);
	    frame.getContentPane().add(sellReserveBtn);

	    buyReserveBtn = new JButton("Buy as reserve");
	    buyReserveBtn.setEnabled(false);
	    buyReserveBtn.setBounds(777, 38, 174, 60);
	    frame.getContentPane().add(buyReserveBtn);

	    buyStarterBtn = new JButton("Buy as starter");
	    buyStarterBtn.setEnabled(false);
	    buyStarterBtn.setBounds(777, 133, 174, 60);
	    frame.getContentPane().add(buyStarterBtn);

	    ListSelectionListener selectionListener = new ListSelectionListener() {
	        public void valueChanged(ListSelectionEvent event) {
	            updateButton();
	        }
	    };

	    availableAthletesList.addListSelectionListener(selectionListener);
	    activeTeamList.addListSelectionListener(selectionListener);
	    reservesList.addListSelectionListener(selectionListener);

	    sellStarterBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int sellIndex = activeTeamList.getSelectedIndex();
	            int replaceIndex = reservesList.getSelectedIndex();
	            String message =  "Starter: "+activeTeam.get(sellIndex).getName()+" sold and replaced with reserve: "+reserves.get(replaceIndex).getName();
	            market.sellStarter(activeTeam.get(sellIndex), reserves.get(replaceIndex), game.getClub());
	            JOptionPane.showMessageDialog(frame,message,"Starter Sold", JOptionPane.INFORMATION_MESSAGE);
	            gui.closeBuyAthleteScreen();
	            gui.OpenMarket();
	            
	        }
	    });

	    sellReserveBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int sellIndex = reservesList.getSelectedIndex();
	            String message =  "Reserve: "+reserves.get(sellIndex).getName()+" sold";
	            market.sellReserve(reserves.get(sellIndex), game.getClub());
	            JOptionPane.showMessageDialog(frame,message,"Reserve Sold", JOptionPane.INFORMATION_MESSAGE);
	            gui.closeBuyAthleteScreen();
	            gui.OpenMarket();
	        }
	    });

	   

	    buyReserveBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int buyIndex = availableAthletesList.getSelectedIndex();
	            String message =  "Free agent: "+freeAgents.get(buyIndex).getName()+" purchased and sent to reserves";
	            String result = market.buyReserve(freeAgents.get(buyIndex), game.getClub());
	            if (result == "You cannot afford this") {
					JOptionPane.showMessageDialog(frame, "You cannot afford this athlete", "Insufficient funds", JOptionPane.ERROR_MESSAGE);
	            }
	            else if (result == "Maximum size of reserves is 5") {
					JOptionPane.showMessageDialog(frame, "You may only have a maximum of 5 reserves", "Reserves full", JOptionPane.ERROR_MESSAGE);

	            }
	            else {
		            JOptionPane.showMessageDialog(frame,message,"Reserve Purchased", JOptionPane.INFORMATION_MESSAGE);

	            }
	            gui.closeBuyAthleteScreen();
	            gui.OpenMarket();
	        }
	    });
	    
	    buyStarterBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int buyIndex = availableAthletesList.getSelectedIndex();
	            int subIndex = activeTeamList.getSelectedIndex();
	            String message =  "Athlete: "+freeAgents.get(buyIndex).getName()+" purchased and subbed on for starter: "+activeTeam.get(subIndex).getName()+", ";
	            String result = market.buyStarter(freeAgents.get(buyIndex),activeTeam.get(subIndex), game.getClub());
	            if (result== "You cannot afford this!") {
					JOptionPane.showMessageDialog(frame, "You cannot afford this athlete", "Insufficient funds", JOptionPane.ERROR_MESSAGE);
	            }
	            else if  (result == "Maximum size of reserves is 5") {
		            JOptionPane.showMessageDialog(frame,"Your team is full", "Team full", JOptionPane.ERROR_MESSAGE);

	            }
	            else {
		            JOptionPane.showMessageDialog(frame,message,"Starter Purchased", JOptionPane.INFORMATION_MESSAGE);

	            }
	            gui.closeBuyAthleteScreen();
	            gui.OpenMarket();
	        }
	    });
	    
	    
	    JLabel lblPleaseSelectA = new JLabel("Please select a starter to sub off ");
	    lblPleaseSelectA.setFont(new Font("Dialog", Font.BOLD, 11));
	    lblPleaseSelectA.setBounds(751, 205, 235, 15);
	    frame.getContentPane().add(lblPleaseSelectA);
	    
	    JLabel lblNewLabel = new JLabel("Please select a reserve to sub on");
	    lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 11));
	    lblNewLabel.setBounds(751, 340, 219, 13);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Starting Lineup");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    lblNewLabel_1.setBounds(350, 216, 127, 13);
	    frame.getContentPane().add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("Reserves");
	    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    lblNewLabel_1_1.setBounds(378, 386, 127, 13);
	    frame.getContentPane().add(lblNewLabel_1_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("Maximum of 5 reserves");
	    lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 11));
	    lblNewLabel_2.setBounds(780, 106, 185, 15);
	    frame.getContentPane().add(lblNewLabel_2);
	    
	    JLabel lblNewLabel_3 = new JLabel("Current Funds:");
	    lblNewLabel_3.setBounds(23, 7, 117, 35);
	    frame.getContentPane().add(lblNewLabel_3);
	    
	    JLabel fundsLabel = new JLabel();
	    fundsLabel.setText("$"+game.getMoneyAmount());
	    fundsLabel.setBounds(139, 20, 159, 35);
	    frame.getContentPane().add(fundsLabel);
	    
	    JLabel lblNewLabel_4 = new JLabel("Available athletes");
	    lblNewLabel_4.setBounds(336, 38, 157, 15);
	    frame.getContentPane().add(lblNewLabel_4);
	}

	private void updateButton() {
	    boolean buyStarterEnabled = activeTeamList.getSelectedIndex() != -1 && availableAthletesList.getSelectedIndex() != -1;
	    boolean buyReserveEnabled = availableAthletesList.getSelectedIndex() != -1 && availableAthletesList.getSelectedIndex() <= 4;
	    boolean sellStarterEnabled = reservesList.getSelectedIndex() != -1 && activeTeamList.getSelectedIndex() != -1;
	    boolean sellReserveEnabled = reservesList.getSelectedIndex() != -1;

	    buyStarterBtn.setEnabled(buyStarterEnabled);
	    buyReserveBtn.setEnabled(buyReserveEnabled);
	    sellStarterBtn.setEnabled(sellStarterEnabled);
	    sellReserveBtn.setEnabled(sellReserveEnabled);
	}
}
