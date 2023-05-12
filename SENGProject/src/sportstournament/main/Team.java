package sportstournament.main;

import java.util.ArrayList;
import java.util.Random;



/**
 * the general class for team, will be used both for the players own team and opposing teams
 * parent class of club
 * @author rsc103
 *
 */

public class Team {
	/**
	 * The game environment.
	 */
	protected GameEnvironment game;
	/**
	 * The teams name
	 */
	protected String name;
	/**
	 * List of active players
	 */
	protected ArrayList<Athlete> activeTeam;
	/**
	 * Default constructor for team
	 */
	public Team(String name, ArrayList<Athlete> activeTeam, GameEnvironment game) {
		setName(name);
		this.activeTeam = activeTeam;
		this.game = game;
	}
	/** 
	 * Constructor for team without game environment.
	 */
	public Team(String name, ArrayList<Athlete> activeTeam) {
		setName(name);
		this.activeTeam = activeTeam;
	}
	/**
	 * Team Constructor
	 */
	public Team(GameEnvironment game) {
		this.game = game;
	}
	/**
	 * returns the team name
	 * @return name The name of team
	 */
	public String viewName() {
		return name;
	}
	
	/**
	 * sets team name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * returns list of active players on the team
	 * @ return activeTeam
	 */
	public ArrayList<Athlete> viewActiveTeam() {
		return activeTeam;
	}
	/** 
	 * To string method for team
	 */
	public String toString() {
		return "Name: " + name + "\n" + activeTeam.get(0).toString() + "\n" + activeTeam.get(1).toString() + "\n" + activeTeam.get(2).toString() + "\n" + activeTeam.get(3).toString();
	}
	/**
	 * Generates a random team based on the weeks remaining.
	 * 
	 * @return a random team
	 */
	public Team randomTeamGenerator() {
		int defenceStat;
		int offenceStat;
		ArrayList<Athlete> athleteList = new ArrayList<Athlete>();
		Random rng = new Random();
		String[] teamNames = {"Eagles", "Hornets", "Crusaders", "Titans", "Sharks", "Wolverines", "Hurricanes", "Hawks", "Snakes", "Serpents", "Cheetahs", "Panthers", "Lions", "Tigers"};
		String randomName = teamNames[rng.nextInt(teamNames.length)];
		int weeksRemaining = game.getWeeksRemaining();
		// As the weeks increases the opponents should be harder
		if (weeksRemaining < 15 && weeksRemaining > 10) {
			defenceStat = rng.nextInt(16) + 50;
			offenceStat = rng.nextInt(16) + 50;
		}
		else if (weeksRemaining < 11 && weeksRemaining > 5) {
			defenceStat = rng.nextInt(16) + 60;
			offenceStat = rng.nextInt(16) + 60;
		}
		else {
			defenceStat = rng.nextInt(26) + 75;
			offenceStat = rng.nextInt(26) + 75;
		}
		for(int i = 0; i < 4; i++ ) {
			Athlete randomAthlete = Athlete.randomAthleteGenerator(defenceStat, offenceStat);
			athleteList.add(randomAthlete);
		}
		Team randomTeam = new Team(randomName, athleteList);
		return randomTeam;
	}
	
	
}



 
   


