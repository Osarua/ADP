package aufgabenblatt_4;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 4: Schnelles Sortieren
 * Die zu sortierende Menge ist N = 10^k  k = 1,...,6.
 * Mit einem Wertebereich von 700 * N <= key <= 800 * N
 * Diese Klasse hilft bei der Ermittlung von Vergleichen, Zeit, Rechenoperationen, etc.
 * fuer den Quicksort Algorithmus aus der Vorlesung.    
 */
public class QuicksortVorlesungTest {

	@Test
	public void testQuicksort() {
		QuicksortVorlesung<Integer> qs = new QuicksortVorlesung<>();
		Integer[] feld = new Integer[10]; 
		feld[0] = 100;
		feld[1] = 200;
		feld[2] = 300;
		feld[3] = 400;
		feld[4] = 500;
		feld[5] = 600;
		feld[6] = 700;
		feld[7] = 800;
		feld[8] = 900;
		feld[9] = 1000;
		qs.quicksort(feld, 0, feld.length-1);
		assertEquals((int) feld[0],100);
		assertEquals((int) feld[1],200);
		assertEquals((int) feld[2],300);
		assertEquals((int) feld[3],400);
		assertEquals((int) feld[4],500);
		assertEquals((int) feld[5],600);
		assertEquals((int) feld[6],700);
		assertEquals((int) feld[7],800);
		assertEquals((int) feld[8],900);
		assertEquals((int) feld[9],1000);
		feld[0] = 10;
		feld[1] = 9;
		feld[2] = 8;
		feld[3] = 7;
		feld[4] = 6;
		feld[5] = 5;
		feld[6] = 4;
		feld[7] = 3;
		feld[8] = 2;
		feld[9] = 1;
		qs.quicksort(feld, 0, feld.length-1);
		assertEquals((int) feld[0],1);
		assertEquals((int) feld[1],2);
		assertEquals((int) feld[2],3);
		assertEquals((int) feld[3],4);
		assertEquals((int) feld[4],5);
		assertEquals((int) feld[5],6);
		assertEquals((int) feld[6],7);
		assertEquals((int) feld[7],8);
		assertEquals((int) feld[8],9);
		assertEquals((int) feld[9],10);
		feld[0] = 6;
		feld[1] = 10;
		feld[2] = 1;
		feld[3] = 2;
		feld[4] = 3;
		feld[5] = 7;
		feld[6] = 8;
		feld[7] = 9;
		feld[8] = 4;
		feld[9] = 5;
		qs.quicksort(feld, 0, feld.length-1);
		assertEquals((int) feld[0],1);
		assertEquals((int) feld[1],2);
		assertEquals((int) feld[2],3);
		assertEquals((int) feld[3],4);
		assertEquals((int) feld[4],5);
		assertEquals((int) feld[5],6);
		assertEquals((int) feld[6],7);
		assertEquals((int) feld[7],8);
		assertEquals((int) feld[8],9);
		assertEquals((int) feld[9],10);
	}

	@Test
	public void testVerteilteSchluessel() {
		int n = 10;
		boolean keyWertebereich = true;
		int key = 0;
		int obereSchluesselSchranke = 800 * n;
		int untereSchluesselSchranke = 700 * n;
		for (int i = 0; i < n; i++) {
			key = (int) (Math.random() * (n * 100)) + untereSchluesselSchranke ;
			if(untereSchluesselSchranke > key ||  key > obereSchluesselSchranke) {
				keyWertebereich = false;
			}
		}
		assertEquals(keyWertebereich,true);
	}
	
	public int erstelleSchluessel(int n) {
		return (int) (Math.random() * (n*100)) + (700 * n);
	}
	
	public int erstelleSchluesselHoch(int n) {
		int wert = 0;
		wert = (int) (Math.random() * (n*100)) + (799 * n);
		while(wert > 800*n) {
			wert = wert - 100;
		}
		return wert;
	}
	
	public void erstelleSchluesselAufsteigend(Integer[] feldI) {
		for(int i = 0; i <feldI.length ;i++) {
			feldI[i] = 700*feldI.length+i;
		}		
			   for (int i = 0;i<feldI.length/100;i++) {
			    int pos = (int)(Math.random()*feldI.length);
			    feldI[i]=feldI[pos];
			   }
	}
	
	/**
	 * Untersuchung mit k = 1
	 */
	@Test
	public void testQuicksortNk1S() {
		int n = 10;
		Integer[] feldI = new Integer[n];
		for (int i = 0; i < n/4; i++) {
			feldI[i] = erstelleSchluessel(n);
		}
		for (int i =  n/4; i < n; i++) {
			feldI[i] = n * 700 + i;
		}
		QuicksortVorlesung<Integer> qs = new QuicksortVorlesung<>();
		long zeit= System.currentTimeMillis();
		qs.quicksort(feldI, 0, feldI.length-1);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(qs);
		System.out.println("N: " + n + ", Laufzeit: " + zeit + "\n");
		boolean korrektSortiert = true;
		for(int i = 0; i < n-1; i++) {
			if(feldI[i].hashCode() > feldI[i+1].hashCode()) {
				korrektSortiert = false;
			}
		}
		assertEquals("Sollte true sein, wenn Array korrekt sortiert ist",korrektSortiert,true);
	}
	
