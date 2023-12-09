package Beveragefiles;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OrderTestStudent {
	Order firstOrder;

	@Before
	public void setUp() throws Exception {
		firstOrder = new Order(23, Day.WEDNESDAY, new Customer("John", 21));
	}


	@Test
	public void testGetBeverage() {
		Coffee ice = new Coffee("Ice Coffee", Size.LARGE, false, true);
		

		firstOrder.addNewBeverage("Ice Coffee", Size.LARGE, false, true);
		assertTrue(firstOrder.getBeverage(0).equals(ice));
		
	}

	@Test
	public void testAddNewBeverage() throws NullPointerException {

		assertTrue(firstOrder.getTotalItems() == 0);
		firstOrder.addNewBeverage("Ice Coffee", Size.LARGE, false, true);
		
	}

	@Test
	public void testCalcOrderTotal() {
		firstOrder.addNewBeverage("Ice Coffee", Size.LARGE, false, true);
		firstOrder.addNewBeverage("beer", Size.SMALL);
		firstOrder.addNewBeverage("apple", Size.MEDIUM, 1, true);

		assertEquals(11.5, firstOrder.calcOrderTotal(), .01);


	}

}
