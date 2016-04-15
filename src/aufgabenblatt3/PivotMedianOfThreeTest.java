package aufgabenblatt3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 3: Rekursive Sortierverfahren: Quicksort  
 * Testet die Klasse PivotMedianOfThree
 */
public class PivotMedianOfThreeTest {

	/**
	 * Testet ob der Median den Mittleren Wert hat.
	 */
	@Test
	public void testMedian() {
		List<Integer> arrL = new ArrayList<>();
		arrL.add(2);
		arrL.add(2);
		arrL.add(2);
		Pivot<Integer> pivoMedian = new PivotMedianOfThree<Integer>();
		assertEquals((int) pivoMedian.getPivot(arrL),2);
		arrL.set(1, 4);
		arrL.set(2, 8);
		assertEquals((int) pivoMedian.getPivot(arrL),4);
		arrL.set(1, 8);
		arrL.set(2, 4);
		assertEquals((int) pivoMedian.getPivot(arrL),4);
		arrL.set(0, 4);
		arrL.set(1, 2);
		arrL.set(2, 8);
		assertEquals((int) pivoMedian.getPivot(arrL),4);
		arrL.set(0, 4);
		arrL.set(1, 8);
		arrL.set(2, 2);
		assertEquals((int) pivoMedian.getPivot(arrL),4);
		arrL.set(0, 8);
		arrL.set(1, 4);
		arrL.set(2, 2);
		assertEquals((int) pivoMedian.getPivot(arrL),4);
		arrL.set(0, 8);
		arrL.set(1, 2);
		arrL.set(2, 4);
	}

}
