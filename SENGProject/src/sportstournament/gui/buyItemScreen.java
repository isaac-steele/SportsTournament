package sportstournament.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import sportstournament.main.GameEnvironment;
import sportstournament.main.Market;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class buyItemScreen extends Screen{

	private JFrame frame;
	private Market market;


	/**
	 * Create the application.
	 */
	public buyItemScreen(GameEnvironment game, Gui gui) {
		super(game, gui);
		market = game.getMarket();
		initialize();
		this.window = frame;
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Buy item");
		btnNewButton.setBounds(72, 345, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sell item");
		btnNewButton_1.setBounds(373, 345, 117, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JList availableItemsList = new JList();
		availableItemsList.setBounds(61, 110, 176, 149);
		frame.getContentPane().add(availableItemsList);
		
		JList inventoryList = new JList();
		inventoryList.setBounds(355, 110, 176, 149);
		frame.getContentPane().add(inventoryList);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.OpenMarket();
				gui.closeBuyItemScreen();
			}
		});
		btnBack.setBounds(36, 22, 117, 25);
		frame.getContentPane().add(btnBack);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 657, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
