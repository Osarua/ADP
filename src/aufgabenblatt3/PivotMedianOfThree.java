package aufgabenblatt3;

import java.util.List;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 3: Rekursive Sortierverfahren: Quicksort  
 */
public class PivotMedianOfThree<E extends Comparable<E>> implements Pivot<E> {

	/**
	 * Es wird das mittlere Element von drei Elementen zurueckgegeben.
	 * Dies wird gemacht indem das erste, mittlere und das letzte Element aus
	 * der Liste miteinander verglichen werden.
	 */
	@Override
	public E getPivot(List<E> liste) {
		E anfang = liste.get(0);
		E mitte = liste.get((liste.size() - 1) / 2);
		E ende = liste.get(liste.size() - 1);
		E median = null;
		if (mitte.compareTo(anfang) < 0) {
			if (anfang.compareTo(ende) < 0) {
				median = anfang;
			} else {
				if (ende.compareTo(mitte) < 0)
					median = mitte;
				else {
					median = ende;
				}
			}
		} else {
			if (mitte.compareTo(ende) < 0) {
				median = mitte;
			} else {
				if (ende.compareTo(anfang) < 0) {
					median = anfang;
				} else {
					median = ende;
				}
			}
		}
		return median;
	}


}
