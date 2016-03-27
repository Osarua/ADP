package aufgabenblatt_1;
/**
 * TI3 ADP, SS16 
 * @author Julian
 * Aufgabenblatt 1: Eine Liste umgesetzt mit einem Array. Die Elemente sind durch einen
 * next- und previous-Index sortiert, welcher in jedem 
 * Array-Element abgespeichert ist.
 * @param <E> Elemente eines Typen 
 */
public class ArrayNextPrevIndex<E extends Comparable<E>> implements Liste<E>{
	
	/**
	 * Innere Klasse fuer einen Knoten mit einem Element. 
	 * Ein Knoten hat eine Referenz auf das next- und previous Element(Knoten).
	 */
	public class Knoten {

		/**
		 * Element(Inhalt) des Knoten
		 */
		E element;

		/**
		 * Verweis auf den vorigen Knoten
		 */
		Knoten previous;

		/**
		 * Verweis auf den naechsten Knoten
		 */
		Knoten next;

		public Knoten(E elementPar, Knoten previousPar, Knoten nextPar) {
			element = elementPar;
			previous = previousPar;
			next = nextPar;
		}
	}
	
	/**
	 * Liste(Array) von Elementen mit next- und previous-Index
	 */
	private Object[] liste;

	/**
	 * Die Anzahl der enhaltenen Elemente in der Liste
	 */
	private int anzahlDerElemente;
	
	/**
	 * Anfang der Liste
	 */
	private Knoten listenKopf;
	
	/**
	 * Ende der Liste
	 */
	private Knoten listenEnde;
	
	/**
	 * construct: ANFANGSKAP X LIST -> LIST
	 * Precondition: keine
	 * Postcondition: Die Anzahl der Elemente in der Liste ist 0 und die Liste(Array)  
	 * wird erzeugt mit einer Anfangskapizitaet. Wenn die anfangsKapazitaet <=0 wird eine
	 * Exception geworfen.   
	 * @param anfangsKapazitaet des Arrays
	 * @throws IllegalArgumentException anfangsKapazitaet <=0
	 */
	public ArrayNextPrevIndex(int anfangsKapazitaet) throws IllegalArgumentException {
		anzahlDerElemente = 0;
		if (anfangsKapazitaet <= 0) {
			throw new IllegalArgumentException("Ungueltige Anfangskapazitaet: " + anfangsKapazitaet);
		} else {
			listenKopf = new Knoten(null, null, null);
			listenEnde = new Knoten(null, null, null);
			liste = new Object[anfangsKapazitaet+2];
			liste[0] = listenKopf;
			liste[liste.length-1] = listenEnde;
		}
	}

	/**
	 * Erweiterte Postcondition: Die Elemente sind 
	 * durch einen next- und previous-Index aufsteigend sortiert.
	 * @throws IndexOutOfBoundsException Position < 0 || Position > Kapazitaet-2
	 */
	@Override
	public void einfuegen(E element, int position) throws IndexOutOfBoundsException, 
	IllegalArgumentException {
		gueltigePosition(position);
		elementMussUngleichNullSein(element);
		if (anzahlDerElemente >= liste.length - 2) {
			arrayVergroessern();
		}
		for (int i = (anzahlDerElemente - 1); i >= position; --i) {
			liste[i + 1] = liste[i];
		}
		Knoten knotenAdd = new Knoten(element, null, null);
		liste[position + 1] = knotenAdd;
		knotenEinfuegen(knotenAdd);
		anzahlDerElemente++;
	}
	
	/**
	 * addKnoten: KNOTEN X LISTE -> LISTE
	 * Precondition: Hilfsmethode, welche von einfuegen(E, int) aufgerufen wird.
	 * Postcondition: Knoten befindet sich in der aufsteigend sortierten Liste.
	 * Der Knoten zeigt auf den korrekten next und previous-Index.
	 */
	private void knotenEinfuegen(Knoten knotenAdd){
		if (anzahlDerElemente == 0) {
			listenKopf.next = knotenAdd;
			knotenAdd.previous = listenKopf;
			knotenAdd.next = listenEnde;
			listenEnde.previous = knotenAdd;
		} else {
			Knoten durchlauf = listenKopf;
			int vergleich = 0;
			while (durchlauf.next != null) {
				vergleich = durchlauf.next.element.compareTo(knotenAdd.element);
				if (vergleich >= 0) {
					knotenAdd.next = durchlauf.next;
					knotenAdd.next.previous = knotenAdd;
					durchlauf.next = knotenAdd;
					knotenAdd.previous = durchlauf;
					break;
				} else if (durchlauf.next.equals(listenEnde.previous)) {
					durchlauf.next.next = knotenAdd;
					knotenAdd.previous = durchlauf.next;
					knotenAdd.next = listenEnde;
					listenEnde.previous = knotenAdd;
					break;
				}
				durchlauf = durchlauf.next;
			}
		}
	}

