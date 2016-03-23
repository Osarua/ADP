package aufgabenblatt_1;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * TI3 ADP, SS16 
 * @author Julian
 * Aufgabenblatt 1: Testet die Klasse ArrayBoundedSize.
 */
public class ArrayBoundedSizeTest {

	@Test
	public void testKonstruktor() {
		ArrayBoundedSize<Integer> aBs= new ArrayBoundedSize<Integer>(1);
		assertEquals("Sollte kein Element enthalten",aBs.groesseDerListe(),0);
	}
	
	@Test
	public void testEinfuegen(){
		ArrayBoundedSize<Integer> aBs= new ArrayBoundedSize<Integer>(1);
		aBs.einfuegen(1, 0);
		assertEquals("Sollte ein Element enthalten",aBs.groesseDerListe(),1);
		aBs.einfuegen(2, 1);
		assertEquals("Sollte zwei Elemente enthalten",aBs.groesseDerListe(),2);
		aBs.einfuegen(3, 2);
		assertEquals("Sollte drei Elemente enthalten",aBs.groesseDerListe(),3);
		aBs.einfuegen(4, 3);
		assertEquals("Sollte vier Elemente enthalten",aBs.groesseDerListe(),4);
		aBs.einfuegen(5, 4);
		assertEquals("Sollte 5 Elemente enthalten",aBs.groesseDerListe(),5);
		aBs.einfuegen(6, 5);
		assertEquals("Sollte 6 Elemente enthalten",aBs.groesseDerListe(),6);
		aBs.einfuegen(7, 6);
		assertEquals("Sollte 7 Elemente enthalten",aBs.groesseDerListe(),7);
		aBs.einfuegen(8, 7);
		assertEquals("Sollte 8 Elemente enthalten",aBs.groesseDerListe(),8);
		aBs.einfuegen(9, 8);
		assertEquals("Sollte 9 Elemente enthalten",aBs.groesseDerListe(),9);
		aBs.einfuegen(10, 9);
		assertEquals("Sollte 10 Elemente enthalten",aBs.groesseDerListe(),10);
		aBs.einfuegen(11, 10);
		assertEquals("Sollte 11 Elemente enthalten",aBs.groesseDerListe(),11);
	}
	
	@Test
	public void testListenZusammenfuegen(){
		ArrayBoundedSize<Integer> aBs= new ArrayBoundedSize<Integer>(1);
		aBs.einfuegen(1, 0);
		ArrayBoundedSize<Integer> aBsDiff= new ArrayBoundedSize<Integer>(1);
		aBsDiff.einfuegen(2, 0);
		aBs.listenZusammenfuegen(aBsDiff);
		assertEquals("Sollte Groesse 2 haben",aBs.groesseDerListe(),2);
		aBsDiff.einfuegen(3, 1);
		aBsDiff.einfuegen(4, 2);
		aBs.listenZusammenfuegen(aBsDiff);
		assertEquals("Sollte Groesse 5 haben",aBs.groesseDerListe(),5);
	}

}
