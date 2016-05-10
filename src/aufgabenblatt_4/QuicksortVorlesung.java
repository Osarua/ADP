package aufgabenblatt_4;

/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 4: Schnelles Sortieren   
 * Die Klasse hat eine Methode quicksort(E[], int, int), welche den
 * Sortieralgorithmus Quicksort implementiert. 
 */
public class QuicksortVorlesung<E> {
	
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
//
	/**
	 * Anzahl der Zuweisungen
//	 */
	private int zuweisungen;

	/**
	 * Die Methode implementiert den Sortieralgorithmus Quicksort 
	 * aus dem Buch "Algorithmen und Datenstrukturen" von Weicker, Karsten & Nicole.
	 * @param feld Array, welches sortiert werden soll
	 * @param links Begin des zu sortierenden Bereichs
	 * @param rechts Ende des zu sortierenden Bereichs
	 */
	public void quicksort(E[] feld, int links, int rechts) {
		zuweisungen++;
		int i = links;
		zuweisungen++;
		int j = rechts;
		vergleiche++;
		if (links < rechts) {
			zuweisungen++;
			E pivot = feld[rechts];
			vergleiche++;
			while (i <= j) {
				vergleiche++;
				while (feld[i].hashCode() < pivot.hashCode()) {
					zuweisungen++;
					rechenoperationen++;
					i = i + 1;
					vergleiche++;
				}
				vergleiche++;
				while (feld[j].hashCode() > pivot.hashCode()) {
					zuweisungen++;
					rechenoperationen++;
					j = j - 1;
					vergleiche++;
				}
				vergleiche++;
				if (i <= j) {
					vertauschungen++;
					vertausche(feld, i, j);
					zuweisungen++;
					rechenoperationen++;
					i = i + 1;
					zuweisungen++;
					rechenoperationen++;
					j = j - 1;
				}
				vergleiche++;
			}
			quicksort(feld, links, j);
			quicksort(feld, i, rechts);
		}
	}
	
	/**
	 * Vertauscht zwei Elemente innerhalb eines Array.
	 * Es wir ein swap ausgefuehrt. Auf der linken Seite steht
	 * anschliessend das Element an der Rechten Position und umgekehrt.
	 * @param feld Liste in welcher vertauscht werden soll
	 * @param i Der Wert der Vor dem Tausch links steht
	 * @param j Der Wert der Vor dem Tausch rechts steht
	 */
	private void vertausche(E[] feld, int i, int j) {
		zuweisungen++;
		E temp = feld[i];
		zuweisungen++;
		feld[i] = feld[j];
		zuweisungen++;
		feld[j] = temp;
	}

	@Override
	public String toString() {
		return "QuicksortVorlesung [vergleiche=" + vergleiche + ",\n vertauschungen=" + vertauschungen
				+ ",\n rechenoperationen=" + rechenoperationen + ",\n zuweisungen=" + zuweisungen + "]";
	}	
	
	
}
