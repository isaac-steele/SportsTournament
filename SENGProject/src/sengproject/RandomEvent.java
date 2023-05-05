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
	
	private Team team;
	private Random rng = new Random();
	public RandomEvent(Team team) {
		this.team = team;
	}
	
	/**
	 * Randomly chooses an athlete and boosts their stats.
	 */
	public void randomAthleteBoost() {
		int randomInt = rng.nextInt(0,4);
		ArrayList<Athlete> activeTeam = team.viewActiveTeam();
		Athlete boostedAthlete = activeTeam.get(randomInt);
		boostedAthlete.increaseDefence(17);
		boostedAthlete.increaseOffence(13);
		
	}
	

	
}
