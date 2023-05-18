package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import sportstournament.main.GameEnvironment;
import sportstournament.main.Item;
import sportstournament.main.Market;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class buyItemScreen extends Screen{

	private JFrame frame;
	private Market market;
	private ArrayList<Item> inventory;
	private ArrayList<Item> availableItems;



	/**
	 * Create the application.
	 */
	public buyItemScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		market = game.getMarket();
		availableItems = market.viewAvailableItems();
		inventory = game.getClub().viewItems();
		initialize();
		this.window = frame;
		frame.getContentPane().setLayout(null);
		
		DefaultListModel<Item> availableItemsModel= new DefaultListModel<Item>();
		availableItemsModel.addAll(availableItems);
		DefaultListModel<Item> inventoryModel= new DefaultListModel<Item>();
		inventoryModel.addAll(inventory);
		
		JButton buyItemBtn = new JButton("Buy item");
		buyItemBtn.setEnabled(false);
		buyItemBtn.setBounds(64, 191, 117, 25);
		frame.getContentPane().add(buyItemBtn);
		

		JButton sellItemBtn = new JButton("Sell item");
		sellItemBtn.setEnabled(false);
		sellItemBtn.setBounds(64, 357, 117, 25);
		frame.getContentPane().add(sellItemBtn);
		
		JList availableItemsList = new JList(availableItemsModel);
		availableItemsList.setBounds(48, 73, 615, 106);
		frame.getContentPane().add(availableItemsList);
		
		JList inventoryList = new JList(inventoryModel);
		inventoryList.setFont(new Font("Dialog", Font.BOLD, 12));
		inventoryList.setBounds(48, 239, 615, 106);
		frame.getContentPane().add(inventoryList);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.OpenMarket();
				gui.closeBuyItemScreen();
			}
		});
		btnBack.setBounds(545, 357, 117, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel lblCurrentFunds = new JLabel("Current Funds:");
		lblCurrentFunds.setBounds(50, 30, 131, 15);
		frame.getContentPane().add(lblCurrentFunds);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setText("$"+game.getMoneyAmount());
		lblNewLabel.setBounds(174, 30, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Available Items");
		lblNewLabel_1.setBounds(305, 46, 131, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Your items");
		lblNewLabel_2.setBounds(324, 212, 94, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		availableItemsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				if (!listSelectionEvent.getValueIsAdjusting()) {
					if (availableItemsList.getSelectedIndex() != -1) {
						buyItemBtn.setEnabled(true);
					}
					else {
						buyItemBtn.setEnabled(false);
					}
					
				}
			}
		});
		inventoryList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				if (!listSelectionEvent.getValueIsAdjusting()) {
					if (inventoryList.getSelectedIndex() != -1) {
						sellItemBtn.setEnabled(true);
					}
					else {
						sellItemBtn.setEnabled(false);
					}	
				}
			}
		});
		
		buyItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int buyIndex = availableItemsList.getSelectedIndex();
				String message = availableItems.get(buyIndex).name()+" purchased for $"+availableItems.get(buyIndex).getPrice();
				JOptionPane.showMessageDialog(frame, message, "Item Purchased", JOptionPane.INFORMATION_MESSAGE);
				market.buyItem(availableItems.get(buyIndex), game.getClub());
				gui.closeBuyItemScreen();
				gui.OpenMarket();
			}
		});
		
		sellItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int buyIndex = inventoryList.getSelectedIndex();
				String message = inventory.get(buyIndex).name()+" sold for $"+inventory.get(buyIndex).getPrice();
				market.sellItem(inventory.get(buyIndex), game.getClub());
				JOptionPane.showMessageDialog(frame, message,"item sold", JOptionPane.INFORMATION_MESSAGE);
				gui.closeBuyItemScreen();
				gui.OpenMarket();
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 734, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
