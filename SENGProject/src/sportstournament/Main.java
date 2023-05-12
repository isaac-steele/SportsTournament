package sportstournament;

import java.util.ArrayList;

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
		
		final ArrayList<Athlete> draft = new ArrayList<Athlete>();
		
		while (draft.size() <= 10) {
			draft.add(Athlete.randomAthleteGenerator());
		}
		
		CommandLine ui = new CommandLine();
		
		GameEnvironment game = new GameEnvironment(ui, draft);
		game.Start();
		
		
	}

}
