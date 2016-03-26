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
		Liste<Integer> aBs = new ArrayBoundedSize<>(1);
		assertEquals("Sollte kein Element enthalten", aBs.groesseDerListe(), 0);
		Liste<String> aBs2 = new ArrayBoundedSize<>(20);
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
		Liste<Integer> aBs= new ArrayBoundedSize<>(1);
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
		Liste<String> aBsString = new ArrayBoundedSize<>(4);
		aBsString.einfuegen("a", 0);
		aBsString.einfuegen("b", 1);
		aBsString.einfuegen("c", 2);
		aBsString.einfuegen("d",1);
		assertEquals("Sollte gleich sein",aBsString.elementAnPosition(0),"a");
		assertEquals("Sollte gleich sein",aBsString.elementAnPosition(1),"d");
		assertEquals("Sollte gleich sein",aBsString.elementAnPosition(2),"b");
		assertEquals("Sollte gleich sein",aBsString.elementAnPosition(3),"c");
		aBsString.einfuegen("z",1);
		assertEquals("Sollte gleich sein",aBsString.elementAnPosition(0),"a");
		assertEquals("Sollte gleich sein",aBsString.elementAnPosition(1),"z");
		assertEquals("Sollte gleich sein",aBsString.elementAnPosition(2),"d");
		assertEquals("Sollte gleich sein",aBsString.elementAnPosition(3),"b");
		assertEquals("Sollte gleich sein",aBsString.elementAnPosition(4),"c");
	}

	/**
	 *  Testet ob die IndexOutOfBoundsException Exception ausgeloesst wird, wenn der 
	 *  aktuelle Parameter position < 0.
	 */
	@Test
	public void testEinfuegenIndexOutOfBoundsException(){
		ArrayBoundedSize<String> aBsString = new ArrayBoundedSize<>(4);
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Ungueltiger Index Zugriff: -1");
		aBsString.einfuegen("a", -1);
	}
	
	/**
	 *  Testet ob die IndexOutOfBoundsException Exception ausgeloesst wird, wenn der 
	 *  aktuelle Parameter position >= Kapazitaet ist.
	 */
	@Test
	public void testEinfuegenIndexOutOfBoundsExceptionKap(){
		Liste<String> aBsString = new ArrayBoundedSize<>(3);
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Ungueltiger Index Zugriff: 3");
		aBsString.einfuegen("a", 3);
	}
	
	/**
	 * Testet ob die IllegalArgumentException Exception ausgeloesst wird, wenn der 
	 * aktuelle Parameter Element eine Referenz auf null hat.
	 */
	@Test
	public void testEinfuegenIllegalArgumentException(){
		Liste<String> aBsString = new ArrayBoundedSize<>(1);
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Element darf nicht null sein");
		aBsString.einfuegen(null, 0);	
	}
	
	/**
	 * Testet die Methode entfernen(int), wenn ein Element am Ende der Liste entfernt wird.
	 */
	@Test
	public void testEntfernen(){
		Liste<String> aBsString = new ArrayBoundedSize<>(1);
		aBsString.einfuegen("a", 0);
		aBsString.entfernen(0);
		assertEquals("Element sollte nicht in der Liste sein",aBsString.elementAnPosition(0),null);
		assertEquals("Anzahl der Elemente sollte 0 sein",aBsString.groesseDerListe(),0);
	}
	
	/**
	 * Testet die Methode entfernen(int), wenn ein Element in der Mitte der Liste entfernt wird.
	 */
	@Test
	public void testEntfernenMitte(){
		Liste<Character> aBsChar = new ArrayBoundedSize<>(4);
		aBsChar.einfuegen('a', 0);
		aBsChar.einfuegen('b', 1);
		aBsChar.einfuegen('c', 2);
		aBsChar.einfuegen('d', 3);
		aBsChar.entfernen(1);
		assertEquals("Anzahl der Elemente sollte 3 sein",aBsChar.groesseDerListe(),3);
		assertEquals("Sollte 'a' sein",aBsChar.elementAnPosition(0),'a');
		assertEquals("Sollte 'c' sein",aBsChar.elementAnPosition(1),'c');
		assertEquals("Sollte 'd' sein",aBsChar.elementAnPosition(2),'d');
		assertEquals("Sollte null sein",aBsChar.elementAnPosition(3),null);
	}

	/**
	 * Testet ob ein Element korrekt gesucht wird und der Index richtig zurueckgegeben wird. 
	 */
	@Test
	public void testFinde() {
		Liste<Integer> aBsInt = new ArrayBoundedSize<>(3);
		aBsInt.einfuegen(11, 0);
		aBsInt.einfuegen(22, 1);
		aBsInt.einfuegen(33, 2);
		assertEquals("Sollte an der Position 1 sein",aBsInt.finde(22),1);
		assertEquals("Sollte an der Position 2 sein",aBsInt.finde(33),2);
		assertEquals("Sollte nicht in der Liste sein",aBsInt.finde(66),-1);
		aBsInt.entfernen(0);
		aBsInt.entfernen(1);
		aBsInt.entfernen(2);
		assertEquals("Sollte nicht in der Liste sein",aBsInt.finde(22),-1);
	}
	
	/**
	 * Testet ob ein Element korrekt zurueckgegeben wird an der uebergebenen Position.
	 */
	@Test
	public void testElementAnPosition(){
		Liste<Character> aBsChar = new ArrayBoundedSize<>(4);
		aBsChar.einfuegen('A', 0);
		aBsChar.einfuegen('H', 1);
		aBsChar.einfuegen('A', 2);
		assertEquals("Sollte gleich sein (A)",aBsChar.elementAnPosition(0),'A');
		assertEquals("Sollte gleich sein (H)",aBsChar.elementAnPosition(1),'H');
		assertEquals("Sollte gleich sein (A)",aBsChar.elementAnPosition(2),'A');
	}
	
	/**
	 * Testet ob bei einem ungueltigen Index zu
	 */
	@Test
	public void testElementAnPositionIndexOutOfBoundsException(){
		Liste<Character> aBsChar = new ArrayBoundedSize<>(1);
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Ungueltiger Index Zugriff: -2");
		aBsChar.elementAnPosition(-2);
	}
	
	/**
	 *  Testet ob die IndexOutOfBoundsException Exception ausgeloesst wird in 
	 *  der Methode entfernen(int). Fuer den fall das der aktuelle 
	 *  Parameter position >= Kapazitaet ist. 
	 */
	@Test
	public void testEntfernennIndexOutOfBoundsExceptionKap(){
		Liste<Character> aBsChar = new ArrayBoundedSize<>(1);
		aBsChar.einfuegen('a', 0);
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Ungueltiger Index Zugriff: 2");
		aBsChar.entfernen(2);
	}
	
	/**
	 *  Fuer den Fall das position < 0 ist. 
	 */
	@Test
	public void testEntfernennIndexOutOfBoundsExceptionNeg(){
		Liste<Character> aBsString = new ArrayBoundedSize<>(1);
		aBsString.einfuegen('a', 0);
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Ungueltiger Index Zugriff: -2");
		aBsString.entfernen(-2);
	}
	
	/**
	 * Testet die Methode listenZusammenfuegen(Liste<E>). Wird eine
	 * Liste von gleichen Typ korrekt am Ende der Liste angefuegt? 
	 */
	@Test
	public void testListenZusammenfuegen() {
		Liste<Integer> aBs = new ArrayBoundedSize<>(1);
		aBs.einfuegen(1, 0);
		Liste<Integer> aBsDiff = new ArrayBoundedSize<>(1);
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
		Liste<Number> aBsNumber = new ArrayBoundedSize<>(1);
		Liste<Number> aBsNumber2 = new ArrayBoundedSize<>(1);
		aBsNumber.einfuegen(3, 0);
		aBsNumber2.einfuegen(-4, 0);
		aBsNumber.listenZusammenfuegen(aBsNumber2);
		assertEquals("Sollte Groesse 2 haben", aBsNumber.groesseDerListe(), 2);
		// Testfall das die Liste nicht vom Typ ArrayBoundedSize<E> ist
		Liste<Number> eVl = new EinfachVerketteteListe<>();
		eVl.einfuegen(1, 0);
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Die konkrete Klasse die das Interface Liste<E>"
					+ "implementiert muss vom Typ ArrayBoundedSize<E> sein");
		aBsNumber.listenZusammenfuegen(eVl);
	}

	/**
	 * Testet ob die IllegalArgumentException Exception ausgeloesst wird, wenn die andere Liste
	 * eine Referenz auf null hat.
	 */
	@Test
	public void testListenZusammenfuegenIllegalArgumentException(){
		Liste<String> aBsString = new ArrayBoundedSize<>(1);
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Liste<E> andereListe darf nicht null sein");
		aBsString.listenZusammenfuegen(null);	
	}
	
	/**
	 * Testet ob die anzahl der Elemente in der Methode korrekt zurueckgegeben wird.
	 */
	@Test
	public void testGroesseDerListe(){
		Liste<Integer> gDL = new ArrayBoundedSize<>(6);
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
		gDL.entfernen(9);
		gDL.entfernen(8);
		gDL.entfernen(7);
		assertEquals("Sollte 7 Elemente enthalten", gDL.groesseDerListe(), 7);
	}
}
