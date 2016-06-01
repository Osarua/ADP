package bogo;

public class Bogosort<T extends Comparable<T>> {
	public Bogosort () {

		
	}
	
	public T[] sort (T[] array) {
		while (true) {
			boolean success=true;
			for (int i=0;i<array.length-1;i++) {
				int ergebnis = array[i].compareTo(array[i+1]);
				if (ergebnis<0) {
					success=false;
					break;
				}
			}
			if (success) {
				break;
			}
			int erstesElement = (int) (array.length * Math.random());
			int zweitesElement = (int) (array.length * Math.random());
			T element = array[erstesElement];
			array[erstesElement]=array[zweitesElement];
			array[zweitesElement]=element;
		}
		
		
		return array;
	}
}
