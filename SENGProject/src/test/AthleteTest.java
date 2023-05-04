package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import sengproject.Athlete;

class AthleteTest {

	@Test 
	public void increaseOffenceTest() {
		Athlete testAthlete = new Athlete();
		testAthlete.setOffenceStat(50);
		testAthlete.increaseOffence(20);
		assertEquals(70, testAthlete.getOffenceStat());
		testAthlete.increaseOffence(40);
		assertEquals(100, testAthlete.getOffenceStat());
	}
	
	@Test
	public void increaseDefenceTest() {
		Athlete testAthlete = new Athlete();
		testAthlete.setDefenceStat(63);
		testAthlete.increaseDefence(27);
		assertEquals(90, testAthlete.getDefenceStat());
		testAthlete.increaseDefence(47);
		assertEquals(100, testAth)
	}

}
