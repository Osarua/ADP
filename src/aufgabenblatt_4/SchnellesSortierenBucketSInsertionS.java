package aufgabenblatt_4;

import java.util.ArrayList;
import java.util.List;


public class SchnellesSortierenBucketSInsertionS<E extends Comparable<E>> {
	
//	private ArrayList<E>[] buckets;
//	
//	private double anzahlB = 0;
	
//	public SchnellesSortieren (int anzahlBPar) {
//		anzahlB = anzahlBPar;
//		 buckets = new ArrayList[(int)anzahlB];
//		for (int i = 0; i < buckets.length; i++) {
//			buckets[i] = new ArrayList<E>(6);
//		}
//	}
	
	@SuppressWarnings("unchecked")
	public void bucketsort(E[] feld, int untereSchranke, int obereSchranke, int anzahlBPar) {
		List<E>[] buckets = new ArrayList[anzahlBPar];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<E>();
		}
		int wertebereich = obereSchranke - untereSchranke;
		for (int i = 0; i < feld.length; i++) {
			double hashco = (double)feld[i].hashCode() - untereSchranke;
			int index = (int) ((hashco / ((double) wertebereich)) * anzahlBPar);
			buckets[index].add(feld[i]);
			for (int i1 = 2; i1 <= buckets[index].size(); i1++) {

				int k = i1 - 1;
				E neu = buckets[index].get(i1 - 1);
				while (k > 0 && buckets[index].get(k - 1).hashCode() > neu.hashCode()) {
					buckets[index].set(k, buckets[index].get(k - 1));
					k = k - 1;
				}
				buckets[index].set(k, neu);
			}
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
	}

//int pointer = 0;
//for (int i = 0; i < buckets.length; i++) {
//	Collections.sort(buckets[i]);
//	for (int j = 0; j < buckets[i].size(); j++) {
//		feld[pointer] = buckets[i].get(j);
//	pointer++;
//}
//
//}
