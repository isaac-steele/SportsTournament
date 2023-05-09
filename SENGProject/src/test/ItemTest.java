package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sengproject.Item;

class ItemTest {

	@Test
	public void proteinShakeTest() {
		Item proteinShake = Item.PROTEIN_SHAKE; 
		int statBoost = proteinShake.getStatBoost();
		int price = proteinShake.getPrice();
		String stat = proteinShake.getStat();
		assertEquals(3, price);
		assertEquals(5, statBoost);
		assertEquals("Defence", stat);
	}
	
	@Test
	public void energyDrinkTest() {
		Item energyDrink = Item.ENERGY_DRINK;
		int price = energyDrink.getPrice();
		int statBoost = energyDrink.getStatBoost();
		String stat = energyDrink.getStat();
		assertEquals(5, price);
		assertEquals(10, statBoost);
		assertEquals("Stamina", stat);
	}
	 
	@Test
	public void kneeSleeveTest() {
		Item kneeSleeve = Item.KNEE_SLEEVE;
		int price = kneeSleeve.getPrice();
		int statBoost = kneeSleeve.getStatBoost();
		String stat = kneeSleeve.getStat();
		assertEquals(4, price);
		assertEquals(5, statBoost);
		assertEquals("Offence", stat);
		
	}

}
