package aufgabenblatt_4;

public class LinkList {

		private int anzahl;
		private int pos;
		private Knoten posKnoten;
		private Knoten anfang;
		public LinkList () {
			anzahl=0;
			pos=-1;
			anfang=null;
			posKnoten=null;
		}
		
		public Object getElement (int index) {
			Knoten knoten = getKnoten (index);
			if (knoten==null) {
				return null;
			}
			return knoten.getElement();
		}
		
		public void setOnPos(int i, Object object) {
			
		}
		
		/**
		 * Das Element wird sortiert nach dem Hashwert eingefügt
		 * Der posKnoten wird auf Position 0 gesetzt;
		 * @param object
		 */
		//Verbessern mit Vorgaenger
		public void addObject (Object object) {
			Knoten neuerKnoten = new Knoten (object);
			if (anfang==null) {
				anfang=neuerKnoten;
			}
			else {
				int key = neuerKnoten.getElement().hashCode();
				Knoten vergleichsKnoten=anfang;
				int vglKey=vergleichsKnoten.getElement().hashCode();
				if (key<vglKey) {
					neuerKnoten.setNachfolger(vergleichsKnoten);
					anfang=neuerKnoten;
				}
				else {
					Knoten vorgaenger = anfang;
					vergleichsKnoten = anfang.getNachfolger();
					while (true) {
						if (vergleichsKnoten==null) {
							vorgaenger.setNachfolger(neuerKnoten);
							break;
						}
						vglKey=vergleichsKnoten.getElement().hashCode();
						if (key<vglKey) {
							vorgaenger.setNachfolger(neuerKnoten);
							neuerKnoten.setNachfolger(vergleichsKnoten);
							break;
						}
						vorgaenger=vergleichsKnoten;
						vergleichsKnoten=vergleichsKnoten.getNachfolger();
					}
				}
			}
			setPosAtZero();
			anzahl++;
			
		}
		
		public int getPos () {
			return pos;
		}
		
		public int getAnzahl () {
			return anzahl;
		}
		
		public void removeObject (int index) {
			if (index<anzahl&&index>=0) {
				if (index==0&&anzahl==1) {
					anfang=null;
					pos=-1;
					posKnoten=null;
					anzahl=0;
				}
				else {
					if (index==0) {
						anfang=anfang.getNachfolger();
					}
					else {
						Knoten vorgaenger = getKnoten (index-1);
						Knoten nachfolger = vorgaenger.getNachfolger().getNachfolger();
						vorgaenger.setNachfolger(nachfolger);
					}
					anzahl--;
				}
			}
		}
		
		public Object getObjectAtPos () {
			return posKnoten.getElement();
		}
		/**
		 * Erhöht die Anzahl der Position, wenn der Knoten auf der Position einen Nachfolger hat
		 */
		public void erhoehePos () {
			if (posKnoten.getNachfolger()!=null) {
				posKnoten=posKnoten.getNachfolger();
				pos++;
			}
		}
		
		public void setPosAtZero () {
			posKnoten=anfang;
			pos=0;
		}
		private Knoten getKnoten (int index) {
			if (index<0||index>=anzahl) {
				return null;
			}
			Knoten knoten=anfang;
			for (int i=0;i<index;i++) {
				knoten=anfang.getNachfolger();
			}
			return knoten;
		}
		
		private class Knoten {
			private Object element;
			private Knoten nachfolger;
			public Knoten (Object object) {
				element=object;
				nachfolger=null;
			}
			public Object getElement() {
				return element;
			}
			public Knoten getNachfolger() {
				return nachfolger;
			}
			public void setNachfolger(Knoten nachfolger) {
				this.nachfolger = nachfolger;
			}
		}
		
	}
