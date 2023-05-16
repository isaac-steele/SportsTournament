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

public class InventoryScreen extends Screen {

	private JFrame inventoryWindow;
	private ArrayList<Item> inventory;
	private Club club = game.getClub();
	private ArrayList<Athlete> team;


	/**
	 * Create the application.
	 */
	public InventoryScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		inventory = club.viewItems();
		team = club.viewActiveTeam();
		// cant do this or else all reserves are now in active team. just do two separate jlists.
		team.addAll(club.viewReserves());
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
		
		JLabel lblItems = new JLabel("Items:");
		lblItems.setBounds(39, 28, 70, 15);
		inventoryWindow.getContentPane().add(lblItems);
		
		
		
		JButton btnClub = new JButton("Club");
		btnClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeInventoryScreen();
				gui.openClub();
			}
		});
		btnClub.setBounds(606, 389, 117, 25);
		inventoryWindow.getContentPane().add(btnClub);
		
		DefaultListModel<Item> inventoryModel = new DefaultListModel<Item>();
		inventoryModel.addAll(inventory);
		JList inventoryList = new JList(inventoryModel);
		inventoryList.setBounds(39, 85, 281, 221);
		inventoryWindow.getContentPane().add(inventoryList);
		
		JLabel lblNewLabel = new JLabel("Choose player to use item on");
		lblNewLabel.setBounds(429, 28, 259, 15);
		inventoryWindow.getContentPane().add(lblNewLabel);
		
		DefaultListModel<Athlete> teamModel = new DefaultListModel<Athlete>();
		teamModel.addAll(team);
		JList teamList = new JList(teamModel);
		teamList.setBounds(406, 85, 287, 221);
		inventoryWindow.getContentPane().add(teamList);
		
		JButton btnUseItem = new JButton("Use Item");
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemIndex = inventoryList.getSelectedIndex();
				int athleteIndex = teamList.getSelectedIndex();
				club.useItem(inventory.get(itemIndex), team.get(athleteIndex));
				gui.closeInventoryScreen();
				gui.openClub();
			}
		});
		btnUseItem.setBounds(307, 348, 117, 25);
		inventoryWindow.getContentPane().add(btnUseItem);
	}
}
