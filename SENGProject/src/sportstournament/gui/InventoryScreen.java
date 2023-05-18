package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sportstournament.main.Athlete;
import sportstournament.main.Club;
import sportstournament.main.GameEnvironment;
import sportstournament.main.Item;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;

public class InventoryScreen extends Screen {

	private JFrame inventoryWindow;
	private ArrayList<Item> inventory;
	private Club club = game.getClub();
	private ArrayList<Athlete> activeTeam;
	private ArrayList<Athlete> reserves;
	private JList<Athlete> teamList;


	/**
	 * Create the application.
	 */
	public InventoryScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		inventory = club.viewItems();
		this.activeTeam = game.getActiveTeam();
		this.reserves = game.getReserves();
		initialize();
		super.window = inventoryWindow;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		inventoryWindow = new JFrame();
		inventoryWindow.setTitle("Inventory");
		inventoryWindow.setBounds(100, 100, 756, 456);
		inventoryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inventoryWindow.getContentPane().setLayout(null);
		
		JLabel lblItems = new JLabel("Available Items:");
		lblItems.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblItems.setBounds(39, 48, 147, 15);
		inventoryWindow.getContentPane().add(lblItems);
		
		
		
		JButton btnClub = new JButton("Back to club");
		btnClub.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeInventoryScreen();
				gui.openClub();
			}
		});
		btnClub.setBounds(551, 350, 136, 44);
		inventoryWindow.getContentPane().add(btnClub);
		
		DefaultListModel<Item> inventoryModel = new DefaultListModel<Item>();
		inventoryModel.addAll(inventory);
		JList inventoryList = new JList(inventoryModel);
		inventoryList.setBounds(39, 85, 281, 221);
		inventoryWindow.getContentPane().add(inventoryList);
		
		JLabel lblNewLabel = new JLabel("Please select a player to use item on");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(448, 47, 259, 15);
		inventoryWindow.getContentPane().add(lblNewLabel);
		
		DefaultListModel<Athlete> teamModel = new DefaultListModel<Athlete>();
		teamModel.addAll(reserves);
		teamModel.addAll(activeTeam);
		teamList = new JList(teamModel);
		teamList.setBounds(406, 85, 287, 221);
		inventoryWindow.getContentPane().add(teamList);
		
		
		
		JButton btnUseItem = new JButton("Use Item");
		btnUseItem.setEnabled(false);
		btnUseItem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemIndex = inventoryList.getSelectedIndex();
				int athleteIndex = teamList.getSelectedIndex();
				if (athleteIndex > 4) {
					athleteIndex -= 4;
					club.useItem(inventory.get(itemIndex), reserves.get(athleteIndex));
				}
				else {
					club.useItem(inventory.get(itemIndex), activeTeam.get(athleteIndex));
				}
				gui.closeInventoryScreen();
				gui.openClub();
			}
		});
		btnUseItem.setBounds(39, 350, 174, 44);
		inventoryWindow.getContentPane().add(btnUseItem);
		
		ListSelectionListener selectionListener = new ListSelectionListener() {
	        public void valueChanged(ListSelectionEvent event) {
	            if (teamList.getSelectedIndex() != -1 && inventoryList.getSelectedIndex()!= -1) {
	            	btnUseItem.setEnabled(true);
	            }
	            else {
	            	btnUseItem.setEnabled(false);
	            }
	        }
	    };
	    
	    teamList.addListSelectionListener(selectionListener);
	    inventoryList.addListSelectionListener(selectionListener);
	}
	
}
