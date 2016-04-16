package aufgabenblatt3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exß (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 3: Rekursive Sortierverfahren: Quicksort  
 */
public class PivotAmEndeTest {

	
	/**
	 * Diesmal ist die Liste zu begin absteigend sortiert.
	 */
	@Test
	public void testQsIntegerPivotAmEndeBestCase() {
		Quicksort<Integer> qs = new Quicksort<>();  
		List<Integer> arrayL = new ArrayList<>();
		arrayL.add(3);
		arrayL.add(9);
		arrayL.add(8);
		arrayL.add(7);
		arrayL.add(0);
		arrayL.add(1);
		arrayL.add(4);
		arrayL.add(10);
		arrayL.add(2);
		arrayL.add(6);
		arrayL.add(5);	
		qs.quicksort(arrayL, 0, arrayL.size()-1);
		assertEquals((int) arrayL.get(0),0);
		assertEquals((int) arrayL.get(1),1);
		assertEquals((int) arrayL.get(2),2);
		assertEquals((int) arrayL.get(3),3);
		assertEquals((int) arrayL.get(4),4);
		assertEquals((int) arrayL.get(5),5);
		assertEquals((int) arrayL.get(6),6);
		assertEquals((int) arrayL.get(7),7);
		assertEquals((int) arrayL.get(8),8);
		assertEquals((int) arrayL.get(9),9);
		assertEquals((int) arrayL.get(10),10);
	}
	
	/**
	 * Liste ist zu begin aufsteigend sortiert.
	 */
	@Test
	public void testQsIntegerPivotAmEndeWorstCase() {
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
	 * Hier wird die Quicksort Methode mit dem Pivot 
	 * am Ende der Liste getestet. In diesem Test wird 
	 * eine Liste mit Integer Elementen genommen.
	 */
	@Test
	public void testQsIntegerPivotAmEndeAverageCase() {
		Quicksort<Integer> qs = new Quicksort<>();  
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
