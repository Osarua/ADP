package aufgabenblatt_6;

import static org.junit.Assert.*;

import org.junit.Test;

public class Huffmann_BaumTest {

	@Test
	public void testAbC() {
		String beispielString = "abbcccddddeeeee";
		Huffmann_Baum hB = new Huffmann_Baum(beispielString);
		Boolean[] code = hB.textCodieren(beispielString);
		assertEquals(hB.textDecodieren(code),"abbcccddddeeeee");
	}

}
