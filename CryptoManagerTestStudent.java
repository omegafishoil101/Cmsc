package Crypto;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("TRUE TEST"));
		assertTrue(CryptoManager.isStringInBounds("\"TRUE TEST@\""));
		assertFalse(CryptoManager.isStringInBounds("false test"));
		assertFalse(CryptoManager.isStringInBounds("{FALSE TEST 2"));
		assertFalse(CryptoManager.isStringInBounds("\"FALSE TEST NUMBER THREE    { TEST MEANT TO TEST RANGE\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("OF[NJW", CryptoManager.caesarEncryption("JAVIER", 5));
		assertEquals("-$9,(5", CryptoManager.caesarEncryption("JAVIER", 99));
		assertEquals("6,/*;5*7.", CryptoManager.caesarEncryption("MCFARLANE", 105));
		assertEquals("TJMHYSHUL", CryptoManager.caesarEncryption("MCFARLANE", 7));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("JAVIER", CryptoManager.caesarDecryption("OF[NJW", 5));
		assertEquals("JAVIER", CryptoManager.caesarDecryption("-$9,(5", 99));
		assertEquals("MCFARLANE", CryptoManager.caesarDecryption("6,/*;5*7.", 105));
		assertEquals("MCFARLANE", CryptoManager.caesarDecryption("TJMHYSHUL", 7));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("WD\\JW^", CryptoManager.bellasoEncryption("JAVIER", "MCFARLANE"));
		assertEquals("WD\\JW^KO[", CryptoManager.bellasoEncryption("MCFARLANE", "JAVIER"));
		assertEquals("UZ\"NP+,RN_MWWZZJ", CryptoManager.bellasoEncryption("JAVIER MCFARLANE", "KYLE"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("JAVIER", CryptoManager.bellasoDecryption("WD\\JW^", "MCFARLANE"));
		assertEquals("MCFARLANE", CryptoManager.bellasoDecryption("WD\\JW^KO[", "JAVIER"));
		assertEquals("JAVIER MCFARLANE", CryptoManager.bellasoDecryption("UZ\"NP+,RN_MWWZZJ", "KYLE"));

	}

}
