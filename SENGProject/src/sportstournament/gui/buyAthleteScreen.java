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
	    frame.setBounds(100, 100, 931, 561);
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

	    DefaultListModel<Athlete> availableAthletesModel = new DefaultListModel<>();
	    availableAthletesModel.addAll(freeAgents);
	    availableAthletesList = new JList<>(availableAthletesModel);
	    availableAthletesList.setFont(new Font("Tahoma", Font.PLAIN, 9));
	    availableAthletesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    availableAthletesList.setBounds(22, 78, 418, 229);
	    frame.getContentPane().add(availableAthletesList);

	    DefaultListModel<Athlete> reservesModel = new DefaultListModel<>();
	    reservesModel.addAll(reserves);
	    reservesList = new JList<>(reservesModel);
	    reservesList.setFont(new Font("Tahoma", Font.PLAIN, 9));
	    reservesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    reservesList.setBounds(466, 304, 426, 175);
	    frame.getContentPane().add(reservesList);

	    DefaultListModel<Athlete> activeTeamModel = new DefaultListModel<>();
	    activeTeamModel.addAll(activeTeam);
	    activeTeamList = new JList<>(activeTeamModel);
	    activeTeamList.setFont(new Font("Tahoma", Font.PLAIN, 9));

	    activeTeamList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    activeTeamList.setBounds(466, 39, 426, 175);
	    frame.getContentPane().add(activeTeamList);

	    sellStarterBtn = new JButton("Sell starter");
	    sellStarterBtn.setEnabled(false);
	    sellStarterBtn.setBounds(466, 224, 117, 25);
	    frame.getContentPane().add(sellStarterBtn);

	    sellReserveBtn = new JButton("Sell reserve");
	    sellReserveBtn.setEnabled(false);
	    sellReserveBtn.setBounds(466, 489, 144, 25);
	    frame.getContentPane().add(sellReserveBtn);

	    buyReserveBtn = new JButton("Buy as reserve");
	    buyReserveBtn.setEnabled(false);
	    buyReserveBtn.setBounds(259, 340, 170, 60);
	    frame.getContentPane().add(buyReserveBtn);

	    buyStarterBtn = new JButton("Buy as starter");
	    buyStarterBtn.setEnabled(false);
	    buyStarterBtn.setBounds(10, 340, 157, 60);
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
	            market.returnStarter(activeTeam.get(sellIndex), reserves.get(replaceIndex), game.getClub());
	            JOptionPane.showMessageDialog(frame,message,"starter sold", JOptionPane.INFORMATION_MESSAGE);
	            gui.closeBuyAthleteScreen();
	            gui.OpenMarket();
	            
	        }
	    });

	    sellReserveBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int sellIndex = reservesList.getSelectedIndex();
	            String message =  "Reserve: "+reserves.get(sellIndex).getName()+" sold";
	            market.returnReserve(reserves.get(sellIndex), game.getClub());
	            JOptionPane.showMessageDialog(frame,message,"reserve sold", JOptionPane.INFORMATION_MESSAGE);
	            gui.closeBuyAthleteScreen();
	            gui.OpenMarket();
	        }
	    });

	   

	    buyReserveBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int buyIndex = availableAthletesList.getSelectedIndex();
	            String message =  "Free agent: "+freeAgents.get(buyIndex).getName()+" purchased and sent to reserves";
	            market.buyReserve(freeAgents.get(buyIndex), game.getClub());
	            JOptionPane.showMessageDialog(frame,message,"reserve purchased", JOptionPane.INFORMATION_MESSAGE);
	            gui.closeBuyAthleteScreen();
	            gui.OpenMarket();
	        }
	    });
	    
	    buyStarterBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int buyIndex = availableAthletesList.getSelectedIndex();
	            int subIndex = activeTeamList.getSelectedIndex();
	            String message =  "Athlete: "+freeAgents.get(buyIndex).getName()+" purchased subbed on for starter: "+activeTeam.get(subIndex).getName()+", ";
	            JOptionPane.showMessageDialog(frame,message,"starter purchased", JOptionPane.INFORMATION_MESSAGE);
	            market.buyStarter(freeAgents.get(buyIndex),activeTeam.get(subIndex), game.getClub());
	            gui.closeBuyAthleteScreen();
	            gui.OpenMarket();
	        }
	    });
	    
	    
	    JLabel lblPleaseSelectA = new JLabel("Please select a starter to take off ");
	    lblPleaseSelectA.setFont(new Font("Dialog", Font.BOLD, 10));
	    lblPleaseSelectA.setBounds(10, 413, 203, 15);
	    frame.getContentPane().add(lblPleaseSelectA);
	    
	    JLabel lblNewLabel = new JLabel("Please select a reserve to sub on");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
	    lblNewLabel.setBounds(643, 230, 193, 13);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Starting Lineup");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    lblNewLabel_1.setBounds(610, 16, 127, 13);
	    frame.getContentPane().add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("Reserves");
	    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    lblNewLabel_1_1.setBounds(621, 281, 127, 13);
	    frame.getContentPane().add(lblNewLabel_1_1);
	}

	private void updateButton() {
	    boolean buyStarterEnabled = activeTeamList.getSelectedIndex() != -1 && availableAthletesList.getSelectedIndex() != -1;
	    boolean buyReserveEnabled = availableAthletesList.getSelectedIndex() != -1;
	    boolean sellStarterEnabled = reservesList.getSelectedIndex() != -1 && activeTeamList.getSelectedIndex() != -1;
	    boolean sellReserveEnabled = reservesList.getSelectedIndex() != -1;

	    buyStarterBtn.setEnabled(buyStarterEnabled);
	    buyReserveBtn.setEnabled(buyReserveEnabled);
	    sellStarterBtn.setEnabled(sellStarterEnabled);
	    sellReserveBtn.setEnabled(sellReserveEnabled);
	}
}
