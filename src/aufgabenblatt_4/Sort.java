package aufgabenblatt_4;


public class Sort {
	
		private Object[] sortierListe;
		private int exponent;
		private final int feldTeiler=10;
		
		public Sort (int exponentPar) {
			exponent=exponentPar;
			sortierListe=arrayErstellen();
		}
		
		private Object[] arrayErstellen () {
			int anzahl = ((int) Math.pow(10, exponent)*100)/feldTeiler+1;
			Object [] array = new Object [anzahl];
			return array;
		}
		/**
		 * Bei vor Wiederverwenderung des Objektes benutzen um das Array zu leeren
		 */
		public void arrayLeeren () {
			for (int i=0;i<sortierListe.length;i++) {
				sortierListe[i]=null;
			}
		}
		private void elementEinfuegen (Object element) {
			int index=element.hashCode();
			index=(index-(700*(int)Math.pow(10, exponent)))/feldTeiler;
			if (sortierListe[index]!=null) {
				if (sortierListe[index] instanceof LinkList) {
					LinkList lokaleListe=(LinkList) sortierListe[index];
					lokaleListe.addObject(element);
				}
				else {
					LinkList lokaleListe = new LinkList ();
					lokaleListe.addObject(sortierListe[index]);
					lokaleListe.addObject(element);
					sortierListe[index]=lokaleListe;
				}
			}
			else {
				sortierListe[index]=element;
			}
		}
		/**
		 * Sortiert die übergebene Liste.
		 * Das Verhalten des Sortier Algorithmuses ist unbestimmt wenn die übergebene List nicht:
		 * Laenge=10^exponent und hashwerte nicht zwischen 700*laenge und 800*laenge liegen
		 * @param list
		 * @return list
		 */
		public Object [] sortier (Object[] list) {
			for (int i=0;i<list.length;i++) {
				elementEinfuegen (list[i]);
			}
			int index=0;
			for (int i=0;i<sortierListe.length;i++) {
				if (sortierListe[i]!=null) {
					if (sortierListe[i] instanceof LinkList) {
						LinkList lokaleListe = (LinkList) sortierListe[i];
						for (int j=0;j<lokaleListe.getAnzahl();j++) {
							list[index]=lokaleListe.getObjectAtPos();
							lokaleListe.erhoehePos();
							index++;
						}
					}
					else {
						list[index]=sortierListe[i];
						index++;
					}
				}
				if (index==list.length) {
					break;
				}
			}
			return list;
		}

	}

