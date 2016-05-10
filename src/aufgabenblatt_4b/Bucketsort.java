package aufgabenblatt_4b;

import java.util.ArrayList;
import java.util.List;




public class Bucketsort<E>  {
	
	private int vergleiche;
	
	private int vertauschungen;
	
	private int rechenoperation;
	
	private int zuweisungen;
	
	private FieldList[] buckets;
	
	private int min;
	
	private int wertebereich;
	
	private int anzahlBuckets;
	
	private  List<Heapsort> heapsort;
	
	@SuppressWarnings("unchecked")
	public void bucketsort(E[] feld) {
		berechneBuckets(feld.length);
		initBuckets(anzahlBuckets);
		vergleiche++;
		zuweisungen++;
		for (int i = 0; i < feld.length; i++) {
			rechenoperation++;
			zuweisungen++;
			double hashco = (double) feld[i].hashCode() - min;
			rechenoperation++;rechenoperation++;
			zuweisungen++;
			int index = (int) ((hashco / ((double) wertebereich)) * anzahlBuckets);
			zuweisungen++;
			buckets[index].insert(feld[i]);
			vergleiche++;
			rechenoperation++;
		}
		vergleiche++;
		zuweisungen++;
		for (int i = 0; i < buckets.length; i++) {
			zuweisungen++;
			heapsort.add(new Heapsort(buckets[i],this));	
			heapsort.get(i).start();
			vergleiche++;
			rechenoperation++;
		}
		vergleiche++;
		zuweisungen++;
		for (int i = 0; i < buckets.length; i++) {
			try {
				heapsort.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			vergleiche++;
			rechenoperation++;
		}
			zuweisungen++;
			zuweisungen++;
		int b = 0;
		int k = 0;
			vergleiche++;
			zuweisungen++;
		for (int i = 0; i < buckets.length; i++) {
				vergleiche++;
			while (b < buckets[i].size()) {	
				feld[k + b] = (E) buckets[i].get(b);
				b++;
						vergleiche++;
						rechenoperation++;
						rechenoperation++;
			}
			k = k + b;
			b = 0;
				vergleiche++;
				rechenoperation++;
				rechenoperation++;
		}
	}
	
	private void berechneBuckets(int size) {
		switch (size) {
		case 1000000:
				vergleiche+=1;
				zuweisungen++;
			min = 700000000;
				zuweisungen++;
			wertebereich = 100000000; 
				zuweisungen++;
			anzahlBuckets = 100;
			zuweisungen++;
			heapsort = new ArrayList<Heapsort>();
			zuweisungen++;
			initBuckets(5000);
			break;
		case 100000:
			vergleiche+=2;
			zuweisungen++;
			min = 70000000;
			zuweisungen++;
			wertebereich = 10000000; 
			zuweisungen++;
			anzahlBuckets = 40;
			zuweisungen++;
			heapsort = new ArrayList<Heapsort>();
			zuweisungen++;
			initBuckets(3000);
			break;
		case 10000:
			vergleiche+=3;
			zuweisungen++;
			min = 7000000;
			zuweisungen++;
			wertebereich = 1000000; 
			zuweisungen++;
			anzahlBuckets = 30;
			zuweisungen++;
			heapsort = new ArrayList<Heapsort>();
			zuweisungen++;
			initBuckets(100);
			break;
		case 1000:
			vergleiche+=4;
			zuweisungen++;
			min = 700000;
			zuweisungen++;
			wertebereich = 100000; 
			zuweisungen++;
			anzahlBuckets = 8;
			zuweisungen++;
			heapsort = new ArrayList<Heapsort>();
			zuweisungen++;
			initBuckets(100);
			break;
		case 100:
			vergleiche+=5;
			zuweisungen++;
			min = 70000;
			zuweisungen++;
			wertebereich = 10000; 
			zuweisungen++;
			anzahlBuckets = 5;
			zuweisungen++;
			heapsort = new ArrayList<Heapsort>();
			zuweisungen++;
			initBuckets(10);
			break;
		case 10:
			vergleiche+=6;
			zuweisungen++;
			min = 7000;
			zuweisungen++;
			zuweisungen++;
			wertebereich = 1000; 
			zuweisungen++;
			anzahlBuckets = 1;
			zuweisungen++;
			heapsort = new ArrayList<Heapsort>();
			zuweisungen++;
			initBuckets(10);
			break;
		}
	}
	
	private void initBuckets(int laenge) {
		vergleiche++;
		zuweisungen++;
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new FieldList(laenge);
			zuweisungen++;
			vergleiche++;
			rechenoperation++;
		}
	}
	
	public synchronized void addiereVergleiche() {
		vergleiche++;
	}
	
	public synchronized void addiereVertauschungen() {
		vertauschungen++;
	}
	
	public synchronized void addiereRechenOp(){
		rechenoperation++;
	}
	
	public synchronized void addiereZuweisungen() {
		zuweisungen++;
	}

	@Override
	public String toString() {
		return "Bucketsort [vergleiche=" + vergleiche + ",\n vertauschungen=" + vertauschungen + ", \n rechenoperation="
				+ rechenoperation + ",\n zuweisungen=" + zuweisungen + "]";
	}
	
	
}
