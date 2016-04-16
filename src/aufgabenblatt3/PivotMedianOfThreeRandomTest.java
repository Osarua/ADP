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
public class PivotMedianOfThreeRandomTest {

	/**
	 * Testet ob der Median den Mittleren Wert hat.
	 */
	@Test
	public void testMedian() {
		List<Integer> arrL = new ArrayList<>();
		arrL.add(2);
		arrL.add(2);
		arrL.add(2);
		Pivot<Integer> pivoMedian = new PivotMedianOfThreeRandom<Integer>();
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
	
	/**
	 * Die Liste ist vor den Aufruf von Quicksort absteigend sortiert.
	 */
	@Test
	public void testQsPivotMedianOfThreeBestCase() {
		Quicksort<Integer> qs = new Quicksort<>(new PivotMedianOfThreeRandom<Integer>());  
		List<Integer> arrayL = new ArrayList<>();
		arrayL.add(10);
		arrayL.add(9);
		arrayL.add(8);
		arrayL.add(7);
		arrayL.add(6);
		arrayL.add(5);
		arrayL.add(4);
		arrayL.add(3);
		arrayL.add(2);
		arrayL.add(1);	
		qs.quicksort(arrayL, 0, arrayL.size()-1);
		assertEquals((int) arrayL.get(0),1);
		assertEquals((int) arrayL.get(1),2);
		assertEquals((int) arrayL.get(2),3);
		assertEquals((int) arrayL.get(3),4);
		assertEquals((int) arrayL.get(4),5);
		assertEquals((int) arrayL.get(5),6);
		assertEquals((int) arrayL.get(6),7);
		assertEquals((int) arrayL.get(7),8);
		assertEquals((int) arrayL.get(8),9);
		assertEquals((int) arrayL.get(9),10);
	}
	
	/**
	 * Liste ist zu begin aufsteigend sortiert.
	 */
	@Test
	public void  testQsPivotMedianOfThreeWorstCase() {
		Quicksort<Integer> qs = new Quicksort<>();  
		List<Integer> arrayL = new ArrayList<>();
		arrayL.add(1);
		arrayL.add(2);
		arrayL.add(3);
		arrayL.add(4);
		arrayL.add(5);
		arrayL.add(6);
		arrayL.add(7);
		arrayL.add(8);
		arrayL.add(9);
		arrayL.add(10);	
		qs.quicksort(arrayL, 0, arrayL.size()-1);
		assertEquals((int) arrayL.get(0),1);
		assertEquals((int) arrayL.get(1),2);
		assertEquals((int) arrayL.get(2),3);
		assertEquals((int) arrayL.get(3),4);
		assertEquals((int) arrayL.get(4),5);
		assertEquals((int) arrayL.get(5),6);
		assertEquals((int) arrayL.get(6),7);
		assertEquals((int) arrayL.get(7),8);
		assertEquals((int) arrayL.get(8),9);
		assertEquals((int) arrayL.get(9),10);
	}
	
	/**
	 * Testet Quicksort mit Pivot aus dem mittleren Element Schluessel von drei Elementen
	 * aus der Liste.  In diesem Test wird  eine Liste mit Integer Elementen genommen.
	 */
	@Test
	public void  testQsPivotMedianOfThreeAverageCase() {
		Quicksort<Integer> qs = new Quicksort<>(new PivotMedianOfThreeRandom<Integer>());  
		List<Integer> arrayL = new ArrayList<>();
		arrayL.add(8);
		arrayL.add(1);
		arrayL.add(4);
		arrayL.add(7);
		arrayL.add(6);
		arrayL.add(3);
		arrayL.add(2);
		arrayL.add(9);
		arrayL.add(10);
		qs.quicksort(arrayL, 0, arrayL.size()-1);
		assertEquals((int) arrayL.get(0),1);
		assertEquals((int) arrayL.get(1),2);
		assertEquals((int) arrayL.get(2),3);
		assertEquals((int) arrayL.get(3),4);
		assertEquals((int) arrayL.get(4),6);
		assertEquals((int) arrayL.get(5),7);
		assertEquals((int) arrayL.get(6),8);
		assertEquals((int) arrayL.get(7),9);
		assertEquals((int) arrayL.get(8),10);
	}

}
