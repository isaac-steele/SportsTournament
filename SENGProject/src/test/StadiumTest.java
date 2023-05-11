package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import sengproject.Stadium;
import sengproject.Team;
import sengproject.Athlete;
import sengproject.Club;
import sengproject.GameEnvironment;

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
		assertEquals("Draw", result);
		assertEquals(0,game.getPoints());
		assertEquals(0,game.getMoneyAmount());
		game.setDifficulty("Hard");
		result = stadium.startMatch(myClub, opposition);
		assertEquals("Draw", result);
		assertEquals(0,game.getPoints());
		assertEquals(0,game.getMoneyAmount());
	}

}
