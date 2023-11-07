package property;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents GFA test cases for a Property object.
 *
 * @author Farnaz Eivazi
 * @version 7/11/2022
 */
class PropertyTestStudent {
	Property HomeYard, vacayHome;

	@BeforeEach
	void setUp() throws Exception {
		HomeYard = new Property("mainHome", "TakomaPark", 1000.00, "me");
		vacayHome = new Property("vacayHome", "GermanTown", 3750.00, "me", 1,1,2,2);
	}

	@AfterEach
	void tearDown() throws Exception {
		HomeYard = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("mainHome", HomeYard.getPropertyName());
		assertEquals("vacayHome", vacayHome.getPropertyName());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(1000.00, HomeYard.getRentAmount());
		assertEquals(3750.00, vacayHome.getRentAmount());
	}

	@Test
	void testGetPlot() {
		assertEquals(0, HomeYard.getPlot().getX());
		assertEquals(0, HomeYard.getPlot().getY());
		assertEquals(1, HomeYard.getPlot().getWidth());
		assertEquals(1, HomeYard.getPlot().getDepth());
		assertEquals(1, vacayHome.getPlot().getX());
		assertEquals(1, vacayHome.getPlot().getY());
		assertEquals(2, vacayHome.getPlot().getWidth());
		assertEquals(2, vacayHome.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("mainHome,TakomaPark,me,1000.0",HomeYard.toString());
		assertEquals("vacayHome,GermanTown,me,3750.0",vacayHome.toString());
	}

}
