package aufgabenblatt_4;

	import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

	import org.junit.Test;

	public class SortTest {
		@Test
		public void testSortierenExpo1() {
			System.out.println (Math.pow(10, 6));
			Integer [] array = new Integer [] {7500,7200,7200,7400,7242,7564,7329,7345,7259,7394};
			Integer [] arraySortiert = new Integer [] {7200,7200,7242,7259,7329,7345,7394,7400,7500,7564};
			Sort sort = new Sort (1);
			sort.sortier(array);
			for (int i=0;i<10;i++) {
				assertTrue (""+i,array[i].equals(arraySortiert[i]));
			}
		}

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
			Sort sort = new Sort (1);
			long zeit= System.currentTimeMillis();
			sort.sortier(feldI);
			zeit = System.currentTimeMillis() - zeit;
			System.out.println(sort);
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
			Sort sort = new Sort (2);
			long zeit= System.currentTimeMillis();
			sort.sortier(feldI);
			zeit = System.currentTimeMillis() - zeit;
			System.out.println(sort);
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
		Sort sort = new Sort (3);
		long zeit= System.currentTimeMillis();
		sort.sortier(feldI);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println(sort);
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
			Sort sort = new Sort (4);
			long zeit= System.currentTimeMillis();
			sort.sortier(feldI);
			zeit = System.currentTimeMillis() - zeit;
			System.out.println(sort);
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
			Sort sort = new Sort (5);
			long zeit= System.currentTimeMillis();
			sort.sortier(feldI);
			zeit = System.currentTimeMillis() - zeit;
			System.out.println(sort);
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
			Sort sort = new Sort (6);
			long zeit= System.currentTimeMillis();
			sort.sortier(feldI);
			zeit = System.currentTimeMillis() - zeit;
			System.out.println(sort);
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
