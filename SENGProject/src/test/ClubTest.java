package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import sengproject.Athlete;
import sengproject.Club;
import sengproject.Item;


class ClubTest {

	@Test
	public void useItemTest() {
		Athlete tempathlete = new  Athlete("Miles", 70, 70, 7);
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		athletes.add(tempathlete);
		Club club = new Club("BOB", athletes);
		club.addItem(Item.ENERGY_DRINK);
		club.addItem(Item.KNEE_SLEEVE);
		club.addItem(Item.PROTEIN_SHAKE);
		Athlete athlete = athletes.get(0);
		athlete.setStamina(70);
		club.useItem(Item.ENERGY_DRINK, athlete);
		club.useItem(Item.KNEE_SLEEVE, athlete);
		club.useItem(Item.PROTEIN_SHAKE, athlete);
		assertEquals(80, athlete.getStamina());
		assertEquals(75, athlete.getOffenceStat());
		assertEquals(75, athlete.getDefenceStat());	
	}
	
	@Test
	public void AthletesTest() {
		
	}

}
