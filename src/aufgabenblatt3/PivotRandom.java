package aufgabenblatt3;

import java.util.List;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 3: Rekursive Sortierverfahren: Quicksort  
 */
public class PivotRandom<E extends Comparable<E>> implements Pivot<E> {

	/**
	 * Liefert das randomisiert berechnete Pivot Element der Liste.
	 */
	@Override
	public E getPivot(List<E> liste) {
		return liste.get((int) (liste.size() * Math.random()));
	}
}
