package aufgabenblatt_3;

import java.util.List;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 3: Rekursive Sortierverfahren: Quicksort  
 */
public class PivotMedianOfThreeRandom<E extends Comparable<E>> implements Pivot<E> {

	/**
	 * Es wird das mittlere Element von drei Elementen zurueckgegeben.
	 * Dies wird gemacht indem randomisiert drei Elemente mit deren Schluessel aus 
	 * der Liste miteinander verglichen werden.
	 */
	@Override
	public E getPivot(List<E> liste) {
		E randomEins = liste.get((int) (liste.size() * Math.random()));;
		E randomZwei = liste.get((int) (liste.size() * Math.random()));;
		E randomDrei = liste.get((int) (liste.size() * Math.random()));;
		E randomMedian = null;
		if (randomZwei.compareTo(randomEins) < 0) {
			if (randomEins.compareTo(randomDrei) < 0) {
				randomMedian = randomEins;
			} else {
				if (randomDrei.compareTo(randomZwei) < 0)
					randomMedian = randomZwei;
				else {
					randomMedian = randomDrei;
				}
			}
		} else {
			if (randomZwei.compareTo(randomDrei) < 0) {
				randomMedian = randomZwei;
			} else {
				if (randomDrei.compareTo(randomEins) < 0) {
					randomMedian = randomEins;
				} else {
					randomMedian = randomDrei;
				}
			}
		}
		return randomMedian;
	}


}
