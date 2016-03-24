package aufgabenblatt_1;

/**
 * TI3 ADP, SS16 
 * @author Julian
 * Aufgabenblatt 1: Ein Interface f�r eine Liste mit Elementen.
 * Es gibt genau sechs Operationen(�ffentliche Methoden) die auf einer Liste 
 * ausgefuehrt werden koennen. Objektmengen der Funktionen: ELEM, LIST, POS.
 * In den Methodenkommentar steht die jeweilige Operation
 * als Funktion. Dahinter Pre- und Postconditions sowie @param und @return.
 * In einer Liste kann ein Element mehrmals vorkommen. Innerhalb einer Liste muessen alle
 * Elemente von dem gleichen Typ sein. 
 * @param <E> Elemente eines Typen 
 */
public interface Liste<E> {

	/**
	 * insert: LIST X POS X ELEM -> LIST
	 * Precondition: Der Elementtyp muss gleich dem konkreten generischen Listen-Typ sein. 
	 * Postcondition: Das Element ist in der Liste enthalten. Wird das Element nicht
	 * am Ende der Liste eingefuegt muessen alle Elemente eine Position weiter nach hinten
	 * ruecken. Wenn position gleich der Laenge der Liste ist, dann wird das Element am Ende 
	 * der Liste eingefuegt. Wird die Methode mit einem Array Implementiert muss sich beim 
	 * uerberschreiten der Kapazitaet, dass Array vergroessern. Die Anzahl der Elemente in der
	 * Liste erhoeht sich um eins. Wenn das Element den Wert Null hat oder falls das Element 
	 * der Liste nicht hinzugefuegt werden kann. Dann wird stattdessen eine Exception geworfen. 
	 * Wenn die Position < 0 || Position > Kapazitaet wird auch eine Exeption geworfen. 
	 * @param element Welches in die List eingefuegt werden soll 
	 * @param position An dieser Position soll das Element hinzugefuegt werden
	 * @throws IllegalArgumentException Element hat eine Referenz auf null
	 * @throws IndexOutOfBoundsException Position < 0 || Position > Kapazitaet
	 */
	public void einfuegen(E element, int position) throws IndexOutOfBoundsException,IllegalArgumentException;
 
 	/**
	 * delete: LIST X POS -> LIST
	 * Precondition: keine
	 * Postcondition: Die Liste beinhaltet nicht mehr das Element an dieser Position(Index).
	 * Wird das Element nicht am Ende der Liste Entfernt muessen alle Elemente um eins 
	 * nach vorne verschoben werden. Dekrementierung(minus eins) der Anzahl der Elmente in
	 * der Liste. Wird auf einen ungueltigen Index zugegriffen (Position < 0 || Position > Kapazitaet)
	 * wird das Element nicht entfernt und eine Exception geworfen. 
	 * Dies ist auch der fall, wenn die Anzahl der Elemente <= 0 ist 
	 * @param position an dieser Position soll ein Element entfernt werden
	 * @throws IndexOutOfBoundsException Position < 0 || Position >= Laenge der Liste
	 * @throws IllegalArgumentException Anzahl der Elemente muss groesser 0 sein
	 */
	public void entfernen(int position) throws IndexOutOfBoundsException,IllegalArgumentException;
 
	/**
	 * find: LIST X ELEM -> POS
	 * Precondition:  Der Elementtyp muss gleich dem konkreten generischen Listen-Typ sein. 
	 * Postcondition: Das Element ist in der Liste und die Position(Index) wird
	 * zurueckgegeben oder es wird nicht gefunden. Dann wird -1 zurueckgegeben.
	 * Wenn, dass Element nicht kompatibel zu den Typen der Liste ist wird stattdessen eine
	 * Exception geworfen. Dies passiert auch, wenn das Element Null ist.
	 * @param element nach dem die Liste durchsucht werden soll
	 * @return int Position des gefundenen Element oder -1 fuer nicht gefunden
	 */
	public int finde(E element);

	/**
	 * retrieve: LIST X POS -> ELEM
	 * Precondition: keine
	 * Postcondition: Es wird das Element an der uebergebenen Position zurueckgegeben.
	 * Falls der aktuelle Parameter position (Position < 0 || Position > Kapazitaet) 
	 * ist wird eine Exception geworfen. Die Methode wird auch ausgefuehr, wenn das Element 
	 * den Wert null hat an dieser Position.
	 * @param position des Element in der Liste
	 * @return Object Element an dieser Position 
	 * @throws IndexOutOfBoundsException Position < 0 || Position >= Laenge der Liste
	 */
	public Object elementAnPosition(int position) throws IndexOutOfBoundsException;

	/**
	 * concat: LIST X LIST -> LIST
	 * Precondition: Die hinzuzufuegende Liste muss zum Typen der Liste kompatibel sein.
	 * Postcondition: andereListe muss das Interface Liste<E> implementieren und mit den konkreten 
	 * Klassentyp(auch gnerischer Typ) dieser Liste kompatibel sein. Ansonsten wird eine Exception geworfen.
	 * Wenn die beiden Listen Typen kompatibel sind, fuegt die Methode diese zusammen. Dabei erhoeht sich die
	 * Anzahl der Elemente um die anzahl der neuen Elmenten. Die anzufuegende Liste wird am Ende dieser Liste
	 * "angehaengt". Wird die Lise mit einem Array Implementiert, vergoessert sich ggf. dieses.
	 * @param liste Die mit dieser zusammengefuegt werden soll
	 * @throws  IllegalArgumentException Liste<E> andereListe darf nicht null sein
	 */
	public void listenZusammenfuegen(Liste<E> andereListe) throws IllegalArgumentException;

	/**
	 * size: LIST -> INT
	 * Precondition: keine 
	 * Postcondition: Methode gibt die Anzahl der Elemente in der Liste zurueck. 
	 * @return int, die Anzahl der Elemente in der Liste
	 */
	public int groesseDerListe();

	
}
