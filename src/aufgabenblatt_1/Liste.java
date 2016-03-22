package aufgabenblatt_1;

/**
 * TI3 ADP, SS16 
 * @author Julian
 * Aufgabenblatt 1: Ein Interface für eine Liste mit Elementen.
 * Es gibt genau sechs Operationen(öffentliche Methoden) die auf einer Liste 
 * ausgeführt werden können. In den Methodenkommentar steht die jeweilige Operation
 * als Funktion. Dahinter Pre- und Postconditions sowie @param und @return.
 * @param <E> Elemente die verarbeitet werden
 */
public interface Liste<E> {

	/**
	 * insert: LIST X POS X ELEM -> LIST
	 * Precondition: Gültiger Index >=0
	 * Postcondition: Element ist in der Liste enthalten oder es wird eine Exception 
	 * geworfen, wenn das Element den Wert Null hat. Es wird auch 
	 * eine Exception geworfen, falls das Element der Liste nicht hinzugefuegt werden kann. 
	 * @param element Welches in die List eingefuegt werden soll 
	 * @param position An dieser Position >= 0 soll das Element hinzugefuegt werden
	 */
 public void insert(E element, int position);
 
 public E delete(int position);
 
	/**
	 * Precondition:
	 * Postcondition:
	 * @param element
	 * @return 
	 */
 public int find(E element);
 
 public E retrieve(int poition);
 
 public E concat(E liste);
 
 public int size();
}
