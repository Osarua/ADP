package aufgabenblatt_5;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 5: Bin‰rer Suchbaum
 * Die Klasse test BinarySearchTree.
 */
public class BinarySearchTreeTest {

	@Test
	public void testInsert() {
		BinarySearchTree sb = new BinarySearchTree(3);
		sb.insert(5);
		sb.insert(3);
		sb.insert(2);
		sb.insert(6);
		Node[] tree = sb.getTree();
		assertEquals(tree[0].getIntValue(), 5);
		assertEquals(tree[1].getIntValue(), 3);
		assertEquals(tree[2].getIntValue(), 6);
		assertEquals(tree[3].getIntValue(), 2);
		BinarySearchTree sb2 = new BinarySearchTree(4);
		sb2.insert(1);
		sb2.insert(2);
		sb2.insert(3);
		sb2.insert(4);
		Node[] tree2 = sb2.getTree();
		assertEquals(tree2[0].getIntValue(), 1);
		assertEquals(tree2[2].getIntValue(), 2);
		assertEquals(tree2[6].getIntValue(), 3);
		assertEquals(tree2[14].getIntValue(), 4);
	}

	@Test
	public void testNM() {
		BinarySearchTree sb = new BinarySearchTree(3);
		sb.insert(10);
		sb.insert(5);
		sb.insert(1);
		sb.insert(6);
		sb.insert(15);
		sb.insert(11);
		sb.insert(18);
		assertEquals(sb.sumBetweenTwoNumbers(5, 15), 47);
		assertEquals(sb.sumBetweenTwoNumbers(1, 18), 66);
		assertEquals(sb.sumBetweenTwoNumbers(4, 18), 65);
		assertEquals(sb.sumBetweenTwoNumbers(4, 19), 65);
		assertEquals(sb.sumBetweenTwoNumbers(4, 190), 65);
		assertEquals(sb.sumBetweenTwoNumbers(0, 7), 12);
	}
	
	@Test
	public void testNMdoppelteWerte() {
		BinarySearchTree sb = new BinarySearchTree(2);
		sb.insert(10);
		sb.insert(10);
		sb.insert(10);
		assertEquals(sb.sumBetweenTwoNumbers(10, 10), 30);
	}
	
	@Test
	public void testNMverdreht() {
		BinarySearchTree sb = new BinarySearchTree(3);
		sb.insert(10);
		sb.insert(5);
		sb.insert(1);
		sb.insert(6);
		sb.insert(15);
		sb.insert(11);
		sb.insert(18);
		assertEquals(sb.sumBetweenTwoNumbers(18, 1), 0);
	}
	
}
