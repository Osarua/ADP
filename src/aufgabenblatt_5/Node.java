package aufgabenblatt_5;

/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 5: Bin‰rer Suchbaum
 * Ein Node hat einen intValue und die Summe der Vorgaenger plus dem intValue.
 */
public class Node {

	/**
	 * Positiver Integerwert
	 */
	private int intValue;

	/**
	 * Summe der Vorgaenger plus intValue
	 */
	private int sumPrevious;

	/**
	 * Precondition: Positiver Integerwert des Parameters intValue.  
	 * Postcondition: Node ist initialisiert. Der Integerwert des Node ist gesetzt.
	 * Die Summe der Vorgaenger hat den Integerwert dieses Nodes.  
	 */
	public Node(int intValuePar) throws IllegalArgumentException {
		try {
			if (intValuePar < 0) {
				throw new IllegalArgumentException("intValuePar muss ein positiver Integer sein");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.format("intValuePar:  %d, " + e.getMessage(), intValuePar);
		}
		intValue = intValuePar;
		sumPrevious = intValue;
	}

	/**
	 * Precondition: keine
	 * Postcondition: positiver Integer key
	 */
	public int getIntValue() {
		return intValue;
	}

	/**
	 * Precondition: keine
	 * Postcondition: Die Summe der Vorgaenger plus diesen key.
	 */
	public int getSumP() {
		return sumPrevious;
	}

	/**
	 * Precondition: key ist ein positiver Integerwert
	 * Postcondition: Die Integer Summe der Vorgaenger ist 
	 * addiert um den Wert von key.
	 */
	public void addSumP(int intValuePar) throws IllegalArgumentException {
		try {
			if (intValuePar < 0) {
				throw new IllegalArgumentException("intValuePar muss ein positiver Integer sein");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.format("intValuePar:  %d, " + e.getMessage(), intValuePar);
		}
		sumPrevious = sumPrevious + intValuePar;
	}

}
