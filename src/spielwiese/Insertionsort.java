package spielwiese;

/**
 * 
 * @author Julian 
 * Sortieralgorithmus Insertionsort
 */
public class Insertionsort {

	/**
	 * Sortieren durch einfügen
	 */
	public void insertionsort(int[] feld) {
		int k = 0;
		for(int i=2;i<feld.length;i++) {
			int neu = feld[i];
			k = i;
			while (k > 0 && feld[k-1] > neu) {
				feld[k]= feld[k-1];
				k = k - 1;
			}
			feld[k] = neu; 
		}
	  }
}