package aufgabenblatt_1;

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
		listenEnde= new Knoten(null, null) ;
	}
	
	@Override
	public void einfuegen(E element, int position) throws IndexOutOfBoundsException, IllegalArgumentException {
		elementMussUngleichNullSein(element);
		if(position==anzahlDerElemente+1) {
			einfuegenNach(element,listenEnde);
		} else {
			int index = 0;
			Knoten durchlaufen = listenKopf;
			while(durchlaufen.nachfolger!=null){
				
				index++;
				
			}
		}
		
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
		anzahlDerElemente++;
	}

	@Override
	public void entfernen(int position) throws IndexOutOfBoundsException, IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int finde(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object elementAnPosition(int position) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listenZusammenfuegen(Liste<E> andereListe) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
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

}
