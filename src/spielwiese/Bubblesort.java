package spielwiese;
/**
 * Sortieralgorithmus Bubblesort
 */
public class Bubblesort {

	/**
	 * Die Methode sortiert ein Array iterativ mit Bubblesort.
	 */
	public void bubblesort(int[] array) {
		for (int i = array.length; i >= 0; i--) {
			for (int j = 0; j < i-1; j++) {
				if (array[j] > array[j + 1]) {
					vertausche(array, j, j+1);
				}
			}
		}
	}

	/**
	 * Die Methode sortiert ein Array  rekursiv mit Bubblesort.
	 * @param array zu sortierendes Feld
	 * @param size Groesse des Felds
	 */
	public void bubblesortR(int[] array, int size) {
		if(size != 0) {
			bubblesortDurchlaufR(array, 0, size);
			bubblesortR(array, size-1);
		}
	}
	
	private void bubblesortDurchlaufR(int[] array, int i, int size) {
		if(i < size-1) {
			if (array[i] > array[i + 1]) {
				vertausche(array, i, i+1);
			}
			bubblesortDurchlaufR(array, i+1 ,size);
		}
	}
	
	/**
	 * Vertauscht zwei Elemente in einem Feld
	 */
	private void vertausche(int[] array, int j, int i) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
}
