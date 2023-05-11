package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import sengproject.Athlete;
import sengproject.Club;
import sengproject.Match;
import sengproject.Team;


class MatchTest {

	@Test
	public void playMatchTest() {
		ArrayList<Athlete> myTeam = new ArrayList<Athlete>();
		ArrayList<Athlete> oppTeam = new ArrayList<Athlete>();
		for(int i = 0; i < 4; i++) {
			Athlete myAthlete = new Athlete("George", 60, 72, 5);
			Athlete oppAthlete = new Athlete("Harry", 81, 60, 3);
			myTeam.add(myAthlete); 
			oppTeam.add(oppAthlete);
		}
		Club myClub = new Club("Fellas", myTeam);
		Team opps = new Team("Devils", oppTeam);
		String result = Match.playMatch(myClub, opps);
		assertEquals("D", result);
		ArrayList<Athlete> clubTeam = myClub.viewActiveTeam();
		Athlete myFirstDefender = clubTeam.get(0);
		Athlete myFirstAttacker = clubTeam.get(2);
		assertEquals(85,myFirstAttacker.getStamina());
		assertEquals(90,myFirstDefender.getStamina());
		myFirstAttacker.setStamina(3);
		myFirstAttacker.setOffenceStat(83);
		String newResult = Match.playMatch(myClub, opps);
		assertEquals("W", newResult);
		assertEquals(0, myFirstAttacker.getStamina());
		assertEquals(80, myFirstDefender.getStamina());
		assertTrue(myFirstAttacker.getInjuryStatus());
		myFirstDefender.setDefenceStat(57);
		myFirstDefender.setStamina(15);
		Athlete mySecondDefender = clubTeam.get(1);
		mySecondDefender.setDefenceStat(60);
		myFirstAttacker.setOffenceStat(81);
		String lossResult = Match.playMatch(myClub, opps);
		assertEquals("L", lossResult);
		assertEquals(0, myFirstDefender.getStamina());
		assertTrue(myFirstDefender.getInjuryStatus());
		
	}

}
