package aufgabenblatt_5;



/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exß (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 5: Binaerer Suchbaum
 * Die Klasse stellt einen binary search tree in einem Array da. 
 * Es ist möglich sich die Summe der Nodes (positive Integerwerte) zwischen zwei 
 * Zahlen n und M ausgeben zulassen.
 */
public class BinarySearchTree {

	/**
	 * binary search tree als Feld
	 */
	private Node[] tree;

	/**
	 * Die Tiefe von tree
	 */
	private int depth;

	/**
	 * Precondition: Die Tiefe des Baumes muss ein positiver Integerwert sein. 
	 * Der Wurzelknoten sollte die Tiefe 1 haben der Nachfolger Knoten hat die Tiefe 2 usw.. 
	 * Postcondition: Das Array tree wurde initialisiert mit der L�nge von zwei hoch der Tiefe.
	 * @param depthPar Tiefe des Baumes
	 * @throws IllegalArgumentException depth muss ein positiver Integer sein
	 */
	public BinarySearchTree(int depthPar) throws IllegalArgumentException {
		try {
			if (depthPar < 0) {
				throw new IllegalArgumentException("depth muss ein positiver Integer sein");
			}
			depth = depthPar;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.format("depth:  %d, " + e.getMessage(), depthPar);
		}
		int sizeOfTree = (int) Math.pow(2, depth);
		tree = new Node[sizeOfTree];
	}

	/**
	 * Precondition: Es muss ein positiver Integerwert uebergeben werden.
	 * Postcondition: Ein neuer Knoten mit den uebergebenen Integetwert steht an
	 * der korrekten Position im binären Suchbaum. Der neue Knoten hat die Summe seiner 
	 * Vorgaenger plus dem uebergebenen Integertwert. Die Vorgaenger sind alle Knoten die einen
	 * Integerwert kleiner gleich des neuen Knoten besitzen.
	 * @param intValue positiver Integerwert des neuen Knoten
	 * @throws IllegalArgumentException intValue muss ein positiver Integer sein
	 */
	public void insert(int intValue) throws IllegalArgumentException{
		try {
			if (intValue < 0) {
				throw new IllegalArgumentException("intValue muss ein positiver Integer sein");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.format("intValue:  %d, " + e.getMessage(), intValue);
		}
		Node newN = new Node(intValue);
		for (int pos = 0; pos < tree.length; pos++) {
			if (tree[pos] != null) {
				if (newN.getIntValue() <= tree[pos].getIntValue()) {
					tree[pos].addSumP(newN.getIntValue());
				}
				if (newN.getIntValue() >= tree[pos].getIntValue()) {
					newN.addSumP(tree[pos].getIntValue());
				}
			}
		}
		insertR(newN, 0, 1);
	}

	/**
	 * Precondition: Die Methode wurde von der Methode insert(int) aufgerufen.
	 * Postcondition: Der neue Knoten steht an der korrekten Position im binären Suchbaum.
	 * Wenn die groesse des Arrays, welches den binären Suchbaum darstellt nicht ausreicht 
	 * wird dieses vergroessert. 
	 * @param newN Der hinzuzufuegende Knoten
	 * @param pos Die aktuelle Position im Suchbaum 
	 * @param depthPar Die aktuelle Tiefe des Baumes 
	 */
	private void insertR(Node newN, int pos, int depthPar) {
		if (depthPar > depth) {
			System.out.printf("Baum ist voll \n");
			treeArrayBigger();
		}
		if (tree[pos] == null) {
			tree[pos] = newN;
		} else if (newN.getIntValue() <= tree[pos].getIntValue()) {
			insertR(newN, pos * 2 + 1, depthPar + 1);
		} else {
			insertR(newN, pos * 2 + 2, depthPar + 1);
		}
	}
	
	/**
	 * Precondition: keine
	 * Postcondition: Die Kapazitaet des Arrays hat sich verdoppelt.
	 */
	private void treeArrayBigger() {
		Node[] treeBigger;
		treeBigger =  new Node[tree.length * 2];
		depth = depth + 1;
		for (int i = 0; i < tree.length; i++) {
			treeBigger[i] = tree[i];
		}
		tree = treeBigger;
	}

	/**
	 * Precondition: Die Zahlen m und M müssen einen positiven Integerwert haben. 
	 * Postcondition: Die Summe der Integerwerte von den Knoten die zwischen m und M liegen 
	 * (m <= ai <= M) 
	 * @param littlem positiver Integerwert m
	 * @param bigM positiver Integerwert M
	 * @return output = m <= ai <= M 
	 * @throws IllegalArgumentException littlem < 0 || bigM < 0
	 */
	public int sumBetweenTwoNumbers(int littlem, int bigM) throws IllegalArgumentException {
		try {
			if (littlem < 0 || bigM < 0) {
				throw new IllegalArgumentException("littlem und bigM sollten positive Integer sein");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.format("littlem:  %d, bigM: %d, " + e.getMessage(), littlem, bigM);
		}
		Node am = findam(littlem, 0, null);
		Node aM = findaM(bigM, 0, null);
		int output = 0;
		if (am.getIntValue() == aM.getIntValue()) {
			output = am.getSumP();
		} else {
			output = aM.getSumP() - (am.getSumP() - am.getIntValue());
			if (output < 0) {
				output = 0;
			}
		}
		return output;
	}

	/**
	 * Precondition: Wird aufgerufen von sumBetweenTwoNumbers(int, int).
	 * Postcondition: Liefert den Knoten mit dem kleinsten Wert der noch groesser gleich m ist.
	 * @param littlem positiver Integerwert m
	 * @param pos Die aktuelle Position im Suchbaum 
	 * @param node Der Beste bisher gefundener Knoten
	 * @return Knoten mit kleinsten Wert groesser gleich m
	 */
	private Node findam(int littlem, int pos, Node node) {
		if (pos >= tree.length || tree[pos] == null) {
			return node;
		} else if (littlem == tree[pos].getIntValue()) {
			return node = tree[pos];
		} else if (littlem < tree[pos].getIntValue()) {
			Node nodeCompare = tree[pos];
			if (node == null || node.getIntValue() > nodeCompare.getIntValue()) {
				node = tree[pos];
			}
			return findam(littlem, pos * 2 + 1, node);
		} else {
			return findam(littlem, pos * 2 + 2, node);
		}
	}

	/**
	 * Precondition: Wird aufgerufen von sumBetweenTwoNumbers(int, int).
	 * Postcondition: Liefert den Knoten mit dem groessten Wert, der noch kleiner gleich M ist.
	 * @param bigM positiver Integerwert M
	 * @param pos Die aktuelle Position im Suchbaum 
	 * @param node Der Beste bisher gefundener Knoten
	 * @return Knoten mit groessten Wert kleiner gleich M
	 */
	private Node findaM(int bigM, int pos, Node node) {
		if (pos >= tree.length || tree[pos] == null) {
			return node;
		} else if (bigM == tree[pos].getIntValue()) {
			return node = tree[pos];
		} else if (bigM > tree[pos].getIntValue()) {
			Node nodeCompare = tree[pos];
			if (node == null || node.getIntValue() < nodeCompare.getIntValue()) {
				node = tree[pos];
			}
			return findaM(bigM, pos * 2 + 2, node);
		} else {
			return findaM(bigM, pos * 2 + 1, node);
		}
	}

	/**
	 * Precondition: keine
	 * Postcondition: Gibt den binary search tree in Form eines Arrays zurueck.
	 * @return binary search tree
	 */
	public Node[] getTree() {
		return tree;
	}
	
}
