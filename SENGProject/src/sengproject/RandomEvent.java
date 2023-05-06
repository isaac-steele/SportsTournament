package sengproject;

import java.util.ArrayList;
import java.util.Random;

/**
 * While the team is resting (taking a bye) there is a chance that random events can occur.
 * The chance they occur depend on the difficulty.
 * The player is alerted when a random event occurs.
 * 
 * @author Isaac Steele
 *
 */

public class RandomEvent {
	/**
	 * Instantiates a Team Object.
	 */
	private Team team;
	/**
	 * Instantiates a Random Object
	 */
	private Random rng = new Random();
	/**
	 * Constructor for Random
	 * 
	 * @param team Allows for access to team methods 
	 */
	public RandomEvent(Team team) {
		this.team = team;
	}
	/**
	 * Creates a random number from 0-100 to be .
	 */
	private int statNumber = rng.nextInt(100);
	/**
	 * Creates a random number from 0-100 to be .
	 */
	private int quitNumber = rng.nextInt(100);/**
	 * Creates a random number from 0-100 to be .
	 */
	private int joinNumber = rng.nextInt(100);
	/**
	 * The athlete index
	 */
	private int athleteIndex;
	
	/**
	 * Returns a random number to be used for a stat boost.
	 * 
	 * @return A random number to be used for a stat boost.
	 */
	public int getStatNumber() {
		return statNumber;
	}
	/**
	 * Returns a random number for the chance for an athlete to quit
	 * 
	 * @return A random number
	 */
	public int getQuitNumber() {
		return quitNumber;
	}
	/**
	 * Returns a random number for the chance a random new athlete joins
	 * 
	 * @return A random number
	 */
	public int getJoinNumber() {
		return joinNumber;
	}
	/**
	 * Randomly chooses an athlete and boosts their stats.
	 */
	public void randomAthleteBoost() {
		int randomInt = rng.nextInt(4);
		ArrayList<Athlete> activeTeam = team.viewActiveTeam();
		Athlete boostedAthlete = activeTeam.get(randomInt);
		boostedAthlete.increaseDefence(17);
		boostedAthlete.increaseOffence(13);
	}
	/**
	 * Returns a number which represents the chance an Athlete quits. 
	 * 
	 * @return A number
	 */
	public int getQuitChance() {
		int randomInt = rng.nextInt(4);
		athleteIndex = randomInt;
		ArrayList<Athlete> activeTeam = team.viewActiveTeam();
		Athlete quitter = activeTeam.get(randomInt);
		if (quitter.getInjuryStatus() == true) {
			int chance = 20;
			return chance;
		} else {
			int chance = 10;
			return chance;
		}
	}
	/**
	 * Removes a random Athlete from the team. The Athlete has more of a chance to get removed if they are injured.
	 */
	public void randomAthleteQuits() {
		ArrayList<Athlete> activeTeam = team.viewActiveTeam();
		ArrayList<Athlete> reserves = team.viewReserves();
		Athlete quitter = activeTeam.get(athleteIndex);
		int randomSub = rng.nextInt(5);
		Athlete replacement = reserves.get(randomSub);
		team.subAthlete(quitter, replacement);
		team.removeReserve(quitter);
	}
	
	/**
	 * The chances increase depending on the number of free slots in the reserves.
	 */
	public int getAthleteJoinChance() {
		ArrayList<Athlete> reserves = team.viewReserves();
		if(reserves.size() == 0) {
			return 30;
		}
		else if(reserves.size() == 1) {
			return 25;
		}
		else if(reserves.size() == 2) {
			return 20;
		}
		else if(reserves.size() == 3) {
			return 15;
		}
		else if(reserves.size() == 4) {
			return 10;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * A random Athlete joins.
	 */
	public void randomAthleteJoins() {
		Athlete randomAthlete = Athlete.randomAthleteGenerator();
		team.addNewAthlete(randomAthlete);
	}
	

	
}