	/**
	 * plusCapacity: LIST X INT -> LIST
	 * Precondition: keine
	 * Postcondition: Array Liste ist um alte Kapazitaet * 3/2+1 vergroessert. 
	 */
	private void arrayVergroessern() {
		Object[] listePlus;
		listePlus =  new Object[liste.length * 3 / 2 + 1];
		for (int i = 0; i < liste.length; i++) {
			listePlus[i] = liste[i];
		}
		liste = listePlus;
		liste[liste.length-1] = listenEnde;
	}
	
	/**
	 *  @throws IndexOutOfBoundsException Position < 0 || Position > Kapazitaet-2
	 */
	@Override
	public void entfernen(int position) throws IndexOutOfBoundsException {
		gueltigePosition(position);
		if (anzahlDerElemente > 0) {
			int iNext =0;
			 Knoten anPosition = listenKopf.next;
				while(iNext<position){
					anPosition = anPosition.next;
					iNext++;
				} if(anPosition.next.equals(listenEnde)){
					anPosition.previous.next= listenEnde;
				}
				Knoten knotenDanach = anPosition.next;
				 anPosition.previous.next = knotenDanach;
				 knotenDanach.previous = anPosition.previous;
			for (int i = position; i < (anzahlDerElemente); i++) {
				liste[i] = liste[i + 1];
			}
		}
		liste[anzahlDerElemente] = null;
		anzahlDerElemente--;
	}

	@Override
	public int finde(E element) {
		for (int i = 0; i < anzahlDerElemente; i++) {
			if (element.equals(liste[i+1])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @throws IndexOutOfBoundsException Position < 0 || Position > Kapazitaet-2
	 */
	@Override
	public Object elementAnPosition(int position) throws IndexOutOfBoundsException {
		gueltigePosition(position);
		int i =0;
		Knoten anPosition = listenKopf.next;
		while(i<position){
			anPosition = anPosition.next;
			i++;
		}
		return anPosition.element;
	}

	/**
	 * @throws IllegalArgumentException andereListe muss vom Typ ArrayNextPrevIndex<E> sein
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void listenZusammenfuegen(Liste<E> andereListe) throws IllegalArgumentException {
		if (andereListe == null) {
			throw new IllegalArgumentException("Liste<E> andereListe darf nicht null sein");
		}
		if (andereListe instanceof ArrayNextPrevIndex<?>) {
			for (int i = 0; i < andereListe.groesseDerListe(); i++) {
				einfuegen((E) andereListe.elementAnPosition(i), anzahlDerElemente);
			} 
		} else {
			throw new IllegalArgumentException("Die konkrete Klasse die das Interface Liste<E>"
					+ "implementiert muss vom Typ ArrayNextPrevIndex<E> sein");
		}
	}
	
	@Override
	public int groesseDerListe() {
		return anzahlDerElemente;
	}

	/**
	 * notNull: ELEM -> ELEM 
	 * Precondition: keine
	 * Postcondition: Wirft eine Exception, fall das Element die Referenz null hat.
	 * @param element welches ueberprueft werden soll
	 * @throws IllegalArgumentException Element hat Referenz auf null
	 */
	private void elementMussUngleichNullSein(Object element) throws IllegalArgumentException {
		if (element == null) {
			throw new IllegalArgumentException("Element darf nicht null sein");
		}
	}
	
    /**
     * truePosition: LIST X POS -> POS
     * Precondition: keine
     * Postcondition: Wirft eine Exception, wenn der Index zugriff mit dem 
     * aktuellen Parameter ungueltig ist.
     * Dies tritt ein, wenn die Position(Index) < 0 || Position > Laenge-2 der Liste ist.
     * @param position welche ueberprueft werden soll
     * @throws IndexOutOfBoundsException Position < 0 || Position > Kapazitaet-2
     */
	private void gueltigePosition(int position) throws IndexOutOfBoundsException {
		if ((position < 0) || (position > liste.length-2)) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + position);
		}
	}
}
 