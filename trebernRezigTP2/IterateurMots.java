package trebernRezigTP2;

public class IterateurMots implements Iterator<String>{
	
	private Object[] o;
	private int curseur;
	
	public IterateurMots(Object[] oo) {
		this.curseur = oo.length;
		this.o = oo;
	}
	
	public void remove() { 
		throw new UnsupportedOperationException();
	}
	
	public boolean hasNext() {
		return curseur <= this.o.length;
	}
	
	public String next() {
		String res = "";
		while(o[curseur] != null) {
			res += o[curseur];
			curseur++;
		}
		while(o[curseur] == null) {
			curseur++;
		}
		
		return res;
	}
	
}
