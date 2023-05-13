package sportstournament.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import sportstournament.main.Athlete;
import sportstournament.main.Club;
import sportstournament.main.GameEnvironment;
import sportstournament.main.Stadium;
import sportstournament.main.Team;

class StadiumTest {

	@Test
	public void startMatchWinTest() {
		GameEnvironment game = new GameEnvironment();
		game.setDifficulty("Easy");
		game.setWeeksRemaining(12);
		Stadium stadium = new Stadium(game);
		ArrayList<Athlete> myTeam = new ArrayList<Athlete>();
		for(int i = 0; i < 4; i++) {
			Athlete myAthlete = new Athlete("George", 99, 99, 10);
			myTeam.add(myAthlete);
		}
		Club myClub = new Club("Fellas", myTeam);
		ArrayList<Team> matches = stadium.getMatches();
		Team opposition = matches.get(0);
		String result = stadium.startMatch(myClub, opposition);
		assertEquals("Win", result);
		assertEquals(3,game.getPoints());
		assertEquals(10,game.getMoneyAmount());
		game.setDifficulty("Hard");
		result = stadium.startMatch(myClub, opposition);
		assertEquals("Win", result);
		assertEquals(8,game.getPoints());
		assertEquals(15,game.getMoneyAmount());
	}
	
	@Test
	public void startMatchLossTest() {
		GameEnvironment game = new GameEnvironment();
		game.setDifficulty("Easy");
		game.setWeeksRemaining(4);
		Stadium stadium = new Stadium(game);
		ArrayList<Athlete> myTeam = new ArrayList<Athlete>();
		for(int i = 0; i < 4; i++) {
			Athlete myAthlete = new Athlete("George", 67, 67, 5);
			myTeam.add(myAthlete);
		}
		Club myClub = new Club("Fellas", myTeam);
		ArrayList<Team> matches = stadium.getMatches();
		Team opposition = matches.get(0);
		String result = stadium.startMatch(myClub, opposition);
		assertEquals("Loss", result);
		assertEquals(0,game.getPoints());
		assertEquals(0,game.getMoneyAmount());
		game.setDifficulty("Hard");
		result = stadium.startMatch(myClub, opposition);
		assertEquals("Loss", result);
		assertEquals(0,game.getPoints());
		assertEquals(0,game.getMoneyAmount());
	}
	
	@Test
	public void startMatchDrawTest() {
		GameEnvironment game = new GameEnvironment();
		game.setDifficulty("Easy");
		game.setWeeksRemaining(7);
		Stadium stadium = new Stadium(game);
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
		String result = stadium.startMatch(myClub, opps);
		assertEquals("Draw", result);
		assertEquals(1,game.getPoints());
		assertEquals(5,game.getMoneyAmount());
		game.setDifficulty("Hard");
		result = stadium.startMatch(myClub, opps);
		assertEquals("Draw", result);
		assertEquals(3,game.getPoints());
		assertEquals(8,game.getMoneyAmount());
	}
	
	@Test
	public void allAthletesInjuredTest() {
		GameEnvironment game = new GameEnvironment();
		game.setDifficulty("Easy");
		game.setWeeksRemaining(4);
		Stadium stadium = new Stadium(game);
		ArrayList<Athlete> myTeam = new ArrayList<Athlete>();
		for(int i = 0; i < 4; i++) {
			Athlete myAthlete = new Athlete("George", 67, 67, 5);
			myAthlete.setInjuryStatus(true);
			myTeam.add(myAthlete);
		}
		Club myClub = new Club("Fellas", myTeam);
		ArrayList<Team> matches = stadium.getMatches();
		Team opposition = matches.get(0);
		String result = stadium.startMatch(myClub, opposition);
		assertEquals(result,"Cannot start match! Must have at least one healthy athlete");
	}

}