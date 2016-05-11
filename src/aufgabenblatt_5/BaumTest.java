package aufgabenblatt_5;

import static org.junit.Assert.*;
import org.junit.Test;
public class BaumTest {

	@Test
	public void baumTest() {
		int[] folge = new int[6];
		folge[0] = 4;
		folge[1] = 3;
		folge[2] = 2;
		folge[3] = 1;
		folge[4] = 5;
		folge[5] = 6;
		Baum baum = new Baum(folge);
		assertEquals(baum.rueckgabe(1, 2),3);
	}
	
}
