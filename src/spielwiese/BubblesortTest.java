package spielwiese;

import static org.junit.Assert.*;

import org.junit.Test;

public class BubblesortTest {

	@Test
	public void testBubblesortIterativ() {
		Bubblesort bubbleS = new Bubblesort();
		int[] array = new int[10];
		array[0] = 40;
		array[1] = 1000;
		array[2] = 10;
		array[3] = 33;
		array[4] = 551;
		array[5] = 12536;
		array[6] = 5;
		array[7] = 53;
		array[8] = 55;
		array[9] = 51;
		bubbleS.bubblesort(array);
		assertEquals(array[0],5);
		assertEquals(array[1],10);
		assertEquals(array[2],33);
		assertEquals(array[3],40);
		assertEquals(array[4],51);
		assertEquals(array[5],53);
		assertEquals(array[6],55);
		assertEquals(array[7],551);
		assertEquals(array[8],1000);
		assertEquals(array[9],12536);
	}
	
	@Test
	public void testBubblesortRekursiv() {
		Bubblesort bubbleS = new Bubblesort();
		int[] array = new int[10];
		array[0] = 40;
		array[1] = 1000;
		array[2] = 10;
		array[3] = 33;
		array[4] = 551;
		array[5] = 12536;
		array[6] = 5;
		array[7] = 53;
		array[8] = 55;
		array[9] = 51;
		bubbleS.bubblesortR(array, 10);
		assertEquals(array[0],5);
		assertEquals(array[1],10);
		assertEquals(array[2],33);
		assertEquals(array[3],40);
		assertEquals(array[4],51);
		assertEquals(array[5],53);
		assertEquals(array[6],55);
		assertEquals(array[7],551);
		assertEquals(array[8],1000);
		assertEquals(array[9],12536);
		
	}
	
	@Test
	public void testBubbleViel() {
		int max = 100000;
		int[] arrayI = new int[max];
		for (int i = 0; i < max; i++) {
			arrayI[i]= i;
		}
		Bubblesort bubbleS = new Bubblesort();
		bubbleS.bubblesort(arrayI);
		assertEquals((int) arrayI[0], 0);
		assertEquals((int) arrayI[1], 1);
		assertEquals((int) arrayI[2], 2);
		assertEquals((int) arrayI[99], 99);
		assertEquals((int) arrayI[999], 999);
		assertEquals((int) arrayI[9999], 9999);
		// Absteigend
		int i = 0;
		for (int integ = max - 1; integ >= 0; integ--) {
			arrayI[i] = integ;
			i++;
		}
		bubbleS.bubblesort(arrayI);
		assertEquals((int) arrayI[0], 0);
		assertEquals((int) arrayI[9999], 9999);
	}
	
	

}
