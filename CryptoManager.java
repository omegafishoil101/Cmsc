package Crypto;


/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		int fails = 0;
		for(int i = 0; i < plainText.length(); i++) {
			fails +=(int)plainText.charAt(i) >= (int)LOWER_RANGE && (int)plainText.charAt(i) <=  (int)UPPER_RANGE ? 0:1; 
		}
		return fails > 0? false: true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		key %= RANGE;
		String newText = "";
		int shiftedKey;
		for(int i = 0; i < plainText.length(); i++) {
			shiftedKey = (int)plainText.charAt(i) + key;
		shiftedKey -= (shiftedKey > (int)UPPER_RANGE)? RANGE: 0;
			newText += (char)shiftedKey;
		}
		return newText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {

		String newText = "";
		int shiftedKey;
		for(int i = 0; i < plainText.length(); i++) {
			int key = bellasoStr.charAt(i % bellasoStr.length());
			shiftedKey = (int)plainText.charAt(i) + key;
			while (shiftedKey > (int)UPPER_RANGE) {
				shiftedKey -= RANGE;
			}
			newText += (char)shiftedKey;
		}
		return newText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		key %= RANGE;
		String newText = "";
		int shiftedKey;
		for(int i = 0; i < encryptedText.length(); i++) {
			shiftedKey = (int)encryptedText.charAt(i) - key;
			shiftedKey += (shiftedKey < (int)LOWER_RANGE)? RANGE: 0;
			newText += (char)shiftedKey;
		}
		return newText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String newText = "";
		int shiftedKey;
		for(int i = 0; i < encryptedText.length(); i++) {
			int key = bellasoStr.charAt(i % bellasoStr.length());
			shiftedKey = (int)encryptedText.charAt(i) - key;
			while (shiftedKey < (int)LOWER_RANGE) {
				shiftedKey += RANGE;
			}
			newText += (char)shiftedKey;
		}
		return newText;
	}
}
