package sengproject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
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
	* default constructor which creates an instance of the command line interface with a scanner
	*/
	public CommandLine() {

		this.scanner = new Scanner(System.in);
		
	}
	/**
	 * prompts the users name and athlete selection and returns the information to the game environment
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
			System.out.println(i+": "+athlete);
			i += 1;
		}
		
	}
	/**
	 * starts the main game run loop where the user selects the action they want to perform
	 * terminates when no more weeks are remaining
	 * @param club
	 */
	public void start(Club club) {
		
		while (game.getWeeksRemaining() > 0) {
			
			Market market = new Market();
			Stadium stadium = new Stadium();
			mainScreen();
			
			
		}
		
	}
	
	public void mainScreen() {
		
		boolean takeBye = false;
		
		do {
			try {
				int selection = scanner.nextInt();
				if (selection == 4) {
					takeBye = true;
				}
				else if (selection >= 1 && selection <= 3) {
					handleMainOption(selection);
				}
			} catch (Exception error) {
				System.out.println("Please enter a number between 1 and 4");
				scanner.nextLine();
			}
			
		} while (takeBye == false);
		
		game.updateWeeksRemaining();
		game.updateCurrentWeek();
		start(club);
	}
	/**
	 * prints out the options available to the user from the main screen
	 */
	public void printMainOptions() {
		
		System.out.println("1: Go to club");
		System.out.println("2: Go to stadium");
		System.out.println("3: Go to market");
		System.out.println("4: Take bye");
	}
	
	/**
	 * handles user selection from the main screen
	 * @param selection
	 */
	public void handleMainOption(int selection) {
		
		switch (selection) {
			default:
				throw new IllegalArgumentException("Unexpected value");
			case(1):
				printClubOptions();
				selection = getIntegerInput(3);
				game.handleClubOptions(5); 
			case(2):
				printStadiumOptions();
			case(3):
				printMarketOptions();				
			}
		}	
	}

	/**
	 * a helper method that takes an integer which represents the number of options the user can select
	 * it then prompts the user for input and checks if the input is valid
	 * then returns the integer
	 * @param numOptions
	 * @return
	 */
	public int getIntegerInput(int numOptions) {
		
		System.out.println("Please enter a number between 1 and "+numOptions);
		
		while (true) {
			try {
				int selection = scanner.nextInt();
				if (selection >= 1 && selection <= numOptions) {
					return selection;
				}
				else {
					System.out.println("Please enter a number between 1 and "+numOptions);
				}
			} catch (InputMismatchException error) {
				System.out.println("Please enter a number between 1 and"+numOptions);
				
			} catch (NoSuchElementException error) {
				System.out.println("Please enter a number between 1 and"+numOptions);
			}
		}
		
	}


	/**
	 * prints the initial options the user can select from the club screen
	 */
	public void printClubOptions() {
		
		System.out.println("1: View active team");
		System.out.println("2: View reserves");
		System.out.println("3: View inventory ");
		System.out.println("4: Substitute player");
		System.out.println("5: Return to main screen");

	}
	
	public void printSubOffOptions(Club club) {
		
		System.out.println("Select the player you wish to take off the active team");
		int i = 1;
		for (Athlete athlete: club.viewActiveTeam()) {
			System.out.println(i+": "+athlete);
			i += 1;
		
		
	public void printSubOnOptions(Club club) {
		System.out.println("Select the player you wish to put on your active team");
		int i = 1;
		for (Athlete reserve: club.viewReserves()) {
			System.out.println(i+": "+reserve);
			i += 1;
	}
		
}
