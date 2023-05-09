package sengproject;

/**
 * stadium class where the player can see and select a match to play
 */

import java.util.ArrayList;

public class Stadium {
	/**
	 * list of possible matches to play
	 */
	private ArrayList<Team> matches;
	
	/**
	 * default constructor for stadium which creates list of matches
	 */
	public Stadium() {
		
		for (int i = 0; i <3; i ++) {
			Team match = Team.randomTeamGenerator();
			this.matches.add(match);
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
	public boolean checkTeamInjuries(Club team) {
		
		for (Athlete athlete: team.viewActiveTeam()){
			if (athlete.getInjuryStatus() == false) {
				return true;
			}
		}
		return false;
	}
	/**
	 * checks if the team is eligible to play a match
	 * if so, it simulates the match
	 */
	public void startMatch(Match match, Club club, Team opponent) {
		
		if (checkTeamInjuries(club) == true) {
			System.out.println("Cannot start match! Must have at least one healthy athlete");
		}
		else { 
			
			String result = Match.playMatch(club, opponent);
			switch(result) {
			case "W":
				club.setPoints(club.getPoints() + 3);
				club.setMoney(club.getMoney() + 5000);
			case "D":
				club.setPoints(club.getPoints() + 1);
				club.setMoney(club.getMoney() + 1000);
			case "L":
				club.setPoints(club.getPoints() + 0);
			}
			
		}
	}

}
