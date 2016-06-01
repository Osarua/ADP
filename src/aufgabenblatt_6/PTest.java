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
public class PTest {

	@Test
	public void testAbC() {
		String beispielString = "abbcccddddeeeee";
		P hB = new P(beispielString);
		Boolean[] code = hB.textCodieren(beispielString);
		assertEquals(hB.textDecodieren(code),beispielString);
	}
	
	@Test
	public void TestEinZeichen() {
		String aString = "a";
		P hB = new P(aString);
		Boolean[] code = hB.textCodieren(aString);
		assertEquals(hB.textDecodieren(code),aString);
		
		String bString = "bbbb";
		P hBb = new P(bString);
		Boolean[] codeB = hBb.textCodieren("b");
		assertEquals(hBb.textDecodieren(codeB),"b");
	}
	
	@Test
	public void testNullZeichen() {
		String zeichen = "";
		try {
			P hB = new P(zeichen);
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
			P hB = new P(zeichen);
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
		P hB = new P(beispielString);
		Boolean[] code = hB.textCodieren("bbaa");
		assertEquals(hB.textDecodieren(code),"bbaa");
		
		String beispielStringR = "bbaa";
		P hBr = new P(beispielStringR);
		Boolean[] codeR = hBr.textCodieren("aabb");
		assertEquals(hBr.textDecodieren(codeR),"aabb");
	}
	
	@Test
	public void testBeispiel () {
		String beispielString = "If you give someone a program you will frustrate them for a day? If you teach them how to"
								+"program, you will frustrate them for a lifetime. The computing scientist?s main challenge is not to"
								+"get confused by the complexities of his own making. Beauty is more important in computing than"
								+"anywhere else in technology because software is so complicated. Beauty is the ultimate defence"
								+"against complexity.";
		System.out.println(beispielString.length()*16);
		P hB = new P(beispielString);
		Boolean[] code = hB.textCodieren(beispielString);
		System.out.println (code.length);
		assertEquals(hB.textDecodieren(code),beispielString);
	}
	
	@Test
	public void testCodierungAnders() {
		String beispielString = "-XXYYXX-";
		P hB = new P(beispielString);
		Boolean[] code = hB.textCodieren("AA");
		assertEquals(hB.textDecodieren(code),"");
	}
}
