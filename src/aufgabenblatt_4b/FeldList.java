package aufgabenblatt_4b;

public class FeldList {
	
	private Object[] bucket;
	
	private int anzahlElements;
	
	public FeldList(int laenge){
		bucket = new Object[laenge];
	}
	
	public void insert(Object elem) {
		if(anzahlElements+1 > bucket.length ) {
			biggerArray();
		}
		bucket[anzahlElements] = elem;
		anzahlElements++;
	}
	
	public void biggerArray() {
		Object[] feldPlus;
		feldPlus =  new Object[bucket.length * 3 / 2 + 1];
		for (int i = 0; i < bucket.length; i++) {
			feldPlus[i] = bucket[i];
		}
		bucket = feldPlus;
	}
	
	public void set(int pos, Object elem) {
		bucket[pos] = elem;
	}
	
	public Object get (int pos) {
		return bucket[pos];
	}
	
	public int size () {
		return anzahlElements;
	}
	
}
