package spielwiese;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertionsortTest {

	@Test
	public void testInsertionsort() {
		Integer[] feldI= new Integer[8];
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
		assertEquals((int)feldI[0],1);
		assertEquals((int)feldI[1],2);
		assertEquals((int)feldI[2],3);
		assertEquals((int)feldI[3],5);
		assertEquals((int)feldI[4],6);
		assertEquals((int)feldI[5],7);
		assertEquals((int)feldI[6],9);
		assertEquals((int)feldI[7],100);
		Integer[] feldInteger = new Integer[1000000];
		erstelleSchluesselAufsteigend(feldInteger);
		long zeit= System.currentTimeMillis();
		inSort.insertionsort(feldInteger);
		zeit = System.currentTimeMillis() - zeit;
		System.out.println("N: " + ", Laufzeit: " + zeit + "\n");
		boolean korrektSortiert = true;
		for(int i = 0; i < feldInteger.length-1; i++) {
			if(feldInteger[i].hashCode() > feldInteger[i+1].hashCode()) {
				korrektSortiert = false;
			}
		}
		assertEquals("Sollte true sein, wenn Array korrekt sortiert ist",korrektSortiert,true);
	}

	public void erstelleSchluesselAufsteigend(Integer[] feldI) {
		for(int i = 0; i <feldI.length ;i++) {
			feldI[i] = 700*feldI.length+i;
		}
			   for (int i = 0;i<feldI.length/100;i++) {
			    int pos = (int)(Math.random()*feldI.length);
			    feldI[i]=feldI[pos];

			   }
	}
}
