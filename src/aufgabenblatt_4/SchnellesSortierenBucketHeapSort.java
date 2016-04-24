package aufgabenblatt_4;

import java.util.ArrayList;

public class SchnellesSortierenBucketHeapSort<E> {

	private ArrayList<E>[] buckets;

	@SuppressWarnings("unchecked")
	public void bucketsort(E[] feld, int untereSchranke, int obereSchranke, int anzahlBPar) {
		buckets = new ArrayList[anzahlBPar];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<E>();
		}
		int wertebereich = obereSchranke - untereSchranke;
		for (int i = 0; i < feld.length; i++) {
			double hashco = (double) feld[i].hashCode() - untereSchranke;
			int index = (int) ((hashco / ((double) wertebereich)) * anzahlBPar);
			buckets[index].add(feld[i]);
		}
		for (int i = 0; i < buckets.length; i++) {
			heapsort(buckets[i]);
		}
		int b = 0;
		int k = 0;
		for (int i = 0; i < buckets.length; i++) {
			while (b < buckets[i].size()) {
				feld[k + b] = buckets[i].get(b);
				b++;
			}
			k = k + b;
			b = 0;
		}
	}

	private void heapsort(ArrayList<E> listFeld) {
		maxHeap(listFeld);
		for (int i = listFeld.size() - 1; i > 0; i--) {
			vertausche(listFeld, 0, i);
			absinkenMaxHeap(listFeld, 0, i - 1);
		}
	}

	private void maxHeap(ArrayList<E> listFeld) {
		for (int i = (listFeld.size() / 2); i >= 0; i--) {
			absinkenMaxHeap(listFeld, i, listFeld.size() - 1);
		}
	}

	private void absinkenMaxHeap(ArrayList<E> listFeld, int index, int obereGrenzeR) {
		int linkerSohn = 2 * index + 1;
		int rechterSohn = linkerSohn + 1;
		int sohn;
		if (linkerSohn <= obereGrenzeR && rechterSohn > obereGrenzeR) {
			// nur ein Sohn (links)
			if (listFeld.get(linkerSohn).hashCode() > listFeld.get(index).hashCode())
				vertausche(listFeld, linkerSohn, index);
		} else {
			if (rechterSohn <= obereGrenzeR) {
				sohn = listFeld.get(linkerSohn).hashCode() > listFeld.get(rechterSohn).hashCode() ? linkerSohn
						: rechterSohn;
				if (listFeld.get(sohn).hashCode() > listFeld.get(index).hashCode()) {
					vertausche(listFeld, index, sohn);
					absinkenMaxHeap(listFeld, sohn, obereGrenzeR);
				}
			}
		}

		// E wert =listFeld.get(index-1);
		// while(index < obereGrenzeR/2) {
		// int j = 2 *index +1 ;
		// if((j+1 <
		// obereGrenzeR)&&(listFeld.get(j).hashCode()<listFeld.get(j+1).hashCode()))
		// {
		// j++;
		// if(wert.hashCode()>= listFeld.get(j).hashCode()) {
		// break;
		// } else {
		// listFeld.set(index, listFeld.get(j));
		// index=j;
		// }
		// }
		// listFeld.set(index, wert);
		// }
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
		listFeld.set(i, listFeld.get(j));
		listFeld.set(j, temp);
	}
}
