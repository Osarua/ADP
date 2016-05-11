package aufgabenblatt_1;

/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Ex� (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 1: Ein Interface f�r eine Liste mit Elementen.
 * In einer Liste kann eine Menge von Elementen stehen. Die Elemente m�ssen 
 * von einem Object Typ sein. F�r alle Elemente in einer Liste 
 * gilt, dass sie von dem gleichen Typ sind. Innerhalb einer Liste kann
 * ein Element mehrmals vorkommen. Es gibt sechs Operationen die auf einer Liste ausgef�hrt
 * werden k�nnen. Die Objektmengen der Funktionen sind: ELEM, LIST, POS. 
 * In dem Methodenkommentar steht die jeweilige Operation als Funktion sowie 
 * die Pre- und Postconditions. 
 * @param <E> Elemente eines Typen 
 */
public interface List<E> {

	/**
	 * insert: LIST X POS X ELEM -> LIST
	 * Precondition: Der Element Typ muss gleich dem konkreten generischen Listen-Typ sein.
	 * Die Position muss ein positiver Integer ungleich 0 sein und darf nicht gr��er 
	 * als die Anzahl der Elemente  plus 1 sein. Das Element muss ungleich NULL sein.
	 * Postcondition: Das Element ist in der Liste enthalten. Wird das Element nicht
	 * am Ende der Liste eingef�gt m�ssen alle Elemente eine Position weiter nach hinten
	 * r�cken. Die Anzahl der Elemente in der Liste erh�ht sich um eins. 
	 * @param elem Element, welches in die List eingef�gt werden soll 
	 * @param pos An dieser Position soll das Element hinzugef�gt werden
	 * @throws IllegalArgumentException Element hat eine Referenz auf null
	 * @throws IndexOutOfBoundsException pos < 1 || pos > Anzahl der Elemente + 1
	 */
	public void insert(E elem, int pos) throws IndexOutOfBoundsException,IllegalArgumentException;
 
 	/**
	 * delete: LIST X POS -> LIST
	 * Precondition: Die Position muss ein positiver Integer Wert ungleich 0 sein und kleiner 
	 * gleich der Anzahl der Elemente sein. 
	 * Postcondition: Die Liste beinhaltet nicht mehr das Element an dieser Position (Index).
	 * Wird das Element nicht am Ende der Liste entfernt, wird die entstandene L�cke
	 * mit dem n�chsten Element in der Liste gef�llt. 
	 * Die n�chsten Elemente r�cken eine Position nach vorne 
	 * Die Anzahl der Elemente in der Liste wird um eins reduziert. 
	 * @param pos an dieser Position soll ein Element entfernt werden
	 * @throws IndexOutOfBoundsException pos < 1 || pos > Anzahl der Elemente
	 */
	public void delete(int pos) throws IndexOutOfBoundsException;
 
	/**
	 * find: LIST X ELEM -> POS
	 * Precondition:  Der Element Typ muss gleich dem konkreten generischen Listen-Typ sein. 
	 * Das Element darf nicht NULL sein.
	 * Postcondition: Das Element ist in der Liste und die Position (Index) wird
	 * zur�ckgegeben oder es wird nicht gefunden. Dann wird -1 zur�ckgegeben.
 	 * @param elem Element nach dem die Liste durchsucht werden soll
 	 * @return int Position des gefundenen Elements oder -1 f�r nicht gefunden
 	 * @throws IllegalArgumentException Element hat Referenz auf null
	 */
	public int find(E elem) throws IllegalArgumentException;

	/**
	 * retrieve: LIST X POS -> ELEM
	 * Precondition: Die Position muss ein positiver Integer Wert ungleich 0 sein und kleiner 
	 * gleich der Anzahl der Elemente in dieser Liste sein.
	 * Postcondition: Es wird das Element an der �bergebenen Position zur�ckgegeben.
	 * @param pos Position des Elements in der Liste
	 * @return Object Element an dieser Position 
	 * @throws IndexOutOfBoundsException pos < 1 || pos > Anzahl der Elemente 
	 */
	public Object retrieve(int pos) throws IndexOutOfBoundsException;

	/**
	 * concat: LIST X LIST -> LIST
	 * Precondition: Andere Liste muss vom konkreten Typ der Liste sein.
	 * Postcondition: Die andere Liste wird am Ende der Liste angef�gt. 
	 * Dabei erh�ht sich die Anzahl der Elemente um die Anzahl 
	 * der Elemente der anderen Liste. 
	 * @param otherList Die Liste, welche mit dieser zusammengef�gt werden soll.
	 * @throws IllegalArgumentException Liste<E> otherList darf nicht null sein
	 * @throws IllegalArgumentException otherList muss mit den konkreten 
	 * Typen dieser Liste kompatibel sein
	 */
	public void concat(List<E> otherList) throws IllegalArgumentException;

	/**
	 * size: LIST -> INT
	 * Precondition: keine 
	 * Postcondition: Methode gibt die Anzahl der Elemente in der Liste zurueck. 
	 * @return int die Anzahl der Elemente in der Liste
	 */
	public int size();
}
