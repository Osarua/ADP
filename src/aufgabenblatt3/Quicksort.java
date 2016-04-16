package aufgabenblatt3;

import java.util.List;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 3: Rekursive Sortierverfahren: Quicksort  
 * Die Klasse hat eine Methode quicksort(Liste<E>, int, int), welche den
 * Sortieralgorithmus Quicksort implementiert. Die Vorgabe zur Wahl des Pivot 
 * Elements kann den Konstruktur uebergeben werden.
 * 
 */
public class Quicksort<E extends Comparable<E>> {
	
	/**
	 * Pivot Vorgabe
	 */
	private Pivot<E> pivot;
	
	/**
	 * Default Konstruktor mit setzten des Pivot am Ende
	 * der Liste. 
	 */
	public Quicksort() {
		this(new PivotAmEnde<E>()); 
	}

	/**
	 * Konstruktur mit Angabe zur Wahl des Pivot.
	 * @param pivotPar Vorgabe zur Wahl des Pivot Elements
	 */
	public Quicksort(Pivot<E> pivotPar) {
		pivot=pivotPar;
	}
	
	/**
	 * Die Methode sortiert eine uebergebene Liste aufsteigend.
	 * Als Vorgabe dient der Sortieralgorithmus Quicksort.
	 * @param liste Die zu sortierende Liste
	 * @param links Begin (Index) der Liste
	 * @param rechts letzter Index der Liste
	 */
	public void quicksort(List<E> liste, int links, int rechts) {
		if (links < rechts) {
			int lZeiger = links;
			int rZeiger = rechts;
			E pivotElement = (E) pivot.getPivot(liste.subList(links, rechts));
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
			quicksort(liste, links, rZeiger);
			quicksort(liste, lZeiger, rechts);
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
