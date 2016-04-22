package aufgabenblatt_1;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exß (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 1: Eine Liste umgesetzt mit einem Array. Die Elemente sind durch einen
 * next- und previous-Index sortiert, welcher in jedem 
 * Array-Element abgespeichert ist.
 * @param <E> Elemente eines Typen 
 */
public class ArrayNextPrevIndex<E extends Comparable<E>> implements List<E>{
	
	/**
	 * Innere Klasse fuer einen Knoten mit einem Element. 
	 * Ein Knoten hat eine Referenz auf das next- und previous Element(Knoten).
	 */
	public class Knoten {

		/**
		 * Element(Inhalt) des Knoten
		 */
		E elem;

		/**
		 * Verweis auf den vorigen Knoten
		 */
		Knoten previous;

		/**
		 * Verweis auf den naechsten Knoten
		 */
		Knoten next;

		public Knoten(E elemPar, Knoten previousPar, Knoten nextPar) {
			elem = elemPar;
			previous = previousPar;
			next = nextPar;
		}
	}
	
	/**
	 * Liste(Array) von Elementen mit next- und previous-Index
	 */
	private Object[] list;

	/**
	 * Die Anzahl der enthaltenen Elemente in der Liste
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
	 * ArrayNextPrevIndex: ANFANGSKAP X LIST -> LIST
	 * Precondition: Die Anfangskapazität muss ein positiver Integer größer 0 sein.
	 * Postcondition: Die Anzahl der Elemente in der Liste ist 0 und die Liste(Array)  
	 * wurde erzeugt mit der übergebenen Anfangskapazität. 
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
			list = new Object[anfangsKapazitaet];
		}
	}

	/**
	 * Erweiterte Postcondition: Die Elemente sind 
	 * durch einen next- und previous-Index aufsteigend sortiert.
	 * @throws IndexOutOfBoundsException pos < 0 || pos >= Länge der Liste
	 */
	@Override
	public void insert(E elem, int pos) throws IndexOutOfBoundsException, 
	IllegalArgumentException {
		gueltigePosition(pos);
		elementUngleichNull(elem);
		if (anzahlDerElemente+1 >= list.length ) {
			arrayVergroessern();
		}
		for (int i = anzahlDerElemente; i >= pos; --i) {
			list[i + 1] = list[i];
		}
		Knoten knotenAdd = new Knoten(elem, null, null);
		list[pos] = knotenAdd;
		knotenEinfuegen(knotenAdd);
		anzahlDerElemente++;
	}
	
	/**
	 * knotenEinfuegen: KNOTEN X LIST -> LIST
	 * Precondition: Hilfsmethode, welche von einfuegen(E, int) aufgerufen wird.
	 * Postcondition: Knoten befindet sich in der aufsteigend sortierten Liste.
	 * Der Knoten zeigt auf den korrekten next und previous-Index.
	 */
	private void knotenEinfuegen(Knoten knotenAdd){
		if (listenKopf.next == null) {
			listenKopf.next = knotenAdd;
			knotenAdd.previous = listenKopf;
			knotenAdd.next = listenEnde;
			listenEnde.previous = knotenAdd;
		} else {
			Knoten durchlauf = listenKopf;
			int vergleich = 0;
			while (durchlauf.next != null) {
				vergleich = durchlauf.next.elem.compareTo(knotenAdd.elem);
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
	 * arrayVergroessern: LIST X INT -> LIST
	 * Precondition: keine
	 * Postcondition: Array Liste ist um alte Kapazitaet * 3/2+1 vergroessert. 
	 */
	private void arrayVergroessern() {
		Object[] listePlus;
		listePlus =  new Object[list.length * 3 / 2 + 1];
		for (int i = 0; i < list.length; i++) {
			listePlus[i] = list[i];
		}
		list = listePlus;
		list[list.length-1] = listenEnde;
	}
	
	/**
	 *  @throws IndexOutOfBoundsException pos < 0 || pos > Kapazitaet-2
	 */
	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		gueltigePosition(pos);
		@SuppressWarnings("unchecked")
		Knoten anPosition = (ArrayNextPrevIndex<E>.Knoten) list[pos];
		if (anPosition.next.equals(listenEnde)) {
			anPosition.previous.next = listenEnde;
		}
		Knoten knotenDanach = anPosition.next;
		anPosition.previous.next = knotenDanach;
		knotenDanach.previous = anPosition.previous;
		list[pos] = list[size() - 1];
		list[size() - 1] = null;
		anzahlDerElemente--;
	}

	@Override
	public int find(E elem) throws IllegalArgumentException {
		elementUngleichNull(elem);
		Knoten knotenLoop= listenKopf.next;
		int i = 0;
		while(knotenLoop.next !=null){
			if(knotenLoop.elem.equals(elem)){
				return i;
			}
			knotenLoop=knotenLoop.next;
			i++;
		}
		return -1;
	}

	/**
	 * @throws IndexOutOfBoundsException pos < 0 || pos > Kapazitaet-2
	 */
	@Override
	public Object retrieve(int pos) throws IndexOutOfBoundsException {
		gueltigePosition(pos);
		@SuppressWarnings("unchecked")
		Knoten anPosition = (ArrayNextPrevIndex<E>.Knoten) list[pos];
		if(anPosition==null){
			return null;
		}
		return anPosition.elem;
	}

	/**
	 * @throws IllegalArgumentException andereListe muss vom Typ ArrayNextPrevIndex<E> sein
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void concat(List<E> otherList) throws IllegalArgumentException {
		if (otherList == null) {
			throw new IllegalArgumentException("Liste<E> andereListe darf nicht null sein");
		}
		if (otherList instanceof ArrayNextPrevIndex<?>) {
			for (int i = 0; i < otherList.size(); i++) {
				insert((E) otherList.retrieve(i), anzahlDerElemente);
			} 
		} else {
			throw new IllegalArgumentException("Die konkrete Klasse die das Interface Liste<E>"
					+ "implementiert muss vom Typ ArrayNextPrevIndex<E> sein");
		}
	}
	
	@Override
	public int size() {
		return anzahlDerElemente;
	}

	/**
	 * elementUngleichNull: ELEM -> ELEM 
	 * Precondition: Das Element muss ungleich NULL sein.
	 * Postcondition:  Es wurde überprüft ob das Element ungleich NULL ist
	 * @param elem welches ueberprueft werden soll
	 * @throws IllegalArgumentException Element hat Referenz auf null
	 */
	private void elementUngleichNull(Object elem) throws IllegalArgumentException {
		if (elem == null) {
			throw new IllegalArgumentException("Element darf nicht null sein");
		}
	}
	
    /**
     * gueltigePosition: LIST X POS -> POS
     * Precondition: Die Position muss ein positiver Integer sein und darf 
     * nicht größer als die Anzahl der Elemente sein.
     * Postcondition: Es wurde überprüft ob die Position einen korrekten Index Zugriff gewährleistet.
     * @param pos Position welche ueberprueft werden soll
     * @throws IndexOutOfBoundsException pos < 0 || pos >= Laenge der Liste
     */
	private void gueltigePosition(int pos) throws IndexOutOfBoundsException {
		if ((pos < 0) || (pos >= list.length)) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + pos);
		}
	}
}
 