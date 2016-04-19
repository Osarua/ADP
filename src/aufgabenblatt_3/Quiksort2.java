package aufgabenblatt_3;

import java.util.LinkedList;

public class Quiksort2 {
	public static Object[] Quiksort (Object[] listPar) {
		return Quiksort (listPar,0,listPar.length-1);
	}
	
	public static Object[] Quiksort (Object[] listPar, int startIndex, int endIndex) {
		if (startIndex>=endIndex) {
			return listPar;
		}
		//int pivotIndex = mittleresPivotElement (startIndex, endIndex);
		//int pivotIndex = zufaelligesPivotElement (startIndex, endIndex);
		int pivotIndex = medianesPivotElement (startIndex,endIndex,(endIndex-startIndex)/2,listPar);
		int pivotHash = listPar [pivotIndex].hashCode();
		LinkedList<Object> kleiner = new LinkedList<Object>();
		LinkedList<Object> groesser = new LinkedList<Object>();
		for (int i=startIndex;i<=endIndex;i++) {
			if (pivotIndex!=i) {
				int hash = listPar[i].hashCode();
				if (pivotHash>hash) {
					kleiner.add(listPar[i]);
				}
				else if (pivotHash<hash) {
					groesser.add(listPar[i]);
				}
				else {
					if (pivotIndex<i) {
						groesser.add(listPar[i]);
					}
					else {
						kleiner.add(listPar[i]);
					}
				}
			}
		}
		Object[] kleinerArray = Quiksort (kleiner.toArray());
		Object[] groesserArray = Quiksort (groesser.toArray());
		Object pivotElement = listPar[pivotIndex];
		for (int i=startIndex; i<=endIndex;i++) {
			if (i<kleinerArray.length) {
				listPar[i]=kleinerArray[i];
			}
			if (i==kleinerArray.length){
				listPar[i]=pivotElement;
			}
			if (i>kleinerArray.length) {
				listPar[i]=groesserArray[i-kleinerArray.length-1];
			}
		}
		return listPar;
	}
	
	public static int mittleresPivotElement (int startIndex, int endIndex) {
		return (endIndex-startIndex)/2+startIndex;
	}
	public static int zufaelligesPivotElement (int startIndex, int endIndex) {
		return startIndex+(int)((endIndex-startIndex)*Math.random());
	}
	/**
	 * 
	 * @param startIndex
	 * @param endIndex
	 * @param genauigkeit Gibt die Anzahl der zufällig ausgewählten Elemente zur Median berechnung an.
	 * Sie ist immer mindestens 1
	 * @param listePar
	 * @return
	 */
	public static int medianesPivotElement (int startIndex, int endIndex, int genauigkeit, Object[] listePar) {
		if (genauigkeit<=0) {
			genauigkeit=1;
		}
		Object[][] unsortierteLokaleListe = new Object [genauigkeit][2];
		Object[] lokaleListe = new Object [genauigkeit];
		for (int i=0;i<genauigkeit;i++) {
			int index = startIndex+(int)((endIndex-startIndex)*Math.random());
			Object lokalesObject = listePar [index];
			for (int j=0;j<i+1;j++) {
				unsortierteLokaleListe[j][0]=lokalesObject;
				unsortierteLokaleListe[j][1]=index;
				if (lokaleListe[j]==null) {
					lokaleListe[j]=lokalesObject;
				}
				else if (listePar[j].hashCode()>lokalesObject.hashCode()) {
					Object buffer = listePar[j];
					lokaleListe[j]=lokalesObject;
					for (int z=j+1;z<i+1;z++) {
						Object buffer2 = listePar[z];
						lokaleListe[z] = buffer;
						buffer = buffer2;
					}
				}
			}
		}
		Object medianesObject = lokaleListe[genauigkeit/2];
		for (int i=0;i<genauigkeit;i++) {
			if (medianesObject.equals(unsortierteLokaleListe[i][0])) {
				return (Integer)unsortierteLokaleListe[i][1];
			}
		}
		return (endIndex-startIndex)/2+startIndex;
	}
}
