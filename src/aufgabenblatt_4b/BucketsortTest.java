package aufgabenblatt_4b;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BucketsortTest {

	public int erstelleSchluessel(int n) {
		return (int) (Math.random() * (n*100)) + (700 * n);
	}
	
	/**
	 * Untersuchung mit k = 1
	 */
	@Test
	public void testSchnellesSortierenNk1() {
		int n = 10;
		Integer[] feldI = new Integer[n];
		for (int i = 0; i < n; i++) {
			feldI[i] = erstelleSchluessel(n);
		}
		Bucketsort<Integer> sS = new Bucketsort<>();
		long zeit = System.currentTimeMillis();
		sS.bucketsort(feldI);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(sS);
		System.out.println("N: " + n + ", Laufzeit: " + zeit + "\n");
		boolean korrektSortiert = true;
		for (int i = 0; i < n - 1; i++) {
			if (feldI[i].hashCode() > feldI[i + 1].hashCode()) {
			korrektSortiert = false;
			}
		}
		assertEquals("Sollte true sein, wenn Array korrekt sortiert ist", korrektSortiert, true);
	}
	
	/**
	 * Untersuchung mit k = 2
	 */
	@Test
	public void testSchnellesSortierenNk2() {
		int n = 100;
		Integer[] feldI = new Integer[n];
		for (int i = 0; i < n; i++) {
			feldI[i] = erstelleSchluessel(n);
		}
		Bucketsort<Integer> sS = new Bucketsort<>();
		long zeit = System.currentTimeMillis();
		sS.bucketsort(feldI);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(sS);
		System.out.println("N: " + n + ", Laufzeit: " + zeit + "\n");
		boolean korrektSortiert = true;
		for (int i = 0; i < n - 1; i++) {
			if (feldI[i].hashCode() > feldI[i + 1].hashCode()) {
			korrektSortiert = false;
			}
		}
		assertEquals("Sollte true sein, wenn Array korrekt sortiert ist", korrektSortiert, true);
	}
	
	/**
	 * Untersuchung mit k = 3
	 */
	@Test
	public void testSchnellesSortierenNk3() {
		int n = 1000;
		Integer[] feldI = new Integer[n];
		for (int i = 0; i < n; i++) {
			feldI[i] = erstelleSchluessel(n);
		}
		Bucketsort<Integer> sS = new Bucketsort<>();
		long zeit = System.currentTimeMillis();
		sS.bucketsort(feldI);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(sS);
		System.out.println("N: " + n + ", Laufzeit: " + zeit + "\n");
		boolean korrektSortiert = true;
		for (int i = 0; i < n - 1; i++) {
			if (feldI[i].hashCode() > feldI[i + 1].hashCode()) {
			korrektSortiert = false;
			}
		}
		assertEquals("Sollte true sein, wenn Array korrekt sortiert ist", korrektSortiert, true);
	}
	
	/**
	 * Untersuchung mit k = 4
	 */
	@Test
	public void testSchnellesSortierenNk4() {
		int n = 10000;
		Integer[] feldI = new Integer[n];
		for (int i = 0; i < n; i++) {
			feldI[i] = erstelleSchluessel(n);
		}
		Bucketsort<Integer> sS = new Bucketsort<>();
		long zeit = System.currentTimeMillis();
		sS.bucketsort(feldI);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(sS);
		System.out.println("N: " + n + ", Laufzeit: " + zeit + "\n");
		boolean korrektSortiert = true;
		for (int i = 0; i < n - 1; i++) {
			if (feldI[i].hashCode() > feldI[i + 1].hashCode()) {
			korrektSortiert = false;
			}
		}
		assertEquals("Sollte true sein, wenn Array korrekt sortiert ist", korrektSortiert, true);
	}
	
	/**
	 * Untersuchung mit k = 5
	 */
	@Test
	public void testSchnellesSortierenNk5() {
		int n = 100000;
		Integer[] feldI = new Integer[n];
		for (int i = 0; i < n; i++) {
			feldI[i] = erstelleSchluessel(n);
		}
		Bucketsort<Integer> sS = new Bucketsort<>();
		long zeit = System.currentTimeMillis();
		sS.bucketsort(feldI);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(sS);
		System.out.println("N: " + n + ", Laufzeit: " + zeit + "\n");
		boolean korrektSortiert = true;
		for (int i = 0; i < n - 1; i++) {
			if (feldI[i].hashCode() > feldI[i + 1].hashCode()) {
			korrektSortiert = false;
			}
		}
		assertEquals("Sollte true sein, wenn Array korrekt sortiert ist", korrektSortiert, true);
	}
	
	/**
	 * Untersuchung mit k = 6
	 */
	@Test
	public void testSchnellesSortierenNk6() {
		int n = 1000000;
		Integer[] feldI = new Integer[n];
		for (int i = 0; i < n; i++) {
			feldI[i] = erstelleSchluessel(n);
		}
		Bucketsort<Integer> sS = new Bucketsort<>();
		long zeit = System.currentTimeMillis();
		sS.bucketsort(feldI);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(sS);
		System.out.println("N: " + n + ", Laufzeit: " + zeit + "\n");
		boolean korrektSortiert = true;
		for (int i = 0; i < n - 1; i++) {
			if (feldI[i].hashCode() > feldI[i + 1].hashCode()) {
			korrektSortiert = false;
			}
		}
		assertEquals("Sollte true sein, wenn Array korrekt sortiert ist", korrektSortiert, true);
	}
	
//	@Test
//	public void testBuch() {
//		FeldList fl = new FeldList(10);
//		fl.insert(20);
//		fl.insert(54);
//		fl.insert(28);
//		fl.insert(31);
//		fl.insert(5);
//		fl.insert(24);
//		fl.insert(39);
//		fl.insert(14);
//		fl.insert(1);
//		fl.insert(15);
//		Heapsort hs = new Heapsort(fl);
//		hs.start();
//		try {
//			hs.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

