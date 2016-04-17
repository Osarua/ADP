package aufgabenblatt_3;

import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class PivotMedianTest {

	/**
	 * Die Methode "Testet" den Worstcase bei der Wahl des Median Pivots.
	 */
	@Test
	public void testQsPivotMedianWorstCase() {
		Quicksort<Integer> qs = new Quicksort<>(new PivotMedian<Integer>());
		List<Integer> linkList = new LinkedList<>();
		linkList.add(8);
		linkList.add(7);
		linkList.add(3);
		linkList.add(5);
		linkList.add(6);
		linkList.add(2);
		linkList.add(1);
		qs.quicksort(linkList, 0, linkList.size()-1);
		assertEquals((int) linkList.get(3),5);
	}
	
	/**
	 * Testet den Best Case.
	 */
	@Test
	public void testQsPivotMedianBestCase() {
		Quicksort<Integer> qs = new Quicksort<>(new PivotMedian<Integer>());
		List<Integer> linkList = new LinkedList<>();
		linkList.add(8);
		linkList.add(7);
		linkList.add(3);
		linkList.add(1);
		linkList.add(6);
		linkList.add(2);
		linkList.add(5);
		qs.quicksort(linkList, 0, linkList.size()-1);
		assertEquals((int) linkList.get(3),5);
	}
	
	/**
	 * Testet den Average Case
	 */
	@Test
	public void testQsPivotMedianAverageCase() {
		Quicksort<Integer> qs = new Quicksort<>(new PivotMedian<Integer>());
		List<Integer> arrayList = new LinkedList<>();
		arrayList.add(20);
		arrayList.add(54);
		arrayList.add(15);
		arrayList.add(31);
		arrayList.add(5);
		arrayList.add(24);
		arrayList.add(39);
		arrayList.add(14);
		arrayList.add(1);
		arrayList.add(28);
		qs.quicksort(arrayList, 0, arrayList.size()-1);
		assertEquals((int) arrayList.get(4),20);
	}
	
	/**
	 * Testet die Methode getPivot.
	 */
	@Test
	public void getPivot() {
		Pivot<String> median = new PivotMedian<>();
		List<String> linkList = new LinkedList<>();
		linkList.add("B");
		linkList.add("A");
		linkList.add("C");
		assertEquals(median.getPivot(linkList),"B");
		linkList.remove(2);
		assertEquals(median.getPivot(linkList),"A");
		linkList.add("C");
		linkList.add("D");
		linkList.add("E");
		linkList.add("F");
		assertEquals(median.getPivot(linkList),"C");
		linkList.add("G");
		assertEquals(median.getPivot(linkList),"D");
	}

}
