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
		
		/**
		 * Index der Position im Array
		 */
		int arrayPos;

		public Knoten(E elemPar, Knoten previousPar, Knoten nextPar, int arrayPosPar) {
			elem = elemPar;
			previous = previousPar;
			next = nextPar;
			arrayPos = arrayPosPar;
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
			listenKopf = new Knoten(null, null, null, 0);
			listenEnde = new Knoten(null, null, null, 0);
			listenKopf.next=listenEnde;
			listenEnde.previous=listenKopf;
			list = new Object[anfangsKapazitaet];
		}
	}

	/**
	 * Erweiterte Postcondition: Die Elemente sind 
	 * durch einen next- und previous-Index aufsteigend sortiert.
	 */
	@Override
	public void insert(E elem, int pos) throws IndexOutOfBoundsException, 
	IllegalArgumentException {
		elementUngleichNull(elem);
		if (anzahlDerElemente == list.length ) {
			arrayVergroessern();
		}
		if ((pos < 1) || (pos > size() + 1)) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + pos);
		}
		Knoten vorgaenger = null;
		if (anzahlDerElemente == 0 || anzahlDerElemente/2 >= pos) {
			vorgaenger = listenKopf;
			for (int i = 1; i < pos; i++) {
				vorgaenger = vorgaenger.next;
			}
		} else {
			vorgaenger = listenEnde.previous;
			for (int i = anzahlDerElemente; i >= pos; i--) {
				vorgaenger = vorgaenger.previous;
			}
		}
		Knoten nachfolger = vorgaenger.next;
		Knoten knotenAdd = new Knoten(elem, vorgaenger, nachfolger, anzahlDerElemente);
		nachfolger.previous=knotenAdd;
		vorgaenger.next=knotenAdd;
		list[anzahlDerElemente] = knotenAdd;
		anzahlDerElemente++;
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
	
	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if ((pos < 1) || (pos > size())) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + pos);
		}
		Knoten loeschender = listenKopf;
		for (int i=0;i<pos;i++) {
			loeschender = loeschender.next;
		}
		Knoten vorgaenger = loeschender.previous;
		Knoten nachfolger = loeschender.next;
		vorgaenger.next=nachfolger;
		nachfolger.previous=vorgaenger;
		if (loeschender.arrayPos!=anzahlDerElemente-1) {
			@SuppressWarnings("unchecked")
			Knoten letzter =(Knoten) list [anzahlDerElemente-1];
			letzter.arrayPos=loeschender.arrayPos;
			list[loeschender.arrayPos]= list[anzahlDerElemente-1];
		} else {
			list[anzahlDerElemente-1]= null;	
		}
		anzahlDerElemente--;
	}

	@Override
	public int find(E elem) throws IllegalArgumentException {
		elementUngleichNull(elem);
		Knoten knotenLoop= listenKopf.next;
		int i = 1;
		while(knotenLoop.next !=null){
			if(knotenLoop.elem.equals(elem)){
				return i;
			}
			knotenLoop=knotenLoop.next;
			i++;
		}
		return -1;
	}

	@Override
	public Object retrieve(int pos) throws IndexOutOfBoundsException {
		if ((pos < 1) || (pos > size())) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + pos);
		}
		Knoten lieferKnoten = null;
		if (anzahlDerElemente/2 >= pos) {
			lieferKnoten = listenKopf;
			for (int i = 1; i <= pos; i++) {
				lieferKnoten = lieferKnoten.next;
			}
		} else {
			lieferKnoten = listenEnde.previous;
			for (int i = anzahlDerElemente; i > pos; i--) {
				lieferKnoten = lieferKnoten.previous;
			}
		}
		return lieferKnoten.elem;
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
			for (int i = 1; i <= otherList.size(); i++) {
				insert((E) otherList.retrieve(i), anzahlDerElemente+1);
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
}
 