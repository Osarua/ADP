package aufgabenblatt_6;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 6: Bin‰rer Baum
 * Testklasse
 */
public class Huffmann_BaumTest {

	@Test
	public void testAbC() {
		String beispielString = "abbcccddddeeeee";
		Huffmann_Baum hB = new Huffmann_Baum(beispielString);
		Boolean[] code = hB.textCodieren(beispielString);
		assertEquals(hB.textDecodieren(code),beispielString);
	}
	
	@Test
	public void TestEinZeichen() {
		String aString = "a";
		Huffmann_Baum hB = new Huffmann_Baum(aString);
		Boolean[] code = hB.textCodieren(aString);
		assertEquals(hB.textDecodieren(code),aString);
		
		String bString = "bbbb";
		Huffmann_Baum hBb = new Huffmann_Baum(bString);
		Boolean[] codeB = hBb.textCodieren("b");
		assertEquals(hBb.textDecodieren(codeB),"b");
	}
	
	@Test
	public void testNullZeichen() {
		String zeichen = "";
		try {
			Huffmann_Baum hB = new Huffmann_Baum(zeichen);
			Boolean[] code = hB.textCodieren(zeichen);
			assertEquals(hB.textDecodieren(code), zeichen);
			assertTrue(false);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testKeinAscii() {
		String zeichen = "Ä";
		try {
			Huffmann_Baum hB = new Huffmann_Baum(zeichen);
			Boolean[] code = hB.textCodieren(zeichen);
			assertEquals(hB.textDecodieren(code), zeichen);
			assertTrue(false);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testDoppeltAuB() {
		String beispielString = "aabb";
		Huffmann_Baum hB = new Huffmann_Baum(beispielString);
		Boolean[] code = hB.textCodieren("bbaa");
		assertEquals(hB.textDecodieren(code),"bbaa");
		
		String beispielStringR = "bbaa";
		Huffmann_Baum hBr = new Huffmann_Baum(beispielStringR);
		Boolean[] codeR = hBr.textCodieren("aabb");
		assertEquals(hBr.textDecodieren(codeR),"aabb");
	}
	
	@Test
	public void testCodierungAnders() {
		String beispielString = "-XXYYXX-";
		Huffmann_Baum hB = new Huffmann_Baum(beispielString);
		Boolean[] code = hB.textCodieren("AA");
		assertEquals(hB.textDecodieren(code),"");
	}
}
