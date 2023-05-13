package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AvailableItemsScreen {

	private JFrame frmAvailableItems;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvailableItemsScreen window = new AvailableItemsScreen();
					window.frmAvailableItems.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AvailableItemsScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAvailableItems = new JFrame();
		frmAvailableItems.setTitle("Available Items");
		frmAvailableItems.setBounds(100, 100, 776, 458);
		frmAvailableItems.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAvailableItems.getContentPane().setLayout(null);
		
		JLabel lblTotalFunds = new JLabel("Total Funds:");
		lblTotalFunds.setBounds(47, 28, 123, 15);
		frmAvailableItems.getContentPane().add(lblTotalFunds);
		
		JLabel lblChooseAnItem = new JLabel("Choose an item to purchase:");
		lblChooseAnItem.setBounds(47, 72, 229, 15);
		frmAvailableItems.getContentPane().add(lblChooseAnItem);
		
		JButton btnPurchaseItem = new JButton("Purchase item");
		btnPurchaseItem.setBounds(324, 319, 174, 25);
		frmAvailableItems.getContentPane().add(btnPurchaseItem);
		
		JButton btnMarket = new JButton("Market");
		btnMarket.setBounds(637, 391, 117, 25);
		frmAvailableItems.getContentPane().add(btnMarket);
	}

}
