package sengproject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * command line interface for the game environment
 * can take input from console and perform actions
 * @author rsc103
 *
 */
public class CommandLine {
	
	/**
	 * new game environment class for this game
	 */
	private GameEnvironment game;
	/**
	 * scanner to read users input from the terminal
	 */
	private final Scanner scanner;
	
	/**
	* default constructor which creates an instance of the command line interface which 
	*/
	public CommandLine() {

		this.scanner = new Scanner(System.in);
		
	}
	/**
	 * prompts the users name and athlete selection and returns the information to the game environmnet
	 * @param game
	 */
	public void SetUp(GameEnvironment game) {
		
		this.game = game;
		final String name = getName();
		final ArrayList<Athlete> team = draftAthletes(game);
		final int numWeeks = getNumWeeks();
;		game.finishSetup(name, team, numWeeks);
	
	}
	/**
	 * 
	 * @return the number of weeks the game shall be played for
	 */
	public int getNumWeeks() {
		
		boolean pass = false;
		while(pass == false) {
			try {
				int numWeeks = scanner.nextInt();
				if (numWeeks <= 15 && numWeeks >= 5) {
					pass = true;
					return numWeeks;
				}
			} catch (Exception error) {
				System.out.println("Please select a number between 5 and 15");
			}
		}
	} return null;
	
	/**
	 * prompts player to enter a name for the team and checks it is valid
	 * @return name
	 */
	public String getName() {
		System.out.println("Enter team name (must be one word)");
		
		boolean pass = false;
		while (pass == false) {
			String name = scanner.nextLine();
			if (!Pattern.matches("[a-zA-Z0-9]+", name)) {
				System.out.println("Name cannot contain special characters");
			}
			else if (name.length() > 15 | name.length() < 3) {
				System.out.println("Name must be between 3 and 15 characters");
			}
			else {
				pass = true;
				return name.toString();
			}
		}
		return null;	
	}
	
	/**
	 * prompts player to select athletes and returns their selected team
	 * @param game
	 * @return selected athletes
	 */
	public ArrayList<Athlete> draftAthletes(GameEnvironment game){
		
		final ArrayList<Athlete> draft = new ArrayList<Athlete>(game.getDraft());
		ArrayList<Athlete> selected = new ArrayList<Athlete>();
		
		
		for (int i =0; i < 4; i++) {
			
			printDraftOptions(draft);
			System.out.println("Please enter the number next to the athlete you want to draft");
		
			boolean stop = false;
			while (stop == false) {
				
				try {
					int selection = scanner.nextInt();
					if (selection >= 1 && selection <= draft.size()) {
						selected.add(draft.get(selection));
						draft.remove(selection);
						stop = true;
					}
					else {
						System.out.println("Please select a valid number");
					}
				} catch (Exception error) {
					
					System.out.println("Please select a valid number");
					scanner.nextLine();
					
				}	
			}		
		}
		return selected;
	
	}
	
	/**
	 * takes the list of available players to draft and displays the number to select them and their stats
	 * @param draft
	 */
	public void printDraftOptions(ArrayList<Athlete> draft) {
		
		int i = 1;
		for (Athlete athlete: draft) {
			System.out.println(i+": "+athlete.toString());
			i += 1;
		}
		
	}
	

}
