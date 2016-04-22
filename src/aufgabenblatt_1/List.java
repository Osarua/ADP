package aufgabenblatt_1;

/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exß (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 1: Ein Interface für eine Liste mit Elementen.
 * In einer Liste steht eine Menge von Elementen. Die Elemente müssen 
 * von einem Object Typ sein. Für alle Elemente in einer Liste 
 * gilt, dass sie von dem gleichen Typ sind. Innerhalb einer Liste kann
 * ein Element mehrmals vorkommen. Es gibt sechs Operationen die auf einer Liste ausgeführt
 * werden können. Die Objektmengen der Funktionen sind: ELEM, LIST, POS. 
 * In dem Methodenkommentar steht die jeweilige Operation als Funktion sowie 
 * die Pre- und Postconditions. 
 * @param <E> Elemente eines Typen 
 */
public interface List<E> {

	/**
	 * insert: LIST X POS X ELEM -> LIST
	 * Precondition: Der Element Typ muss gleich dem konkreten generischen Listen-Typ sein.
	 * Die Position muss ein positiver Integer sein und darf nicht größer 
	 * als die Anzahl der Elemente sein. Das Element muss ungleich NULL sein.
	 * Postcondition: Das Element ist in der Liste enthalten. Wird das Element nicht
	 * am Ende der Liste eingefügt müssen alle Elemente eine Position weiter nach hinten
	 * rücken. Wenn Position gleich der Länge der Liste ist, dann wird das Element am Ende 
	 * der Liste eingefügt. Die Anzahl der Elemente in der Liste erhöht sich um eins. 
	 * @param elem Element, welches in die List eingefügt werden soll 
	 * @param pos An dieser Position soll das Element hinzugefügt werden
	 * @throws IllegalArgumentException Element hat eine Referenz auf null
	 * @throws IndexOutOfBoundsException Wenn pos außerhalb der Liste liegt.
	 */
	public void insert(E elem, int pos) throws IndexOutOfBoundsException,IllegalArgumentException;
 
 	/**
	 * delete: LIST X POS -> LIST
	 * Precondition: Die Position muss ein positiver Integer Wert sein und kleiner 
	 * als die Anzahl der Elemente sein. 
	 * Postcondition: Die Liste beinhaltet nicht mehr das Element an dieser Position (Index).
	 * Wird das Element nicht am Ende der Liste entfernt, wird die entstandene Lücke
	 * mit einem anderen Element der Liste gefüllt. 
	 * Die Anzahl der Elemente in der Liste wird um eins reduziert. 
	 * @param pos an dieser Position soll ein Element entfernt werden
	 * @throws IndexOutOfBoundsException Wenn pos außerhalb der Liste liegt.
	 */
	public void delete(int pos) throws IndexOutOfBoundsException;
 
	/**
	 * find: LIST X ELEM -> POS
	 * Precondition:  Der Element Typ muss gleich dem konkreten generischen Listen-Typ sein. 
	 * Das Element darf nicht NULL sein.
	 * Postcondition: Das Element ist in der Liste und die Position (Index) wird
	 * zurückgegeben oder es wird nicht gefunden. Dann wird -1 zurückgegeben.
 	 * @param elem Element nach dem die Liste durchsucht werden soll
 	 * @return int Position des gefundenen Elements oder -1 für nicht gefunden
 	 * @throws IllegalArgumentException Element hat Referenz auf null
	 */
	public int find(E elem) throws IllegalArgumentException;

	/**
	 * retrieve: LIST X POS -> ELEM
	 * Precondition: Die Position muss ein positiver Integer Wert sein und kleiner 
	 * als die Anzahl der Elemente der Liste sein.
	 * Postcondition: Es wird das Element an der übergebenen Position zurückgegeben.
	 * Die Methode wird auch ausgeführt, wenn das Element den Wert null hat an dieser Position.
	 * @param pos Position des Elements in der Liste
	 * @return Object Element an dieser Position 
	 * @throws IndexOutOfBoundsException Wenn Position(Index) außerhalb der Liste liegt.
	 */
	public Object retrieve(int pos) throws IndexOutOfBoundsException;

	/**
	 * concat: LIST X LIST -> LIST
	 * Precondition: Andere Liste muss vom konkreten Typ der Liste sein.
	 * Postcondition: Wenn die beiden Listen Typen kompatibel sind, fügt 
	 * die Methode diese zusammen. Dabei erhöht sich die Anzahl der Elemente um die Anzahl 
	 * der neuen Elemente. 
	 * @param otherList Die Liste, welche mit dieser zusammengefügt werden soll.
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
