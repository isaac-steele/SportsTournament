package sengproject;

import java.util.ArrayList;


/**
 * Matches will be generated randomly and will get harder as weeks go on.
 * In a match, the stat of their position will be compared.
 * 
 * 
 * @author Isaac Steele
 *
 */

public class Match extends Stadium{
	
	/**
	 * Play match
	 */
	public static String playMatch(Club me, Team opponent) {
		int myScore = 0;
		int opponentScore = 0;
		ArrayList<Athlete> myTeam = me.viewActiveTeam();
		ArrayList<Athlete> opponentTeam = opponent.viewActiveTeam();
		for(int i = 0; i < 2 ; i++) {
			Athlete myDefender = myTeam.get(i);
			Athlete oppDefender = opponentTeam.get(i);
			if(myDefender.getDefenceStat() > oppDefender.getDefenceStat()) {
				myScore += 10;
			}
			else if (myDefender.getDefenceStat() < oppDefender.getDefenceStat()) {
				opponentScore += 10;
				myDefender.decreaseStamina(5);
			}
			else {
				myScore += 5;
				opponentScore += 5;
			}
			myDefender.decreaseStamina(10);
			if (myDefender.getStamina() == 0) {
				myDefender.setInjuryStatus(true);
			}
		}
		for(int i = 2; i < 4; i++) {
			Athlete myAttacker = myTeam.get(i);
			Athlete oppAttacker = opponentTeam.get(i);
			if(myAttacker.getOffenceStat() > oppAttacker.getOffenceStat()) {
				myScore += 10;
			}
			else if (myAttacker.getOffenceStat() < oppAttacker.getOffenceStat()) {
				opponentScore += 10;
				myAttacker.decreaseStamina(5);
			}
			else {
				myScore +=5;
				opponentScore += 5;
			}
			myAttacker.decreaseStamina(10);
			if (myAttacker.getStamina() == 0) {
				myAttacker.setInjuryStatus(true);
			}
		}
		if(myScore > opponentScore) {
			return "W";
		}
		else if(myScore < opponentScore) {
			return "L";
		}
		else {
			return "D";
		}
		
		
	}
	
}