	/**
	 * Untersuchung mit k = 2
	 */
	@Test
	public void testQuicksortNk2S() {
		int n = 100;
		Integer[] feldI = new Integer[n];
		for (int i = 0; i < n/4; i++) {
			feldI[i] = erstelleSchluessel(n);
		}
		for (int i = n/4; i < n; i++) {
			feldI[i] = n * 700 + i;
		}
		QuicksortVorlesung<Integer> qs = new QuicksortVorlesung<>();
		long zeit= System.currentTimeMillis();
		qs.quicksort(feldI, 0, feldI.length-1);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(qs);
		System.out.println("N: " + n + ", Laufzeit: " + zeit + "\n");
		boolean korrektSortiert = true;
		for(int i = 0; i < n-1; i++) {
			if(feldI[i].hashCode() > feldI[i+1].hashCode()) {
				korrektSortiert = false;
			}
		}
		assertEquals("Sollte true sein, wenn Array korrekt sortiert ist",korrektSortiert,true);
	}
	
	/**
	 * Untersuchung mit k = 3
	 */
	@Test
	public void testQuicksortNk3S() {
		int n = 1000;
		Integer[] feldI = new Integer[n];
		for (int i = 0; i < n/4; i++) {
			feldI[i] = erstelleSchluessel(n);
		}
		for (int i =  n/4; i < n; i++) {
			feldI[i] = n * 700 + i;
		}
		QuicksortVorlesung<Integer> qs = new QuicksortVorlesung<>();
		long zeit= System.currentTimeMillis();
		qs.quicksort(feldI, 0, feldI.length-1);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(qs);
		System.out.println("N: " + n + ", Laufzeit: " + zeit + "\n");
		boolean korrektSortiert = true;
		for(int i = 0; i < n-1; i++) {
			if(feldI[i].hashCode() > feldI[i+1].hashCode()) {
				korrektSortiert = false;
			}
		}
		assertEquals("Sollte true sein, wenn Array korrekt sortiert ist",korrektSortiert,true);
	}
	
	/**
	 * Untersuchung mit k = 4
	 */
	@Test
	public void testQuicksortNk4S() {
		int n = 10000;
		Integer[] feldI = new Integer[n];
		for (int i = 0; i < n/4; i++) {
			feldI[i] = erstelleSchluessel(n);
		}
		for (int i = n/4; i < n; i++) {
			feldI[i] = n * 700 + i;
		}
		QuicksortVorlesung<Integer> qs = new QuicksortVorlesung<>();
		long zeit= System.currentTimeMillis();
		qs.quicksort(feldI, 0, feldI.length-1);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(qs);
		System.out.println("N: " + n + ", Laufzeit: " + zeit + "\n");
		boolean korrektSortiert = true;
		for(int i = 0; i < n-1; i++) {
			if(feldI[i].hashCode() > feldI[i+1].hashCode()) {
				korrektSortiert = false;
			}
		}
		assertEquals("Sollte true sein, wenn Array korrekt sortiert ist",korrektSortiert,true);
	}
	
	/**
	 * Untersuchung mit k = 5
	 */
	@Test
	public void testQuicksortNk5S() {
		int n = 100000;
		Integer[] feldI = new Integer[n];
		for (int i = 0; i < n/4; i++) {
			feldI[i] = erstelleSchluessel(n);
		}
		for (int i = n/4; i < n; i++) {
			feldI[i] = n * 700 + i;
		}
		QuicksortVorlesung<Integer> qs = new QuicksortVorlesung<>();
		long zeit= System.currentTimeMillis();
		qs.quicksort(feldI, 0, feldI.length-1);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(qs);
		System.out.println("N: " + n + ", Laufzeit: " + zeit + "\n");
		boolean korrektSortiert = true;
		for(int i = 0; i < n-1; i++) {
			if(feldI[i].hashCode() > feldI[i+1].hashCode()) {
				korrektSortiert = false;
			}
		}
		assertEquals("Sollte true sein, wenn Array korrekt sortiert ist",korrektSortiert,true);
	}
	
	/**
	 * Untersuchung mit k = 6
	 */
	@Test
	public void testQuicksortNk6S() {
		int n = 1000000;
		Integer[] feldI = new Integer[n];
		for (int i = 0; i < n/4; i++) {
			feldI[i] = erstelleSchluessel(n);
		}
		for (int i = n/4; i < n; i++) {
			feldI[i] = n * 700 + i;
		}
		QuicksortVorlesung<Integer> qs = new QuicksortVorlesung<>();
		long zeit= System.currentTimeMillis();
		qs.quicksort(feldI, 0, feldI.length-1);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(qs);
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
