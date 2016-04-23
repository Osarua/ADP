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
	
	/**
	 * Anzahl der Zuweisungen
	 */
	private int zuweisungen;
	
	/**
	 * Anzahl der Bewegungen
	 */
	private int bewegungen;
	
	/**
	 * Anzahl rekusiver Aufrufe
	 */
	private int rekursiveAufrufe;
	
	
	/**
	 * Die Methode implementiert den Sortieralgorithmus Quicksort 
	 * aus dem Buch "Algorithmen und Datenstrukturen" von Weicker, Karsten & Nicole.
	 * @param feld Array, welches sortiert werden soll
	 * @param links Begin des zu sortierenden Bereichs
	 * @param rechts Ende des zu sortierenden Bereichs
	 */
	public void quicksort(E[] feld, int links, int rechts) {
		int i = links;
							zuweisungen++;
		int j = rechts;
							zuweisungen++;
		vergleiche++;
		if (links < rechts) {
			E pivot = feld[rechts];
							zuweisungen++;
							vergleiche++;
			while (i <= j) {
							vergleiche++; 
				while (feld[i].hashCode() < pivot.hashCode()) {
					i = i + 1;
							bewegungen++;
							rechenoperationen++;
							zuweisungen++;
							vergleiche++; 
				}
							vergleiche++;
				while (feld[j].hashCode() > pivot.hashCode()) {
					j = j - 1;
							bewegungen++;
							rechenoperationen++;
							zuweisungen++;
							vergleiche++; 
				}
							vergleiche++;
				if (i <= j) {
					vertausche(feld, i, j);
							vertauschungen++;
					i = i + 1;
							bewegungen++;
							zuweisungen++;
							rechenoperationen++;
					j = j - 1;
							bewegungen++;
							zuweisungen++;
							rechenoperationen++;
				}
							vergleiche++; 
			}
							rekursiveAufrufe++;
			quicksort(feld, links, j);
							rekursiveAufrufe++;
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
		E temp = feld[i];
							zuweisungen++;
		feld[i] = feld[j];
							zuweisungen++;
		feld[j] = temp;
							zuweisungen++;
	}

	@Override
	public String toString() {
		return "Quicksort: vergleiche=" + vergleiche + ", vertauschungen=" + vertauschungen
				+ ", rechenoperationen=" + rechenoperationen + ", zuweisungen=" + zuweisungen + ", bewegungen="
				+ bewegungen + ", rekursiveAufrufe=" + rekursiveAufrufe ;
	}
	
	
}
