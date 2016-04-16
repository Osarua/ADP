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
 */
public class QuicksortTest {

	/**
	 * Hier wird die Quicksort Methode mit dem Pivot 
	 * am Ende der Liste getestet. In diesem Test wird 
	 * eine Liste mit Integer Elementen genommen.
	 */
	@Test
	public void testQsIntegerPivotAmEnde() {
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

	
	/**
	 * Testet die Quicksort Methode mit dem Pivot 
	 * Median (median of three). In diesem Test wird 
	 * eine Liste mit Integer Elementen genommen.
	 */
	@Test
	public void testQsIntegerPivotMedian() {
		Quicksort<Integer> qs = new Quicksort<>(new PivotMedianOfThree<Integer>());  
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
	
	/**
	 * Testet die Methode mit ein paar mehr Integer Werten.
	 */
	@Test
	public void testQsIntegerPivotMedianEtwasMehr() {
		Quicksort<Integer> qs = new Quicksort<>(new PivotMedianOfThree<Integer>());
		List<Integer> arrayL = new ArrayList<>();
		int max = 1000000;
		for (int i = 1; i <= max; i++) {
			arrayL.add(i);
		}
		qs.quicksort(arrayL, 0, arrayL.size() - 1);
		assertEquals((int) arrayL.get(0), 1);
		assertEquals((int) arrayL.get(1), 2);
		assertEquals((int) arrayL.get(2), 3);
		assertEquals((int) arrayL.get(99), 100);
		assertEquals((int) arrayL.get(999), 1000);
		assertEquals((int) arrayL.get(9999), 10000);
		// Absteigend
		int i = 0;
		for (int integ = max - 1; integ > 0; integ--) {
			arrayL.set(i, integ);
			i++;
		}
		qs.quicksort(arrayL, 0, arrayL.size() - 1);
		assertEquals((int) arrayL.get(0), 1);
		assertEquals((int) arrayL.get(9999), 10000);
	}

	/**
	 * Testet die Quicksort Methode mit dem Pivot 
	 * randomisiert berechnet. In diesem Test wird 
	 * eine Liste mit Integer Elementen genommen.
	 */
	@Test
	public void testQsIntegerPivotRandom() {
		Quicksort<Integer> qs = new Quicksort<>(new PivotRandom<Integer>());  
		List<Integer> arrayL = new ArrayList<>();
		arrayL.add(80);
		arrayL.add(10);
		arrayL.add(40);
		arrayL.add(70);
		arrayL.add(60);
		arrayL.add(30);
		arrayL.add(20);
		arrayL.add(90);
		arrayL.add(100);
		qs.quicksort(arrayL, 0, arrayL.size()-1);
		assertEquals((int) arrayL.get(0),10);
		assertEquals((int) arrayL.get(1),20);
		assertEquals((int) arrayL.get(2),30);
		assertEquals((int) arrayL.get(3),40);
		assertEquals((int) arrayL.get(4),60);
		assertEquals((int) arrayL.get(5),70);
		assertEquals((int) arrayL.get(6),80);
		assertEquals((int) arrayL.get(7),90);
		assertEquals((int) arrayL.get(8),100);
	}
	
	/**
	 * Hier wird die Methode mit einem String getestet.
	 */
	@Test
	public void testQsStringPivotRandom() {
		Quicksort<String> qs = new Quicksort<>(new PivotRandom<String>());  
		List<String> arrayL = new ArrayList<>();
		arrayL.add("C");
		arrayL.add("U");
		arrayL.add("C");
		arrayL.add("K");
		arrayL.add("N");
		arrayL.add("O");
		arrayL.add("R");
		arrayL.add("R");
		arrayL.add("I");
		arrayL.add("S");
		qs.quicksort(arrayL, 0, arrayL.size()-1);
		assertEquals(arrayL.get(0),"C");
		assertEquals(arrayL.get(1),"C");
		assertEquals(arrayL.get(2),"I");
		assertEquals(arrayL.get(3),"K");
		assertEquals(arrayL.get(4),"N");
		assertEquals(arrayL.get(5),"O");
		assertEquals(arrayL.get(6),"R");
		assertEquals(arrayL.get(7),"R");
		assertEquals(arrayL.get(8),"S");
		assertEquals(arrayL.get(9),"U");
	}

}
