package aufgabenblatt3;

import java.util.List;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 3: Rekursive Sortierverfahren: Quicksort  
 */
public class PivotMedian<E extends Comparable<E>> implements Pivot<E> {
	
	/**
	 * Pivotsuchverfahren
	 */
	Pivot<E> pivot;

	public PivotMedian(){
		pivot = new PivotMedianOfThreeRandom<E>();
	}

	/**
	 * Liefert das Median Element(Schlussel) aus einer Liste.
	 */
	@Override
	public E getPivot(List<E> liste) {
		int mitte = (liste.size()-1)/2 ;
		return medianElement(liste, 0, liste.size()-1, mitte );
	}
	
	/**
	 * Diese Methode wahlt den Median aus mit den Rang k. 
	 * @param liste In dieser Liste wird gesucht
	 * @param links Index des ersten Elements
	 * @param rechts Index des letzten Elements
	 * @param k Element mit den Rang k
	 * @return
	 */
	private E medianElement(List<E> liste, int links, int rechts, int k) {
		if (links < rechts) {
			int lZeiger = links;
			int rZeiger = rechts;
			E pivotElement = pivot.getPivot(liste.subList(links, rechts));
			while (lZeiger <= rZeiger) {
				while (liste.get(lZeiger).compareTo(pivotElement) < 0) {
					lZeiger = lZeiger + 1;
				}
				while (liste.get(rZeiger).compareTo(pivotElement) > 0) {
					rZeiger = rZeiger - 1;
				}
				if (lZeiger <= rZeiger) {
					vertausche(liste, lZeiger, rZeiger);
					lZeiger = lZeiger + 1;
					rZeiger = rZeiger - 1;
				}
			}
			if (k <= rZeiger) {
				return medianElement(liste, links, rZeiger, k);
			} else if (k >= lZeiger) {
				return medianElement(liste, lZeiger, rechts, k);
			} else {
				return liste.get(k);
			}
		} else {
			return liste.get(k);
		}
	}
	
	/**
	 * Vertauscht zwei Elemente innerhalb einer Liste.
	 * Es wir ein swap ausgefuehrt. Auf der Linken Seite steht
	 * anschliessend das Element an der Rechten Position und umgekehrt.
	 * @param liste Liste in welcher vertauscht werden soll
	 * @param links Der Wert der Vor dem Tausch links steht
	 * @param rechts Der Wert der Vor dem Tausch rechts steht
	 */
	private void vertausche(List<E> liste, int links, int rechts) {
		E temp = liste.get(links);
		liste.set(links, liste.get(rechts));
		liste.set(rechts, temp);
	}
}
