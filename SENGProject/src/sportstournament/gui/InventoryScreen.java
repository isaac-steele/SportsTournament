package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class InventoryScreen {

	private JFrame frmInventory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryScreen window = new InventoryScreen();
					window.frmInventory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InventoryScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInventory = new JFrame();
		frmInventory.setTitle("Inventory");
		frmInventory.setBounds(100, 100, 756, 456);
		frmInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventory.getContentPane().setLayout(null);
		
		JLabel lblItems = new JLabel("Items:");
		lblItems.setBounds(39, 28, 70, 15);
		frmInventory.getContentPane().add(lblItems);
		
		JButton btnUseItem = new JButton("Use Item");
		btnUseItem.setBounds(307, 348, 117, 25);
		frmInventory.getContentPane().add(btnUseItem);
		
		JButton btnClub = new JButton("Club");
		btnClub.setBounds(606, 389, 117, 25);
		frmInventory.getContentPane().add(btnClub);
	}

}
