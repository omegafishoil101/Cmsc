package Beveragefiles;


import org.junit.Before;
	import org.junit.Test;
	import static org.junit.Assert.*;
	
	
public class CoffeeTestStudent {

 Coffee coffee1;
 Coffee coffee2;
 Coffee coffee3;

	    @Before
	    public void setUp() {
	coffee1 = new Coffee("hotCoffee", Size.SMALL, true, false);
	coffee2 = new Coffee("coldCoffee", Size.MEDIUM, false, true);
	coffee3 = new Coffee("iceCoffee", Size.SMALL, true, false);
	    }

 @Test
 public void testCalcPrice() {
 assertEquals(3.5, coffee2.calcPrice(), 0.0);
 }

 	@Test
 	public void testEquals() {
	assertFalse(coffee1.equals(coffee2));
}

 	@Test
 	public void testGetExtraShot() {
	 assertTrue(coffee1.getExtraShot());
	 assertFalse(coffee2.getExtraShot());
}

 @Test
 public void testGetExtraSyrup() {
 assertFalse(coffee1.getExtraSyrup());
 assertTrue(coffee2.getExtraSyrup());
 }

 @Test
 	public void testToString() {
	String test = "hotCoffee, SMALL, 2.5, true, false";
	assertEquals(test, coffee1.toString());

	    }
	}

