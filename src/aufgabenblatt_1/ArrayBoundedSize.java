package aufgabenblatt_1;

/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Ex� (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 1: Eine Liste umgesetzt mit einem Array fester Groesse.
 * Wenn die Kapazitaet des Arrays nicht mehr ausreicht wird dieses vergroessert.
 * @param <E> Elemente eines Typen 
 */
public class ArrayBoundedSize<E> implements List<E>{

	/**
	 * Liste(Array Bounded Size) von Elementen
	 */
	private Object[] list;

	/**
	 * Die Anzahl der enthaltenen Elemente in der Liste
	 */
	private int anzahlDerElemente;

	/**
	 * ArrayBoundedSize: ANFANGSKAPAZITAET X LIST -> LIST
	 * Precondition: Die Anfangskapazit�t muss ein positiver Integer gr��er 0 sein.
	 * Postcondition: Die Anzahl der Elemente in der Liste ist 0 und die Liste(Array)  
	 * wurde erzeugt mit der �bergebenen Anfangskapazit�t. 
	 * @param anfangsKapazitaet des Arrays
	 * @throws IllegalArgumentException anfangsKapazitaet <=0
	 */
	public ArrayBoundedSize(int anfangsKapazitaet) throws IllegalArgumentException {
		anzahlDerElemente = 0;
		if (anfangsKapazitaet <= 0) {
			throw new IllegalArgumentException("Ungueltige Anfangskapazitaet: " + anfangsKapazitaet);
		} else {
			list = new Object[anfangsKapazitaet];
		}
	}

	/**
	 * Erweiterte Postcondition: Falls die groesse des Arrays nicht ausreicht 
	 * wird ein groesseres Array allokiert.
	 */
	@Override
	public void insert(E elem, int pos) throws 
	IndexOutOfBoundsException, IllegalArgumentException {
		if ((pos < 1) || (pos > size() + 1)) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + pos);
		}
		elementUngleichNull(elem);
		if (anzahlDerElemente+1 >= list.length) {
			arrayVergroessern();
		}
		for (int i = (anzahlDerElemente - 1); i >= pos-1; --i) {
			list[i + 1] = list[i];
		}
		list[pos-1] = elem;
		anzahlDerElemente++;
	}

	/**
	 * arrayVergroessern: LIST X INT -> LIST
	 * Precondition: keine
	 * Postcondition: Array ist um alte Kapazitaet * 3/2+1 vergroessert. 
	 */
	private void arrayVergroessern() {
		Object[] listePlus;
		listePlus =  new Object[list.length * 3 / 2 + 1];
		for (int i = 0; i < list.length; i++) {
			listePlus[i] = list[i];
		}
		list = listePlus;
	}
	
	/**
	 * @throws IndexOutOfBoundsException pos < 1 || pos > Anzahl der Elemente 
	 */
	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if ((pos < 1) || (pos > size())) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + pos);
		}
		for (int i = pos -1; i < size(); i++) {
			
		}
		//list[pos] = list[size()-1];
		list[size() - 1] = null;
		anzahlDerElemente--;
	}

	@Override
	public int find(E elem) throws IllegalArgumentException {
		elementUngleichNull(elem);
		for (int i = 0; i < anzahlDerElemente; i++) {
			if (elem.equals(list[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Object retrieve(int pos) throws IndexOutOfBoundsException {
		if ((pos < 1) || (pos > size())) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + pos);
		}
		return list[pos-1];
	}

	/**
	 * Erweiterte Postcondition: Falls die Gr��e des Arrays der urspr�nglichen Liste 
	 * nicht ausreichte wurde ein gr��eres Array allokiert.
	 * @throws IllegalArgumentException andereListe muss vom Typ ArrayBoundedSize<E> sein
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void concat(List<E> otherList) throws IllegalArgumentException {
		if (otherList == null) {
			throw new IllegalArgumentException("Liste<E> andereListe darf nicht null sein");
		}
		if (otherList instanceof ArrayBoundedSize<?>) {
			for (int i = 1; i <= otherList.size(); i++) {
				insert((E) otherList.retrieve(i), anzahlDerElemente+1);
			}
		} else {
			throw new IllegalArgumentException("Die konkrete Klasse die das Interface Liste<E>"
					+ "implementiert muss vom Typ ArrayBoundedSize<E> sein");
		}
	}
	
	@Override
	public int size() {
		return anzahlDerElemente;
	}

	/**
	 * elementUngleichNull: ELEM -> ELEM 
	 * Precondition: Das Element muss ungleich NULL sein.
	 * Postcondition:  Es wurde �berpr�ft ob das Element ungleich NULL ist
	 * @param elem welches ueberprueft werden soll
	 * @throws IllegalArgumentException Element hat Referenz auf null
	 */
	private void elementUngleichNull(Object elem) throws IllegalArgumentException {
		if (elem == null) {
			throw new IllegalArgumentException("Element darf nicht null sein");
		}
	}
}
 