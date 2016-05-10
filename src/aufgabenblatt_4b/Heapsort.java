package aufgabenblatt_4b;

public class Heapsort extends Thread {

	private FieldList feld;
	
	private Bucketsort<?> v;
	
	public Heapsort(FieldList feldPar, Bucketsort<?> vPar) {
		v = vPar;v.
		addiereZuweisungen();
		v.addiereZuweisungen();
		feld = feldPar;
	}
	
	public void run() {
		heapsort();
	}
	
	private void heapsort() {
		 aufbauMaxHeap();
		 v.addiereVergleiche();
		 v.addiereZuweisungen();
		 for ( int i = feld.size(); i > 1 ; i--) {
		 swap(0, i-1);
		 absinkenMaxHeap(0, i-1);
		 v.addiereVergleiche();
		 v.addiereRechenOp();
		 }
	}
	
	
	private void aufbauMaxHeap() {
		v.addiereZuweisungen();
		v.addiereVergleiche();
		v.addiereRechenOp();
		for (int i = feld.size()/2; i > 0; i--) {
			absinkenMaxHeap(i-1, feld.size());
			v.addiereRechenOp();
			v.addiereVergleiche();
		}
	}
	
	private void absinkenMaxHeap(int index, int r) {
// 	Weicker, Algorithmen und Datenstrukturen, S.266
//		int wert = feld.get(index).hashCode();
//		int alterIndex = 0;
//		int max = 0;
//		int maxWert = 0;
//		do {
//			alterIndex = index;
//			if (2 * index  <= r && feld.get(2 * index ).hashCode() > wert) {
//				max = 2 * index ;
//				maxWert = feld.get(2 * index ).hashCode();
//			} else {
//				max = index ;
//				maxWert = wert;
//			}
//			if (2 * index + 1 <= r && feld.get(2 * index  +1).hashCode() > maxWert) {
//				max = 2 * index + 1;
//				maxWert = feld.get(2 * index + 1).hashCode();
//			}
//			if (max != index) {
//				feld.set(index, feld.get(max));
//				index = max;
//			} else {
//				break;
//			}
//		} while (alterIndex == max);
//		feld.set(max, wert);
//		https://de.wikibooks.org/wiki/Algorithmensammlung:_Sortierverfahren:_Heapsort
//		while (i <= (n / 2) - 1) {
//			int kindIndex = ((i + 1) * 2) - 1; // berechnet den Index des linken
//												// kind
//			// bestimme ob ein rechtes Kind existiert
//			if (kindIndex + 1 <= n - 1) {
//				// rechtes kind existiert
//				if (feld.get(kindIndex).hashCode() < feld.get(kindIndex + 1).hashCode()) {
//					kindIndex++; // wenn rechtes kind größer ist nimm das
//				}
//			}
//			// teste ob element sinken muss
//			if (feld.get(i).hashCode() < feld.get(kindIndex).hashCode()) {
//				swap(feld, i, kindIndex); // element versenken
//				i = kindIndex; // wiederhole den vorgang mit der neuen position
//			} else break;
//			}
//		 Weicker Bottom-Up
//		 int wert = feld.get(1).hashCode();
//		 int index = 1;
//		 int next = 2;
//		 while (next < r) {
//		 if (feld.get(next).hashCode() < feld.get(next+1).hashCode()) {
//		 feld.set(index, feld.get(next+1));
//		 index = next + 1;
//		 } else {
//		 feld.set(index, feld.get(next));
//		 index = next;
//		 }
//		 next = 2 * index;
//		 }
//		 if (next == r) {
//		 feld.set(index, feld.get(r));
//		 index = r;
//		 }
//		 while (index > 1 && feld.get(index/2).hashCode() < wert) {
//		 feld.set(index, feld.get(index/2));
//		 index = index / 2;
//		 }
//		 feld.set(index, wert);
//		Manfred Meyer, Java: Algorithmen und Datenstrukturen, S.148
		v.addiereZuweisungen();
		int wert = feld.get(index).hashCode();
		v.addiereVergleiche();
		v.addiereRechenOp();
		while (index < r / 2) {
			v.addiereZuweisungen();
			v.addiereRechenOp();
			int j = 2 * index + 1;
			v.addiereVergleiche();
			v.addiereRechenOp();
			if ((j + 1 < r) && (feld.get(j).hashCode() < feld.get(j + 1).hashCode())) {
				v.addiereZuweisungen();
				v.addiereRechenOp();
				j = j + 1;
				v.addiereVergleiche();
			}
			v.addiereVergleiche();
			if (wert >= feld.get(j).hashCode()) {
				break;
			} else {
				v.addiereZuweisungen();
				feld.set(index, feld.get(j));
				v.addiereZuweisungen();
				index = j;
			}
			v.addiereRechenOp();
			v.addiereVergleiche();
		}
		v.addiereVertauschungen();
		v.addiereZuweisungen();
		feld.set(index, wert);
	}
	
	private void swap(int top, int i) {
		v.addiereVertauschungen();
		v.addiereZuweisungen();
		Object temp = feld.get(top);
		v.addiereZuweisungen();
		feld.set(top, feld.get(i));
		v.addiereZuweisungen();
		feld.set(i, temp);
	}
}
