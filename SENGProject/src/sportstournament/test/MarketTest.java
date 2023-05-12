package sportstournament.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import sportstournament.main.*;
class MarketTest {

	@Test
	public void buyReserveTest() {
		GameEnvironment game = new GameEnvironment();
		Team team = new Team(game);
		game.setMoneyAmount(250);
		int totalFunds = game.getMoneyAmount();
		Market market = new Market(game);
		ArrayList<Athlete> myTeam = team.randomTeamGenerator().viewActiveTeam();
		Club club = new Club("Pumas", myTeam);
		ArrayList<Athlete> reserves = club.viewReserves();
		ArrayList<Athlete> freeAgents = market.getFreeAgents();
		Athlete athleteToBuy = freeAgents.get(0);
		String purchase = market.buyReserve(athleteToBuy, club);
		int expectedFunds = totalFunds - athleteToBuy.getPrice();
		assertEquals(athleteToBuy.getName() + " purchased.", purchase);
		assertEquals(expectedFunds, game.getMoneyAmount());
		assertFalse(freeAgents.contains(athleteToBuy));
		assertTrue(reserves.contains(athleteToBuy));
		game.setMoneyAmount(2);
		freeAgents.remove(0);
		Athlete freeAgent = freeAgents.get(0);
		purchase = market.buyReserve(athleteToBuy, club);
		assertEquals("You cannot afford this!", purchase);
		game.setMoneyAmount(11);
		market.buyReserve(freeAgent, club);
		assertEquals(3, freeAgents.size());
	}
	
	@Test
	public void buyStarterTest() {
		
	}

}
