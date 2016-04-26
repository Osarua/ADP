package aufgabenblatt_4;

import java.util.ArrayList;

public class SchnellesSortierenBucketHeapSort<E> {
	/**
	 * Anzahl der Vergleiche
	 */
	private int vergleiche;
	
	/**
	 * Anzahl der Vertauschungen
	 */
	private int vertauschungen;
	
	/**
	 * Anzahl der Rechenoperationen
	 */
	private int rechenoperationen;
	
	/**
	 * Anzahl der Zuweisungen
	 */
	private int zuweisungen;
	
	private ArrayList<E>[] buckets;

	@SuppressWarnings("unchecked")
	public void bucketsort(E[] feld, int untereSchranke, int obereSchranke, int anzahlBPar) {
		buckets = new ArrayList[anzahlBPar];
		vergleiche++;
		zuweisungen++;
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<E>();
			zuweisungen++;
			vergleiche++;
			rechenoperationen++;
		}
		int wertebereich = obereSchranke - untereSchranke;
		rechenoperationen++;
		zuweisungen++;
		vergleiche++;
		zuweisungen++;
		for (int i = 0; i < feld.length; i++) {
			double hashco = (double) feld[i].hashCode() - untereSchranke;
			zuweisungen++;
			rechenoperationen++;
			int index = (int) ((hashco / ((double) wertebereich)) * anzahlBPar);
			zuweisungen++;
			rechenoperationen++; 
			buckets[index].add(feld[i]);
			vergleiche++;
			rechenoperationen++;
		}
		vergleiche++;
		zuweisungen++;
		for (int i = 0; i < buckets.length; i++) {
			heapsort(buckets[i]);
			vergleiche++;
			rechenoperationen++;
		}
		int b = 0;
		int k = 0;
		vergleiche++;
		zuweisungen++;
		for (int i = 0; i < buckets.length; i++) {
			vergleiche++;
			while (b < buckets[i].size()) {
				zuweisungen++;
				feld[k + b] = buckets[i].get(b);
				b++;
				rechenoperationen++;
				vergleiche++;
			}
			zuweisungen++;
			k = k + b;
			rechenoperationen++;
			rechenoperationen++;
			zuweisungen++;
			b = 0;
			vergleiche++;
		}
	}

	private void heapsort(ArrayList<E> listFeld) {
		maxHeap(listFeld);
		vergleiche++;
		zuweisungen++;
		for (int i = listFeld.size() - 1; i > 0; i--) {
			vertausche(listFeld, 0, i);
			vertauschungen++;
			absinkenMaxHeap(listFeld, 0, i - 1);
			vergleiche++;
			rechenoperationen++;
			rechenoperationen++;
		}
	}

	private void maxHeap(ArrayList<E> listFeld) {
		vergleiche++;
		zuweisungen++;
		for (int i = (listFeld.size() / 2); i >= 0; i--) {
			absinkenMaxHeap(listFeld, i, listFeld.size() - 1);
			vergleiche++;
			rechenoperationen++;
			rechenoperationen++;
			rechenoperationen++;
		}
	}

	private void absinkenMaxHeap(ArrayList<E> listFeld, int index, int obereGrenzeR) {
		int linkerSohn = 2 * index + 1;
		zuweisungen++;
		rechenoperationen++;
		int rechterSohn = linkerSohn + 1;
		zuweisungen++;
		rechenoperationen++;
		int sohn;
		vergleiche++; 
		if (linkerSohn <= obereGrenzeR && rechterSohn > obereGrenzeR) {
			vergleiche++; vergleiche++;
			if (listFeld.get(linkerSohn).hashCode() > listFeld.get(index).hashCode())
				vertausche(listFeld, linkerSohn, index);
			vertauschungen++;
		} else {
			vergleiche++;
			if (rechterSohn <= obereGrenzeR) {
				vergleiche++;
				zuweisungen++;
				sohn = listFeld.get(linkerSohn).hashCode() > listFeld.get(rechterSohn).hashCode() ? linkerSohn
						: rechterSohn;
				vergleiche++;
				if (listFeld.get(sohn).hashCode() > listFeld.get(index).hashCode()) {
					vertausche(listFeld, index, sohn);
					vertauschungen++;
					absinkenMaxHeap(listFeld, sohn, obereGrenzeR);
				}
			}
		}
	}

	/**
	 * Vertauscht zwei Elemente innerhalb eines Array. Es wir ein swap
	 * ausgefuehrt. Auf der linken Seite steht anschliessend das Element an der
	 * Rechten Position und umgekehrt.
	 * 
	 * @param feld
	 *            Liste in welcher vertauscht werden soll
	 * @param i
	 *            Der Wert der Vor dem Tausch links steht
	 * @param j
	 *            Der Wert der Vor dem Tausch rechts steht
	 */
	private void vertausche(ArrayList<E> listFeld, int i, int j) {
		E temp = listFeld.get(i);
		zuweisungen++;
		listFeld.set(i, listFeld.get(j));
		zuweisungen++;
		listFeld.set(j, temp);
		zuweisungen++;
	}

	@Override
	public String toString() {
		return "SchnellesSortierenBucketHeapSort vergleiche=" + vergleiche + ", vertauschungen=" + vertauschungen
				+ ", rechenoperationen=" + rechenoperationen + ", zuweisungen=" + zuweisungen ;
	}
	
	
}
