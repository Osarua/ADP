package aufgabenblatt3;

import java.util.List;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 3: Rekursive Sortierverfahren: Quicksort  
 */
public class PivotAmEnde<E extends Comparable<E>> implements Pivot<E> {

	/**
	 * Gibt das Element am Ende der Liste zurueck.
	 * Diese ist dann, dass neue Pivot.
	 */
	@Override
	public E getPivot(List<E> liste) {
		return liste.get(liste.size() -1);
	}

}
