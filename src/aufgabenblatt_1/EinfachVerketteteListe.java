package aufgabenblatt_1;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exß (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 1: Eine Liste umgesetzt mit einer einfach Verketteten Liste.
 * @param <E> Elemente eines Typen 
 */
public class EinfachVerketteteListe<E> implements List<E> {
	
	/**
	 * Innere Klasse für einen einfach verketten Knoten mit einem Element.  
	 */
	public class Knoten {
		
		/**
		 * Element(Inhalt) des Knoten
		 */
		E elem;
		
		/**
		 * Verweis auf den Nachfolger Knoten in der Liste
		 */
		Knoten nachfolger;
		
		public Knoten(E elementPar,Knoten nachfolgerPar){
			elem = elementPar;
			nachfolger = nachfolgerPar;
		}	
	}
	
	/**
	 * Die Anzahl der enthaltenen Elemente in der Liste
	 */
	private int anzahlDerElemente;
	
	/**
	 * Beginn der einfach verketteten Liste
	 */
	private Knoten listenKopf;
	
	/**
	 * Ende der einfach verketteten Liste
	 */
	private Knoten listenEnde;
	
	/**
	 * EinfachVerketteteListe: -> LIST
	 * Precondition: keine
	 * Postcondition: Initialisiert die Liste. Anzahl der Elemente ist 0.
	 *  
	 */
	public EinfachVerketteteListe()  {
		anzahlDerElemente = 0;
		listenKopf= new Knoten(null, null);
		listenEnde= listenKopf;
	}
	
	@Override
	public void insert(E elem, int pos) throws IndexOutOfBoundsException, IllegalArgumentException {
		elementUngleichNull(elem);
		if ((pos < 1) || (pos > size() + 1)) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + pos);
		}
		if(listenKopf.nachfolger == null) {
			einfuegenNach(elem,listenKopf);
		}
		else if(pos==anzahlDerElemente) {
			einfuegenNach(elem,listenEnde);
		} else {
				Knoten knotenAdd = knotenAnPosition(pos-1);
				einfuegenNach(elem,knotenAdd);
			}
		anzahlDerElemente++;
		}
	
	/**
	 * einfuegenNach: -> LISTE X ELEM X KNOTEN -> LISTE
	 * Precondition: Wird von der Methode einfuegen(E,int) aufgerufen.
	 * Postcondition: Liste enthaelt einen Knoten mit Element und Referenz auf
	 * den nachfolger Knoten.
	 * @param elem Element das in die Liste eingefuegt werden soll
	 * @param vorgaenger Knoten, hinter dem das neue Element eingefuegt  werden soll.
	 */
	private void einfuegenNach(E elem, Knoten vorgaenger) {
		Knoten knotenNeu = new Knoten(elem, vorgaenger.nachfolger);
		vorgaenger.nachfolger = knotenNeu;
		if (listenEnde == vorgaenger) {
			listenEnde = knotenNeu;
		}
	}

	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if ((pos < 1) || (pos > size())) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + pos);
		}
			if (pos == 1) {
				listenKopf.nachfolger = listenKopf.nachfolger.nachfolger;
			} else {
				Knoten knotenSub = knotenAnPosition(pos-1);
				knotenSub.nachfolger = knotenSub.nachfolger.nachfolger;
			}
		anzahlDerElemente--;
	}
	
	@Override
	public int find(E elem) throws IllegalArgumentException {
		elementUngleichNull(elem);
		int i = 1;
		Knoten knotenTest = listenKopf;
		while (knotenTest.nachfolger != null) {
			knotenTest = knotenTest.nachfolger;
			if (elem.equals(knotenTest.elem)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	@Override
	public Object retrieve(int pos) throws IndexOutOfBoundsException {
		if ((pos < 1) || (pos > size())) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + pos);
		}
		int i = 1;
		Knoten knotenTest = listenKopf;
		while (knotenTest.nachfolger != null) {
			knotenTest = knotenTest.nachfolger;
			if (i == pos) {
				break;
			}
			i++;
		}
		return knotenTest.elem;
	}

	/**
	 * knotenAnPosition: LIST X POS -> KNOTEN
	 * Precondition: Die Position muss ein positiver Integer sein und darf 
     * nicht größer als die Anzahl der Elemente sein.
	 * Postcondition: Es wird der Knoten an der uebergebenen Position zurueckgegeben.
	 * @param pos Position des Knoten in der Liste
	 * @return Knoten an dieser Position 
	 * @throws IndexOutOfBoundsException pos < 1 || pos > Anzahl der Elemente + 1
	 */
	public Knoten knotenAnPosition(int pos) throws IndexOutOfBoundsException {
		if ((pos < 1) || (pos > size() + 1)) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + pos);
		}
		int i = 1;
		Knoten knotenTest = listenKopf;
		while (knotenTest.nachfolger != null) {
			knotenTest = knotenTest.nachfolger;
			if (i == pos) {
				break;
			}
			i++;
		}
		return knotenTest;
	}
	
	/**
	 * @throws IllegalArgumentException otherList muss vom Typ EinfachVerketteteListe<E> sein
	 */
	@Override
	public void concat(List<E> otherList) throws IllegalArgumentException {
		if (otherList == null) {
			throw new IllegalArgumentException("Liste<E> andereListe darf nicht null sein");
		}
		if (otherList instanceof EinfachVerketteteListe<?>) {
			Knoten knoten = ((EinfachVerketteteListe<E>) otherList).knotenAnPosition(1);
				insert(knoten.elem, anzahlDerElemente);
				anzahlDerElemente+= otherList.size()-1;
			
		} else {
			throw new IllegalArgumentException("Die konkrete Klasse die das Interface Liste<E>"
					+ "implementiert muss vom Typ EinfachVerketteteListe<E> sein");
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


