package aufgabenblatt_4;


public class Sort {
	
		private LinkList[] sortierListe;
		private int exponent;
		
		public Sort (int exponentPar) {
			exponent=exponentPar;
			sortierListe=arrayErstellen();
		}
		
		private LinkList[] arrayErstellen () {
			int anzahl = (int) Math.pow(10, exponent)/10;
			LinkList [] array = new LinkList [anzahl];
			return array;
		}
		private void arrayAufbauen () {
			for (int i=0;i<sortierListe.length;i++) {
				sortierListe[i]=new LinkList();
			}
		}
		private void elementEinfuegen (Object element) {
			int index=element.hashCode();
			index=index-(700*(int)Math.pow(10, exponent));
			index=index/1000;
			sortierListe[index].addObject(element);
		}
		/**
		 * Sortiert die übergebene Liste.
		 * Das Verhalten des Sortier Algorithmuses ist unbestimmt wenn die übergebene List nicht:
		 * Laenge=10^exponent und hashwerte nicht zwischen 700*laenge und 800*laenge liegen
		 * @param list
		 * @return list
		 */
		public Object [] sortier (Object[] list) {
			arrayAufbauen();
			for (int i=0;i<list.length;i++) {
				elementEinfuegen (list[i]);
			}
			int index=0;
			for (int i=0;i<sortierListe.length;i++) {
				for (int j=0;j<sortierListe[i].getAnzahl();j++) {
					list[index]=sortierListe[i].getObjectAtPos();
					sortierListe[i].erhoehePos();
					index++;
				}
			}
			return list;
		}
	}

