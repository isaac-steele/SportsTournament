package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sportstournament.main.GameEnvironment;

import javax.swing.JButton;

public class InventoryScreen extends Screen {

	private JFrame inventoryWindow;


	/**
	 * Create the application.
	 */
	public InventoryScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
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
		
		JButton btnUseItem = new JButton("Use Item");
		btnUseItem.setBounds(307, 348, 117, 25);
		inventoryWindow.getContentPane().add(btnUseItem);
		
		JButton btnClub = new JButton("Club");
		btnClub.setBounds(606, 389, 117, 25);
		inventoryWindow.getContentPane().add(btnClub);
	}

}
