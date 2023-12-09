package Beveragefiles;


	import org.junit.Before;
	import org.junit.Test;
	import static org.junit.Assert.*;
	
public class AlcoholTestStudent {
	
 Alcohol alcohol1;
 Alcohol alcohol2;
 Alcohol alcohol3;

@Before
 public void setUp() {
	alcohol1 = new Alcohol("beer1", Size.MEDIUM, false); 
	alcohol2 = new Alcohol("beer1", Size.MEDIUM, false);
	alcohol3 = new Alcohol("beer2", Size.LARGE, true);
	     
 }

@Test
	public void testCalcPrice() {
	assertEquals(3.0, alcohol1.calcPrice(), 0.0);
}

@Test
	public void testEquals() {
   assertTrue(alcohol1.equals(alcohol2));
 }

 @Test
 public void testIsWeekend() {
assertFalse(alcohol1.isWeekend());
assertTrue(alcohol3.isWeekend());
}

	@Test
public void testToString() {
	 String test1 = "beer1, MEDIUM, 3.0, false";
	  assertEquals(test1, alcohol1.toString());

	  String test2 = "beer2, LARGE, 4.6, true";
	   assertEquals(test2, alcohol3.toString());
	    }
	}

