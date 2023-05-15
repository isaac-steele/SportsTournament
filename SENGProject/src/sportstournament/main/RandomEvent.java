package sportstournament.main;

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
	 * Instantiates a Club Object.
	 */
	private Club team;
	/**
	 * Instantiates a Random Object
	 */
	private Random rng = new Random();
	/**
	 * Constructor for Random
	 * 
	 * @param team Allows for access to team methods 
	 */
	public RandomEvent(Club team) {
		this.team = team;
	}
	/**
	 * The athlete that quits
	 */
	private Athlete quitter;
	/**
	 * The athlete that joins
	 */
	private Athlete booster;
	/**
	 * The athlete that joined
	 */
	private Athlete joiner;
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
	 * Gets the athlete that quits
	 * 
	 * @return quitter 
	 */
	public Athlete getQuitter() {
		return quitter;
	}
	/**
	 * Gets the athlete that stats are boosted
	 * 
	 * @return booster
	 */
	public Athlete getBooster() {
		return booster;
	}
	/**
	 * Gets the athlete that joined
	 * 
	 * @return joiner
	 */
	public Athlete getJoiner() {
		return joiner;
	}
	
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
		booster = activeTeam.get(randomInt);
		booster.increaseDefence(10);
		booster.increaseOffence(10);
	}
	/**
	 * Returns a number which represents the chance an Athlete quits. 
	 * 
	 * @return A number
	 */
	public int getQuitChance() {
		int randomInt = rng.nextInt(4);
		ArrayList<Athlete> reserves = team.viewReserves();
		ArrayList<Athlete> activeTeam = team.viewActiveTeam();
		quitter = activeTeam.get(randomInt);
		if (reserves.size()==0) {
			return 0;
		}
		else if (quitter.getInjuryStatus() == true) {
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
		ArrayList<Athlete> reserves = team.viewReserves();
		int randomSub = rng.nextInt(reserves.size());
		Athlete replacement = reserves.get(randomSub);
		team.subAthlete(replacement, quitter);
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
		joiner = randomAthlete;
		team.addNewAthlete(randomAthlete);
	}
	
	public String doRandomEvent(String difficulty) {
		String randomEventOccurrence = "None";
		if (difficulty == "Hard") {
			
			if(getStatNumber() < 10) {
				randomAthleteBoost();
				randomEventOccurrence = "Athlete Boost";
			}
		
			if(getQuitNumber() < getQuitChance()) {
				randomAthleteQuits();
				randomEventOccurrence = "Athlete Quits";
			}
		
			if(getJoinNumber() < (getAthleteJoinChance() - 5)) {
				randomAthleteJoins();
				randomEventOccurrence = "Athlete Joins";
			}
		}
	
		else if(difficulty == "Easy") {
			if(getStatNumber() < 20) {
				randomAthleteBoost();
				randomEventOccurrence = "Athlete Boost";
			}
			
			if(getQuitNumber() < (getQuitChance()) - 5) {
				randomAthleteQuits();
				randomEventOccurrence = "Athlete Quits";
			}
			
			if(getJoinNumber() < (getAthleteJoinChance())) {
				randomAthleteJoins();
				randomEventOccurrence = "Athlete Joins";
			}
		}
		return randomEventOccurrence;
	
	}
	
}
