package aufgabenblatt_3;

import java.util.List;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 3: Rekursive Sortierverfahren: Quicksort
 * Interface Pivot beinhaltet eine Schnittstelle, welche ein Pivot einer
 * Liste ermitteln soll.  
 */
public interface Pivot<E extends Comparable<E>>{

	/**
	 * Diese Methode liefert das Pivot Element von der uebergebenen Liste.
	 * @param liste des zu ermittelnden Pivot
	 * @return Pivot Element
	 */
	public E getPivot(List<E> liste);
}
