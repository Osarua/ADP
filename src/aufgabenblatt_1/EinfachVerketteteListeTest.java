package aufgabenblatt_1;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
/**
 * TI3 ADP, SS16 
 * Gruppe: Julian Magierski (julian.magierski@haw-hamburg.de)
 * Kristian Exﬂ (kristian.exss@haw-hamburg) 
 * Aufgabenblatt 1: Testet die Klasse Einfach verkettete Liste.
 */
public class EinfachVerketteteListeTest {
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
		List<Integer> aBs = new EinfachVerketteteListe<>();
		assertEquals("Sollte kein Element enthalten", aBs.size(), 0);
	}
		
	/**
	 * Testet die Methode einfuegen. Ein Element ist korrekt eingefuegt, wenn
	 * es Teil der Liste ist und sich die Anzahl der Elemente um eins erhoeht hat.
	 */
	@Test
	public void testEinfuegen(){
		List<Integer> aBs= new EinfachVerketteteListe<>();
		aBs.insert(1, 0);
		assertEquals("Sollte ein Element enthalten",aBs.size(),1);
		aBs.insert(2, 1);
		assertEquals("Sollte zwei Elemente enthalten",aBs.size(),2);
		assertEquals("Sollte den Wert 1 haben",aBs.retrieve(0),1);
		assertEquals("Sollte den Wert 2 haben",aBs.retrieve(1),2);
		aBs.insert(3, 2);
		assertEquals("Sollte drei Elemente enthalten",aBs.size(),3);
		aBs.insert(4, 3);
		assertEquals("Sollte vier Elemente enthalten",aBs.size(),4);
		aBs.insert(-5, 4);
		assertEquals("Sollte 5 Elemente enthalten",aBs.size(),5);
		aBs.insert(6, 5);
		assertEquals("Sollte 6 Elemente enthalten",aBs.size(),6);
		aBs.insert(7, 6);
		assertEquals("Sollte 7 Elemente enthalten",aBs.size(),7);
		aBs.insert(0, 7);
		assertEquals("Sollte 8 Elemente enthalten",aBs.size(),8);
		aBs.insert(9, 8);
		assertEquals("Sollte 9 Elemente enthalten",aBs.size(),9);
		aBs.insert(10, 9);
		assertEquals("Sollte 10 Elemente enthalten",aBs.size(),10);
		aBs.insert(11, 10);
		assertEquals("Sollte 11 Elemente enthalten",aBs.size(),11);
		assertEquals("Sollte den Wert 11 haben",aBs.retrieve(10),11);
	}
	
	/**
	 * Testet ob ein Element korrekt in der Mitte der Liste eingefuegt wird.
	 */
	@Test
	public void testEinfuegenNachruecken(){
		List<String> aBsString = new EinfachVerketteteListe<>();
		aBsString.insert("a", 0);
		aBsString.insert("b", 1);
		aBsString.insert("c", 2);
		aBsString.insert("d",1);
		assertEquals("Sollte gleich sein",aBsString.retrieve(0),"a");
		assertEquals("Sollte gleich sein",aBsString.retrieve(1),"d");
		assertEquals("Sollte gleich sein",aBsString.retrieve(2),"b");
		assertEquals("Sollte gleich sein",aBsString.retrieve(3),"c");
		aBsString.insert("z",1);
		assertEquals("Sollte gleich sein",aBsString.retrieve(0),"a");
		assertEquals("Sollte gleich sein",aBsString.retrieve(1),"z");
		assertEquals("Sollte gleich sein",aBsString.retrieve(2),"d");
		assertEquals("Sollte gleich sein",aBsString.retrieve(3),"b");
		assertEquals("Sollte gleich sein",aBsString.retrieve(4),"c");
	}

	/**
	 *  Testet ob die IndexOutOfBoundsException Exception ausgeloesst wird, wenn der 
	 *  aktuelle Parameter position < 0.
	 */
	@Test
	public void testEinfuegenIndexOutOfBoundsException(){
		List<String> aBsString = new EinfachVerketteteListe<>();
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Ungueltiger Index Zugriff: -1");
		aBsString.insert("a", -1);
	}
	
	/**
	 *  Testet ob die IndexOutOfBoundsException Exception ausgeloesst wird, wenn der 
	 *  aktuelle Parameter position >= Kapazitaet ist.
	 */
	@Test
	public void testEinfuegenIndexOutOfBoundsExceptionKap(){
		List<String> aBsString = new EinfachVerketteteListe<>();
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Ungueltiger Index Zugriff: 3");
		aBsString.insert("a", 3);
	}
	
	/**
	 * Testet ob die IllegalArgumentException Exception ausgeloesst wird, wenn der 
	 * aktuelle Parameter Element eine Referenz auf null hat.
	 */
	@Test
	public void testEinfuegenIllegalArgumentException(){
		List<String> aBsString = new EinfachVerketteteListe<>();
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Element darf nicht null sein");
		aBsString.insert(null, 0);	
	}
	
	/**
	 * Testet die Methode entfernen(int), wenn ein Element am Ende der Liste entfernt wird.
	 */
	@Test
	public void testEntfernen(){
		List<String> aBsString = new EinfachVerketteteListe<>();
		aBsString.insert("a", 0);
		aBsString.delete(0);
		assertEquals("Element sollte nicht in der Liste sein",aBsString.retrieve(0),null);
		assertEquals("Anzahl der Elemente sollte 0 sein",aBsString.size(),0);
	}
	
	/**
	 * Testet die Methode entfernen(int), wenn ein Element in der Mitte der Liste entfernt wird.
	 */
	@Test
	public void testEntfernenMitte(){
		List<Character> aBsChar = new EinfachVerketteteListe<>();
		aBsChar.insert('a', 0);
		aBsChar.insert('b', 1);
		aBsChar.insert('c', 2);
		aBsChar.insert('d', 3);
		aBsChar.delete(1);
		assertEquals("Anzahl der Elemente sollte 3 sein",aBsChar.size(),3);
		assertEquals("Sollte 'a' sein",aBsChar.retrieve(0),'a');
		assertEquals("Sollte 'c' sein",aBsChar.retrieve(1),'c');
		assertEquals("Sollte 'd' sein",aBsChar.retrieve(2),'d');
	}

	/**
	 * Testet ob ein Element korrekt gesucht wird und der Index richtig zurueckgegeben wird. 
	 */
	@Test
	public void testFinde() {
		List<Integer> aBsInt = new EinfachVerketteteListe<>();
		aBsInt.insert(11, 0);
		aBsInt.insert(22, 1);
		aBsInt.insert(33, 2);
		assertEquals("Sollte an der Position 1 sein",aBsInt.find(22),1);
		assertEquals("Sollte an der Position 2 sein",aBsInt.find(33),2);
		assertEquals("Sollte nicht in der Liste sein",aBsInt.find(66),-1);
		aBsInt.delete(0);
		aBsInt.delete(1);
		aBsInt.delete(0);
		assertEquals("Sollte nicht in der Liste sein",aBsInt.find(22),-1);
	}
	
	/**
	 * Testet ob ein Element korrekt zurueckgegeben wird an der uebergebenen Position.
	 */
	@Test
	public void testElementAnPosition(){
		List<Character> aBsChar = new EinfachVerketteteListe<>();
		aBsChar.insert('A', 0);
		aBsChar.insert('H', 1);
		aBsChar.insert('A', 2);
		assertEquals("Sollte gleich sein (A)",aBsChar.retrieve(0),'A');
		assertEquals("Sollte gleich sein (H)",aBsChar.retrieve(1),'H');
		assertEquals("Sollte gleich sein (A)",aBsChar.retrieve(2),'A');
	}
	
	/**
	 * Testet ob bei einem ungueltigen Index zu
	 */
	@Test
	public void testElementAnPositionIndexOutOfBoundsException(){
		List<Character> aBsChar = new ArrayBoundedSize<>(1);
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Ungueltiger Index Zugriff: -2");
		aBsChar.retrieve(-2);
	}
	
	/**
	 *  Testet ob die IndexOutOfBoundsException Exception ausgeloesst wird in 
	 *  der Methode entfernen(int). Fuer den fall das der aktuelle 
	 *  Parameter position >= Kapazitaet ist. 
	 */
	@Test
	public void testEntfernennIndexOutOfBoundsExceptionKap(){
		List<Character> aBsChar = new EinfachVerketteteListe<>();
		aBsChar.insert('a', 0);
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Ungueltiger Index Zugriff: 2");
		aBsChar.delete(2);
	}
	
	/**
	 *  Fuer den Fall das position < 0 ist. 
	 */
	@Test
	public void testEntfernennIndexOutOfBoundsExceptionNeg(){
		List<Character> aBsString = new EinfachVerketteteListe<>();
		aBsString.insert('a', 0);
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Ungueltiger Index Zugriff: -2");
		aBsString.delete(-2);
	}
	
	/**
	 *  Fuer den Fall das die Anzahl der Elemente == 0 ist
	 */
	
	public void testEntfernennIllegalArgumentException(){
		List<Character> aBsString = new EinfachVerketteteListe<>();
		aBsString.insert('a', 0);
		aBsString.delete(0);
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Anzahl der Elemente muss groesser 0 sein");
		aBsString.delete(1);
	}
	
	/**
	 * Testet die Methode listenZusammenfuegen(Liste<E>). Wird eine
	 * Liste von gleichen Typ korrekt am Ende der Liste angefuegt? 
	 */
	@Test
	public void testListenZusammenfuegen() {
		List<Integer> aBs = new EinfachVerketteteListe<>();
		aBs.insert(1, 0);
		List<Integer> aBsDiff = new EinfachVerketteteListe<>();
		aBsDiff.insert(2, 0);
		aBs.concat(aBsDiff);
		assertEquals("Sollte Groesse 2 haben", aBs.size(), 2);
		assertEquals("Sollte 1 sein", aBs.retrieve(0), 1);
		assertEquals("Sollte 2 sein", aBs.retrieve(1), 2);
		aBsDiff.insert(3, 1);
		aBsDiff.insert(4, 2);
		aBs.concat(aBsDiff);
		assertEquals("Sollte Groesse 5 haben", aBs.size(), 5);
		assertEquals("Sollte 4 sein", aBs.retrieve(4), 4);
		List<Number> aBsNumber = new EinfachVerketteteListe<>();
		List<Number> aBsNumber2 = new EinfachVerketteteListe<>();
		aBsNumber.insert(3, 0);
		aBsNumber2.insert(-4, 0);
		aBsNumber.concat(aBsNumber2);
		assertEquals("Sollte Groesse 2 haben", aBsNumber.size(), 2);
		// Testfall das die Liste nicht vom Typ EinfachVerketteteListe<E> ist
		List<Number> eVl = new ArrayBoundedSize<>(1);
		eVl.insert(1, 0);
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Die konkrete Klasse die das Interface Liste<E>"
					+ "implementiert muss vom Typ EinfachVerketteteListe<E> sein");
		aBsNumber.concat(eVl);
	}

	/**
	 * Testet ob die IllegalArgumentException Exception ausgeloesst wird, wenn die andere Liste
	 * eine Referenz auf null hat.
	 */
	@Test
	public void testListenZusammenfuegenIllegalArgumentException(){
		List<String> aBsString = new EinfachVerketteteListe<>();
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Liste<E> andereListe darf nicht null sein");
		aBsString.concat(null);	
	}
	
	/**
	 * Testet ob die anzahl der Elemente in der Methode korrekt zurueckgegeben wird.
	 */
	@Test
	public void testGroesseDerListe(){
		List<Integer> gDL = new EinfachVerketteteListe<>();
		assertEquals("Sollte kein Element enthalten", gDL.size(), 0);
		gDL.insert(10, 0);
		gDL.insert(1, 1);
		gDL.insert(1, 2);
		gDL.insert(1, 3);
		gDL.insert(1, 4);
		gDL.insert(1, 5);
		gDL.insert(1, 6);
		gDL.insert(1, 7);
		gDL.insert(1, 8);
		gDL.insert(1, 9);
		assertEquals("Sollte 10 Elemente enthalten", gDL.size(), 10);
		gDL.delete(9);
		gDL.delete(8);
		gDL.delete(7);
		assertEquals("Sollte 7 Elemente enthalten", gDL.size(), 7);
	}
}
