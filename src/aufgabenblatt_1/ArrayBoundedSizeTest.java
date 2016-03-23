package aufgabenblatt_1;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
/**
 * TI3 ADP, SS16 
 * @author Julian
 * Aufgabenblatt 1: Testet die Klasse ArrayBoundedSize.
 */
public class ArrayBoundedSizeTest {
	/**
	 * ExpectedException rule erlaubt es in JUnit die erwarteten Exception zu spezifizieren.
	 * Welcher Exception Typ wird erwartet. Sowie welche Nachricht sollte ausgegeben werden. 
	 */
	@Rule
	public ExpectedException exception = ExpectedException.none();

	/**
	 * Testet den Konstruktor. 
	 */
	@Test
	public void testKonstruktor() {
		ArrayBoundedSize<Integer> aBs = new ArrayBoundedSize<>(1);
		assertEquals("Sollte kein Element enthalten", aBs.groesseDerListe(), 0);
		ArrayBoundedSize<String> aBs2 = new ArrayBoundedSize<>(20);
		assertEquals("Sollte kein Element enthalten", aBs2.groesseDerListe(), 0);
		// IllegalArgumentException erwartet, wenn aktueller Parameter ist <= 0
		exception.expect(IllegalArgumentException.class);
		// Die erwartete Nachricht der Exception..
		exception.expectMessage("Ungueltige Anfangskapazitaet: " + -21);
		new ArrayBoundedSize<Integer>(-21);
	}
	
	/**
	 * Bei der erzeugung mit einer Anfangskapazitaet 0 sollte eine Exception geworfen werden. 
	 */
	@Test 
	public void testKonstruktorKAPN(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Ungueltige Anfangskapazitaet: " + 0);
		new ArrayBoundedSize<Integer>(0);
	}
	
	/**
	 * Testet die Methode einfuegen. Ein Element ist korrekt eingefuegt, wenn
	 * es Teil der Liste ist und sich die Anzahl der Elemente um eins erhoeht hat.
	 */
	@Test
	public void testEinfuegen(){
		ArrayBoundedSize<Integer> aBs= new ArrayBoundedSize<>(1);
		aBs.einfuegen(1, 0);
		assertEquals("Sollte ein Element enthalten",aBs.groesseDerListe(),1);
		aBs.einfuegen(2, 1);
		assertEquals("Sollte zwei Elemente enthalten",aBs.groesseDerListe(),2);
		assertEquals("Sollte den Wert 1 haben",aBs.elementAnPosition(0),1);
		assertEquals("Sollte den Wert 2 haben",aBs.elementAnPosition(1),2);
		aBs.einfuegen(3, 2);
		assertEquals("Sollte drei Elemente enthalten",aBs.groesseDerListe(),3);
		aBs.einfuegen(4, 3);
		assertEquals("Sollte vier Elemente enthalten",aBs.groesseDerListe(),4);
		aBs.einfuegen(-5, 4);
		assertEquals("Sollte 5 Elemente enthalten",aBs.groesseDerListe(),5);
		aBs.einfuegen(6, 5);
		assertEquals("Sollte 6 Elemente enthalten",aBs.groesseDerListe(),6);
		aBs.einfuegen(7, 6);
		assertEquals("Sollte 7 Elemente enthalten",aBs.groesseDerListe(),7);
		aBs.einfuegen(0, 7);
		assertEquals("Sollte 8 Elemente enthalten",aBs.groesseDerListe(),8);
		aBs.einfuegen(9, 8);
		assertEquals("Sollte 9 Elemente enthalten",aBs.groesseDerListe(),9);
		aBs.einfuegen(10, 9);
		assertEquals("Sollte 10 Elemente enthalten",aBs.groesseDerListe(),10);
		aBs.einfuegen(11, 10);
		assertEquals("Sollte 11 Elemente enthalten",aBs.groesseDerListe(),11);
		assertEquals("Sollte den Wert 11 haben",aBs.elementAnPosition(10),11);
	}
	
	/**
	 * Testet ob ein Element korrekt in der Mitte der Liste eingefuegt wird.
	 */
	@Test
	public void testEinfuegenNachruecken(){
		ArrayBoundedSize<String> aBsString = new ArrayBoundedSize<>(4);
		aBsString.einfuegen("a", 0);
		aBsString.einfuegen("b", 1);
		aBsString.einfuegen("c", 2);
		aBsString.einfuegen("d",1);
		assertEquals("Sollte gleich sein",aBsString.elementAnPosition(0),"a");
		assertEquals("Sollte gleich sein",aBsString.elementAnPosition(1),"d");
		assertEquals("Sollte gleich sein",aBsString.elementAnPosition(2),"b");
		assertEquals("Sollte gleich sein",aBsString.elementAnPosition(3),"c");
	}

