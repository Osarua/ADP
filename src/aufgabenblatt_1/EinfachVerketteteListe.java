package aufgabenblatt_1;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 1: Eine Liste umgesetzt mit einer einfach Verketteten Liste.
 * @param <E> Elemente eines Typen 
 */
public class EinfachVerketteteListe<E> implements Liste<E> {
	
	/**
	 * Innere Klasse f¸r einen einfach verketten Knoten mit einem Element.  
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
	 *  
	 */
	public EinfachVerketteteListe()  {
		anzahlDerElemente = 0;
		listenKopf= new Knoten(null, null);
		listenEnde= listenKopf ;
	}
	
	/**
	 * @throws IndexOutOfBoundsException Position < 0 || Position > Laenge der Liste
	 */
	@Override
	public void einfuegen(E element, int position) throws IndexOutOfBoundsException, IllegalArgumentException {
		elementUngleichNull(element);
		gueltigePosition(position);
		if(position==anzahlDerElemente) {
			einfuegenNach(element,listenEnde);
		} else {
				Knoten knotenAdd = knotenAnPosition(position-1);
				einfuegenNach(element,knotenAdd);
			}
		anzahlDerElemente++;
		}
	
	/**
	 * addNach: -> LISTE X ELEM X KNOTEN -> LISTE
	 * Precondition: Wird von der Methode einfuegen(E,int) aufgerufen.
	 * Postcondition: Liste enthaelt einen Knoten mit Element und Referenz auf
	 * den nachfolger Knoten.
	 * @param element Element das in die Liste eingefuegt werden soll
	 * @param vorgaenger Knoten, hinter dem das neue Element eingefuegt  werden soll.
	 */
	private void einfuegenNach(E element, Knoten vorgaenger) {
		Knoten knotenNeu = new Knoten(element, vorgaenger.nachfolger);
		vorgaenger.nachfolger = knotenNeu;
		if (listenEnde == vorgaenger) {
			listenEnde = knotenNeu;
		}
	}

	/**
	 * 	@throws IndexOutOfBoundsException Position < 0 || Position > Laenge der Liste
	 */
	@Override
	public void entfernen(int position) throws IndexOutOfBoundsException,IllegalArgumentException {
		gueltigePosition(position);
		if (anzahlDerElemente > 0) {
			if (position == 0) {
				listenKopf.nachfolger = listenKopf.nachfolger.nachfolger;
			} else {
				Knoten knotenSub = knotenAnPosition(position - 1);
				knotenSub.nachfolger = knotenSub.nachfolger.nachfolger;
			}
		} else {
			throw new IllegalArgumentException("Anzahl der Elemente muss groesser 0 sein");
		}
		anzahlDerElemente--;
	}
	
	@Override
	public int finde(E element) throws IllegalArgumentException {
		elementUngleichNull(element);
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

	/**
	 * 	@throws IndexOutOfBoundsException Position < 0 || Position > Laenge der Liste
	 */
	@Override
	public Object elementAnPosition(int position) throws IndexOutOfBoundsException {
		gueltigePosition(position);
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

	/**
	 * retrieve: LIST X POS -> KNOTEN
	 * Precondition: keine
	 * Postcondition: Es wird der Knoten an der uebergebenen Position zurueckgegeben.
	 * Falls der aktuelle Parameter position ausserhalb des gueltigen Indexbereich der Liste liegt
	 * wird eine Exception geworfen. 
	 * @param position des Knoten in der Liste
	 * @return Knoten an dieser Position 
	 * @throws IndexOutOfBoundsException Position < 0 || Position > Laenge der Liste
	 */
	public Knoten knotenAnPosition(int position) throws IndexOutOfBoundsException {
		gueltigePosition(position);
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
	
	/**
	 * @throws IllegalArgumentException andereListe muss vom Typ EinfachVerketteteListe<E> sein
	 */
	@Override
	public void listenZusammenfuegen(Liste<E> andereListe) throws IllegalArgumentException {
		if (andereListe == null) {
			throw new IllegalArgumentException("Liste<E> andereListe darf nicht null sein");
		}
		if (andereListe instanceof EinfachVerketteteListe<?>) {
			Knoten knoten = ((EinfachVerketteteListe<E>) andereListe).knotenAnPosition(0);
			for (int i = 0; i < andereListe.groesseDerListe(); i++) {
				einfuegen(knoten.element, anzahlDerElemente);
				knoten = knoten.nachfolger;
			}
		} else {
			throw new IllegalArgumentException("Die konkrete Klasse die das Interface Liste<E>"
					+ "implementiert muss vom Typ EinfachVerketteteListe<E> sein");
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
	private void elementUngleichNull(Object element) throws IllegalArgumentException {
		if (element == null) {
			throw new IllegalArgumentException("Element darf nicht null sein");
		}
	}
	
    /**
     * truePosition: LIST X POS -> POS
     * Precondition: keine
     * Postcondition: Wirft eine Exception, weil der Index zugriff mit dem 
     * aktuellen Parameter ungueltig war.
     * @param position welche ueberprueft werden soll
	 * @throws IndexOutOfBoundsException Position < 0 || Position > Laenge der Liste
     */
	private void gueltigePosition(int position) throws IndexOutOfBoundsException {
		if ((position < 0) || (position > anzahlDerElemente)) {
			throw new IndexOutOfBoundsException("Ungueltiger Index Zugriff: " + position);
		}
	}
}


