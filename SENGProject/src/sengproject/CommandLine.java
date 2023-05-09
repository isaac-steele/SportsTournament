package sengproject;

import java.util.Scanner;

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
	
	public void SetUp(GameEnvironment game) {
		
		this.game = game;
	}

}
