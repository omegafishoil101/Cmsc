package Beveragefiles;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SmoothieTestStudent {

	Smoothie smoothie1;
	Smoothie smoothie2;

@Before
 public void setUp() {
 smoothie1 = new Smoothie("apple", Size.LARGE, 3, true);
 smoothie2 = new Smoothie("strawberry", Size.MEDIUM, 1, false);
}

	@Test
	public void testCalcPrice() {
	  assertEquals(7.0, smoothie1.calcPrice(), 0.0);
	  assertEquals(3.5, smoothie2.calcPrice(), 0.0);
 	}

 	@Test
 	public void testEquals() {
	 assertFalse(smoothie1.equals(smoothie2));
 }

	@Test
	public void testGetAddProtein() {
		assertTrue(smoothie1.getAddProtein());
 	assertFalse(smoothie2.getAddProtein());
	}
	@Test
	public void testGetNumOfFruits() {
	assertEquals(3, smoothie1.getNumOfFruits());
	assertEquals(1, smoothie2.getNumOfFruits());
	    }

 	@Test
 	public void testToString() {
	 String test = "apple, LARGE, 7.0, 3, true";
	 assertEquals(test, smoothie1.toString());

	}

}