	/**
	 *  Testet ob die IndexOutOfBoundsException Exception ausgeloesst wird, wenn der 
	 *  aktuelle Parameter position < 0.
	 */
	@Test
	public void testEinfuegenIndexOutOfBoundsException(){
		ArrayBoundedSize<String> aBsString = new ArrayBoundedSize<>(4);
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Ungueltiger Index zugriff: -1");
		aBsString.einfuegen("a", -1);
	}
	
	/**
	 *  Testet ob die IndexOutOfBoundsException Exception ausgeloesst wird, wenn der 
	 *  aktuelle Parameter position > Kapazitaet ist.
	 */
	@Test
	public void testEinfuegenIndexOutOfBoundsExceptionKap(){
		ArrayBoundedSize<String> aBsString = new ArrayBoundedSize<>(2);
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Ungueltiger Index zugriff: 3");
		aBsString.einfuegen("a", 3);
	}
	
	/**
	 * Testet ob die IllegalArgumentException Exception ausgeloesst wird, wenn der 
	 * aktuelle Parameter Element eine Referenz auf null hat.
	 */
	@Test
	public void testEinfuegenIllegalArgumentException(){
		ArrayBoundedSize<String> aBsString = new ArrayBoundedSize<>(4);
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Element darf nicht null sein");
		aBsString.einfuegen(null, 0);	
	}
	
	/**
	 * Testet die Methode listenZusammenfuegen(Liste<E>). Wird eine
	 * Liste von gleichen Typ korrekt am Ende der Liste angefuegt? 
	 */
	@Test
	public void testListenZusammenfuegen() {
		ArrayBoundedSize<Integer> aBs = new ArrayBoundedSize<>(1);
		aBs.einfuegen(1, 0);
		ArrayBoundedSize<Integer> aBsDiff = new ArrayBoundedSize<>(1);
		aBsDiff.einfuegen(2, 0);
		aBs.listenZusammenfuegen(aBsDiff);
		assertEquals("Sollte Groesse 2 haben", aBs.groesseDerListe(), 2);
		assertEquals("Sollte 1 sein", aBs.elementAnPosition(0), 1);
		assertEquals("Sollte 2 sein", aBs.elementAnPosition(1), 2);
		aBsDiff.einfuegen(3, 1);
		aBsDiff.einfuegen(4, 2);
		aBs.listenZusammenfuegen(aBsDiff);
		assertEquals("Sollte Groesse 5 haben", aBs.groesseDerListe(), 5);
		assertEquals("Sollte 4 sein", aBs.elementAnPosition(4), 4);
		ArrayBoundedSize<Number> aBsNumber = new ArrayBoundedSize<>(1);
		ArrayBoundedSize<Number> aBsNumber2 = new ArrayBoundedSize<>(1);
		aBsNumber.einfuegen(3, 0);
		aBsNumber2.einfuegen(-4, 0);
		aBsNumber.listenZusammenfuegen(aBsNumber2);
		assertEquals("Sollte Groesse 2 haben", aBsNumber.groesseDerListe(), 2);
		ArrayBoundedSize<String> aBsString = new ArrayBoundedSize<>(1);
		ArrayBoundedSize<String> aBsString2 = new ArrayBoundedSize<>(1);
		aBsString.listenZusammenfuegen(aBsString2);
		assertEquals("Sollte Groesse 0 haben", aBsString.groesseDerListe(), 0);
	}

	/**
	 * Testet ob die anzahl der Elemente in der Methode korrekt zurueckgegeben wird.
	 */
	@Test
	public void testGroesseDerListe(){
		ArrayBoundedSize<Integer> gDL = new ArrayBoundedSize<>(6);
		assertEquals("Sollte kein Element enthalten", gDL.groesseDerListe(), 0);
		gDL.einfuegen(10, 0);
		gDL.einfuegen(1, 1);
		gDL.einfuegen(1, 2);
		gDL.einfuegen(1, 3);
		gDL.einfuegen(1, 4);
		gDL.einfuegen(1, 5);
		gDL.einfuegen(1, 6);
		gDL.einfuegen(1, 7);
		gDL.einfuegen(1, 8);
		gDL.einfuegen(1, 9);
		assertEquals("Sollte 10 Elemente enthalten", gDL.groesseDerListe(), 10);
	}
}
