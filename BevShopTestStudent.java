package Beveragefiles;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {

    private BevShop bevShop;

    @Before
    public void setUp() {
        bevShop = new BevShop();
    }

    @Test
    public void testIsValidTime() {
        assertTrue(bevShop.isValidTime(10));
        assertFalse(bevShop.isValidTime(5));
        assertFalse(bevShop.isValidTime(24));
    }

    @Test
    public void testGetMaxNumOfFruitsAndMinAgeForAlcohol() {
        assertEquals(BevShop.MIN_AGE_FOR_ALCOHOL, bevShop.getMaxNumOfFruits());
        assertEquals(BevShop.MIN_AGE_FOR_ALCOHOL, bevShop.getMinAgeForAlcohol());
    }



    @Test
    public void testIsValidAge() {
        assertTrue(bevShop.isValidAge(21));
        assertFalse(bevShop.isValidAge(20));
    }

 
    @Test
    public void testFindOrder() {
        bevShop.startNewOrder(12, Day.MONDAY, "John Doe", 30);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();
        assertEquals(0, bevShop.findOrder(orderNo));
        assertEquals(-1, bevShop.findOrder(orderNo + 1));
    }
}

