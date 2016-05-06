package spielwiese;

/**
 * 
 * @author Julian 
 * Sortieralgorithmus Insertionsort
 */
public class Insertionsort {

	/**
	 * Sortieren durch einf�gen
	 */
	public void insertionsort(Integer[] feld) {
		int k = 0;
		for(int i=2;i<=feld.length;i++) {
			int neu = feld[i-1].hashCode();
			k = i-1;
			while (k > 0 && feld[k-1].hashCode() > neu) {
				feld[k]= feld[k-1];
				k = k - 1;
			}
			feld[k] = neu; 
		}
	  }
}