package property;


/**
 * This class represents GFA test cases for a ManagementCompany object.
 * 
 * @author Farnaz Eivazi
 * @version 7/12/2022
 * 
 */
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
	Property yard;
	Property beach;
	ManagementCompany me ;
	ManagementCompany brother;
	
	@Before
	public void setUp() throws Exception {
		me= new ManagementCompany("me", "123456",1);
		brother = new ManagementCompany("me", "445531",3);
	}

	@After
	public void tearDown() throws Exception {
		me=null;
		brother = null;
	}

	@Test
	public void testAddProperty() {
		yard = new Property ("shed", "Land", 800, "Dad",1,1,1,1);
		beach = new Property ("beach", "beach", 12000, "Mom",3,2,3,3);
		assertEquals(me.addProperty(yard),0,0);	//property has been successfully added to index 0
		assertEquals(me.addProperty(beach),1,0);
	}
	
	@Test
	public void testGetPropertiesCount() {
		yard = new Property ("shed", "Land", 800, "Dad",1,1,1,1);	
		beach = new Property ("beach", "beach", 12000, "Mom",3,2,3,3);
		assertEquals(me.addProperty(yard),1);
		assertEquals(brother.addProperty(beach),1);
		assertEquals(me.getPropertiesCount(), 1);
		assertEquals(brother.getPropertiesCount(), 1);
	}

	@Test
	public void testToString() {
		yard = new Property ("shed", "Land", 800, "Dad",1,1,1,1);
		assertEquals(me.addProperty(yard), 0);	//property has been successfully added to index 0
		String expectedString = "List of the properties for Railey, taxID: 555555555\n"
				+ "______________________________________________________\n"
				+ "shed,Land,Dad,800"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 800.00";
		String expectedString2 = "List of the properties for Railey, taxID: 555555555\n"
				+ "______________________________________________________\n"
				+ "beach,beach,Mom,12000"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 12000.00";
		System.out.println(expectedString);
		System.out.println(me.toString());
		System.out.println(expectedString2);
		System.out.println(brother.toString());
		assertEquals(expectedString, me.toString());
		assertEquals(expectedString2, brother.toString());
				
	}

}
