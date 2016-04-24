package aufgabenblatt_4;

import static org.junit.Assert.*;

import org.junit.Test;

public class SchnellesSortierenTest {

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
		SchnellesSortierenBucketSInsertionS<Integer> sS = new SchnellesSortierenBucketSInsertionS<>();
		int max = 8000;
		int min = 7000;
		long zeit = System.currentTimeMillis();
		sS.bucketsort(feldI,min, max,1);
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
		SchnellesSortierenBucketSInsertionS<Integer> sS = new SchnellesSortierenBucketSInsertionS<>();
		int max = 80000;
		int min = 70000;
		long zeit = System.currentTimeMillis();
		sS.bucketsort(feldI, min, max, 10);
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
	SchnellesSortierenBucketSInsertionS<Integer> sS = new SchnellesSortierenBucketSInsertionS<>();
	int max = 800000;
	int min = 700000;
	long zeit = System.currentTimeMillis();
	sS.bucketsort(feldI,min, max,100);
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
		SchnellesSortierenBucketSInsertionS<Integer> sS = new SchnellesSortierenBucketSInsertionS<>();
		int max = 8000000;
		int min = 7000000;
		long zeit = System.currentTimeMillis();
		sS.bucketsort(feldI,min, max,1500);
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
		SchnellesSortierenBucketSInsertionS<Integer> sS = new SchnellesSortierenBucketSInsertionS<>();
		int max = 80000000;
		int min = 70000000;
		long zeit = System.currentTimeMillis();
		sS.bucketsort(feldI,min, max,100000);
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
		for(int i = 0; i < n; i++) {
			feldI[i]= erstelleSchluessel(n);
		}
		SchnellesSortierenBucketSInsertionS<Integer> sS = new SchnellesSortierenBucketSInsertionS<>();
		int max = 800000000;
		int min = 700000000;
		long zeit= System.currentTimeMillis();
		sS.bucketsort(feldI,min, max,500000);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(sS);
		System.out.println("N: " + n + ", Laufzeit: " + zeit + "\n");
		
		boolean korrektSortiert = true;
		for(int i = 0; i < n-1; i++) {
			if(feldI[i].hashCode() > feldI[i+1].hashCode()) {
				korrektSortiert = false;
			}
		}
		assertEquals("Sollte true sein, wenn Array korrekt sortiert ist",korrektSortiert,true);
	}

}
