package sengproject;

/**
 * stadium class where the player can see and select a match to play
 */

import java.util.ArrayList;

public class Stadium {
	/**
	 * list of possible matches to play
	 */
	private ArrayList<Team> matches = new ArrayList<Team>();
	/**
	 *Game Environment object
	 */
	private GameEnvironment game;
	/**
	 * Club Object
	 */
	private Team team;
	/**
	 * default constructor for stadium which creates list of matches
	 */
	public Stadium(GameEnvironment game) {
		this.team = new Team(game);
		this.game = game;
		
		for (int i = 0; i <3; i ++) {
			Team match = team.randomTeamGenerator();
			matches.add(match);
		}
	}
	
	/** 
	 * @return the available matches
	 */
	public ArrayList<Team> getMatches() {
		return matches;
	}

	/**
	 * helper function that checks if all the players on the active team are injured
	 */
	public static boolean checkTeamInjuries(Club team) {
		
		for (Athlete athlete: team.viewActiveTeam()){
			if (athlete.getInjuryStatus() == false) {
				return false;
			}
		}
		return true;
	}
	/**
	 * checks if the team is eligible to play a match
	 * if so, it simulates the match
	 */
	public String startMatch(Club club, Team opponent) {
		String difficulty = game.getDifficulty();
		if (checkTeamInjuries(club)) {
			return "Cannot start match! Must have at least one healthy athlete";
		}
		else {

			String result = Match.playMatch(club, opponent);
			switch(result) {
			case "Win":
				if(difficulty == "Easy") {
					game.updatePoints(3);
					game.updateMoney(10);
				} else if(difficulty == "Hard") {
					game.updatePoints(5);
					game.updateMoney(5);
				}
				break;
			case "Draw":
				if(difficulty == "Easy") {
					game.updatePoints(1);
					game.updateMoney(5);
				}
				else if(difficulty == "Hard") {
					game.updatePoints(2);
					game.updateMoney(3);
				}
				break;
			case "Loss":
				break;
			}
			matches.remove(opponent);
			return result; 
		}
	}

}
