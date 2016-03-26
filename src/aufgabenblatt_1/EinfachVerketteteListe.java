package aufgabenblatt_1;
/**
 * TI3 ADP, SS16 
 * @author Julian
 * Aufgabenblatt 1: Eine Liste umgesetzt mit einer einfach Verketteten Liste.
 * @param <E> Elemente eines Typen 
 */
public class EinfachVerketteteListe<E> implements Liste<E> {
	
	/**
	 * Innere Klasse für einen einfach verketten Knoten mit einem Element.  
	 */
	public class Knoten {
		
		/**
		 * Element(Inhalt) des Knoten
		 */
		E element;
		
		/**
		 * Verweis auf den Nachfolger Knoten in der Liste
		 */
		Knoten nachfolger;
		
		public Knoten(E elementPar,Knoten nachfolgerPar){
			element = elementPar;
			nachfolger = nachfolgerPar;
		}	
	}
	
	/**
	 * Die Anzahl der enhaltenen Elemente in der Liste
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
	 * construct: -> LIST
	 * Precondition: keine
	 * Postcondition: Initialisiert die Liste. Anzahl der Elemente ist 0. 
	 */
	public EinfachVerketteteListe()  {
		anzahlDerElemente = 0;
		listenKopf= new Knoten(null, null);
		listenEnde= listenKopf ;
	}
	
	@Override
	public void einfuegen(E element, int position) throws IndexOutOfBoundsException, IllegalArgumentException {
		elementMussUngleichNullSein(element);
		unGueltigePosition(position);
		if(position==anzahlDerElemente) {
			einfuegenNach(element,listenEnde);
		} else {
				Knoten knotenAdd = knotenAnPosition(position-1);
				einfuegenNach(element,knotenAdd);
			}
		anzahlDerElemente++;
		}
	
	/**
	 * @param element Element das in die Liste eingefuegt werden soll
	 * @param vorgaenger Knoten, hinter dem das neue Element eingefuegt 
	 * werden soll.
	 */
	private void einfuegenNach(E element, Knoten vorgaenger) {
		Knoten knotenNeu = new Knoten(element, vorgaenger.nachfolger);
		vorgaenger.nachfolger = knotenNeu;
		if (listenEnde == vorgaenger) {
			listenEnde = knotenNeu;
		}
	}

	@Override
	public void entfernen(int position) throws IndexOutOfBoundsException {
		unGueltigePosition(position);
		if(position==0){
			listenKopf.nachfolger = listenKopf.nachfolger.nachfolger;
		} else {
			Knoten knotenSub = knotenAnPosition(position-1);
			knotenSub.nachfolger= knotenSub.nachfolger.nachfolger;
		}
		anzahlDerElemente--;
	}

	
	@Override
	public int finde(E element) {
		int i = 0;
		Knoten knotenTest = listenKopf;
		while (knotenTest.nachfolger != null) {
			knotenTest = knotenTest.nachfolger;
			if (element.equals(knotenTest.element)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	@Override
	public Object elementAnPosition(int position) throws IndexOutOfBoundsException {
		unGueltigePosition(position);
		int i = 0;
		Knoten knotenTest = listenKopf;
		while (knotenTest.nachfolger != null) {
			knotenTest = knotenTest.nachfolger;
			if (i == position) {
				break;
			}
			i++;
		}
		return knotenTest.element;
	}


	public Knoten knotenAnPosition(int position) throws IndexOutOfBoundsException {
		unGueltigePosition(position);
		int i = 0;
		Knoten knotenTest = listenKopf;
		while (knotenTest.nachfolger != null) {
			knotenTest = knotenTest.nachfolger;
			if (i == position) {
				break;
			}
			i++;
		}
		return knotenTest;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void listenZusammenfuegen(Liste<E> andereListe) throws IllegalArgumentException {
		if (andereListe == null) {
			throw new IllegalArgumentException("Liste<E> andereListe darf nicht null sein");
		}
		if (andereListe instanceof EinfachVerketteteListe<?>) {
			for (int i = 0; i < andereListe.groesseDerListe(); i++) {
				einfuegen( (E) andereListe.elementAnPosition(i), anzahlDerElemente);
			}
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
     * truePosition: 
     * Precondition: keine
     * Postcondition: Wirft eine Exception, weil der Index zugriff mit dem 
     * aktuellen Parameter ungueltig war.
     * @param position welche ueberprueft werden soll
     * @throws IndexOutOfBoundsException 
     */
	private void unGueltigePosition(int position) throws IndexOutOfBoundsException {
		if ((position < 0) || (position > anzahlDerElemente)) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + position);
		}
	}
}


