package spielwiese;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertionsortTest {

	@Test
	public void testInsertionsort() {
		int[] feldI= new int[8];
		feldI[0] = 2;
		feldI[1] = 5;
		feldI[2] = 6;
		feldI[3] = 1;
		feldI[4] = 3;
		feldI[5] = 9;
		feldI[6] = 100;
		feldI[7] = 7;
		Insertionsort inSort = new Insertionsort();
		inSort.insertionsort(feldI);
		assertEquals(feldI[0],1);
		assertEquals(feldI[1],2);
		assertEquals(feldI[2],3);
		assertEquals(feldI[3],5);
		assertEquals(feldI[4],6);
		assertEquals(feldI[5],7);
		assertEquals(feldI[6],9);
		assertEquals(feldI[7],100);
	}

}
