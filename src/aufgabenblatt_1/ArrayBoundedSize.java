package aufgabenblatt_1;

/**
 * TI3 ADP, SS16 
 * @author Julian
 * Aufgabenblatt 1: Eine Liste umgesetzt mit einem Array fester Groesse.
 * Wenn die Kapazitaet des Arrays nicht mehr ausreicht wird dieses vergroessert.
 * @param <E> Elemente eines Typen 
 */
public class ArrayBoundedSize<E> implements Liste<E>{

	/**
	 * Liste(Array Bounded Size) von Elementen
	 */
	private Object[] liste;

	/**
	 * Die Anzahl der enhaltenen Elemente in der Liste
	 */
	private int anzahlDerElemente;

	/**
	 * construct: ANFANGSKAP X LIST -> LIST
	 * Precondition: keine
	 * Postcondition: Die Anzahl der Elemente in der Liste ist 0 und die Liste(Array)  
	 * wird erzeugt mit einer Anfangskapizitaet. Wenn die anfangsKapazitaet <=0 wird eine
	 * Exception geworfen.   
	 * @param anfangsKapazitaet des Arrays
	 * @throws IllegalArgumentException anfangsKapazitaet <=0
	 */
	public ArrayBoundedSize(int anfangsKapazitaet) throws IllegalArgumentException {
		anzahlDerElemente = 0;
		if (anfangsKapazitaet <= 0) {
			throw new IllegalArgumentException("Ungueltige Anfangskapazitaet: " + anfangsKapazitaet);
		} else {
			liste = new Object[anfangsKapazitaet];
		}
	}

	@Override
	public void einfuegen(E element, int position) throws 
	IndexOutOfBoundsException, IllegalArgumentException {
		gueltigePosition(position);
		elementMussUngleichNullSein(element);
		if (anzahlDerElemente+1 >= liste.length) {
			arrayVergroessern();
		}
		for (int i = (anzahlDerElemente - 1); i >= position; --i) {
			liste[i + 1] = liste[i];
		}
		liste[position] = element;
		anzahlDerElemente++;
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
	}
	
	@Override
	public void entfernen(int position) throws IndexOutOfBoundsException,IllegalArgumentException {
		gueltigePosition(position);
		if (anzahlDerElemente > 0) {
			for (int i = position; i < (anzahlDerElemente - 1); i++) {
				liste[i] = liste[i + 1];
			}
			liste[anzahlDerElemente - 1] = null;
			anzahlDerElemente--;
		} else {
			throw new IllegalArgumentException("Anzahl der Elemente muss groesser 0 sein");
		}
	}

	@Override
	public int finde(E element) {
		for (int i = 0; i < anzahlDerElemente; i++) {
			if (element.equals(liste[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Object elementAnPosition(int position) throws IndexOutOfBoundsException {
		gueltigePosition(position);
		return liste[position];
	}

	@SuppressWarnings("unchecked")
	@Override
	public void listenZusammenfuegen(Liste<E> andereListe) throws IllegalArgumentException {
		if (andereListe == null) {
			throw new IllegalArgumentException("Liste<E> andereListe darf nicht null sein");
		}
		if (andereListe instanceof ArrayBoundedSize<?>) {
			for (int i = 0; i < andereListe.groesseDerListe(); i++) {
				einfuegen((E) andereListe.elementAnPosition(i), anzahlDerElemente);
			}
		}
	}
	
	@Override
	public int groesseDerListe() {
		return anzahlDerElemente;
	}

	/**
	 * notNull: LIST X ELEM -> ELEM 
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
     * Dies tritt ein, wenn die Position(Index) < 0 || Position >= Laenge der Liste ist.
     * @param position welche ueberprueft werden soll
     * @throws IndexOutOfBoundsException Position < 0 || Position >= Kapazitaet
     */
	private void gueltigePosition(int position) throws IndexOutOfBoundsException {
		if ((position < 0) || (position >= liste.length)) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + position);
		}
	}
}
 