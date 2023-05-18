package sportstournament;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.SwingUtilities;

import sportstournament.gui.Gui;
import sportstournament.main.Athlete;
import sportstournament.main.GameEnvironment;
import sportstournament.ui.CommandLine;

/**
 * Where application begins. 
 * Facilitates use of command line interface
 * @author rsc103
 *
 */

public class Main {
	
	public static void main(String[] args) {
		Random rng = new Random();
		final ArrayList<Athlete> draft = new ArrayList<Athlete>();
		
		while (draft.size() <= 10) {
			int offenceStat = rng.nextInt(16) + 50;
			int defenceStat = rng.nextInt(16) + 50;
			draft.add(Athlete.randomAthleteGenerator(defenceStat, offenceStat));
		}
		
		 if (args.length > 0 && (args[0].equals("cmd"))) {
	            CommandLine ui = new CommandLine();
	        	GameEnvironment game = new GameEnvironment(ui, draft);
	            game.startUi();
	        } else {
	            Gui gui = new Gui();
	            GameEnvironment game = new GameEnvironment(gui, draft);
	            SwingUtilities.invokeLater(() -> game.startGui());
	        }
		
	}

}
