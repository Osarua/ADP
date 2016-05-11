package aufgabenblatt_5;

public class Baum {
	Node wurzel;
	//Eventuell sichergehen ob folge eine Folge ist
	public Baum (int [] folge) {
		Node [] folgeNodes = new Node [folge.length];
		folgeNodes [0] = new Node (folge[0]);
		for (int i=1;i<folge.length;i++) {
			folgeNodes[i]=new Node (folge[i]);
			folgeNodes[i].setWertDerVorgaenger(folgeNodes[i-1].getWertDerVorgaenger()+folgeNodes[i-1].getWert());
		}
		
		wurzel=nodeAnfuegen (0,folgeNodes.length,folgeNodes,null);
		
	}
	
	private Node nodeAnfuegen (int anfang, int ende,Node [] folge, Node vorgaenger) {
		int laenge = ende-anfang;
		Node neuerNode = folge[laenge/2];
		neuerNode.setVorgaenger(vorgaenger);
		if (laenge>0) {
			neuerNode.setNachfolgerKleiner(nodeAnfuegen (anfang, laenge/2-1,folge,neuerNode));
			neuerNode.setNachfolgerGroesser (nodeAnfuegen (laenge/2+1, ende,folge,neuerNode));
		}
		return neuerNode;
	}
	
	public int rueckgabe (int m, int M) {
		Node am = findam (wurzel, m);
		Node aM = findaM (wurzel, M);
		return aM.getWertDerVorgaenger()+aM.getWert()-am.getWertDerVorgaenger()-am.getWert();
	}
	
	private Node findam (Node node, int m) {
		if (node==null) {
			return null;
		}
		if (node.getWert()==m) {
			return node;
		}
		else if (m>node.getWert()) {
			Node nachfolger=findam (node.getNachfolgerKleiner(),m);
			if (nachfolger==null) {
				return node;
			}
			return nachfolger;
		}
		else {
			Node nachfolger = findam (node.getNachfolgerGroesser(),m);
			return nachfolger;
		}
	}
	
	private Node findaM (Node node, int m) {
		if (node==null) {
			return null;
		}
		if (node.getWert()==m) {
			return node;
		}
		else if (m<node.getWert()) {
			Node nachfolger=findam (node.getNachfolgerKleiner(),m);
			if (nachfolger==null) {
				return node;
			}
			return nachfolger;
		}
		else {
			Node nachfolger = findam (node.getNachfolgerGroesser(),m);
			return nachfolger;
		}
	}
	
	
	
	
	
	private class Node {
		private int wert;
		private int wertDerVorgaenger;
		private Node vorgaenger;
		private Node nachfolgerKleiner;
		private Node nachfolgerGroesser;
		public Node (int wertPar) {
			wert = wertPar;
			wertDerVorgaenger=0;
			vorgaenger=null;
			nachfolgerKleiner=null;
			nachfolgerGroesser=null;
		}
		public int getWert () {
			return wert;
		}
		public int getWertDerVorgaenger() {
			return wertDerVorgaenger;
		}
		public void setWertDerVorgaenger (int wert) {
			wertDerVorgaenger=wert;
		}
		public Node getVorgaenger() {
			return vorgaenger;
		}
		public void setVorgaenger(Node vorgaenger) {
			this.vorgaenger = vorgaenger;
		}
		public Node getNachfolgerKleiner() {
			return nachfolgerKleiner;
		}
		public void setNachfolgerKleiner(Node nachfolgerKleiner) {
			this.nachfolgerKleiner = nachfolgerKleiner;
		}
		public Node getNachfolgerGroesser() {
			return nachfolgerGroesser;
		}
		public void setNachfolgerGroesser(Node nachfolgerGroesser) {
			this.nachfolgerGroesser = nachfolgerGroesser;
		}
		
	}
}
