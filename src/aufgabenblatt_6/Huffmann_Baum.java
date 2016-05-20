package aufgabenblatt_6;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;


public class Huffmann_Baum {
	
	/**
	 * 
	 *
	 */
	public class Knoten {
		int wert;
		String zeichen;
		Knoten kleinerNachfolger, grosserNachfolger;

		public Knoten(int wertPar) {
			wert = wertPar;
			zeichen = null;
			kleinerNachfolger = null;
			grosserNachfolger = null;
		}
	}

	public class Knoten_Comperator implements Comparator<Knoten> {
		@Override
		public int compare(Knoten arg0, Knoten arg1) {
			return arg0.wert - arg1.wert;
		}
	}
	
	private Knoten baum;
	
	/**
	 * Precondition: text darf nur ascii Zeichen enthalten und muss mindestens 1 Zeichen enthalten
	 * @param text
	 */
	public Huffmann_Baum(String text) {
		int haeufigkeit[] = new int[256];
		for (int i = 0; i < text.length(); i++) {
			int lokalChar = text.charAt(i);
			haeufigkeit[lokalChar] = haeufigkeit[lokalChar] + 1;
		}
		List<Knoten> knotenListe = new ArrayList<Knoten>();
		for (int i = 0; i < 256; i++) {
			if (haeufigkeit[i] > 0) {
				Knoten knoten = new Knoten(haeufigkeit[i]);
				knoten.zeichen = "" + (char) i;
				knotenListe.add(knoten);
			}
		}
		knotenListe.sort(new Knoten_Comperator());
		baum = knotenListe.get(0);
		for (int i = 1; i < knotenListe.size(); i++) {
			baum = baum_erstellen(baum, knotenListe.get(i));
		}
		//Sonderfall für einen 1 Knoten Baum
		if (baum.grosserNachfolger == null && baum.kleinerNachfolger == null) {
			Knoten neueWurzel = new Knoten(baum.wert);
			neueWurzel.grosserNachfolger = baum;
			baum = neueWurzel;
		}
	}
	
	private Knoten baum_erstellen(Knoten wurzel, Knoten neuer) {
		Knoten neueWurzel = new Knoten(wurzel.wert + neuer.wert);
		neueWurzel.zeichen = wurzel.zeichen + neuer.zeichen;
		if (wurzel.wert > neuer.wert) {
			neueWurzel.grosserNachfolger = wurzel;
			neueWurzel.kleinerNachfolger = neuer;
		} else {
			neueWurzel.grosserNachfolger = neuer;
			neueWurzel.kleinerNachfolger = wurzel;
		}
		return neueWurzel;
	}
	/**
	 * Postcondition: Codiert einen String in ein boolean array, nach dem Huffmann Baum.
	 * 				  Sollten Zeichen verwendet werden die nicht im Baum vorkommen werden diese
	 * 				  nicht codiert
	 * @param textPar
	 * @return
	 */
	public Boolean[] textCodieren(String textPar) {
		LinkedList<Boolean> list = new LinkedList<Boolean>();
		for (int i = 0; i < textPar.length(); i++) {
			zeichenZuCode(list, "" + textPar.charAt(i), baum);
		}
		return list.toArray(new Boolean[list.size()]);
	}
	
	private void zeichenZuCode(LinkedList<Boolean> list, String zeichen, Knoten knoten) {
		if (knoten.grosserNachfolger != null) {
			if (knoten.grosserNachfolger.zeichen.contains(zeichen)) {
				list.add(true);
				zeichenZuCode(list, zeichen, knoten.grosserNachfolger);
			}
		} else if (knoten.kleinerNachfolger != null) {
			if (knoten.kleinerNachfolger.zeichen.contains(zeichen)) {
				list.add(false);
				zeichenZuCode(list, zeichen, knoten.kleinerNachfolger);
			}
		}
	}
	
	public String textDecodieren(Boolean[] codePar) {
		String text = "";
		Knoten knoten = baum;
		for (int i = 0; i < codePar.length; i++) {
			if (codePar[i]) {
				if (knoten.grosserNachfolger != null) {
					knoten = knoten.grosserNachfolger;
					if (knoten.grosserNachfolger == null && knoten.kleinerNachfolger == null) {
						text = text + knoten.zeichen;
						knoten = baum;
					}
				} else {
					knoten = baum;
				}
			} else {
				if (knoten.kleinerNachfolger != null) {
					knoten = knoten.kleinerNachfolger;
					if (knoten.grosserNachfolger == null && knoten.kleinerNachfolger == null) {
						text = text + knoten.zeichen;
						knoten = baum;
					}
				} else {
					knoten = baum;
				}
			}
		}
		return text;
	}
}
