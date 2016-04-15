package aufgabenblatt3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exß (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 3: Rekursive Sortierverfahren: Quicksort  
 */
public class QuicksortTest {

	@Test
	public void test() {
		Quicksort<Integer> qs = new Quicksort<>();  
		ArrayList<Integer> arrayL = new ArrayList<>();
		arrayL.add(8);
		arrayL.add(1);
		arrayL.add(4);
		arrayL.add(7);
		arrayL.add(6);
		arrayL.add(3);
		arrayL.add(2);
		arrayL.add(9);
		arrayL.add(10);
//		arrayL.add(20);
//		arrayL.add(54);
//		arrayL.add(28);
//		arrayL.add(31);
//		arrayL.add(5);
//		arrayL.add(24);
//		arrayL.add(39);
//		arrayL.add(14);
//		arrayL.add(1);
//		arrayL.add(15);
// 		qs.quicksort(arrayL, 0, arrayL.size()-1);
//		assertEquals("",(int) arrayL.get(0),1);
//		assertEquals("",(int) arrayL.get(1),5);
//		assertEquals("",(int) arrayL.get(2),14);
//		assertEquals("",(int) arrayL.get(3),15);
//		assertEquals("",(int) arrayL.get(4),20);
//		assertEquals("",(int) arrayL.get(5),24);
//		assertEquals("",(int) arrayL.get(6),28);
//		assertEquals("",(int) arrayL.get(7),31);
//		assertEquals("",(int) arrayL.get(8),39);
//		assertEquals("",(int) arrayL.get(9),54);
		qs.quicksort(arrayL, 0, arrayL.size()-1);
		assertEquals("",(int) arrayL.get(0),1);
		assertEquals("",(int) arrayL.get(1),2);
		assertEquals("",(int) arrayL.get(2),3);
		assertEquals("",(int) arrayL.get(3),4);
		assertEquals("",(int) arrayL.get(4),6);
		assertEquals("",(int) arrayL.get(5),7);
		assertEquals("",(int) arrayL.get(6),8);
		assertEquals("",(int) arrayL.get(7),9);
		assertEquals("",(int) arrayL.get(8),10);
	}

}
